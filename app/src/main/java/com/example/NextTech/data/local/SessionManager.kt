package com.example.NextTech.data.local


import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = "session"
)

class SessionManager(
    private val context: Context
) {

    companion object {

        val IS_LOGGED =
            booleanPreferencesKey("is_logged")

        val USER_ID =
            stringPreferencesKey("user_id")

        val USER_NAME =
            stringPreferencesKey("user_name")

        val USER_EMAIL =
            stringPreferencesKey("user_email")

        val USER_PASSWORD =
            stringPreferencesKey("user_password")

    }

    suspend fun saveSession(id: String, name: String, email: String, passwd: String) {

        context.dataStore.edit { prefs ->

            prefs[IS_LOGGED] = true
            prefs[USER_ID] = id
            prefs[USER_NAME] = name
            prefs[USER_EMAIL] = email
            prefs[USER_PASSWORD] = passwd
        }
    }

    val isLoggedIn: Flow<Boolean> =
        context.dataStore.data.map { prefs ->
            prefs[IS_LOGGED] ?: false
        }

    suspend fun logout() {

        context.dataStore.edit {
            it.clear()
        }
    }

    val userName: Flow<String> =
        context.dataStore.data.map {
            it[USER_NAME] ?: ""
        }

    val userEmail: Flow<String> =
        context.dataStore.data.map {
            it[USER_EMAIL] ?: ""
        }

    val userId: Flow<String> =
        context.dataStore.data.map {
            it[USER_ID] ?: ""
        }

    val userPassword: Flow<String> =
        context.dataStore.data.map {

            it[USER_PASSWORD] ?: ""
        }


}