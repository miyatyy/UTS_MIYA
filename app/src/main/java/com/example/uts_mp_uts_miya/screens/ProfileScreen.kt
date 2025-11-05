package id.antasari.uts_mp_UTS_MIYA.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(onNext: (name: String, kelas: String, hobby: String) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Form Profil") }) }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            var name by remember { mutableStateOf(TextFieldValue("")) }
            var kelas by remember { mutableStateOf(TextFieldValue("")) }
            var hobby by remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nama Lengkap") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = kelas,
                onValueChange = { kelas = it },
                label = { Text("Kelas") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = hobby,
                onValueChange = { hobby = it },
                label = { Text("Hobi") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = {
                    if (name.text.isNotEmpty() && kelas.text.isNotEmpty() && hobby.text.isNotEmpty()) {
                        onNext(name.text, kelas.text, hobby.text)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Simpan & Lanjut")
            }
        }
    }
}
