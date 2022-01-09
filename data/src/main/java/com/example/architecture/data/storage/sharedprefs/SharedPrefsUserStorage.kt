package com.example.architecture.data.storage.sharedprefs

import android.content.Context
import com.example.architecture.data.storage.UserStorage
import com.example.architecture.data.storage.model.User

const val SHARED_PREF_NAME = "shared_pref_name"
const val KEY_FIRST_NAME = "first_name"
const val KEY_LAST_NAME = "last_name"
const val DEFAULT_FIRST_NAME = "First"
const val DEFAULT_LAST_NAME = "Last"

class SharedPrefsUserStorage(
    context: Context
) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun save(user: User) {
        sharedPreferences.edit()
            .putString(KEY_FIRST_NAME, user.firstName)
            .putString(KEY_LAST_NAME, user.lastName)
            .apply()
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME

        return User(firstName, lastName)
    }
}