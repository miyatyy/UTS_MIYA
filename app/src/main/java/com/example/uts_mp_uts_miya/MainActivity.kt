package id.antasari.uts_mp_UTS_MIYA

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import id.antasari.uts_mp_UTS_MIYA.data.PrefsHelper
import id.antasari.uts_mp_UTS_MIYA.ui.BottomNavItem
import id.antasari.uts_mp_UTS_MIYA.ui.theme.UTS_MIYATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = PrefsHelper(this)

        setContent {
            var isDarkMode by remember { mutableStateOf(prefs.loadDarkMode()) }

            val onToggleDark: (Boolean) -> Unit = { newValue ->
                isDarkMode = newValue
                prefs.saveProfile(
                    prefs.loadName() ?: "",
                    prefs.loadKelas() ?: "",
                    prefs.loadHobby() ?: "",
                    newValue
                )
            }

            UTS_MIYATheme(darkTheme = isDarkMode) {
                val navController = rememberNavController()
                val navBackStackEntry = navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry.value?.destination?.route

                Scaffold(
                    bottomBar = {
                        // tampilkan bottom bar hanya di form/summary/saved
                        if (currentRoute?.startsWith("summary") == true ||
                            currentRoute == "form" ||
                            currentRoute == "saved"
                        ) {
                            BottomNavigationBar(navController)
                        }
                    }
                ) { innerPadding ->
                    Surface(
                        color = MaterialTheme.colors.background,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        NavGraph(
                            navController = navController,
                            context = this@MainActivity,
                            isDarkMode = isDarkMode,
                            onToggleDark = onToggleDark
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: androidx.navigation.NavHostController) {
    val items = listOf(
        BottomNavItem.Form,
        BottomNavItem.Summary,
        BottomNavItem.Saved
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute?.startsWith(item.route) == true,
                onClick = {
                    when (item) {
                        is BottomNavItem.Form -> navController.navigate("form")
                        is BottomNavItem.Summary -> navController.navigate("summary/test/test/test")
                        is BottomNavItem.Saved -> navController.navigate("saved")
                    }
                },
                alwaysShowLabel = true,
                selectedContentColor = MaterialTheme.colors.onPrimary,
                unselectedContentColor = MaterialTheme.colors.onPrimary.copy(alpha = 0.6f)
            )
        }
    }
}
