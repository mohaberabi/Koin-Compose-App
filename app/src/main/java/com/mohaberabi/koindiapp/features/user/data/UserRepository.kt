package com.mohaberabi.koindiapp.features.user.data

import com.mohaberabi.koindiapp.features.user.model.User

interface UserRepository {
    fun findUser(name: String): User?
    fun addUsers(users: List<User>)
}


class UserRepositoryImpl : UserRepository {


    private val _users = mutableListOf<User>()
    override fun addUsers(users: List<User>) {
        _users.addAll(users)
    }

    override fun findUser(name: String): User? {

        return _users.firstOrNull()
    }
}