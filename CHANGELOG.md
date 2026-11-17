# Changelog

Add a short entry at the top for each update, with the newest first.

## 2026-11-17: Black Book app icon
- New app icon: a black hardback army book with a silver frame, silver corner guards, a "U" roundel and a red ribbon bookmark, on a dark crimson background.

## 2026-11-17: Settings, dark mode and in-app data updates
- **Settings:** a gear icon at the top of both builders opens Settings.
- **Appearance:** System, Light or Dark. It is remembered, and applies to both editions.
- **Data updates (Android app):** Check for updates compares the pages in the app with the newest ones in this repository. Download and install fetches them, checks each file against GitHub's checksum, and switches to them without reinstalling.
  - Saved lists are kept.
  - Use built-in version goes back to the pages in the APK.
  - Installing a newer APK replaces any downloaded pages.
  - The repository is private, so the app needs a read-only fine-grained access token (Contents: Read-only, this repository only). The token is stored only on the phone, and the steps are in Settings.
- The app now has internet permission, used only for these update checks.

## 2026-11-17: 2nd Edition – every army list, missions
- **New 2nd Edition army lists:**
  - Liber Imperium: Solar Auxilia, Legio Custodes and Sisters of Silence;
  - Liber Mechanicum: Mechanicum, Questoris Knights and Titan Legions;
  - the Divisio Assassinorum.
- **Legacies of the Age of Darkness units:** the Imperialis Militia list, plus the Legacies units for the Legiones Astartes, Solar Auxilia and Mechanicum. That covers named characters, Legion-specific units, super-heavies, flyers and fortifications. The new Legion consuls (Primus Nullificator and Warmonger) are on the Centurion.
- **Army rules built in:**
  - **Solar Auxilia Tercios:** each Tercio uses one slot. Extra sections join an existing Tercio, command sections sit inside one, and the limits are checked.
  - **Cohort Doctrines:** chosen like a Rite of War.
  - **Militia Provenances of War:** up to two on the Force Commander.
  - **Orders of High Techno-arcana:** one per Archmagos, each Order only once per army.
  - **Questoris Household:** its own Force Organisation chart and the Household Ranks.
  - **Titan Maniple or Household Detachment:** picked as the Allied Detachment.
  - **Titans and Knights in any army's Lords of War Detachment.**
  - **Clade Operatives:** one per army, Primary Detachment only.
  - **Agents of the Emperor:** Loyalist only.
- **Reference:** special rules, unit types, wargear, weapons, Warlord Traits and faction rules from all of these books.
- **2nd edition missions:** the six core missions, the six deployment maps, victory conditions and the mission special rules from the rulebook.
- **Total:** the 2nd Edition builder now holds 409 units in 25 factions.

## 2026-11-17: 2nd Edition builder (first draft)
- **Edition switch:** "1st Edition" and "2nd Edition" buttons at the top. Everything built so far is the 1st Edition builder, unchanged. Each edition keeps its own saved lists.
- **2nd Edition builder** (`2e.html`), with the 2nd edition rules as the master. It covers the rulebook, Liber Astartes and Liber Hereticus: 160 units, all 18 Legions, 50 Rites of War, Core and Legion Warlord Traits, 2nd edition weapons, special rules and psychic disciplines.
- **2nd edition army building:**
  - the Crusade Force Organisation chart with a Primarch slot;
  - Lords of War and Primarchs only at 2,000 points or more, and together no more than 25% of the army;
  - one Master of the Legion per 1,000 points, and a Rite of War needs one in its Detachment;
  - Rite of War slot changes;
  - Legiones Consularis and Legion Consul upgrades;
  - Legion armoury wargear, shown only to that Legion (Traitor-only items only to Traitors).
- **Not yet in 2nd Edition:** missions; the Imperium and Mechanicum books; converted extras behind tickboxes.
- **Fix:** Space Wolves 1st edition army selection checks no longer apply in 2nd Edition.

## 2026-11-17: Missions on phones, clearer wargear options
- **Missions tab:** Missions is now a fifth tab on the phone tab bar. Tapping any other tab closes it, and reopening it returns to the same mission and scroll position. Android's Back button closes it too.
- **Edge-to-edge fix:** on Android 15 and later, the app now keeps clear of the status bar, navigation bar and keyboard, so the Missions Close button and the header are no longer jammed against the screen edge.
- **Terminator armour options:** on Praetors, Centurions and Command Squads, choosing Terminator armour now hides the power armour weapon lists, which can't be used in Terminator armour, with a note saying they are hidden. Before, they stayed on screen greyed out, and the greyed-out "Power weapon" looked like it couldn't be taken. A model in Terminator armour already carries a power weapon as standard.
- **Mhara Gal Tainted Dreadnought:** the two arm options are relabelled. Swapping the close combat arm for a ranged weapon, while keeping the warpfire plasma cannon, is the 1st edition way to carry two ranged weapons.

## 2026-11-17: Legal disclaimer
- Added an unofficial fan-made notice and Games Workshop trademark and copyright disclaimer. It appears at the bottom of the builder, on printed lists and in the README.
- The builder page asks search engines not to index it.

## 2026-11-16: First app release
- First Android build of the Unification List Builder (renamed from the Heresy List Builder).
- **Phone layout:** a bottom tab bar (Army, Units, List, Rules), larger tap targets and pop-up messages.
- **Xenos colour scheme:** green for Xenos armies, alongside Loyalist blue and Traitor red.
- **Rites of War:** a broad pass so every rite's list-building permissions work:
  - slot changes;
  - transports taken from other slots;
  - Brethren of Iron and Head of the Gorgon automata;
  - Primarch's Chosen, Master of Armour and The Storm of War;
  - rite-only wargear.
- **The Rewards of Treason** (Coils of the Hydra) is one Elites entry with a dropdown of eligible units.
- **Post-Edition Legiones Consularis:**
  - Stormseer, Esoterist (with Ruinstorm daemons through Breach the Veil), Pathfinder, Armistos, Mortificator (Keeper of the Dead) and Overseer (Auxilia or Militia retinue);
  - Paladin of the Hekatonystika, Pack Thegn, Speaker of the Dead and Caster of Runes (Deathsworn retinue), Castellan and Dark Emissary.
- **Spellcheck and clean-up:** fixed text scraped from poor-quality PDFs throughout the rulebook special rules and Rites of War.
- **Error check fixes:** broken option names on the Contemptor-Cortus Talon and Legion of One, and duplicated options on three Solar Auxilia super-heavies.
