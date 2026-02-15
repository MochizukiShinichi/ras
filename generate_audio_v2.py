import json
from gtts import gTTS
import os

# Define the lessons data (Updated to match new LessonRepository.kt)
lessons = [
    {
        "id": "day_1",
        "street": {
            "filename": "lesson_1_street",
            "transcript": [
                "भैया, कनॉट प्लेस चलोगे?",
                "हाँ मैडम, बैठिये। दो सौ रुपये लगेंगे।",
                "दो सौ? बहुत ज़्यादा है। डेढ़ सौ ले लो।",
                "चलो ठीक है, बैठो।"
            ]
        },
        "court": {
            "filename": "lesson_1_court",
            "transcript": [
                "गोरी सोवे सेज पर, मुख पर डारे केस।",
                "चल खुसरो घर आपने, रैन भई चहुँ देस।"
            ]
        }
    },
    {
        "id": "day_2",
        "street": {
            "filename": "lesson_2_street",
            "transcript": [
                "आलू कैसे दिए?",
                "बीस रुपये किलो।",
                "ताज़े हैं ना?",
                "बिल्कुल ताज़े हैं, अभी मंडी से लाया हूँ।"
            ]
        },
        "court": {
            "filename": "lesson_2_court",
            "transcript": [
                "दुख में सुमिरन सब करे, सुख में करे न कोय।",
                "जो सुख में सुमिरन करे, तो दुख काहे को होय।"
            ]
        }
    },
    {
        "id": "day_3",
        "street": {
            "filename": "lesson_3_street",
            "transcript": [
                "भैया, खाने में क्या है?",
                "दाल मखनी है, शाही पनीर है, और रोटी।",
                "एक दाल और दो तंदूरी रोटी कर दो।",
                "मिर्ची कम रखना।"
            ]
        },
        "court": {
            "filename": "lesson_3_court",
            "transcript": [
                "दिल-ए-नादान तुझे हुआ क्या है?",
                "आखिर इस दर्द की दवा क्या है?"
            ]
        }
    }
]

output_dir = "/home/hanakaze/ras-android/app/src/main/res/raw"
os.makedirs(output_dir, exist_ok=True)

for lesson in lessons:
    # Street
    street = lesson["street"]
    full_text_street = " ".join(street["transcript"])
    filepath_street = os.path.join(output_dir, f"{street['filename']}.mp3")
    print(f"Generating audio for {street['filename']}...")
    tts = gTTS(text=full_text_street, lang='hi')
    tts.save(filepath_street)

    # Court
    court = lesson["court"]
    full_text_court = " ".join(court["transcript"])
    filepath_court = os.path.join(output_dir, f"{court['filename']}.mp3")
    print(f"Generating audio for {court['filename']}...")
    tts = gTTS(text=full_text_court, lang='hi')
    tts.save(filepath_court)

print("All audio files generated successfully.")
