package com.mohaberabi.koindiapp.features.user.di

import com.mohaberabi.koindiapp.features.user.data.UserRepository
import com.mohaberabi.koindiapp.features.user.data.UserRepositoryImpl
import com.mohaberabi.koindiapp.features.user.presentation.UserPresenter
import com.mohaberabi.koindiapp.features.user.presentation.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val appModule = module {

    /**
     * [single] an only one singleton instance during the whole life cylce of the whole app
     */
    single<UserRepository> { UserRepositoryImpl() }
    /**
     * [factory] this instance is scoped to where the isntance is alive whre it will be collected or destroyed each time
     * the corresponding view destroyed and it will be recreated again [Factory] Design Pattern
     */
    factory { UserPresenter(get()) }
    viewModel { UserViewModel(get()) }


}

/**
 * we can create the same [appmodule] in a more compact way to retrieve the same target and goal like below
 */

val appModule2 = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    factoryOf(::UserPresenter)
}