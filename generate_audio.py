import json
from gtts import gTTS
import os

# Define the lessons data (copied from LessonRepository.kt structure)
lessons = [
    {
        "id": "lesson_1_auto",
        "title": "Day 1: Negotiating an Auto",
        "transcript": [
            "भैया, कनॉट प्लेस चलोगे?",
            "हाँ मैडम, बैठिये। दो सौ रुपये लगेंगे।",
            "दो सौ? बहुत ज़्यादा है। डेढ़ सौ ले लो।",
            "चलो ठीक है, बैठो।"
        ]
    },
    {
        "id": "lesson_2_kabir",
        "title": "Day 2: Kabir's Doha",
        "transcript": [
            "दुख में सुमिरन सब करे, सुख में करे न कोय।",
            "जो सुख में सुमिरन करे, तो दुख काहे को होय।"
        ]
    },
    {
        "id": "lesson_3_dhaba",
        "title": "Day 3: Ordering at a Dhaba",
        "transcript": [
            "भैया, खाने में क्या है?",
            "दाल मखनी है, शाही पनीर है, और रोटी।",
            "एक दाल और दो तंदूरी रोटी कर दो।",
            "मिर्ची कम रखना।"
        ]
    },
    {
        "id": "lesson_4_ghalib",
        "title": "Day 4: Ghalib's Lament",
        "transcript": [
            "दिल-ए-नादान तुझे हुआ क्या है?",
            "आखिर इस दर्द की दवा क्या है?"
        ]
    },
    {
        "id": "lesson_5_train",
        "title": "Day 5: Train Station Inquiry",
        "transcript": [
            "सुनिए, शताब्दी एक्सप्रेस किस प्लेटफॉर्म पर आएगी?",
            "प्लेटफॉर्म नंबर चार पर।",
            "क्या ट्रेन समय पर है?",
            "नहीं, आधा घंटा लेट है।"
        ]
    },
    {
        "id": "lesson_6_mythology",
        "title": "Day 6: Samudra Manthan",
        "transcript": [
            "देवताओं और असुरों ने मिलकर समुद्र मंथन किया।",
            "उसमें से अमृत निकला।",
            "विष्णु ने मोहिनी रूप धारण किया।"
        ]
    },
    {
        "id": "lesson_7_pharmacy",
        "title": "Day 7: At the Pharmacy",
        "transcript": [
            "मेरे सिर में बहुत दर्द है।",
            "ये लो, एक गोली अभी खा लो।",
            "पानी के साथ लेना।",
            "कितने पैसे हुए?"
        ]
    }
]

output_dir = "/home/hanakaze/ras-android/app/src/main/res/raw"
os.makedirs(output_dir, exist_ok=True)

for lesson in lessons:
    # Concatenate all Hindi sentences with a slight pause
    full_text = " ".join(lesson["transcript"])
    filename = f"{lesson['id']}.mp3"
    filepath = os.path.join(output_dir, filename)
    
    print(f"Generating audio for {lesson['id']}...")
    tts = gTTS(text=full_text, lang='hi')
    tts.save(filepath)
    print(f"Saved to {filepath}")

print("All audio files generated successfully.")
