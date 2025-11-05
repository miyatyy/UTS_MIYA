package id.antasari.uts_mp_UTS_MIYA

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.antasari.uts_mp_UTS_MIYA.data.PrefsHelper
import id.antasari.uts_mp_UTS_MIYA.screens.ProfileScreen
import id.antasari.uts_mp_UTS_MIYA.screens.SavedScreen
import id.antasari.uts_mp_UTS_MIYA.screens.SummaryScreen

@Composable
fun NavGraph(navController: NavHostController) {
    val context = LocalContext.current
    val prefs = PrefsHelper(context)

    NavHost(navController = navController, startDestination = "form") {
        composable("form") {
            ProfileScreen { name, kelas, hobby ->
                navController.navigate("summary/$name/$kelas/$hobby")
            }
        }

        composable("summary/{name}/{kelas}/{hobby}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val kelas = backStackEntry.arguments?.getString("kelas") ?: ""
            val hobby = backStackEntry.arguments?.getString("hobby") ?: ""

            SummaryScreen(
                name = name,
                kelas = kelas,
                hobby = hobby,
                onSaveToDevice = { n, k, h, d ->
                    prefs.saveProfile(n, k, h, d)
                    navController.navigate("saved")
                },
                onBackToForm = { navController.popBackStack() }
            )
        }

        composable("saved") {
            SavedScreen(
                prefsHelper = prefs,
                onBackToForm = { navController.navigate("form") }
            )
        }
    }
}
