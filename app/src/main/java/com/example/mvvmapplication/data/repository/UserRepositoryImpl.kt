package com.example.mvvmapplication.data.repository

import com.example.mvvmapplication.data.storage.interfaces.UserStorage
import com.example.mvvmapplication.domain.interfaces.UserRepository
import com.example.mvvmapplication.domain.models.User
import com.example.mvvmapplication.data.storage.model.UserNameData
import com.example.mvvmapplication.domain.models.UserName


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveParam(saveParam: User): Boolean {
        return userStorage.save(userNameData = UserNameData(saveParam.userNameData))
    }

    override fun getUserName(): UserName {
        val userName = userStorage.get()
        return UserName(firstName = userName.firstName, lastName = userName.lastName)
    }
}