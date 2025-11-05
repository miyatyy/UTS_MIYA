package id.antasari.uts_mp_UTS_MIYA.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.antasari.uts_mp_UTS_MIYA.data.PrefsHelper

@Composable
fun SummaryScreen(
    name: String,
    kelas: String,
    hobby: String,
    prefsHelper: PrefsHelper,
    currentDarkMode: Boolean,
    onToggleDark: (Boolean) -> Unit,
    onBackToForm: () -> Unit,
    onSavedNavigate: () -> Unit
) {
    // local state untuk switch, diinisialisasi dari currentDarkMode
    var darkMode by remember { mutableStateOf(currentDarkMode) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Ringkasan Profil") }) }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Nama: $name")
            Text("Kelas: $kelas")
            Text("Hobi: $hobby")

            Spacer(Modifier.height(16.dp))

            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Text("Aktifkan Mode Gelap (Ya/Tidak)", Modifier.weight(1f))
                Switch(
                    checked = darkMode,
                    onCheckedChange = { newValue ->
                        darkMode = newValue
                        // panggil callback untuk langsung mengubah theme global
                        onToggleDark(newValue)
                        // jangan simpan profil penuh di sini (biar disimpan saat tombol "Simpan ke Perangkat")
                        // tetapi karena onToggleDark juga menyimpan darkMode ke prefs di contoh MainActivity, itu sudah tercatat
                    }
                )
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    // Simpan profile lengkap + darkMode ke prefs
                    prefsHelper.saveProfile(name, kelas, hobby, darkMode)
                    // navigasi ke saved screen
                    onSavedNavigate()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Simpan ke Perangkat")
            }

            Spacer(Modifier.height(8.dp))

            OutlinedButton(
                onClick = onBackToForm,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Kembali ke Form")
            }
        }
    }
}
