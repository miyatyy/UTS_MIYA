package id.antasari.uts_mp_UTS_MIYA.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object Form : BottomNavItem("form", Icons.Default.AccountCircle, "Profil")
    object Summary : BottomNavItem("summary_placeholder", Icons.Default.CheckCircle, "Ringkasan")
    object Saved : BottomNavItem("saved", Icons.Default.Settings, "Tersimpan")
}
