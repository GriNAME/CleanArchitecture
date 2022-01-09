package com.example.architecture.data.repository

import com.example.architecture.data.storage.model.User
import com.example.architecture.data.storage.UserStorage
import com.example.architecture.domain2.model.SavedUserNameParam
import com.example.architecture.domain2.model.UserName
import com.example.architecture.domain2.repository.UserRepository

class UserRepositoryImpl(
    private val userStorage: UserStorage
) : UserRepository {

    override fun saveName(savedParam: SavedUserNameParam) {
        val user = mapToStorage(savedParam)
        userStorage.save(user)
    }

    override fun getUserName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(userName: SavedUserNameParam): User {
        return User(firstName = userName.name, lastName = "Default from URImpl")
    }
}