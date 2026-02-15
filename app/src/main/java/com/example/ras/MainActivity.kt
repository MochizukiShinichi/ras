package com.example.ras

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RasApp()
        }
    }
}

// --- SHARED DESIGN TOKENS ---
// We define a shared design system to bridge the two worlds.
// Commonality: Typography scale, Corner Radii (gentle), Iconography style.

val SharedShape = RoundedCornerShape(12.dp)
val SharedPadding = 16.dp

// Theme Palette Definitions
val StreetPalette = lightColorScheme(
    primary = Color(0xFF2E7D32), // Forest Green
    secondary = Color(0xFFE0F2E9), // Minty
    background = Color(0xFFFDFCF0), // Cream
    surface = Color.White,
    onSurface = Color(0xFF1B1B1B)
)

val CourtPalette = darkColorScheme(
    primary = Color(0xFFFFD700), // Gold
    secondary = Color(0xFF4A0E2E), // Deep Maroon
    background = Color(0xFF1A0010), // Midnight
    surface = Color(0xFF2C041C), // Velvet
    onSurface = Color(0xFFE0E0E0)
)

@Composable
fun RasApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Crossfade(targetState = currentScreen, animationSpec = tween(500)) { screen ->
                when (screen) {
                    is Screen.Home -> HomeScreen(
                        onLessonClick = { lesson -> currentScreen = Screen.LessonDetail(lesson) }
                    )
                    is Screen.LessonDetail -> LessonDetailScreen(
                        lesson = screen.lesson,
                        onBack = { currentScreen = Screen.Home }
                    )
                }
            }
        }
    }
}

sealed class Screen {
    object Home : Screen()
    data class LessonDetail(val lesson: Lesson) : Screen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onLessonClick: (Lesson) -> Unit) {
    val lessons = remember { LessonRepository.getLessons() }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("RAS", fontWeight = FontWeight.Bold, letterSpacing = 2.sp) }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(padding)
        ) {
            item {
                Text(
                    "The Palace of Life",
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(bottom = 8.dp).fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
            }
            items(lessons) { lesson ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { onLessonClick(lesson) },
                    elevation = CardDefaults.cardElevation(2.dp),
                    shape = SharedShape,
                    colors = CardDefaults.cardColors(containerColor = Color.White) // Neutral card
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFE0E0E0)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = lesson.dayTitle.takeLast(1),
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(lesson.dayTitle, style = MaterialTheme.typography.titleLarge)
                            Text(
                                "${lesson.street.title} • ${lesson.court.title}", 
                                style = MaterialTheme.typography.bodySmall, 
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonDetailScreen(lesson: Lesson, onBack: () -> Unit) {
    var selectedTab by remember { mutableStateOf(0) } // 0 = Street, 1 = Court
    
    // Audio Player
    val context = LocalContext.current
    var activeAudioId by remember { mutableStateOf<String?>(null) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.stop()
            mediaPlayer?.release()
        }
    }

    fun playAudio(id: String) {
        if (activeAudioId == id && mediaPlayer?.isPlaying == true) {
            mediaPlayer?.stop()
            activeAudioId = null
            return
        }
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        activeAudioId = null

        val resId = context.resources.getIdentifier(id, "raw", context.packageName)
        if (resId != 0) {
            mediaPlayer = MediaPlayer.create(context, resId).apply {
                setOnCompletionListener { activeAudioId = null }
                start()
            }
            activeAudioId = id
        }
    }

    // ANIMATED THEME TRANSITION
    val targetColors = if (selectedTab == 0) StreetPalette else CourtPalette
    
    // We animate the background color to smooth the transition
    val animatedBgColor by animateColorAsState(targetColors.background, animationSpec = tween(500))
    val animatedPrimaryColor by animateColorAsState(targetColors.primary, animationSpec = tween(500))
    
    MaterialTheme(colorScheme = targetColors) {
        Scaffold(
            topBar = {
                // Unified Header Design: Minimalist but changes color
                TopAppBar(
                    title = { 
                        Text(
                            text = if (selectedTab == 0) "GALI" else "LEELA",
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp,
                            style = MaterialTheme.typography.titleMedium
                        ) 
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.Default.ArrowBack, "Back")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = animatedBgColor, // Seamless header
                        titleContentColor = animatedPrimaryColor,
                        navigationIconContentColor = animatedPrimaryColor
                    )
                )
            },
            bottomBar = {
                // Floating Tab Switcher (Custom) instead of standard NavBar for coherence
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Surface(
                        shape = RoundedCornerShape(50),
                        color = Color.Black.copy(alpha = 0.8f),
                        contentColor = Color.White,
                        modifier = Modifier.height(56.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 8.dp)) {
                            TabButton(
                                text = "Gali", 
                                icon = Icons.Default.DirectionsCar, 
                                isSelected = selectedTab == 0,
                                selectedColor = StreetPalette.primary
                            ) { selectedTab = 0 }
                            
                            Spacer(modifier = Modifier.width(8.dp))
                            
                            TabButton(
                                text = "Leela", 
                                icon = Icons.Default.TempleHindu, 
                                isSelected = selectedTab == 1,
                                selectedColor = CourtPalette.primary
                            ) { selectedTab = 1 }
                        }
                    }
                }
            }
        ) { padding ->
            // Smooth content switch (stable API)
            Crossfade(
                targetState = selectedTab,
                animationSpec = tween(350),
                modifier = Modifier
                    .fillMaxSize()
                    .background(animatedBgColor)
                    .padding(padding)
            ) { tab ->
                if (tab == 0) {
                    StreetView(lesson.street, activeAudioId, ::playAudio)
                } else {
                    CourtView(lesson.court, activeAudioId, ::playAudio)
                }
            }
        }
    }
}

