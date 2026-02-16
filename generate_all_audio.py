import re
import os
from gtts import gTTS

# File paths
REPO_FILE = "/home/hanakaze/ras-android/app/src/main/java/com/example/ras/LessonRepository.kt"
OUTPUT_DIR = "/home/hanakaze/ras-android/app/src/main/res/raw"

os.makedirs(OUTPUT_DIR, exist_ok=True)

# Regex patterns to extract ID and Hindi text
# DialogueLine("d1_s_1", "Passenger", "भैया...", "Brother...")
# VocabItem("d1_v_1", "चलना (chalnā)", ...)
# WordAnalysis("d1_c_1", "गोरी (Gori)", ...)

patterns = [
    r'DialogueLine\s*\(\s*"([^"]+)"\s*,\s*"[^"]+"\s*,\s*"([^"]+)"',
    r'VocabItem\s*\(\s*"([^"]+)"\s*,\s*"([^"]+)"',
    r'WordAnalysis\s*\(\s*"([^"]+)"\s*,\s*"([^"]+)"'
]

count = 0

with open(REPO_FILE, 'r', encoding='utf-8') as f:
    content = f.read()
    
    for pattern in patterns:
        matches = re.findall(pattern, content)
        for audio_id, hindi_text in matches:
            filename = f"{audio_id}.mp3"
            path = os.path.join(OUTPUT_DIR, filename)
            
            # Clean hindi text (remove English in parens if any, e.g. "चलना (chalnā)" -> "चलना")
            # Usually gTTS handles it, but better safe. Actually gTTS reads english too. 
            # User might want the pronunciation. Let's keep it as is, or strip.
            # "गोरी (Gori)" -> gTTS will say "Gori bracket Gori". That's annoying.
            # Let's strip brackets and english content for cleaner Hindi audio.
            clean_hindi = re.sub(r'\s*\(.*?\)', '', hindi_text)
            
            if not os.path.exists(path):
                print(f"Generating {audio_id}: {clean_hindi}")
                try:
                    tts = gTTS(text=clean_hindi, lang='hi')
                    tts.save(path)
                    count += 1
                except Exception as e:
                    print(f"Error generating {audio_id}: {e}")
            else:
                # print(f"Skipping {audio_id} (exists)")
                pass

print(f"Finished. Generated {count} new audio files.")
