package com.example.architecture.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.data.repository.UserRepositoryImpl
import com.example.architecture.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.architecture.databinding.ActivityMainBinding
import com.example.architecture.domain2.model.SavedUserNameParam
import com.example.architecture.domain2.usecase.GetUserUseCase
import com.example.architecture.domain2.usecase.SaveUserUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    private val userRepositoryImpl by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(SharedPrefsUserStorage(applicationContext)) }
    private val getUserUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserUseCase(userRepositoryImpl) }
    private val saveUserUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserUseCase(userRepositoryImpl) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.apply {

            sendButton.setOnClickListener {
                val text = dataEditText.text.toString()
                val param = SavedUserNameParam(name = text)
                val result = saveUserUseCase.execute(param = param)
                dataTextView.text = "Save result = $result ($text)"
            }
            receiveButton.setOnClickListener {
                val userName = getUserUseCase.execute()
                dataTextView.text = "${userName.firstName} ${userName.lastName}"
            }

        }
    }
}