@Composable
fun TabButton(text: String, icon: androidx.compose.ui.graphics.vector.ImageVector, isSelected: Boolean, selectedColor: Color, onClick: () -> Unit) {
    val bgColor by animateColorAsState(if (isSelected) Color.White else Color.Transparent)
    val contentColor by animateColorAsState(if (isSelected) selectedColor else Color.White)
    
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(bgColor)
            .clickable { onClick() }
            .padding(vertical = 10.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, null, tint = contentColor, modifier = Modifier.size(18.dp))
        if (isSelected) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(text, color = contentColor, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelLarge)
        }
    }
}

// ---------------- STREET UI (Clean, Modern, Functional) ----------------

@Composable
fun StreetView(section: StreetSection, activeId: String?, onPlay: (String) -> Unit) {
    LazyColumn(contentPadding = PaddingValues(bottom = 100.dp, top = 16.dp, start = 16.dp, end = 16.dp)) {
        item {
            Text(section.title, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onSurface, modifier = Modifier.padding(bottom = 16.dp))
        }
        
        items(section.dialogue) { line ->
            StreetBubble(line, activeId == line.id) { onPlay(line.id) }
        }

        item { SectionDivider() }
        item { SectionTitle("Vocabulary") }
        
        items(section.vocabulary) { vocab ->
            VocabItemRow(vocab, activeId == vocab.id) { onPlay(vocab.id) }
        }

        item { SectionDivider() }
        item { SectionTitle("Grammar Notes") }
        
        items(section.grammarGuides) { grammar ->
            GrammarCard(grammar)
        }
    }
}

@Composable
fun StreetBubble(line: DialogueLine, isPlaying: Boolean, onPlay: () -> Unit) {
    val isDriver = line.speaker == "Auto Driver"
    val align = if (isDriver) Alignment.Start else Alignment.End
    // Shared DNA: Same typography scale, just different color/shape nuances
    val containerColor = if (isDriver) Color.White else MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
    val borderColor = if (isPlaying) MaterialTheme.colorScheme.primary else Color.Transparent
    
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp), horizontalAlignment = align) {
        Text(line.speaker, style = MaterialTheme.typography.labelSmall, color = Color.Gray, modifier = Modifier.padding(horizontal = 8.dp))
        Surface(
            shape = if (isDriver) RoundedCornerShape(4.dp, 16.dp, 16.dp, 16.dp) else RoundedCornerShape(16.dp, 4.dp, 16.dp, 16.dp),
            color = containerColor,
            border = BorderStroke(1.dp, if (isPlaying) borderColor else Color.Transparent),
            modifier = Modifier.widthIn(max = 300.dp).clickable { onPlay() },
            shadowElevation = 1.dp
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(line.hindi, style = MaterialTheme.typography.bodyLarge, color = Color.Black)
                Text(line.english, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            }
        }
    }
}

