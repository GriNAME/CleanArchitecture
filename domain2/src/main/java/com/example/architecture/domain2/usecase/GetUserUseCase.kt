package com.example.architecture.domain2.usecase

import com.example.architecture.domain2.model.UserName
import com.example.architecture.domain2.repository.UserRepository

class GetUserUseCase(
    private val userRepository: UserRepository
) {

    fun execute(): UserName {
        return userRepository.getUserName()
    }
}