package id.antasari.uts_mp_UTS_MIYA.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColors = lightColors(
    primary = LightGreenPrimary,
    primaryVariant = LightGreenVariant,
    secondary = LightGreenSecondary,
    background = BackgroundLight,
    surface = BackgroundLight,
    onPrimary = TextDark,
    onSecondary = TextDark,
    onBackground = TextDark,
    onSurface = TextDark
)

private val DarkColors = darkColors(
    primary = DarkGreenPrimary,
    primaryVariant = DarkGreenVariant,
    secondary = DarkGreenSecondary,
    background = BackgroundDark,
    surface = BackgroundDark,
    onPrimary = TextLight,
    onSecondary = TextLight,
    onBackground = TextLight,
    onSurface = TextLight
)

@Composable
fun UTS_MIYATheme(
    darkTheme: Boolean = false, // 🔹 Tambahkan parameter ini
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
