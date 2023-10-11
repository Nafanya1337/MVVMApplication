package com.example.mvvmapplication.data.storage

import android.content.Context
import com.example.mvvmapplication.data.storage.interfaces.UserStorage
import com.example.mvvmapplication.data.storage.model.User
import com.example.mvvmapplication.data.storage.model.UserNameData


private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val SHARED_KEY_NAME = "name"
private const val SHARED_KEY_LAST_NAME = "last_name"

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(userNameData: UserNameData): Boolean {
        val array = userNameData.data.split(' ')
        val firstName = array[0]
        sharedPreferences.edit().putString(SHARED_KEY_NAME, firstName).apply()
        if (array.size == 2) {
            val lastName = array[1]
            sharedPreferences.edit().putString(SHARED_KEY_LAST_NAME, lastName).apply()
        }
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(SHARED_KEY_NAME, "Default Name") ?: ""
        val lastName = sharedPreferences.getString(SHARED_KEY_LAST_NAME, "Default LastName") ?: ""

        return User(firstName = firstName, lastName = lastName)
    }
}