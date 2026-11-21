# Changelog

Add a short entry at the top for each update, with the newest first.

## 2026-11-21: Forge World Eldar and Necron units (1st Edition, 7th edition codices option)
- Revenants of a Dead Empire (Eldar), from Imperial Armour: The Doom of Mymeara (2nd edition): Irillyth, Farseer Bel-Annath, Wraithseer, Wasp Assault Walkers, Shadow Spectres, Hornet Squadron, Nightwing, Phoenix Bomber, Lynx, Warp Hunter Squadron, Skathach Wraithknight, Cobra, Scorpion, Vampire Raider/Hunter, Revenant Titan and Phantom Titan. Autarchs gain the Shadow Spectre equipment options.
- The Awakened (Necrons), from Imperial Armour: The Fall of Orpheus: Canoptek Tomb Stalker, Canoptek Acanthrites, Canoptek Tomb Sentinel, Tesseract Ark, Sentry Pylons and Night Shroud Bomber.
- All of them appear only with the 7th edition codices tickbox on; with it off the list is unchanged.

## 2026-11-21: Data updates always refresh the screen
- App: after "Download and install", the app now clears the WebView's cache and loads the page fresh, so the new version shows straight away instead of sometimes keeping the old screen.
- App: pages are never cached, and update checks ask GitHub for an uncached answer.
- This needs this app build installed once from GitHub; after that, page updates from Settings refresh properly.

## 2026-11-21: 3rd Edition print and settings
- 3rd Edition page now has the Print list button (printable list with profiles, weapons and options) and the Settings button (theme, Android data updates), like the 1st and 2nd Edition pages.
- Android back button now closes the 3rd Edition pop-ups first.
- Units with either/or wargear (e.g. Mounted Praetor) now show both weapon profiles.

## 2026-11-21: Optional Ork Ramshackle table
- 1st Edition: the Ork Trukk's Ramshackle rule now includes the optional Forge World Ramshackle table (Kaboom!/Kareen!/Kerrunch!), labelled as optional and only used if both players agree. Shown only with the 7th edition codices tickbox on.

## 2026-11-21: Error check
- Full audit of all three editions: every unit card rendered with options maxed, points, profiles, option lists, detachments and army checks. No script errors.
- 1st Edition: the Necron Cryptek's Solar Staff option no longer points at a Melee Weapons group the Cryptek doesn't have.
- 1st Edition purity check still clean (0 differences with all extras off).

## 2026-11-21: 3rd Edition – weapon profiles
- Added about 250 weapon profiles from Wahapedia datasheets and armoury sections: Primarch and character relics, Solar Auxilia super-heavy weapons, Mechanicum/Talons/Daemon weapons, Legion-specific melee weapons, forge-crafted weapons.
- "Power weapon", "Force weapon" and "Perdition weapon" now show every profile you can pick from.
- Better weapon matching for pintle/sponson/hull-mounted and plural names.

## 2026-11-20: 3rd Edition – Militia Provenances and Cohort Doctrines
- Imperialis Militia Provenances of War (all 19): one per army, two with a Planetary Overlord; Traitor-only ones respected. Their extra wargear-list items, unit upgrades (Frenzon, Repair Automata, rad grenades, Exo-riggers, boarding shields, Expendable, Voidjumpers) and borrowed units (Triaros/Krios, Rhino/Termite/Land Raider Carrier) appear only when chosen.
- Solar Auxilia Cohort Doctrine picker (one per army) with each doctrine's rules.
- Export text lists Provenances, Cohort Doctrine, Oaths of Moment and Shattered Legions choices.

## 2026-11-20: 3rd Edition – Talons check
- Gyrfalcon Jetbike Sodality, Pallas Grav-attack and Caladius Grav-tank checked against Liber Custodes: points, sizes, profiles and options match.
- Gyrfalcon: the Adrathic devastator and twin corvae las-pulser swaps now share one limit (one swap per model).

