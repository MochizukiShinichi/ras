package com.example.ras

data class Lesson(
    val id: String,
    val dayTitle: String,
    val street: StreetSection,
    val court: CourtSection
)

data class StreetSection(
    val title: String,
    val dialogue: List<DialogueLine>,
    val vocabulary: List<VocabItem>,
    val grammarGuides: List<GrammarPoint>
)

data class CourtSection(
    val title: String,
    val poemLines: List<String>,
    val analysis: String,
    val wordBreakdown: List<WordAnalysis>
)

data class DialogueLine(
    val id: String, // for audio filename mapping
    val speaker: String,
    val hindi: String,
    val english: String
)

data class VocabItem(
    val id: String, // for audio
    val word: String,
    val meaning: String,
    val detail: String
)

data class GrammarPoint(
    val title: String,
    val content: String
)

data class WordAnalysis(
    val id: String, // for audio
    val word: String,
    val literal: String,
    val metaphor: String
)
