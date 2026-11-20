package com.unification.listbuilder;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Color;
import android.graphics.Insets;
import android.os.Build;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.JavascriptInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Unification List Builder: the list builder page bundled in assets/index.html,
 * shown full screen in a WebView. Lists are kept in the WebView's local storage,
 * so they stay on the phone between launches and work offline.
 */
public class MainActivity extends Activity {
    private WebView web;

    // Data updates: newer builder pages downloaded from the GitHub repository are kept in the app's own
    // storage (files/web/) and served in place of the bundled assets at the same file:///android_asset/ address,
    // so saved lists (local storage) stay where they are.
    private static final String REPO = "Imperialist29/unification-list-builder";
    private static final String ASSETS = "app/src/main/assets";
    private static final String[] PAGES = {"index.html", "2e.html", "3e.html"};
    private File webDir() { return new File(getFilesDir(), "web"); }
    private SharedPreferences prefs() { return getSharedPreferences("updates", MODE_PRIVATE); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        web = new WebView(this);
        web.setBackgroundColor(Color.parseColor("#F7F8FA"));
        // The WebView sits in a frame so the frame, not the WebView, takes the system-bar padding.
        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Color.parseColor("#1F4E8C"));
        root.addView(web, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        setContentView(root);

        // Android 15+ draws apps edge to edge: keep the page clear of the status bar, the navigation bar,
        // camera cut-outs and the on-screen keyboard.
        if (Build.VERSION.SDK_INT >= 30) {
            root.setOnApplyWindowInsetsListener((v, insets) -> {
                Insets b = insets.getInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout() | WindowInsets.Type.ime());
                v.setPadding(b.left, b.top, b.right, b.bottom);
                return WindowInsets.CONSUMED;
            });
        }

