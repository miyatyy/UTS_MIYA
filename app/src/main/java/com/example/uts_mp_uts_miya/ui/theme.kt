package id.antasari.uts_mp_UTS_MIYA.ui.theme

import androidx.compose.material.MaterialTheme
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

@Composable
fun UTS_MIYATheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
