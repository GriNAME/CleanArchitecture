package com.example.architecture.domain2.repository

import com.example.architecture.domain2.model.SavedUserNameParam
import com.example.architecture.domain2.model.UserName

interface UserRepository {

    fun saveName(savedParam: SavedUserNameParam)

    fun getUserName(): UserName
}