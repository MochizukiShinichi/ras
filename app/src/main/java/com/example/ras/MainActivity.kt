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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ras.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RasApp()
        }
    }
}

val EczarFont = FontFamily(
    Font(R.font.eczar_variable, FontWeight.Normal),
    Font(R.font.eczar_variable, FontWeight.Bold)
)

val LatoFont = FontFamily(
    Font(R.font.lato_regular, FontWeight.Normal),
    Font(R.font.lato_bold, FontWeight.Bold)
)

// --- DESIGN TOKENS ---
val GaliShape = RoundedCornerShape(14.dp) // Refined for Gali
val LeelaShape = RoundedCornerShape(24.dp) // Organic for Leela
val SharedPadding = 16.dp

// Colors
val GaliHeaderBg = Color(0xFFF4F1EA)
val GaliHeaderDivider = Color(0xFFE5DED2)
val GaliTitleColor = Color(0xFF3E5E4B)
val GaliSectionHeaderColor = Color(0xFF6F6A60)
val GaliPlayBtnBg = Color(0xFFEFEAE0)

// Theme Palette Definitions
val StreetPalette = lightColorScheme(
    primary = Color(0xFF2E7D32),
    secondary = Color(0xFFE0F2E9),
    background = Color(0xFFFDFCF0),
    surface = Color.White,
    onSurface = Color(0xFF1B1B1B)
)

val CourtPalette = darkColorScheme( // Revert to Dark Scheme for the Dark Background
    primary = Color(0xFFFFD700),    // Gold
    secondary = Color(0xFFD4AF37),  // Metallic Gold
    tertiary = Color(0xFF8D6E63),   // Bronze
    background = Color.Transparent, // Let the image show
    surface = Color(0x1AFFFFFF),    // Glassy White (10%)
    onSurface = Color(0xFFFFECB3),  // Pale Gold Text
    onPrimary = Color.Black
)

@Composable
fun RasApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    MaterialTheme(
        typography = Typography(
            headlineMedium = androidx.compose.material3.Typography().headlineMedium.copy(fontFamily = EczarFont),
            headlineLarge = androidx.compose.material3.Typography().headlineLarge.copy(fontFamily = EczarFont),
            titleLarge = androidx.compose.material3.Typography().titleLarge.copy(fontFamily = EczarFont),
            titleMedium = androidx.compose.material3.Typography().titleMedium.copy(fontFamily = LatoFont),
            bodyLarge = androidx.compose.material3.Typography().bodyLarge.copy(fontFamily = LatoFont),
            bodyMedium = androidx.compose.material3.Typography().bodyMedium.copy(fontFamily = LatoFont),
            labelMedium = androidx.compose.material3.Typography().labelMedium.copy(fontFamily = LatoFont)
        )
    ) {
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
                title = { 
                    Text(
                        "रस", // Hindi for Ras
                        fontWeight = FontWeight.Bold, 
                        fontSize = 32.sp,
                        fontFamily = EczarFont,
                        color = Color(0xFF3E2723) // Dark Brown stone color
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        containerColor = Color.Transparent
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
                ClayCard(
                    modifier = Modifier.fillMaxWidth().clickable { onLessonClick(lesson) },
                    elevation = 2.dp,
                    shape = GaliShape, // Updated to GaliShape
                    backgroundColor = Color.White // Neutral card
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
        // --- Full Screen Background (Global) ---
        Box(modifier = Modifier.fillMaxSize()) {
            if (selectedTab == 1) {
                // Leela (Court) - User provided Dark Mandala Background
                Image(
                    painter = androidx.compose.ui.res.painterResource(R.drawable.bg_leela_combined),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                // Gali (Street) - Sandstone Light
                Image(
                    painter = androidx.compose.ui.res.painterResource(R.drawable.bg_sandstone),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            // 3. Content Scaffold
            Scaffold(
                containerColor = Color.Transparent, 
                topBar = {
                    if (selectedTab == 1) {
                        // Leela Header (Transparent)
                        CenterAlignedTopAppBar(
                            title = { 
                                Text("रस", fontWeight = FontWeight.Bold, fontSize = 32.sp, fontFamily = EczarFont, color = Color(0xFFFFECB3))
                            },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent),
                            navigationIcon = {
                                IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, "Back", tint = Color(0xFFFFECB3)) }
                            }
                        )
                    } else {
                        // Gali Header (Solid Beige + Divider)
                        Column {
                            CenterAlignedTopAppBar(
                                title = { 
                                    Text("GALI", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, letterSpacing = 2.sp, color = GaliTitleColor)
                                },
                                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = GaliHeaderBg),
                                navigationIcon = {
                                    IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, "Back", tint = GaliTitleColor) }
                                }
                            )
                            Divider(color = GaliHeaderDivider, thickness = 1.dp)
                        }
                    }
                },
            bottomBar = {
                // Floating Tab Switcher (Custom) - Lowered position
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    ClayCard(
                        shape = RoundedCornerShape(50),
                        backgroundColor = Color.Transparent,
                        elevation = 8.dp,
                        modifier = Modifier.height(56.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Image(
                                painter = androidx.compose.ui.res.painterResource(R.drawable.terracotta_texture),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.matchParentSize().alpha(0.95f),
                                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Black.copy(alpha=0.1f), blendMode = BlendMode.Darken) // Darken by 10%
                            )
                            // Top border
                            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFF4A2B1E).copy(alpha=0.5f)).align(Alignment.TopCenter))
                            
                            Row(
                                verticalAlignment = Alignment.CenterVertically, 
                                modifier = Modifier.padding(horizontal = 8.dp).align(Alignment.Center)
                            ) {
                                TabButton(
                                    text = "Gali",
                                    subText = "गली",
                                    icon = Icons.Default.DirectionsCar, 
                                    isSelected = selectedTab == 0,
                                    selectedColor = Color.White,
                                    unselectedColor = Color(0xFF4A2B1E)
                                ) { selectedTab = 0 }
                                
                                Spacer(modifier = Modifier.width(8.dp))
                                
                                TabButton(
                                    text = "Leela",
                                    subText = "लीला",
                                    icon = Icons.Default.TempleHindu, 
                                    isSelected = selectedTab == 1,
                                    selectedColor = Color.White,
                                    unselectedColor = Color(0xFF4A2B1E)
                                ) { selectedTab = 1 }
                            }
                        }
                    }
                }
            }
        ) { padding ->
            // Smooth content switch (stable API)
            val leelaBg = remember {
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFFDE7), Color(0xFFFFECB3))
                )
            }
            val bgBrush = if (selectedTab == 1) leelaBg else SolidColor(animatedBgColor)

            Crossfade(
                targetState = selectedTab,
                animationSpec = tween(350),
                modifier = Modifier
                    .fillMaxSize()
                    // .background(bgBrush) REMOVED: Handled by parent Box
                    .padding(padding)
            ) { tab ->
                if (tab == 0) {
                    StreetView(lesson.street, activeAudioId, ::playAudio)
                } else {
                    CourtView(lesson.court, activeAudioId, ::playAudio, isDark = true)
                }
            }
        }
        }
    }
}

