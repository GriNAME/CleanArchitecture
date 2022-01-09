package com.example.architecture.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.architecture.data.repository.UserRepositoryImpl
import com.example.architecture.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.architecture.domain2.usecase.GetUserUseCase
import com.example.architecture.domain2.usecase.SaveUserUseCase

const val TAG = "MainViewModel"

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepositoryImpl by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            SharedPrefsUserStorage(
                application.applicationContext
            )
        )
    }

    private val getUserUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserUseCase(userRepositoryImpl) }
    private val saveUserUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserUseCase(userRepositoryImpl) }

    fun send() {

    }

    fun get() {

    }

    init {
        Log.d(TAG, "init: created")
    }

    override fun onCleared() {
        Log.d(TAG, "onCleared: destroyed")
        super.onCleared()
    }
}