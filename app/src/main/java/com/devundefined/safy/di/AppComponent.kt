package com.devundefined.safy.di

import com.devundefined.safy.di.modules.ContextModule
import com.devundefined.safy.di.modules.NavigationModule
import dagger.Component
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Component(modules = [ContextModule::class, NavigationModule::class])
@Singleton
interface AppComponent {
    fun navigatorHolder(): NavigatorHolder

    fun router(): Router
}