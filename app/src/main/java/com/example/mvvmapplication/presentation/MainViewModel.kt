package com.example.mvvmapplication.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmapplication.domain.models.User
import com.example.mvvmapplication.domain.usecase.GetUserNameUseCase
import com.example.mvvmapplication.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private var resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "VM Created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM Cleared")
        super.onCleared()
    }


    fun save(text: String) {
        val saveUserName = User(text)
        val result = saveUserNameUseCase.execute(saveUserName)
        resultLiveMutable.value = "Save result = $result"
    }

    fun get() {
        val userName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName}\n${userName.lastName}"
    }

}