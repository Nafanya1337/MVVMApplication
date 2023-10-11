package com.example.mvvmapplication.data.storage.interfaces

import com.example.mvvmapplication.data.storage.model.User
import com.example.mvvmapplication.data.storage.model.UserNameData


interface UserStorage {

    fun save(userNameData: UserNameData): Boolean

    fun get(): User

}