@Composable
fun TabButton(text: String, subText: String, icon: androidx.compose.ui.graphics.vector.ImageVector, isSelected: Boolean, selectedColor: Color, unselectedColor: Color = Color.LightGray, onClick: () -> Unit) {
    val bgColor by animateColorAsState(if (isSelected) Color.White.copy(alpha=0.1f) else Color.Transparent)
    val contentColor by animateColorAsState(if (isSelected) selectedColor else unselectedColor)
    
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(bgColor)
            .clickable { onClick() }
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, null, tint = contentColor, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text, 
                color = contentColor, 
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal, 
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                subText, 
                color = contentColor.copy(alpha = 0.8f), 
                fontWeight = FontWeight.Normal, 
                style = MaterialTheme.typography.labelSmall,
                fontFamily = EczarFont
            )
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
    // Left side = service/local speaker; Right side = learner
    val leftSpeakers = setOf("Auto Driver", "Local", "Server", "Shopkeeper", "Host", "Chemist", "Official")
    val isLeft = line.speaker in leftSpeakers
    val align = if (isLeft) Alignment.Start else Alignment.End
    // Shared DNA: Same typography scale, just different color/shape nuances
    val containerColor = if (isLeft) Color.White else MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
    val borderColor = if (isPlaying) MaterialTheme.colorScheme.primary else Color.Transparent
    
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp), horizontalAlignment = align) {
        Text(line.speaker, style = MaterialTheme.typography.labelSmall, color = Color.Gray, modifier = Modifier.padding(horizontal = 8.dp))
        ClayCard(
            modifier = Modifier.widthIn(max = 300.dp).clickable { onPlay() },
            backgroundColor = containerColor,
            elevation = if (isPlaying) 8.dp else 2.dp,
            shape = if (isLeft) RoundedCornerShape(4.dp, 16.dp, 16.dp, 16.dp) else RoundedCornerShape(16.dp, 4.dp, 16.dp, 16.dp)
        ) {
            Column {
                Text(line.hindi, style = MaterialTheme.typography.bodyLarge, color = Color.Black)
                Text(line.english, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            }
        }
    }
}

@Composable
fun VocabItemRow(vocab: VocabItem, isPlaying: Boolean, onPlay: () -> Unit) {
    ClayCard(
        modifier = Modifier.fillMaxWidth().clickable { onPlay() },
        elevation = if (isPlaying) 6.dp else 2.dp,
        backgroundColor = MaterialTheme.colorScheme.surface
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
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
    }
    Spacer(modifier = Modifier.height(12.dp))
}