## 2026-11-20: 3rd Edition – GW downloads (FAQ Oct 26, Legacies, Primary Detachments)
- Checked every unit in the Legacies documents (Age of Darkness, Imperialis Militia, Legiones Inductii, Legio Custodes, Daemons, Blackshields) against the data: points and unit sizes all match.
- New Legiones Astartes Primary Detachments (pick from the Primary Detachment box): Pride of the Legion, Fury of the Ancients, Sky-Hunter Phalanx, Armoured Spearhead, Orbital Drop Assault, with their slot charts, added slots, allowed detachments, Prime Advantages and restrictions.
- Legiones Decurion upgrades on Predator, Sicaran, Kratos, Fellblade and Falchion.
- Imperialis Militia Apex and Auxiliary Detachments (Grenadier Muster, Ogryn Auxilia, Infantry Cohort, Artillery Division, Cavalry Wing, Armoured Phalanx, Oversight Delegation, Storm Cadre, Daemonic Manifestation).
- Battlefield Fortifications Detachment with all nine fortifications; Infernus Abomination via the Cult Operative Prime Advantage.
- Blackshields Oaths of Moment (with slot changes for Pride is our Armour, Alone and Forgotten, In Disgrace all are Equal, Panoply of Old armoury, Taint of the Xenos weapons).
- Shattered Legions faction: choose 2–3 Legions, their armouries, named commanders and the Exemplars of the Legion Prime Advantage.
- FAQ: Lord of Automata adds a Castellax slot; Logistical Benefit slots keep the detachment's restrictions; one Ætheric Dominion per Daemon army.

## 2026-11-20: 3rd Edition – all army lists
- Added the other 3rd Edition army lists from Wahapedia: Solar Auxilia, Mechanicum (Taghmata), Imperialis Militia, Questoris Familia, Legio Titanicus, Talons of the Emperor and Ruinstorm Daemons (184 datasheets).
- Faction pickers now offer every Legion plus the other army lists; Lord of War and Allied Detachments can use any of them.
- Knight and Titan profiles show their own columns (Front/Rear, Primary/Exposed by location); weapons are looked up per army list.
- Ruinstorm Daemons: each unit must choose an Ætheric Dominion. Talons: Clade Operative adds three Assassin-only Support slots. Faction Prime Advantages added.
- Talons of the Emperor are Loyalist-only and Ruinstorm Daemons Traitor-only.
- Faction-specific detachments (Tercios, Taghmata maniples, Militia musters, Knight Households, Titan Ordinal) are not in yet: their slot counts are not on Wahapedia.

## 2026-11-20: 3rd Edition – chart layout
- **New Chart layout (the default),** switchable with the List layout from the Army heading:
  - each detachment is drawn like the Force Organisation charts in the rulebook: role icons in the book's rows, with a starburst around Prime slots;
  - filled slots turn solid with a tick and show the unit's name and points underneath;
  - tapping an empty slot opens a filterable unit picker; tapping a filled slot opens its unit card (Prime Advantage, model count, wargear, profiles and weapons) as a pop-up.
- **Choosing a detachment:** "+ Add detachment" opens a picker that shows each detachment's slots as icons, how many you have unlocked, and why any are unavailable.
- Export text now opens in a pop-up too.

## 2026-11-20: 3rd Edition – checked against the books
- **Checked the Legiones Astartes data against Liber Astartes, Liber Hereticus, the rulebook and the Journal Tactica supplements.** Points, unit sizes, per-model costs and profiles matched for every datasheet in those books, apart from the fixes below.
- **Fixes:**
  - Deathwing Companion Detachment: Oathbearer Leadership 9, Companions 8 (they were swapped);
  - Drop Pod and Phraetus Anointed Conclave now use the book names;
  - Javelin Squadron: added its cyclone missile launcher swap options;
  - Exalted Conclave: all four slots are Prime;
  - Sons of Bodt: no longer limited to Traitor armies.
- **New detachments from the books:** Linebreaker Echelon, Maelstrom Sentry Battery, Veteran Cadre, Apothecarion Delegation, Techmarine Covenant, Storm Battery, Recon Demi-Company and Planetfall Speartip.

## 2026-11-20: 3rd Edition builder (Legiones Astartes)
- **Added a 3rd Edition tab** to the edition switch at the top of every page, alongside 1st and 2nd Edition.
- **New 3rd Edition builder (`3e.html`),** starting with the Legiones Astartes army list from Wahapedia:
  - 330 datasheets with profiles, points, unit sizes, wargear, special rules, traits and options;
  - weapon profiles in the 3rd edition format (R, FP, RS, AP, D; IM, AM, SM for melee) and the Legion wargear lists.
- **Army building:**
  - Crusade Primary Detachment with Prime slots and Prime Advantages, including Logistical Benefit's extra slot and Special Assignment;
  - Apex and Auxiliary Detachments unlocked by filled High Command and Command slots, plus the Legion-specific Detachments;
  - Warlord, Lord of War and Allied Detachments, with the 25% and 50% caps and Unique and 0-1 checks;
  - saved lists and text export.