@Composable
fun VocabItemRow(vocab: VocabItem, isPlaying: Boolean, onPlay: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onPlay() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            if (isPlaying) Icons.Default.VolumeUp else Icons.Default.PlayCircleOutline, 
            contentDescription = "Play",
            tint = if (isPlaying) MaterialTheme.colorScheme.primary else Color.LightGray,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(vocab.word, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
            Text(vocab.meaning, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
        }
    }
    Divider(color = Color.LightGray.copy(alpha = 0.2f))
}

// ---------------- COURT UI (Elegant, Serif, Deep) ----------------

@Composable
fun CourtView(section: CourtSection, activeId: String?, onPlay: (String) -> Unit) {
    LazyColumn(contentPadding = PaddingValues(bottom = 100.dp, top = 16.dp, start = 24.dp, end = 24.dp)) {
        item {
            // Shared DNA: Same structure as Street, but Serif font and gold color
            Text(
                section.title, 
                style = MaterialTheme.typography.headlineMedium, 
                fontFamily = FontFamily.Serif, 
                color = MaterialTheme.colorScheme.primary, 
                modifier = Modifier.padding(bottom = 24.dp),
                textAlign = TextAlign.Center
            )
        }

        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.05f)),
                shape = SharedShape,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
            ) {
                Column(modifier = Modifier.padding(24.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    section.poemLines.forEach { line ->
                        Text(
                            text = line,
                            style = MaterialTheme.typography.titleLarge,
                            fontFamily = FontFamily.Serif,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }

        item { SectionDivider(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)) }
        
        item {
            Text(
                section.analysis,
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = FontFamily.Serif,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                lineHeight = 28.sp
            )
        }

        item { SectionDivider(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)) }
        item { SectionTitle("Lexicon", color = MaterialTheme.colorScheme.primary) }

        items(section.wordBreakdown) { word ->
            CourtLexiconItem(word, activeId == word.id) { onPlay(word.id) }
        }
    }
}

@Composable
fun CourtLexiconItem(word: WordAnalysis, isPlaying: Boolean, onPlay: () -> Unit) {
    val activeColor = MaterialTheme.colorScheme.primary
    
    Column(modifier = Modifier.fillMaxWidth().clickable { onPlay() }.padding(vertical = 12.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                word.word, 
                style = MaterialTheme.typography.titleLarge, 
                color = if (isPlaying) activeColor else MaterialTheme.colorScheme.onSurface,
                fontFamily = FontFamily.Serif
            )
            Spacer(modifier = Modifier.weight(1f))
            if (isPlaying) Icon(Icons.Default.VolumeUp, null, tint = activeColor, modifier = Modifier.size(16.dp))
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Text("Lit: ", color = Color.Gray, style = MaterialTheme.typography.bodySmall)
            Text(word.literal, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f), style = MaterialTheme.typography.bodySmall)
        }
        Row {
            Text("Meta: ", color = activeColor.copy(alpha = 0.7f), style = MaterialTheme.typography.bodySmall)
            Text(word.metaphor, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f), style = MaterialTheme.typography.bodySmall)
        }
    }
    Divider(color = Color.White.copy(alpha = 0.1f))
}

// --- SHARED UTILS ---

@Composable
fun SectionTitle(text: String, color: Color = Color.Gray) {
    Text(
        text = text.uppercase(),
        style = MaterialTheme.typography.labelMedium,
        color = color,
        letterSpacing = 1.5.sp,
        modifier = Modifier.padding(vertical = 12.dp)
    )
}

@Composable
fun SectionDivider(color: Color = Color.LightGray.copy(alpha = 0.2f)) {
    Divider(color = color, modifier = Modifier.padding(vertical = 24.dp))
}

@Composable
fun GrammarCard(grammar: GrammarPoint) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        shape = SharedShape,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(grammar.title, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(grammar.content, style = MaterialTheme.typography.bodyMedium, color = Color.DarkGray)
        }
    }
}
