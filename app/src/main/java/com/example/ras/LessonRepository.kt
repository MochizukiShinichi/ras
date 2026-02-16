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
            ),
            Lesson(
                id = "day_2",
                dayTitle = "Day 2",
                street = StreetSection(
                    title = "Asking for Directions",
                    dialogue = listOf(
                        DialogueLine("d2_s_1", "Tourist", "माफ़ कीजिये, लाल किला कहाँ है?", "Excuse me, where is the Red Fort?"),
                        DialogueLine("d2_s_2", "Local", "सीधे जाइये, फिर बाएँ मुड़िये।", "Go straight, then turn left."),
                        DialogueLine("d2_s_3", "Tourist", "क्या यह यहाँ से दूर है?", "Is it far from here?"),
                        DialogueLine("d2_s_4", "Local", "नहीं, बस दस मिनट का रास्ता है।", "No, it's just a 10-minute way."),
                        DialogueLine("d2_s_5", "Tourist", "क्या मैं पैदल जा सकता हूँ?", "Can I go on foot?"),
                        DialogueLine("d2_s_6", "Local", "हाँ, बिल्कुल। मौसम भी अच्छा है।", "Yes, absolutely. The weather is also nice."),
                        DialogueLine("d2_s_7", "Tourist", "शुक्रिया भाई साहब।", "Thank you, brother."),
                        DialogueLine("d2_s_8", "Local", "कोई बात नहीं।", "No problem (It's nothing).")
                    ),
                    vocabulary = listOf(
                        VocabItem("d2_v_1", "माफ़ कीजिये (māf kījiye)", "Excuse me/Forgive me", "Formal way to start a conversation with a stranger."),
                        VocabItem("d2_v_2", "कहाँ (kahāñ)", "Where", "Interrogative adverb."),
                        VocabItem("d2_v_3", "सीधे (sīdhe)", "Straight", "Direction."),
                        VocabItem("d2_v_4", "बाएँ (bāeñ)", "Left", "Direction. Right is 'Dāeñ' (दाएँ)."),
                        VocabItem("d2_v_5", "मुड़िये (muṛiye)", "Turn", "Imperative (Formal). Root: Muṛnā."),
                        VocabItem("d2_v_6", "दूर (dūr)", "Far", "Adjective/Adverb."),
                        VocabItem("d2_v_7", "पैदल (paidal)", "On foot", "Mode of travel."),
                        VocabItem("d2_v_8", "मौसम (mausam)", "Weather", "Noun (M). Arabic origin.")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Interrogatives", "Question words like 'Kahāñ' (Where), 'Kyā' (What/Is it?) usually come before the verb or at the start of yes/no questions."),
                        GrammarPoint("Giving Directions", "Use 'Jāiye' (Go) and 'Muṛiye' (Turn) for polite instructions. 'Seedhe' means straight ahead."),
                        GrammarPoint("Possession 'Ka'", "'Das minute ka rasta' (10 minute's way). 'Ka' changes to 'Ki' or 'Ke' depending on the gender/number of the object (Rasta is Masc. Sing., so 'Ka').")
                    )
                ),
                court = CourtSection(
                    title = "Kabir's Truth",
                    poemLines = listOf(
                        "पोथी पढ़ि पढ़ि जग मुआ, पंडित भया न कोय।",
                        "ढाई आखर प्रेम का, पढ़े सो पंडित होय॥",
                        "Pothi paḍhi paḍhi jag muā, pandit bhayā na koy",
                        "Ḍhāī ākhar prem kā, paḍhe so pandit hoy"
                    ),
                    analysis = "Kabir Das, the great weaver-poet, challenges the orthodoxy of bookish knowledge. He asserts that true wisdom comes not from scriptures but from love.\n\n**The Critique:** 'Pothi' refers to heavy religious scriptures. Kabir says the world has died (wasted its life) reading them, yet no one became truly wise ('Pandit').\n\n**The Solution:** The 'Two and a half letters' (Dhai Akhar) refer to the word 'Prem' (Love) - which in Hindi script is arguably composed of two and a half strokes/sounds. Understanding love makes one a true knower.",
                    wordBreakdown = listOf(
                        WordAnalysis("d2_c_1", "पोथी (Pothi)", "Book/Scripture", "Symbol of rigid, theoretical knowledge."),
                        WordAnalysis("d2_c_2", "मुआ (Mua)", "Died", "Metaphor for wasted effort/spiritual death."),
                        WordAnalysis("d2_c_3", "पंडित (Pandit)", "Scholar/Wise man", "The goal of intellectual pursuit."),
                        WordAnalysis("d2_c_4", "भया (Bhaya)", "Became", "State of being."),
                        WordAnalysis("d2_c_5", "ढाई (Dhai)", "Two and a half", "Refers to the brevity/simplicity of Truth vs complex texts."),
                        WordAnalysis("d2_c_6", "आखर (Akhar)", "Letter/Alphabet", "The building block of words."),
                        WordAnalysis("d2_c_7", "प्रेम (Prem)", "Love", "Divine love/Bhakti."),
                        WordAnalysis("d2_c_8", "होय (Hoy)", "Becomes", "Transformation.")
                    )
                )
            ),
            Lesson(
                id = "day_3",
                dayTitle = "Day 3",
                street = StreetSection(
                    title = "Ordering Food",
                    dialogue = listOf(
                        DialogueLine("d3_s_1", "Server", "नमस्ते साहब, क्या लाऊँ?", "Namaste Sir, what should I bring?"),
                        DialogueLine("d3_s_2", "Customer", "मेनू दीजिये। क्या ताज़ा है?", "Give me the menu. What is fresh?"),
                        DialogueLine("d3_s_3", "Server", "आज दाल मखनी और पनीर बटर मसाला बहुत अच्छे हैं।", "Today Dal Makhani and Paneer Butter Masala are very good."),
                        DialogueLine("d3_s_4", "Customer", "एक दाल और दो बटर नान दीजिये।", "Give one Dal and two Butter Naans."),
                        DialogueLine("d3_s_5", "Server", "मिर्च कैसी रखूँ? ज़्यादा या कम?", "How should I keep the spice? More or less?"),
                        DialogueLine("d3_s_6", "Customer", "कम मिर्च रखियेगा। और पानी की बोतल भी।", "Keep the spice low (polite future). And a water bottle too."),
                        DialogueLine("d3_s_7", "Server", "ठीक है। दस मिनट में आता है।", "Okay. It comes in 10 minutes."),
                        DialogueLine("d3_s_8", "Customer", "जल्दी कीजिये, मुझे भूख लगी है।", "Hurry up, I am hungry.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d3_v_1", "लाऊँ (lāūñ)", "Shall I bring?", "Verb 'Lana' (Bring) in Subjunctive mood."),
                        VocabItem("d3_v_2", "ताज़ा (tāzā)", "Fresh", "Adjective. Persian origin."),
                        VocabItem("d3_v_3", "दाल (dāl)", "Lentils", "Staple food."),
                        VocabItem("d3_v_4", "मिर्च (mirch)", "Chili/Spice", "Noun (F)."),
                        VocabItem("d3_v_5", "रखूँ (rakhūñ)", "Should I keep?", "Verb 'Rakhna' (Keep/Put) in Subjunctive."),
                        VocabItem("d3_v_6", "भूख (bhūkh)", "Hunger", "Noun (F). 'Mujhe bhookh lagi hai' = Hunger has struck me."),
                        VocabItem("d3_v_7", "जल्दी (jaldī)", "Quickly/Hurry", "Adverb."),
                        VocabItem("d3_v_8", "आता है (ātā hai)", "Comes", "Present tense used for immediate future.")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Subjunctive 'May I'", "Verbs ending in '-ūñ' (लाऊँ, रखूँ) imply 'Shall I?' or 'May I?'. It asks for permission or instruction."),
                        GrammarPoint("Feeling Sensations", "In Hindi, you don't 'be' hungry, hunger 'happens' to you. 'Mujhe bhookh lagi hai' (To me, hunger is felt/attached). Same for thirst (pyaas) and cold (thand)."),
                        GrammarPoint("Polite Future", "'Rakhiyega' is a polite future imperative. 'Please keep it (in the future)'.")
                    )
                ),
                court = CourtSection(
                    title = "Ghalib's Wine & Love",
                    poemLines = listOf(
                        "हज़ारों ख़्वाहिशें ऐसी कि हर ख़्वाहिश पे दम निकले,",
                        "बहुत निकले मेरे अरमान लेकिन फिर भी कम निकले।",
                        "Hazāron khwāhishen aisī ki har khwāhish pe dam nikle",
                        "Bahut nikle mere armān lekin phir bhī kam nikle"
                    ),
                    analysis = "Mirza Ghalib encapsulates the insatiable nature of human desire. This sher (couplet) is one of the most quoted lines in Urdu/Hindi literature.\n\n**The Paradox:** He has 'thousands' of desires, each so intense that it could consume his life ('dam nikle' - breath leaves). Many desires were fulfilled ('nikle'), yet so many remain that it feels like too few were met.\n\n**Philosophical Note:** It highlights the tragic beauty of life—defined not by satisfaction, but by the relentless pursuit of longing.",
                    wordBreakdown = listOf(
                        WordAnalysis("d3_c_1", "हज़ारों (Hazāron)", "Thousands", "Plural of Hazar."),
                        WordAnalysis("d3_c_2", "ख़्वाहिशें (Khwāhishen)", "Desires/Wishes", "Urdu noun (F)."),
                        WordAnalysis("d3_c_3", "दम निकले (Dam nikle)", "Breath leaves", "To die / To spend a lifetime."),
                        WordAnalysis("d3_c_4", "अरमान (Armān)", "Longings/Yearnings", "Similar to Khwahish but deeper."),
                        WordAnalysis("d3_c_5", "फिर भी (Phir bhī)", "Even then/Still", "Conjunction."),
                        WordAnalysis("d3_c_6", "कम (Kam)", "Few/Less", "Adjective.")
                    )
                )
            ),
            Lesson(
                id = "day_4",
                dayTitle = "Day 4",
                street = StreetSection(
                    title = "Bargaining at the Market",
                    dialogue = listOf(
                        DialogueLine("d4_s_1", "Shopper", "यह कुर्ता कितने का है?", "How much is this Kurta?"),
                        DialogueLine("d4_s_2", "Shopkeeper", "पूरी तरह से रेशम है, ५००० रुपये।", "It is entirely silk, 5000 rupees."),
                        DialogueLine("d4_s_3", "Shopper", "अरे! बहुत महंगा है। सही दाम लगाइये।", "Oh! It's very expensive. Apply the right price."),
                        DialogueLine("d4_s_4", "Shopkeeper", "मैडम, क्वालिटी देखिये। अच्छा, ४५०० दीजिये।", "Madam, look at the quality. Okay, give 4500."),
                        DialogueLine("d4_s_5", "Shopper", "नहीं, मैं २५०० से ज़्यादा नहीं दूँगी।", "No, I will not give more than 2500."),
                        DialogueLine("d4_s_6", "Shopkeeper", "इतने में तो मुझे भी नहीं मिला! ३५०० लास्ट।", "I didn't even get it for that much! 3500 last."),
                        DialogueLine("d4_s_7", "Shopper", "ठीक है, ३००० लीजिये, नहीं तो मैं जा रही हूँ।", "Okay, take 3000, otherwise I am going."),
                        DialogueLine("d4_s_8", "Shopkeeper", "चलिए, आपकी बात रही। पैक कर देता हूँ।", "Alright, let it be your way (your word remains). I will pack it.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d4_v_1", "कुर्ता (kurtā)", "Tunic/Shirt", "Traditional upper garment."),
                        VocabItem("d4_v_2", "कितने का (kitne kā)", "Of how much?", "Common phrase for asking price."),
                        VocabItem("d4_v_3", "महंगा (mahangā)", "Expensive", "Adjective. Antonym: Sasta (Cheap)."),
                        VocabItem("d4_v_4", "दाम (dām)", "Price/Rate", "Noun (M)."),
                        VocabItem("d4_v_5", "लगाइये (lagāiye)", "Apply/Fix", "Context: Fix the price."),
                        VocabItem("d4_v_6", "क्वालिटी (quality)", "Quality", "English loan word used commonly."),
                        VocabItem("d4_v_7", "लास्ट (last)", "Last/Final", "Used for 'Final Price'."),
                        VocabItem("d4_v_8", "पैक (pack)", "Pack", "Verb: Pack karna.")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Genitive Price", "Asking price uses 'Ka/Ki'. 'Yeh kitne ka hai?' (Of how much is this?)."),
                        GrammarPoint("Conditionals", "'Nahi to' means 'Otherwise' or 'Else'. '3000 lijiye, nahi to main ja rahi hoon' (Take 3000, else I am going)."),
                        GrammarPoint("Compound Verbs", "'Pack kar deta hoon'. 'Dena' (to give) here adds the nuance of doing something for someone else (benefactive).")
                    )
                ),
                court = CourtSection(
                    title = "Mirabai's Devotion",
                    poemLines = listOf(
                        "मेरे तो गिरधर गोपाल, दूसरो न कोई।",
                        "जाके सिर मोर मुकुट, मेरो पति सोई॥",
                        "Mere to Girdhar Gopāl, dūsro na koī",
                        "Jāke sir mor mukuṭ, mero pati soī"
                    ),
                    analysis = "Mirabai, the Rajasthani princess turned mystic, declares her absolute, singular devotion to Krishna (Girdhar/Gopal). She rejects all worldly relations.\n\n**The Imagery:** She identifies her lord by the 'peacock feather crown' (Mor Mukut) on his head. She claims him as her 'husband' (Pati), defying the societal norms of her time which expected her to be a dutiful widow or wife to a mortal king.",
                    wordBreakdown = listOf(
                        WordAnalysis("d4_c_1", "गिरधर (Girdhar)", "One who holds the mountain", "Name of Krishna (Govardhan story)."),
                        WordAnalysis("d4_c_2", "गोपाल (Gopāl)", "Protector of cows", "Name of Krishna."),
                        WordAnalysis("d4_c_3", "दूसरो (Dūsro)", "Second/Other", "Another person."),
                        WordAnalysis("d4_c_4", "जाके (Jāke)", "On whose / Whose", "Braji/Rajasthani dialect for 'Jiske'."),
                        WordAnalysis("d4_c_5", "मोर (Mor)", "Peacock", "Symbol of Krishna."),
                        WordAnalysis("d4_c_6", "मुकुट (Mukuṭ)", "Crown", "Royal/Divine headgear."),
                        WordAnalysis("d4_c_7", "पति (Pati)", "Husband/Lord", "Master."),
                        WordAnalysis("d4_c_8", "सोई (Soī)", "He alone", "That very one.")
                    )
                )
            ),
            Lesson(
                id = "day_5",
                dayTitle = "Day 5",
                street = StreetSection(
                    title = "Introducing Family",
                    dialogue = listOf(
                        DialogueLine("d5_s_1", "Host", "आइये, मेरे परिवार से मिलिये।", "Come, meet my family."),
                        DialogueLine("d5_s_2", "Guest", "ज़रूर। ये कौन हैं?", "Sure. Who is this?"),
                        DialogueLine("d5_s_3", "Host", "ये मेरे पिताजी हैं, और वो मेरी माँ हैं।", "This is my father, and that is my mother."),
                        DialogueLine("d5_s_4", "Guest", "नमस्ते अंकल, नमस्ते आंटी।", "Namaste Uncle, Namaste Aunty."),
                        DialogueLine("d5_s_5", "Host", "और ये मेरा छोटा भाई है, राहुल।", "And this is my younger brother, Rahul."),
                        DialogueLine("d5_s_6", "Guest", "तुम क्या करते हो, राहुल?", "What do you do, Rahul?"),
                        DialogueLine("d5_s_7", "Rahul", "मैं कॉलेज में पढ़ता हूँ।", "I study in college."),
                        DialogueLine("d5_s_8", "Host", "हम सब साथ रहते हैं।", "We all live together.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d5_v_1", "परिवार (parivār)", "Family", "Noun (M)."),
                        VocabItem("d5_v_2", "मिलिये (miliye)", "Meet", "Imperative/Request. 'Se miliye' = Meet with."),
                        VocabItem("d5_v_3", "पिताजी (pitājī)", "Father", "Respectful term."),
                        VocabItem("d5_v_4", "माँ (mā̃)", "Mother", "Noun (F)."),
                        VocabItem("d5_v_5", "छोटा (chhoṭā)", "Small/Younger", "Adjective. 'Bada' is Big/Older."),
                        VocabItem("d5_v_6", "भाई (bhāī)", "Brother", "Noun (M)."),
                        VocabItem("d5_v_7", "पढ़ता (paṛhtā)", "Study/Read", "Verb 'Padhna'."),
                        VocabItem("d5_v_8", "साथ (sāth)", "Together", "Adverb. 'Ke saath' = With.")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Demonstratives Yeh/Woh", "'Yeh' (This/He/She close) and 'Woh' (That/He/She far). Used for introducing people. Plural/Respect forms are 'Ye' and 'Ve' (though spoken Hindi often uses Yeh/Woh for all)."),
                        GrammarPoint("Respect 'Ji'", "Adding 'Ji' to relations (Pitaji, Mataji) is crucial for showing respect to elders."),
                        GrammarPoint("Present Habitual", "Ta/Te/Ti suffixes. 'Padhta hoon' (I study - generally). 'Rehte hain' (We live - generally). Formula: Stem + ta/te/ti + hun/hai/hain.")
                    )
                ),
                court = CourtSection(
                    title = "Premchand's Godaan",
                    poemLines = listOf(
                        "होरी ने कहा - 'जब दूसरे के पाँव",
                        "तले अपनी गर्दन दबी हो, तो उन",
                        "पाँवों को सहलाने में ही कुशल है।'",
                        "Hori ne kahā - 'Jab dūsre ke pāñv",
                        "tale apnī gardan dabī ho, to un",
                        "pāñvon ko sahlāne meñ hī kushal hai.'"
                    ),
                    analysis = "A prose excerpt from 'Godaan' (The Gift of a Cow), the greatest novel of Hindi literature by Munshi Premchand. Hori, the tragic peasant protagonist, explains his survival philosophy.\n\n**The Metaphor:** It is a stark look at feudal oppression. 'When your neck is under someone else's foot, it is wise to massage that foot.' It reflects the helplessness of the Indian farmer against the zamindar (landlord) and moneylenders.",
                    wordBreakdown = listOf(
                        WordAnalysis("d5_c_1", "पाँव (Pāñv)", "Foot/Feet", "Symbol of power/oppression."),
                        WordAnalysis("d5_c_2", "तले (Tale)", "Underneath", "Postposition."),
                        WordAnalysis("d5_c_3", "गर्दन (Gardan)", "Neck", "Symbol of life/dignity."),
                        WordAnalysis("d5_c_4", "दबी (Dabī)", "Pressed/Buried", "State of being trapped."),
                        WordAnalysis("d5_c_5", "सहलाने (Sahlāne)", "To massage/stroke", "Act of appeasement."),
                        WordAnalysis("d5_c_6", "कुशल (Kushal)", "Welfare/Wisdom", "Safety/Well-being.")
                    )
                )
            ),
            Lesson(
                id = "day_6",
                dayTitle = "Day 6",
                street = StreetSection(
                    title = "At the Pharmacy",
                    dialogue = listOf(
                        DialogueLine("d6_s_1", "Patient", "मुझे बुखार और सरदर्द है।", "I have a fever and headache."),
                        DialogueLine("d6_s_2", "Chemist", "कब से है?", "Since when?"),
                        DialogueLine("d6_s_3", "Patient", "कल रात से। क्या कोई दवा है?", "Since last night. Is there any medicine?"),
                        DialogueLine("d6_s_4", "Chemist", "ये लीजिये पैरासिटामोल। दिन में दो बार खाइये।", "Take this Paracetamol. Eat (take) it twice a day."),
                        DialogueLine("d6_s_5", "Patient", "क्या इसे खाने के बाद लेना है?", "Should I take it after food?"),
                        DialogueLine("d6_s_6", "Chemist", "हाँ, खाली पेट मत लीजिये।", "Yes, don't take it on an empty stomach."),
                        DialogueLine("d6_s_7", "Patient", "गले में भी दर्द है।", "There is pain in the throat too."),
                        DialogueLine("d6_s_8", "Chemist", "तो ये कफ सिरप भी ले लीजिये।", "Then take this cough syrup also.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d6_v_1", "बुखार (bukhār)", "Fever", "Noun (M)."),
                        VocabItem("d6_v_2", "सरदर्द (sardard)", "Headache", "Sar (Head) + Dard (Pain)."),
                        VocabItem("d6_v_3", "कल (kal)", "Yesterday/Tomorrow", "Depends on tense. Here 'Kal raat' = Last night."),
                        VocabItem("d6_v_4", "दवा (davā)", "Medicine", "Noun (F)."),
                        VocabItem("d6_v_5", "बार (bār)", "Time(s)", "Din mein do baar = Two times in a day."),
                        VocabItem("d6_v_6", "पेट (peṭ)", "Stomach", "Noun (M)."),
                        VocabItem("d6_v_7", "खाली (khālī)", "Empty", "Adjective."),
                        VocabItem("d6_v_8", "गला (galā)", "Throat", "Noun (M).")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Having an Illness", "Like hunger, illness 'is' to you. 'Mujhe bukhar hai' (To me, there is fever)."),
                        GrammarPoint("Time 'Se'", "'Kab se?' (Since when?). 'Kal se' (Since yesterday). 'Se' indicates the starting point of time."),
                        GrammarPoint("Prohibitive 'Mat'", "For 'Don't', use 'Mat' with imperatives. 'Mat lijiye' (Don't take). 'Nahi' is for simple negation, 'Mat' is for commands.")
                    )
                ),
                court = CourtSection(
                    title = "Tulsidas' Ramcharitmanas",
                    poemLines = listOf(
                        "रघुकुल रीत सदा चली आई।",
                        "प्राण जाई पर बचन न जाई॥",
                        "Raghukul rīt sadā chalī āī",
                        "Prāṇ jāī par bachan na jāī"
                    ),
                    analysis = "From the Ramcharitmanas, describing the code of the Raghu clan (Rama's lineage). It defines the absolute integrity of the promised word.\n\n**The Code:** 'The tradition of Raghukul has always been: Life may go, but the Word (Promise) must not go.' King Dasharatha dies of grief but keeps his promise to exile Rama. This line is the bedrock of Indian ethos regarding 'Zuban' (Word of honor).",
                    wordBreakdown = listOf(
                        WordAnalysis("d6_c_1", "रघुकुल (Raghukul)", "Raghu Clan", "Lineage of Lord Rama."),
                        WordAnalysis("d6_c_2", "रीत (Rīt)", "Tradition/Custom", "Way of life."),
                        WordAnalysis("d6_c_3", "सदा (Sadā)", "Always", "Eternally."),
                        WordAnalysis("d6_c_4", "प्राण (Prāṇ)", "Life force/Breath", "Life itself."),
                        WordAnalysis("d6_c_5", "जाई (Jāī)", "Go/Leave", "Awadhi dialect form of 'Jaaye'."),
                        WordAnalysis("d6_c_6", "बचन (Bachan)", "Word/Promise", "Vachan.")
                    )
                )
            ),
            Lesson(
                id = "day_7",
                dayTitle = "Day 7",
                street = StreetSection(
                    title = "Travel by Train",
                    dialogue = listOf(
                        DialogueLine("d7_s_1", "Traveler", "मुंबई की ट्रेन किस प्लेटफार्म पर आएगी?", "On which platform will the Mumbai train come?"),
                        DialogueLine("d7_s_2", "Official", "प्लेटफार्म नंबर चार पर।", "On platform number four."),
                        DialogueLine("d7_s_3", "Traveler", "क्या ट्रेन समय पर है?", "Is the train on time?"),
                        DialogueLine("d7_s_4", "Official", "नहीं, आधा घंटा लेट है।", "No, it is half an hour late."),
                        DialogueLine("d7_s_5", "Traveler", "क्या मेरा टिकट कन्फर्म है?", "Is my ticket confirmed?"),
                        DialogueLine("d7_s_6", "Official", "पीएनआर नंबर दीजिये।", "Give the PNR number."),
                        DialogueLine("d7_s_7", "Traveler", "ये लीजिये।", "Take this."),
                        DialogueLine("d7_s_8", "Official", "हाँ, कोच बी-२, सीट १५।", "Yes, Coach B-2, Seat 15.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d7_v_1", "किस (kis)", "Which", "Oblique form of 'Kaun'."),
                        VocabItem("d7_v_2", "आएगी (āegī)", "Will come", "Future tense (F)."),
                        VocabItem("d7_v_3", "समय (samay)", "Time", "Noun (M). Formal. 'Waqt' is Urdu/Colloquial."),
                        VocabItem("d7_v_4", "पर (par)", "On/At", "Postposition."),
                        VocabItem("d7_v_5", "आधा (ādhā)", "Half", "Adjective."),
                        VocabItem("d7_v_6", "घंटा (ghanṭā)", "Hour/Bell", "Noun (M)."),
                        VocabItem("d7_v_7", "लेट (late)", "Late", "English loan."),
                        VocabItem("d7_v_8", "सीट (seat)", "Seat", "English loan.")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Oblique 'Kis'", "When 'Kaun' (Who/Which) is followed by a postposition like 'Par' (On), it becomes 'Kis'. 'Kaun par' is wrong; 'Kis par' is right."),
                        GrammarPoint("Future Gender", "'Train' is considered feminine in Hindi. So it 'aayegi' (F), not 'aayega' (M)."),
                        GrammarPoint("Telling Time", "'Samay par' = On time. 'Der se' = Late (with delay).")
                    )
                ),
                court = CourtSection(
                    title = "The Gita's Karma",
                    poemLines = listOf(
                        "कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।",
                        "मा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि॥",
                        "Karmaṇy-evādhikāraste mā phaleṣhu kadāchana",
                        "Mā karmaphalaheturbhūrmā te saṅgo'stvakarmaṇi"
                    ),
                    analysis = "Sanskrit Shloka from the Bhagavad Gita (2.47). Krishna speaks to Arjuna.\n\n**The Message:** 'You have a right to perform your prescribed duty (Karma), but you are not entitled to the fruits of action.'\n\n**Nishkama Karma:** Do not let the fruit (result) be the motive for your action. Do not be attached to inaction either. Just do what must be done. This is the central tenet of Dharma.",
                    wordBreakdown = listOf(
                        WordAnalysis("d7_c_1", "कर्मणि (Karmani)", "In action/duty", "Locative case of Karma."),
                        WordAnalysis("d7_c_2", "एव (Eva)", "Only", "Emphasis."),
                        WordAnalysis("d7_c_3", "अधिकार (Adhikara)", "Right/Authority", "Jurisdiction."),
                        WordAnalysis("d7_c_4", "मा (Ma)", "Not", "Prohibition."),
                        WordAnalysis("d7_c_5", "फलेषु (Phaleshu)", "In the fruits/results", "Locative plural of Phala."),
                        WordAnalysis("d7_c_6", "कदाचन (Kadachana)", "Ever/At any time", "Never be attached."),
                        WordAnalysis("d7_c_7", "सङ्गो (Sango)", "Attachment", "Association/Clinging."),
                        WordAnalysis("d7_c_8", "अकर्मणि (Akarmani)", "In inaction", "Not doing duty.")
                    )
                )
            )
        )
    }
}
