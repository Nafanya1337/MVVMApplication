package com.example.mvvmapplication.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapplication.data.repository.UserRepositoryImpl
import com.example.mvvmapplication.data.storage.SharedPrefUserStorage
import com.example.mvvmapplication.domain.usecase.GetUserNameUseCase
import com.example.mvvmapplication.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    private val sharedPrefUserStorage by lazy {
        SharedPrefUserStorage(context = context)
    }

    private val userRepositoryImpl by lazy {
        UserRepositoryImpl(userStorage = sharedPrefUserStorage)
    }

    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(userRepositoryImpl = userRepositoryImpl)
    }

    private val saveUserNameUseCase by lazy {
        SaveUserNameUseCase(userRepositoryImpl = userRepositoryImpl)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}