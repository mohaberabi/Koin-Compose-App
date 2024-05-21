package com.mohaberabi.koindiapp

import com.mohaberabi.koindiapp.features.user.di.appModule
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.verify.verify

class CheckModuleTest {


    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkModules() {
        appModule.verify()
    }
}