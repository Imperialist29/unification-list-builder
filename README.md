# Unification List Builder

A private army list builder for **Warhammer: The Horus Heresy**, with a builder for each edition: **1st edition (Age of Darkness)** and **2nd edition**. Switch between them with the buttons at the top. It is packaged as an offline Android app and is also a single web page. Pick a faction, Rite of War and units, set the wargear, and the builder costs the list, checks it against the force organisation and the rules, and prints it.

Get the app from **Releases → latest → `UnificationListBuilder.apk`**. Every push to `main` builds a new APK there.

---

## What's in the builder

### Rules basis
- **Horus Heresy 1st edition is the master ruleset.** Its points and rules are never changed. Newer content is only added, behind opt-in tickboxes.
- **With every tickbox off, the list is pure 1.0.** This is checked with a comparison harness after every change.


### Factions (362 units with the 1.0 rules)
- **All 18 Legiones Astartes**, plus Shattered Legions and Blackshields, each with their Legion rules, wargear, characters, Rites of War and Warlord Traits.
- **Solar Auxilia, Imperialis Militia, Questoris Knights, Mechanicum, Legio Custodes and Daemons of the Ruinstorm.**
- **Rites of War (115).** Their list-building effects are built in:
  - unit slot changes and compulsory Troops;
  - transports taken from other slots;
  - units joining from other lists, such as Brethren of Iron's automata and The Coils of the Hydra's Rewards of Treason (one dropdown entry);
  - the Company Command vehicle, the Primarch as an HQ, and rite-only wargear.
- **Force Organisation charts (9)** and **missions (124)**, including the campaign and Exemplary Battles missions with their deployment maps.

### Optional content (tickboxes)
- **Playtest rules:** updated profiles from the Errata and FAQ v1.1.
- **7th edition codex armies (160 units), converted to Heresy rules:** The Awakened (Necrons), Revenants of a Dead Empire (Eldar and Dark Eldar), Remnants of Ullanor (Orks), Xenos Beast Swarms (Tyranids) and Xenos Cults (Genestealer Cults).
  - These use the green Xenos colour scheme and a Xenos allegiance.
  - Formations become Rites of War.
  - They take only their own Lords of War and no Fortifications.
- **Post-Edition units (114 units):** 2nd and 3rd edition content converted to 1.0 rules, including:
  - Saturnine Terminators, Inductii (all Legions), Veteran Breacher and Assault Squads, Nullificators and Scouts;
  - Sicaran variants, Kratos, Macharius, Baneblade-pattern super-heavies and Marauders;
  - Sisters of Silence as their own army (Silent Judge, Knight Abyssal and the Cadres);
  - Solar Auxilia, Militia and Mechanicum additions, Armigers and the Acastus Asterius;
  - named characters from the 2nd edition books (Fafnir Rann, Argel Tal, Lucius, Horus Ascended, Fulgrim and Angron Transfigured and others);
  - Legiones Consularis: Stormseer, Esoterist, Pathfinder, Armistos, Mortificator, Overseer, Paladin of the Hekatonystika, Pack Thegn, Speaker of the Dead, Caster of Runes, Castellan and Dark Emissary;
  - 2nd edition Rites of War (Underworld Assault, Templar Assault, The Black Watch) and the Emperor's Children Legiones Hereticus rites.

### 2nd Edition builder
- **Rules basis:** the 2nd edition rulebook, Liber Astartes, Liber Hereticus, Liber Imperium, Liber Mechanicum and the Legacies of the Age of Darkness PDFs are the master. No 1st edition content is mixed in.
- **Factions (409 units):**
  - all 18 Legions;
  - Solar Auxilia, Imperialis Militia, Mechanicum, Questoris Knights, Titan Legions, Legio Custodes and Sisters of Silence;
  - Clade Operatives of the Divisio Assassinorum.
- **List-building rules:**
  - Rites of War and Cohort Doctrines;
  - Solar Auxilia Tercios;
  - Militia Provenances;
  - Orders of High Techno-arcana;
  - Household Ranks and the Questoris Household chart;
  - Titan Maniple and Household Detachments;
  - Legiones Consularis and Legion armoury;
  - the 2nd edition Lords of War and Primarch limits.
