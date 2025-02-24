object Colors {
    val primary = Color(0xFF6200EE)
    val secondary = Color(0xFF03DAC5)
    // Outras cores...
}

object Typography {
    val h1 = TextStyle(/* Definições de estilo */)
    // Outras definições de tipografia...
}

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = Colors,
        typography = Typography,
        content = content
    )
} 