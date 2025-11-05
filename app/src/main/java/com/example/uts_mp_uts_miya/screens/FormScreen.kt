package id.antasari.uts_mp_UTS_MIYA

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FormScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("👋 Halo! Ini Form Screen", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("summary") }) {
            Text("Lanjut ke Ringkasan")
        }
    }
}

@Composable
fun SummaryScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("📋 Ini Ringkasan Profil", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("settings") }) {
            Text("Lihat Pengaturan Tersimpan")
        }
    }
}

@Composable
fun SettingsScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("⚙️ Ini Screen Pengaturan", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("form") }) {
            Text("Kembali ke Form")
        }
    }
}
