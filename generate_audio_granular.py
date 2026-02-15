import json
from gtts import gTTS
import os

# Data structure matching LessonRepository (Day 1 only for v3)
day_1 = {
    "street": {
        "dialogue": [
            {"id": "d1_s_1", "text": "भैया, कनॉट प्लेस चलोगे?"},
            {"id": "d1_s_2", "text": "हाँ, बैठिये। कहाँ जाना है ठीक से बताइये।"},
            {"id": "d1_s_3", "text": "इनर सर्कल जाना है। मीटर से चलोगे?"},
            {"id": "d1_s_4", "text": "मीटर नहीं, साहब। २०० रुपये फिक्स।"},
            {"id": "d1_s_5", "text": "ये तो बहुत ज़्यादा है! १५० रुपये ठीक हैं।"},
            {"id": "d1_s_6", "text": "आगे बहुत ट्रैफ़िक है, टाइम लगेगा। १८० दे दीजिये।"},
            {"id": "d1_s_7", "text": "ठीक है, चलो। लेकिन ट्रैफ़िक से मत ले जाना।"},
            {"id": "d1_s_8", "text": "फ़िक्र मत कीजिये, मैं छोटे रास्ते से ले चलूँगा।"}
        ],
        "vocabulary": [
            {"id": "d1_v_1", "text": "चलना"},
            {"id": "d1_v_2", "text": "भैया"},
            {"id": "d1_v_3", "text": "बैठिये"},
            {"id": "d1_v_4", "text": "ठीक से"},
            {"id": "d1_v_5", "text": "मीटर"},
            {"id": "d1_v_6", "text": "ज़्यादा"},
            {"id": "d1_v_7", "text": "रुपये"},
            {"id": "d1_v_8", "text": "आगे"},
            {"id": "d1_v_9", "text": "रास्ता"},
            {"id": "d1_v_10", "text": "फ़िक्र"}
        ]
    },
    "court": {
        "wordBreakdown": [
            {"id": "d1_c_1", "text": "गोरी"},
            {"id": "d1_c_2", "text": "सोवे"},
            {"id": "d1_c_3", "text": "सेज"},
            {"id": "d1_c_4", "text": "मुख"},
            {"id": "d1_c_5", "text": "केस"},
            {"id": "d1_c_6", "text": "घर आपने"},
            {"id": "d1_c_7", "text": "साँझ"},
            {"id": "d1_c_8", "text": "चहुँ देस"}
        ]
    }
}

output_dir = "/home/hanakaze/ras-android/app/src/main/res/raw"
os.makedirs(output_dir, exist_ok=True)

def generate(id, text):
    filepath = os.path.join(output_dir, f"{id}.mp3")
    if not os.path.exists(filepath):
        print(f"Generating {id}...")
        tts = gTTS(text=text, lang='hi')
        tts.save(filepath)
    else:
        print(f"Skipping {id} (exists)")

# Street Dialogue
for item in day_1["street"]["dialogue"]:
    generate(item["id"], item["text"])

# Street Vocab
for item in day_1["street"]["vocabulary"]:
    generate(item["id"], item["text"])

# Court Words
for item in day_1["court"]["wordBreakdown"]:
    generate(item["id"], item["text"])

print("Granular audio generation complete.")