- **Android app:** now ships and updates `3e.html` too (this needs the new APK).

## 2026-11-18: 1st Edition – Legion Terminator Indomitus Squad (Post-Edition)
- **Added the Legion Terminator Indomitus Squad to the 1st Edition Post-Edition units,** converted from the 2nd edition Legacies: Legiones Astartes datasheet.
- **Rules:** it is a Troops choice with Support Squad. Under Pride of the Legion it can fill compulsory Troops.
- **Wargear and options:**
  - Proteus assault cannon, Proteus storm shield, chainfists, thunder hammers, lightning claws, and the vexilla, augury scanner and nuncio-vox;
  - Dedicated Transport: Land Raider Proteus or Dreadclaw.
- **Profile and points:** profiles follow the 1.0 Terminator Squad (W1). Options cost the same as the 1.0 Terminator Squad's where they match.

## 2026-11-18: Dedicated Transports linked to their units (both editions)
- **New "Dedicated Transport" menu on each unit** that may take one. It lists only the transports that unit's datasheet allows, read from its own text, plus transports a Rite of War grants. Pick one and it appears indented under the unit. Its points count towards the unit's slot, and it takes no slot of its own.
- **Transports that list their passengers are included,** for example the Aurox for Auxilia command and Veletaris sections, and the Sons of Horus Dreadclaw.
- **2nd edition:** a Land Raider Proteus Carrier, Spartan, Dreadclaw, Kharybdis or Storm Eagle chosen this way no longer uses a Heavy Support or Fast Attack slot.
- **New list checks:**
  - a Dedicated Transport that doesn't belong to a unit;
  - a transport the unit isn't allowed;
  - a unit that is too large for its transport, such as a Tactical Squad over 10 models with a Rhino, or Terminators over 5 with a Land Raider.
- **Handling:**
  - Adding a transport from the library links it to a unit that can take one and doesn't have one yet.
  - Lists saved earlier have their loose transports linked the same way.
  - Removing or moving a unit takes its transport with it. This also works for a transport on an attached Command Squad.

## 2026-11-18: App – newer installs are no longer hidden by older downloaded data
- **Fix:** installing a new APK now drops any copy of the builder pages downloaded through Settings before that install. Previously an older download kept being shown, so changes like the Attached units box didn't appear after updating the app.

## 2026-11-18: Attached units on leader cards (both editions)
- **New "Attached units" box on a leader's card**, above Wargear options. It lists the units that can join that leader outside the Force Organisation chart. Pick one and press Add; it appears indented under its leader and takes no slot.
- **1st edition:**
  - Zardu Layak → Anakatis Kul Blade-slaves;
  - Leman Russ → Wolf-kin of Russ;
  - Praetor, Lion El'Jonson and the Deathwing masters → Deathwing Companion Detachment;
  - Praetor, Primarchs and unique Master of the Legion characters → Legion Command Squad;
  - Praetor and Centurion (including Saturnine) → Saturnine Terminator Command Squad;
  - xenos: Archon → Court of the Archon; Ork HQs → Greenskin Engineer; Apex Predator → Apex Guard.
- **2nd edition:**
  - Master of the Legion → Legion, Cataphractii and Tartaros Command Squads (Retinue);
  - Silent Sisterhood leaders → Questora and Raptora Cadres;
  - Praetors and Centurions → Saturnine Terminator Command Squad (with the 3rd Edition units box ticked).
  - Retinue squads no longer use up an HQ slot once attached. A Retinue left unattached gets a list check.
- **Handling:**
  - Adding one of these units from the library attaches it to a suitable leader automatically.
  - Removing a leader removes what's attached to it.
  - Moving a leader to another Detachment brings its attached units along.

## 2026-11-18: 2nd Edition – 3rd Edition units tickbox
- **New tickbox on the Army tab:** "3rd Edition units (optional, converted to 2nd edition rules)". With it off, the 2nd Edition list is unchanged.
- **First batch of units:**
  - Saturnine: Praetor and Centurion in Saturnine Terminator Armour, the Command Squad, the Terminator Squad and the Saturnine Dreadnought;
  - Araknae Quad Accelerator Platform;
  - Legion Veteran Assault Squad and Legion Veteran Breacher Squad;
  - Angron Transfigured (cannot share an army with Angron);
  - Solar Auxilia Hermes Command Section.
  Each unit comes with its weapons, wargear and rules.
