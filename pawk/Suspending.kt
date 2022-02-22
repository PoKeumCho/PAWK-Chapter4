package pawk

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


fun fetchAndLoadProfile(id: String, scope: CoroutineScope) {

    scope.launch {
        val profileDeffered = async {
            fetchProfile(id)
        }
        val profile = profileDeffered.await()
        loadProfile(profile)
    }
}

class Profile { }

suspend fun fetchProfile(id: String): Profile = Profile()
fun loadProfile(profile: Profile): String = "Profile"