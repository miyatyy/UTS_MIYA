package id.antasari.uts_mp_UTS_MIYA.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.antasari.uts_mp_UTS_MIYA.data.PrefsHelper

@Composable
fun SavedScreen(prefsHelper: PrefsHelper, onBackToForm: () -> Unit) {
    val hasData = prefsHelper.hasProfile()
    val name = prefsHelper.loadName()
    val kelas = prefsHelper.loadKelas()
    val hobby = prefsHelper.loadHobby()
    val dark = prefsHelper.loadDarkMode()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Pengaturan Tersimpan") }) }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            if (!hasData) {
                Text("Belum ada data, silakan isi profil dulu")
            } else {
                Text("Nama: ${name ?: "-"}")
                Text("Kelas: ${kelas ?: "-"}")
                Text("Hobi: ${hobby ?: "-"}")
                Text("Mode Gelap: ${if (dark) "Ya" else "Tidak"}")
            }

            Spacer(Modifier.height(16.dp))
            Button(onClick = onBackToForm, modifier = Modifier.fillMaxWidth()) {
                Text("Kembali ke Form")
            }
        }
    }
}
