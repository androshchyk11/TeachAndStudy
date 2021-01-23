package com.example.ts.managers

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesManager @Inject constructor(@ApplicationContext context: Context) {

    private val USER_ACCESS_TOKEN_KEY = "USER_ACCESS_TOKEN_KEY"
    private val PREFERENCES_FILE_NAME = "t&s.spref"

    private val sharedPreferences: SharedPreferences

    init {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    }

    var userAccessToken: String?
        get() = sharedPreferences.getString(USER_ACCESS_TOKEN_KEY, null)
        set(token) {
            sharedPreferences.edit {
                putString(USER_ACCESS_TOKEN_KEY, token)
            }
        }


}