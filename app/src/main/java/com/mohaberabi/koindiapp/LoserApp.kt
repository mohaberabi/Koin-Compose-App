package com.mohaberabi.koindiapp

import android.app.Application
import com.mohaberabi.koindiapp.features.user.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LoserApp : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@LoserApp)
            modules(appModule)
        }
    }
}