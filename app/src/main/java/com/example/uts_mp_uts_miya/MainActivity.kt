package id.antasari.uts_mp_UTS_MIYA

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import id.antasari.uts_mp_UTS_MIYA.ui.BottomNavItem
import id.antasari.uts_mp_UTS_MIYA.ui.theme.UTS_MIYATheme
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTS_MIYAApp()
        }
    }
}

@Composable
fun UTS_MIYAApp() {
    UTS_MIYATheme {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController)
            }
        ) { innerPadding ->
            Surface(
                color = MaterialTheme.colors.background,
                modifier = Modifier.padding(innerPadding)
            ) {
                NavGraph(navController = navController)
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
                        is BottomNavItem.Summary -> {
                            // Hanya bisa dari data form → ringkasan
                            navController.navigate("form")
                        }
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
