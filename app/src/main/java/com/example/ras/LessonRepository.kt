package com.example.ras

object LessonRepository {
    fun getLessons(): List<Lesson> {
        return listOf(
            Lesson(
                id = "day_1",
                dayTitle = "Day 1",
                street = StreetSection(
                    title = "Negotiating an Auto",
                    dialogue = listOf(
                        DialogueLine("d1_s_1", "Passenger", "भैया, कनॉट प्लेस चलोगे?", "Brother, will you go to Connaught Place?"),
                        DialogueLine("d1_s_2", "Auto Driver", "हाँ, बैठिये। कहाँ जाना है ठीक से बताइये।", "Yes, sit. Tell me exactly where to go."),
                        DialogueLine("d1_s_3", "Passenger", "इनर सर्कल जाना है। मीटर से चलोगे?", "I need to go to the Inner Circle. Will you go by meter?"),
                        DialogueLine("d1_s_4", "Auto Driver", "मीटर नहीं, साहब। २०० रुपये फिक्स।", "No meter, sir. 200 rupees fixed."),
                        DialogueLine("d1_s_5", "Passenger", "ये तो बहुत ज़्यादा है! १५० रुपये ठीक हैं।", "That is too much! 150 rupees is fair."),
                        DialogueLine("d1_s_6", "Auto Driver", "आगे बहुत ट्रैफ़िक है, टाइम लगेगा। १८० दे दीजिये।", "There is a lot of traffic ahead, it will take time. Give 180."),
                        DialogueLine("d1_s_7", "Passenger", "ठीक है, चलो। लेकिन ट्रैफ़िक से मत ले जाना।", "Okay, let's go. But don't take [us] through the traffic."),
                        DialogueLine("d1_s_8", "Auto Driver", "फ़िक्र मत कीजिये, मैं छोटे रास्ते से ले चलूँगा।", "Don't worry, I will take you via the shortcut.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d1_v_1", "चलना (chalnā)", "To move/go", "Verb (Intransitive). Context: Asking the driver to move."),
                        VocabItem("d1_v_2", "भैया (bhaiyā)", "Brother", "Noun (M). Common, polite way to address a male stranger."),
                        VocabItem("d1_v_3", "बैठिये (baiṭhiye)", "Please sit", "Verb (Imperative, Formal 'Aap' form)."),
                        VocabItem("d1_v_4", "ठीक से (ṭhīk se)", "Properly/Exactly", "Adverb phrase."),
                        VocabItem("d1_v_5", "मीटर (mīṭar)", "Meter", "Noun (M). Loan word from English."),
                        VocabItem("d1_v_6", "ज़्यादा (zyādā)", "Too much/More", "Adjective. Originally Persian."),
                        VocabItem("d1_v_7", "रुपये (rupaye)", "Rupees", "Noun (M, Pl). Currency."),
                        VocabItem("d1_v_8", "आगे (āge)", "Ahead", "Adverb of place."),
                        VocabItem("d1_v_9", "रास्ता (rāstā)", "Way/Route", "Noun (M)."),
                        VocabItem("d1_v_10", "फ़िक्र (fikr)", "Worry/Concern", "Noun (F). Urdu origin.")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Future Tense: -oge vs -enge", "In Hindi, future tense suffixes depend on the subject's respect level. 'Chaloge' (चलोगे) ends in '-oge' because the passenger uses 'Tum' (informal you) for the driver. If speaking formally, it would be 'Chalenge' (चलेंगे) for 'Aap'.\nFormula: Tum + stem + oge | Aap + stem + enge"),
                        GrammarPoint("Imperatives & Respect", "Commands reflect social hierarchy. The driver uses 'Baithiye' (Sit, formal) with the suffix '-iye' for the customer (Aap). The customer implies 'Tum' by asking 'Chaloge?'."),
                        GrammarPoint("Postposition 'Se'", "'Se' (से) is a versatile marker.\n1. Instrumental: 'Meter se' = By means of the meter.\n2. Path/Via: 'Raaste se' = Via the route.\nIt connects the noun to the action.")
                    )
                ),
                court = CourtSection(
                    title = "The Grief of Amir Khusrau",
                    poemLines = listOf(
                        "गोरी सोवे सेज पर, मुख पर डारे केस।",
                        "चल खुसरो घर आपने, साँझ भई चहुँ देस॥",
                        "Gori sove sej par, mukh par ḍāre kes",
                        "Chal Khusrau ghar āpne, sāñjh bhaī chahuñ des"
                    ),
                    analysis = "This legendary doha (couplet) was uttered by Amir Khusrau immediately upon seeing the face of his deceased spiritual master, Nizamuddin Auliya. It is a masterpiece of Sufi ambiguity.\n\n**The Sufi Context (Urs):** In Sufism, death is not a tragedy but a 'Wedding' (Urs)—the soul's reunion with the Divine. Khusrau sees his master not as a corpse, but as a 'Gori' (fair maiden/bride) finally resting on the 'Sej' (bridal bed) after the long struggle of life, her face covered in the veil of mystery (Kes).\n\n**The Human Grief:** Simultaneously, the second line shifts to Khusrau's personal despair. 'Saanjh bhaī' (Evening has fallen) signifies the setting of the sun on his own life. With his guide gone, the world ('Chahu des') has plunged into darkness.",
                    wordBreakdown = listOf(
                        WordAnalysis("d1_c_1", "गोरी (Gori)", "Fair maiden", "The Soul (of the Saint), pure and ready for union."),
                        WordAnalysis("d1_c_2", "सोवे (Sove)", "Sleeps", "Death / Eternal Rest / The state of Union."),
                        WordAnalysis("d1_c_3", "सेज (Sej)", "Bed (bridal)", "The bier / Grave / The place of final union."),
                        WordAnalysis("d1_c_4", "मुख (Mukh)", "Face", "Identity / Earthly presence."),
                        WordAnalysis("d1_c_5", "केस (Kes)", "Hair", "Veil / Darkness / The mystery of death."),
                        WordAnalysis("d1_c_6", "घर आपने (Ghar Aapne)", "To [my] own house", "The true home (The Divine/Afterlife)."),
                        WordAnalysis("d1_c_7", "साँझ (Saanjh)", "Evening", "The end of life / The onset of spiritual darkness."),
                        WordAnalysis("d1_c_8", "चहुँ देस (Chahuñ Des)", "All 4 directions", "The entire physical world (now empty).")
                    )
                )
            )
        )
    }
}
