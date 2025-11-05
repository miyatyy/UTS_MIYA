package id.antasari.uts_mp_UTS_MIYA.data

import android.content.Context
import android.content.SharedPreferences

class PrefsHelper(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("profile_prefs", Context.MODE_PRIVATE)

    fun saveProfile(name: String, kelas: String, hobby: String, darkMode: Boolean) {
        prefs.edit().apply {
            putString("name", name)
            putString("kelas", kelas)
            putString("hobby", hobby)
            putBoolean("darkMode", darkMode)
            apply()
        }
    }

    fun hasProfile(): Boolean = prefs.contains("name")

    fun loadName(): String? = prefs.getString("name", null)
    fun loadKelas(): String? = prefs.getString("kelas", null)
    fun loadHobby(): String? = prefs.getString("hobby", null)
    fun loadDarkMode(): Boolean = prefs.getBoolean("darkMode", false)
}
