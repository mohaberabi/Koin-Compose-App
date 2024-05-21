package com.mohaberabi.koindiapp.features.user.presentation

import com.mohaberabi.koindiapp.features.user.data.UserRepository

class UserPresenter(
    private val userRepository: UserRepository,
) {


    fun sayHello(name: String): String {
        val foundUser = userRepository.findUser(name)
        return foundUser?.let {
            "Hello ${it} from ${this}"
        } ?: "${name} is not found "
    }
}