        // A newer APK bundles newer pages: drop any copies downloaded before it was installed.
        try {
            PackageInfo pi = getPackageManager().getPackageInfo(getPackageName(), 0);
            if (pi.lastUpdateTime > prefs().getLong("downloadedAt", 0)) clearDownloaded();
        } catch (Exception e) { /* keep what we have */ }

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);          // localStorage: saved lists
        s.setDatabaseEnabled(true);
        s.setAllowFileAccess(true);
        s.setTextZoom(100);
        s.setBuiltInZoomControls(true);
        s.setDisplayZoomControls(false);

        web.addJavascriptInterface(new Bridge(), "AndroidBridge");
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest req) {
                Uri u = req.getUrl();
                if ("file".equals(u.getScheme())) return false;
                try { startActivity(new Intent(Intent.ACTION_VIEW, u)); } catch (ActivityNotFoundException e) { /* no browser */ }
                return true;
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest req) {
                String u = req.getUrl().toString();
                if (u.startsWith("file:///android_asset/")) {
                    String name = u.substring("file:///android_asset/".length());
                    int q = name.indexOf('?'); if (q >= 0) name = name.substring(0, q);
                    int h = name.indexOf('#'); if (h >= 0) name = name.substring(0, h);
                    File f = new File(webDir(), name);
                    if (isPage(name) && f.isFile()) {
                        try { return new WebResourceResponse("text/html", "utf-8", new FileInputStream(f)); }
                        catch (Exception e) { /* fall back to the bundled page */ }
                    }
                }
                return null;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // The page's Print button calls window.print(), which a WebView ignores: route it to Android printing
                // (which also offers "Save as PDF"). Clipboard writes are routed to the system clipboard.
                view.evaluateJavascript(
                    "window.print=function(){AndroidBridge.print()};" +
                    "if(navigator.clipboard){navigator.clipboard.writeText=function(t){AndroidBridge.copy(String(t));return Promise.resolve()}};",
                    null);
            }
        });

        // A newer app install brings newer built-in pages: drop pages downloaded before it, or they would hide the update.
        try {
            long installed = getPackageManager().getPackageInfo(getPackageName(), 0).lastUpdateTime;
            if (new File(webDir(), "index.html").isFile() && prefs().getLong("downloadedAt", 0) < installed) clearDownloaded();
        } catch (Exception e) { }
        if (savedInstanceState != null) web.restoreState(savedInstanceState);
        else web.loadUrl("file:///android_asset/index.html");
    }

    private class Bridge {
        @JavascriptInterface
        public void print() {
            runOnUiThread(() -> {
                PrintManager pm = (PrintManager) getSystemService(Context.PRINT_SERVICE);
                PrintDocumentAdapter ad = web.createPrintDocumentAdapter("Unification army list");
                pm.print("Unification army list", ad, new PrintAttributes.Builder().build());
            });
        }

        /** Which copy of the pages is in use: {"source":"built-in"|"downloaded","date":...,"msg":...}. */
        @JavascriptInterface
        public String updateInfo() {
            try {
                JSONObject o = new JSONObject();
                boolean dl = new File(webDir(), "index.html").isFile();
                o.put("source", dl ? "downloaded" : "built-in");
                o.put("date", prefs().getString("date", ""));
                o.put("msg", prefs().getString("msg", ""));
                o.put("hasToken", !prefs().getString("token", "").isEmpty());
                try { o.put("app", getPackageManager().getPackageInfo(getPackageName(), 0).versionName); } catch (Exception e) { }
                return o.toString();
            } catch (Exception e) { return "{}"; }
        }

        /** Keeps the GitHub access token on the phone (app storage only). An empty string removes it. */
        @JavascriptInterface
        public void setToken(String t) { prefs().edit().putString("token", t == null ? "" : t.trim()).apply(); }

        /** Compares the pages in use with the repository's latest; answers through window.__updCb(result). */
        @JavascriptInterface
        public void checkUpdate() { new Thread(() -> reply(check(false))).start(); }

        /** Downloads the repository's latest pages, checks them and keeps them; answers through window.__updCb. */
        @JavascriptInterface
        public void installUpdate() { new Thread(() -> reply(check(true))).start(); }

        /** Goes back to the pages bundled with the app. */
        @JavascriptInterface
        public void useBuiltIn() { clearDownloaded(); runOnUiThread(() -> web.reload()); }

        @JavascriptInterface
        public void copy(String text) {
            runOnUiThread(() -> {
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setPrimaryClip(ClipData.newPlainText("Army list", text));
                Toast.makeText(MainActivity.this, "Copied", Toast.LENGTH_SHORT).show();
            });
        }
    }

    private boolean isPage(String n) { for (String p : PAGES) if (p.equals(n)) return true; return false; }

    private void clearDownloaded() {
        File d = webDir();
        File[] fs = d.listFiles();
        if (fs != null) for (File f : fs) f.delete();
        prefs().edit().remove("date").remove("msg").remove("downloadedAt").apply();
    }

    private void reply(JSONObject r) {
        final String js = "window.__updCb&&window.__updCb(" + r.toString() + ")";
        runOnUiThread(() -> web.evaluateJavascript(js, null));
    }

    private HttpURLConnection gh(String path, boolean raw) throws Exception {
        HttpURLConnection c = (HttpURLConnection) new URL("https://api.github.com/repos/" + REPO + path).openConnection();
        c.setConnectTimeout(15000);
        c.setReadTimeout(60000);
        c.setRequestProperty("Accept", raw ? "application/vnd.github.raw" : "application/vnd.github+json");
        c.setRequestProperty("X-GitHub-Api-Version", "2022-11-28");
        c.setRequestProperty("User-Agent", "UnificationListBuilder");
        String t = prefs().getString("token", "");
        if (!t.isEmpty()) c.setRequestProperty("Authorization", "Bearer " + t);
        return c;
    }

    private static byte[] readAll(InputStream in) throws Exception {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte[] buf = new byte[65536];
        int n;
        while ((n = in.read(buf)) > 0) b.write(buf, 0, n);
        in.close();
        return b.toByteArray();
    }

    private byte[] fetch(String path, boolean raw) throws Exception {
        HttpURLConnection c = gh(path, raw);
        int code = c.getResponseCode();
        if (code == 401) throw new Exception("GitHub refused the access token (401). Check it has not expired.");
        if (code == 403) throw new Exception("GitHub refused the request (403). The token needs read access to this repository's contents, or the hourly limit was reached.");
        if (code == 404) throw new Exception("Repository not found (404). A private repository needs an access token.");
        if (code != 200) throw new Exception("GitHub answered " + code + ".");
        return readAll(c.getInputStream());
    }

    /** Git's blob id for a file's bytes, the same id GitHub lists for it. */
    private static String blobSha(byte[] d) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(("blob " + d.length + "\0").getBytes(StandardCharsets.UTF_8));
        md.update(d);
        StringBuilder sb = new StringBuilder();
        for (byte x : md.digest()) sb.append(String.format("%02x", x));
        return sb.toString();
    }

    private byte[] current(String name) throws Exception {
        File f = new File(webDir(), name);
        return f.isFile() ? readAll(new FileInputStream(f)) : readAll(getAssets().open(name));
    }

    private JSONObject check(boolean install) {
        JSONObject r = new JSONObject();
        try {
            r.put("action", install ? "install" : "check");
            JSONArray list = new JSONArray(new String(fetch("/contents/" + ASSETS + "?ref=main", false), StandardCharsets.UTF_8));
            JSONArray changed = new JSONArray();
            for (String p : PAGES) {
                String remote = null;
                for (int i = 0; i < list.length(); i++) if (p.equals(list.getJSONObject(i).optString("name"))) remote = list.getJSONObject(i).optString("sha");
                if (remote == null) continue;
                String local = "";
                try { local = blobSha(current(p)); } catch (Exception e) { }
                if (!remote.equals(local)) { JSONObject x = new JSONObject(); x.put("name", p); x.put("sha", remote); changed.put(x); }
            }
            String date = "", msg = "";
            try {
                JSONArray cm = new JSONArray(new String(fetch("/commits?sha=main&per_page=1&path=" + ASSETS, false), StandardCharsets.UTF_8));
                if (cm.length() > 0) {
                    JSONObject c = cm.getJSONObject(0).getJSONObject("commit");
                    date = c.getJSONObject("committer").optString("date");
                    msg = c.optString("message").split("\n")[0];
                }
            } catch (Exception e) { /* the date is only for display */ }
            r.put("date", date);
            r.put("msg", msg);
            r.put("changed", changed.length());
            if (install && changed.length() > 0) {
                File d = webDir();
                d.mkdirs();
                // Download everything first and check it, then swap the files in.
                for (int i = 0; i < changed.length(); i++) {
                    JSONObject x = changed.getJSONObject(i);
                    String name = x.getString("name");
                    byte[] data = fetch("/contents/" + ASSETS + "/" + name + "?ref=main", true);
                    String head = new String(data, 0, Math.min(data.length, 4000), StandardCharsets.UTF_8);
                    if (!blobSha(data).equals(x.getString("sha"))) throw new Exception(name + " did not download completely. Try again.");
                    if (data.length < 100000 || !head.contains("<html") ) throw new Exception(name + " from GitHub does not look like the builder page, so it was not installed.");
                    FileOutputStream o = new FileOutputStream(new File(d, name + ".part"));
                    o.write(data);
                    o.close();
                }
                for (int i = 0; i < changed.length(); i++) {
                    String name = changed.getJSONObject(i).getString("name");
                    File part = new File(d, name + ".part"), dest = new File(d, name);
                    dest.delete();
                    if (!part.renameTo(dest)) throw new Exception("Could not save " + name + ".");
                }
                // Pages that did not change still need a local copy alongside, so both editions come from one source.
                for (String p : PAGES) {
                    File f = new File(d, p);
                    if (!f.isFile()) { FileOutputStream o = new FileOutputStream(f); o.write(readAll(getAssets().open(p))); o.close(); }
                }
                prefs().edit().putString("date", date).putString("msg", msg).putLong("downloadedAt", System.currentTimeMillis()).apply();
                r.put("installed", true);
            }
            r.put("ok", true);
        } catch (Exception e) {
            try { r.put("ok", false); r.put("error", e.getMessage() == null ? e.toString() : e.getMessage()); } catch (Exception x) { }
        }
        return r;
    }

    @Override
    protected void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        web.saveState(out);
    }

    @Override
    public void onBackPressed() {
        // Close the topmost overlay (zoomed map, Missions, print view) first, otherwise leave the app.
        web.evaluateJavascript(
            "(function(){try{return window.__appBack?window.__appBack():0}catch(e){return 0}})()",
            r -> { if (!"1".equals(r)) MainActivity.super.onBackPressed(); });
    }
}
