package com.example.architecture.domain2.usecase

import com.example.architecture.domain2.model.SavedUserNameParam
import com.example.architecture.domain2.repository.UserRepository

class SaveUserUseCase(
    private val userRepository: UserRepository
) {

    fun execute(param: SavedUserNameParam): Boolean {

        val oldUserName = userRepository.getUserName()

        return if (param.name.isNotEmpty()) {
            if (oldUserName.firstName == param.name) {
                true
            } else {
                userRepository.saveName(param)
                true
            }
        } else {
            false
        }
    }
}