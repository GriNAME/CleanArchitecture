package com.example.architecture.data.storage

import com.example.architecture.data.storage.model.User

interface UserStorage {

    fun save(user: User)

    fun get(): User
}