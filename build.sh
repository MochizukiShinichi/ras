#!/bin/bash
export ANDROID_HOME=/home/hanakaze/android-sdk
export PATH=$ANDROID_HOME/platform-tools:$ANDROID_HOME/cmdline-tools/latest/bin:$PATH
cd /home/hanakaze/ras-android
/home/hanakaze/.openclaw/workspace/gradle-8.5/bin/gradle assembleDebug --stacktrace