package com.example.mvvmapplication.domain.interfaces

import com.example.mvvmapplication.domain.models.User
import com.example.mvvmapplication.domain.models.UserName

interface UserRepository {
    fun saveParam(saveParam: User): Boolean

    fun getUserName(): UserName
}