// ---------------- COURT UI (Elegant, Serif, Deep) ----------------

@Composable
fun CourtView(section: CourtSection, activeId: String?, onPlay: (String) -> Unit, isDark: Boolean = false) {
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
            ClayCard(
                backgroundColor = if (isDark) Color.Black.copy(alpha = 0.85f) else Color.White.copy(alpha = 0.88f),
                shape = LeelaShape, // Update to LeelaShape
                elevation = 10.dp,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
            ) {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
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

        item { LeelaDivider() }
        
        item {
            ClayCard(
                elevation = 3.dp,
                backgroundColor = if (isDark) Color.Black.copy(alpha = 0.75f) else Color.White.copy(alpha = 0.82f), // 75% Black for analysis card
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
            ) {
                Text(
                    section.analysis,
                    style = MaterialTheme.typography.bodyLarge,
                    fontFamily = FontFamily.Serif,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                    lineHeight = 28.sp
                )
            }
        }

        item { LeelaDivider() }
        item { SectionTitle("Lexicon", color = MaterialTheme.colorScheme.primary) }

        items(section.wordBreakdown) { word ->
            CourtLexiconItem(word, activeId == word.id, { onPlay(word.id) }, isDark)
        }
    }
}

@Composable
fun CourtLexiconItem(word: WordAnalysis, isPlaying: Boolean, onPlay: () -> Unit, isDark: Boolean = false) {
    val activeColor = MaterialTheme.colorScheme.primary
    
    ClayCard(
        modifier = Modifier.fillMaxWidth().clickable { onPlay() },
        elevation = if (isPlaying) 6.dp else 2.dp,
        backgroundColor = if (isPlaying) activeColor.copy(alpha = 0.1f) else (if (isDark) Color.Black.copy(alpha = 0.7f) else MaterialTheme.colorScheme.surface)
    ) {
        Column {
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
    }
    Spacer(modifier = Modifier.height(12.dp))
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
fun LeelaDivider() {
    val gold = MaterialTheme.colorScheme.primary
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(modifier = Modifier.weight(1f), color = gold.copy(alpha = 0.5f)) // Brighter line
        Spacer(modifier = Modifier.width(10.dp))
        Surface(
            shape = CircleShape,
            color = Color.Black.copy(alpha = 0.3f), // Darker center
            border = BorderStroke(1.dp, gold)
        ) {
            Box(modifier = Modifier.size(8.dp))
        }
        Spacer(modifier = Modifier.width(10.dp))
        Divider(modifier = Modifier.weight(1f), color = gold.copy(alpha = 0.5f))
    }
}

@Composable
fun GrammarCard(grammar: GrammarPoint) {
    ClayCard(
        modifier = Modifier.fillMaxWidth(),
        shape = GaliShape, // Update to GaliShape
        backgroundColor = Color.White,
        elevation = 2.dp
    ) {
        Column {
            Text(grammar.title, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(grammar.content, style = MaterialTheme.typography.bodyMedium, color = Color.DarkGray)
        }
    }
}

// --- PREVIEWS (FOR FAST ITERATION) ---
// Use the "Split" or "Design" view in Android Studio to see these update in real-time.

@Composable
fun ClayCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    elevation: androidx.compose.ui.unit.Dp = 4.dp,
    shape: androidx.compose.ui.graphics.Shape = RoundedCornerShape(24.dp),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(16.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier
            .padding(bottom = 6.dp)
            .shadow(elevation, shape, clip = false)
            .offset(y = if (elevation > 0.dp) 4.dp else 0.dp),
        shape = shape,
        color = backgroundColor,
        shadowElevation = elevation,
        border = border ?: if (elevation > 0.dp) null else BorderStroke(1.dp, Color(0x33000000))
    ) {
        Column(modifier = Modifier.padding(contentPadding), content = content)
    }
}

@Preview(showBackground = true, name = "Gali Mode (Street)", heightDp = 800)
@Composable
fun PreviewGali() {
    val dummyLesson = LessonRepository.getLessons().first()
    MaterialTheme(colorScheme = StreetPalette) {
        Surface {
           StreetView(dummyLesson.street, null) {}
        }
    }
}

@Preview(showBackground = true, name = "Leela Mode (Court)", heightDp = 800)
@Composable
fun PreviewLeela() {
    val dummyLesson = LessonRepository.getLessons().first()
    MaterialTheme(colorScheme = CourtPalette) {
        Surface(color = Color.Black) { // Preview with dark background
           CourtView(dummyLesson.court, null, {}, isDark = true)
        }
    }
}