- **Conversion notes** are in Rules → Army rules (other factions) → 3rd Edition units. In short:
  - 3rd edition Damage 3+ becomes Brutal;
  - Breaching moves one step;
  - Overload becomes Gets Hot;
  - Terminator armour loses the extra point of Toughness 3rd edition added;
  - points are the 3rd edition values.
- **Fixes:**
  - about 115 bits of rules text the PDF reader had mistaken for weapons are gone from 2nd edition weapon cards;
  - real weapons it had misnamed are restored, such as the Plasma burner and incinerator, Infernus, Devotion and the Skyreaper battery;
  - the Conversion beam cannon profiles are added;
  - assault grenade launchers no longer appear on every unit with frag grenades;
  - duplicate weapon rows are merged.

## 2026-11-18: 2nd Edition – Daemons of the Ruinstorm
- **New faction: Daemons of the Ruinstorm** (Legacies v1.0), with all 15 units, from the Sovereign to Ka'bandha, Cor'bax Utterblight and Samus Unbound.
- **Ætheric Dominion:** pick it on each unit at no cost. List checks make sure every unit in a Detachment shares one (Lords of War may differ) and that no unit is left without one.
- **Army rules:**
  - Traitor only.
  - A Daemon army can only add Ruinstorm Lords of War, and other armies cannot take Daemons in an optional Detachment.
- **Reference:** Daemon Warlord Traits, armoury, weapons and special rules, plus the Gargantuan sub-type.
- **Fix:** weapon cards no longer show six stray sub-profiles (such as "(Ranged)") on every unit. Those profiles now carry their proper names: The Logos Array, The Talon, Phosphex shell and Needlespine blaster.

## 2026-11-18: 2nd Edition – campaign books
- **The Battle for Beta-Garmon:**
  - **Shattered Legions:** a faction in its own right. Pick the Legion each unit represents, with 2-3 Legions per Detachment. Veteran Squads count as Troops. No other Detachments, Primarchs or Legion-specific units.
  - **Blackshields:** a faction in its own right, with the Oaths of Vengeance and Wrath picked on the Army tab (up to two, choosing the Legion for The Eternal Vendetta and Panoply of Old). No Rites of War, plus its own Warlord Traits.
  - Mutable Tactics and Legiones Auxilia rules for reference.
  - The Overseer consul, whose Overseer's Retinue brings Solar Auxilia Rifle Sections or Militia Infantry Squads into a Legion army.
  - New Solar Auxilia units (Hermes and Aethon Sentinels, Lifeward Section), plus Horus Aximand, Hibou Khan, Endryd Haar, the Legion Optae and the Company Command Squad.
- **Exemplary Battles Vol. 1:**
  - new units: Atramentar, Dominator Cohort, Red Hand Destroyers, Nemesis Destroyers, Sanctifiers and the Arcology Brutes (for their missions only);
  - Fulgrim Transfigured and the Daemon Primarch rules;
  - two Corrupted Rites of War for the Emperor's Children, which need Fulgrim Transfigured;
  - the Armoury of Indulgence.
- **The Siege of Cthonia:**
  - Lord-Castellan Evander Garrius and Vheren Ashurhaddon;
  - extra Imperial Fists and Sons of Horus Warlord Traits;
  - Legiones Decurion upgrades on Predators, Sicarans and Kratos;
  - all 18 Inductii templates on Tactical or Despoiler Squads;
  - the Infernus Abomination Cult Operative.
- **Missions:**
  - the 2023 Core Missions (5);
  - Apex missions from Beta-Garmon and Cthonia (4);
  - the Zone Mortalis core rules, Core Missions and Apex missions;
  - the ten Exemplary Battles missions.
- **Gaps closed:**
  - **Cohort Doctrines** now change slots and options (for example Veletaris as Troops, Armoured Command as HQ, and Thallax and Castellax under the Iron Pattern).
  - **Titan Maniple or Household Detachment:** now its own optional Detachment, alongside an Allied Detachment.
  - **Special rule text:** every special rule on a unit card now has its text.
- **Fix:** several 1st edition Legion army-building checks no longer apply in 2nd Edition.
- **Total:** the 2nd Edition builder now has 428 units in 27 factions and 40 mission pages.

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