- **Missions:** the six core missions and six deployment maps.
- **Still to come:** converted extras behind opt-in tickboxes.

### Using it
- **Live list checks:** slots, compulsory choices, unit limits, Rite of War restrictions, wargear restrictions and Warlord eligibility, each explained in plain language.
- **Unit cards:** the profile, wargear, weapon profiles, every special rule's text and a suggested base size.
- **Rules reference:** special rules, unit types, weapons, wargear and psychic disciplines, all searchable.
- **Print view:** a clean printable list with the rules it uses. On Android it opens the print dialog, which includes Save as PDF.
- **My lists:** save, load and share lists as text.
- **Custom units** can be added to the library.
- **Phone layout:** a bottom tab bar (Army, Units, List, Rules) with points and list checks on the tabs.
- **Colour schemes:** Loyalist blue, Traitor red, Xenos green, each with light and dark modes. The gear icon opens Settings: System, Light or Dark.
- **Data updates in the app:** Settings → Check for updates pulls the newest builder pages from this repository without reinstalling. It needs a read-only fine-grained access token (Contents: Read-only, this repository only), kept only on the phone.

---

## Repository layout

| Path | What it is |
|---|---|
| `app/src/main/assets/index.html` | **The 1st Edition builder.** One self-contained page holding all data and code. Replace it to update the app. |
| `app/src/main/assets/2e.html` | **The 2nd Edition builder:** the rulebook, all four Liber books and the Legacies PDFs, with 2nd edition rules as the master. |
| `app/src/main/java/com/unification/listbuilder/MainActivity.java` | The Android shell: a full-screen WebView with Android printing, clipboard and back-button support. |
| `app/src/main/AndroidManifest.xml`, `app/src/main/res/` | App name, theme and launcher icon. |
| `app/build.gradle.kts`, `build.gradle.kts`, `settings.gradle.kts`, `gradle.properties` | Android build settings. |
| `app/signing/unification.keystore.b64` | The app's signing key, stored as text. Every build uses it so updates install over the old app. **Keep this repository private.** |
| `.github/workflows/build-apk.yml` | Builds the APK on every push to `main` and attaches it to the **latest** release. |
| `CHANGELOG.md` | What changed in each update. |

## Updating the app
Pushing a new `index.html` or `2e.html` here is enough for phones to pick it up through Settings → Check for updates. A new APK is only needed when the Android code changes.

1. Replace `app/src/main/assets/index.html` with the new page. On GitHub, open the folder, choose **Add file → Upload files**, and drop the new `index.html` in.
2. Add a line to `CHANGELOG.md` saying what changed.
3. Commit to `main`. After a few minutes, the new APK appears under **Releases → latest**.
4. On your phone, download it and install it over the old one. Your saved lists are kept.

## Installing on Android
1. Open **Releases → latest** on your phone and tap `UnificationListBuilder.apk`.
2. Open the download. Android asks you to allow installs from your browser or Files app; allow it once.
3. Play Protect may say the app is from an unknown developer. Choose **Install anyway**.

Inside the app, lists are saved on the phone. To move a list to another device, copy it as text from **Save, load and share**.

## Building locally (optional)
Open the folder in Android Studio and choose *Build → Build APK(s)*. The signing key is unpacked automatically on the first build.

---

## Legal disclaimer
This is an unofficial, fan-made tool for personal, non-commercial use. It is not endorsed by, affiliated with or approved by Games Workshop Limited. Warhammer, The Horus Heresy, Warhammer 40,000, the Legiones Astartes and all associated names, logos, races, characters, units, rules and illustrations are trademarks and/or copyright of Games Workshop Limited, used without permission. No challenge to their status is intended. Rules text is summarised or quoted for reference only; please own the relevant Games Workshop publications to play. The software licence in `LICENSE` covers this project's own code only, not Games Workshop's intellectual property.
