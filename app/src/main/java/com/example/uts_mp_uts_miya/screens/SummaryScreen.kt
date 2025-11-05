package id.antasari.uts_mp_UTS_MIYA.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SummaryScreen(
    name: String,
    kelas: String,
    hobby: String,
    onSaveToDevice: (String, String, String, Boolean) -> Unit,
    onBackToForm: () -> Unit
) {
    var darkMode by remember { mutableStateOf(false) }

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
                Switch(checked = darkMode, onCheckedChange = { darkMode = it })
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = { onSaveToDevice(name, kelas, hobby, darkMode) },
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
