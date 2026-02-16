# Ras (रस) - Product Context

## 1. Product Vision: "The Palace of Life"
**Ras** is not just a language app; it is a dual-track journey into the soul of Hindi. It rejects the sterile "tourist phrasebook" approach in favor of a holistic experience that balances **Survival** (The Street) with **Wisdom** (The Court).

*   **Concept:** A digital "Palace" with two distinct wings.
    *   **Gali (The Street):** The chaotic, vibrant, practical world of everyday India.
    *   **Leela (The Court):** The refined, spiritual, poetic world of India's history and philosophy.

## 2. Core Experience
The user navigates through **Days**, each split into two contrasting halves:

### 🟢 Gali (Street Mode) - *Functional Hindi*
*   **Goal:** Survival and utility.
*   **Content:** Realistic dialogues (Auto rickshaws, ordering food, bargaining, pharmacy).
*   **UI Vibe:** Earthy, beige/green, "Sandstone", clean, modern, functional.
*   **Key Features:**
    *   **Dialogue Bubbles:** Bilingual (Hindi/English) conversational flows.
    *   **Vocabulary:** Practical word lists with context.
    *   **Grammar Cards:** Bite-sized rules (e.g., "Future Tense: -oge vs -enge").

### 🟡 Leela (Court Mode) - *Aesthetic Hindi*
*   **Goal:** Appreciation and depth.
*   **Content:** Poetry, philosophy, and literature (Amir Khusrau, Kabir, Ghalib, Mirabai, Premchand).
*   **UI Vibe:** Dark, gold/black, "Mandala", "Glassy", elegant, serif fonts.
*   **Key Features:**
    *   **Poetry Cards:** Center-aligned Shlokas/Dohas/Sher.
    *   **Deep Analysis:** Cultural context (e.g., Sufi double-meanings).
    *   **Lexicon:** Word breakdown showing **Literal** vs **Metaphorical** meanings.

## 3. Architecture & Tech Stack
*   **Platform:** Android (Native)
*   **Language:** Kotlin
*   **UI Framework:** Jetpack Compose (Material3)
*   **Audio:** Native `MediaPlayer` integration for word/sentence pronunciation.
*   **Assets:**
    *   **Audio:** Generated via Python scripts (`generate_audio.py`) using TTS, stored in `res/raw`.
    *   **Fonts:** `Eczar` (Headings/Devanagari flavor) & `Lato` (Body/Readability).
    *   **Images:** Background textures (`bg_sandstone.jpg`, `bg_leela_combined.jpg`).

## 4. Data Model
The app drives off a static `LessonRepository` containing a list of `Lesson` objects:

```kotlin
data class Lesson(
    val id: String,          // e.g., "day_1"
    val dayTitle: String,    // e.g., "Day 1"
    val street: StreetSection,
    val court: CourtSection
)
```

*   **StreetSection:** `title`, `dialogue` (List), `vocabulary` (List), `grammarGuides` (List).
*   **CourtSection:** `title`, `poemLines` (List), `analysis` (String), `wordBreakdown` (List).

## 5. Design System
*   **Typography:**
    *   **Headings:** `Eczar` (Variable weight). Used for titles and Hindi poetry.
    *   **Body:** `Lato`. Used for English translations and explanations.
*   **Components:**
    *   **ClayCard:** A custom surface with shadow/elevation to mimic tactile cards.
    *   **TabButton:** Custom pill-shaped toggle for switching between Gali and Leela.
*   **Theming:**
    *   **StreetPalette:** Primary Green (`#2E7D32`), Background Off-White (`#FDFCF0`).
    *   **CourtPalette:** Primary Gold (`#FFD700`), Background Dark/Transparent (`Color.Black` overlay).

## 6. Current Content (The 7 Days)
1.  **Day 1:** Auto Rickshaw Negotiation (Street) / Amir Khusrau's Grief (Court)
2.  **Day 2:** Asking Directions (Street) / Kabir's Truth (Court)
3.  **Day 3:** Ordering Food (Street) / Ghalib's Desire (Court)
4.  **Day 4:** Market Bargaining (Street) / Mirabai's Devotion (Court)
5.  **Day 5:** Family Introduction (Street) / Premchand's *Godaan* (Court)
6.  **Day 6:** Pharmacy/Sick (Street) / Tulsidas' *Ramcharitmanas* (Court)
7.  **Day 7:** Train Travel (Street) / The Gita's Karma (Court)

## 7. Future/Missing
*   **Dynamic Content:** Move from hardcoded `LessonRepository` to JSON/Database.
*   **User Progress:** Tracking completed days.
*   **Quiz Mode:** Interactive testing of learned vocab.
