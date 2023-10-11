package com.example.mvvmapplication.domain.usecase

import com.example.mvvmapplication.domain.interfaces.UserRepository
import com.example.mvvmapplication.domain.models.User

class SaveUserNameUseCase(val userRepositoryImpl: UserRepository) {

    fun execute(saveUserName: User): Boolean {
        val result = userRepositoryImpl.saveParam(saveParam = saveUserName)
        return result
    }

}