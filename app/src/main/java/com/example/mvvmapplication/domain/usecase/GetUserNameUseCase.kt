package com.example.mvvmapplication.domain.usecase

import com.example.mvvmapplication.domain.interfaces.UserRepository
import com.example.mvvmapplication.domain.models.UserName

class GetUserNameUseCase(val userRepositoryImpl: UserRepository) {

    fun execute(): UserName {
        return userRepositoryImpl.getUserName()
    }

}