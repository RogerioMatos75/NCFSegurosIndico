package com.ncf.seguros.indico.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ncf.seguros.indico.R

private val LightColors = lightColorScheme(
    primary = colorResource(id = R.color.md_theme_primary),
    onPrimary = colorResource(id = R.color.md_theme_onPrimary),
    primaryContainer = colorResource(id = R.color.md_theme_primaryContainer),
    onPrimaryContainer = colorResource(id = R.color.md_theme_onPrimaryContainer),
    secondary = colorResource(id = R.color.md_theme_secondary),
    onSecondary = colorResource(id = R.color.md_theme_onSecondary),
    secondaryContainer = colorResource(id = R.color.md_theme_secondaryContainer),
    onSecondaryContainer = colorResource(id = R.color.md_theme_onSecondaryContainer),
    tertiary = colorResource(id = R.color.md_theme_tertiary),
    onTertiary = colorResource(id = R.color.md_theme_onTertiary),
    tertiaryContainer = colorResource(id = R.color.md_theme_tertiaryContainer),
    onTertiaryContainer = colorResource(id = R.color.md_theme_onTertiaryContainer),
    error = colorResource(id = R.color.md_theme_error),
    onError = colorResource(id = R.color.md_theme_onError),
    errorContainer = colorResource(id = R.color.md_theme_errorContainer),
    onErrorContainer = colorResource(id = R.color.md_theme_onErrorContainer),
    background = colorResource(id = R.color.md_theme_background),
    onBackground = colorResource(id = R.color.md_theme_onBackground),
    surface = colorResource(id = R.color.md_theme_surface),
    onSurface = colorResource(id = R.color.md_theme_onSurface),
    surfaceVariant = colorResource(id = R.color.md_theme_surfaceVariant),
    onSurfaceVariant = colorResource(id = R.color.md_theme_onSurfaceVariant),
    outline = colorResource(id = R.color.md_theme_outline),
    outlineVariant = colorResource(id = R.color.md_theme_outlineVariant),
    scrim = colorResource(id = R.color.md_theme_scrim),
    inverseSurface = colorResource(id = R.color.md_theme_inverseSurface),
    inverseOnSurface = colorResource(id = R.color.md_theme_inverseOnSurface),
    inversePrimary = colorResource(id = R.color.md_theme_inversePrimary),
    surfaceDim = colorResource(id = R.color.md_theme_surfaceDim),
    surfaceBright = colorResource(id = R.color.md_theme_surfaceBright),
    surfaceContainerLowest = colorResource(id = R.color.md_theme_surfaceContainerLowest),
    surfaceContainerLow = colorResource(id = R.color.md_theme_surfaceContainerLow),
    surfaceContainer = colorResource(id = R.color.md_theme_surfaceContainer),
    surfaceContainerHigh = colorResource(id = R.color.md_theme_surfaceContainerHigh),
    surfaceContainerHighest = colorResource(id = R.color.md_theme_surfaceContainerHighest)
)

private val DarkColors = darkColorScheme(
    primary = colorResource(id = R.color.md_theme_dark_primary),
    onPrimary = colorResource(id = R.color.md_theme_dark_onPrimary),
    primaryContainer = colorResource(id = R.color.md_theme_dark_primaryContainer),
    onPrimaryContainer = colorResource(id = R.color.md_theme_dark_onPrimaryContainer),
    secondary = colorResource(id = R.color.md_theme_dark_secondary),
    onSecondary = colorResource(id = R.color.md_theme_dark_onSecondary),
    secondaryContainer = colorResource(id = R.color.md_theme_dark_secondaryContainer),
    onSecondaryContainer = colorResource(id = R.color.md_theme_dark_onSecondaryContainer),
    tertiary = colorResource(id = R.color.md_theme_dark_tertiary),
    onTertiary = colorResource(id = R.color.md_theme_dark_onTertiary),
    tertiaryContainer = colorResource(id = R.color.md_theme_dark_tertiaryContainer),
    onTertiaryContainer = colorResource(id = R.color.md_theme_dark_onTertiaryContainer),
    error = colorResource(id = R.color.md_theme_dark_error),
    onError = colorResource(id = R.color.md_theme_dark_onError),
    errorContainer = colorResource(id = R.color.md_theme_dark_errorContainer),
    onErrorContainer = colorResource(id = R.color.md_theme_dark_onErrorContainer),
    background = colorResource(id = R.color.md_theme_dark_background),
    onBackground = colorResource(id = R.color.md_theme_dark_onBackground),
    surface = colorResource(id = R.color.md_theme_dark_surface),
    onSurface = colorResource(id = R.color.md_theme_dark_onSurface),
    surfaceVariant = colorResource(id = R.color.md_theme_dark_surfaceVariant),
    onSurfaceVariant = colorResource(id = R.color.md_theme_dark_onSurfaceVariant),
    outline = colorResource(id = R.color.md_theme_dark_outline),
    outlineVariant = colorResource(id = R.color.md_theme_dark_outlineVariant),
    scrim = colorResource(id = R.color.md_theme_dark_scrim),
    inverseSurface = colorResource(id = R.color.md_theme_dark_inverseSurface),
    inverseOnSurface = colorResource(id = R.color.md_theme_dark_inverseOnSurface),
    inversePrimary = colorResource(id = R.color.md_theme_dark_inversePrimary),
    surfaceDim = colorResource(id = R.color.md_theme_dark_surfaceDim),
    surfaceBright = colorResource(id = R.color.md_theme_dark_surfaceBright),
    surfaceContainerLowest = colorResource(id = R.color.md_theme_dark_surfaceContainerLowest),
    surfaceContainerLow = colorResource(id = R.color.md_theme_dark_surfaceContainerLow),
    surfaceContainer = colorResource(id = R.color.md_theme_dark_surfaceContainer),
    surfaceContainerHigh = colorResource(id = R.color.md_theme_dark_surfaceContainerHigh),
    surfaceContainerHighest = colorResource(id = R.color.md_theme_dark_surfaceContainerHighest)
)

private val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    )
)

@Composable
fun NCFSegurosIndicoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}