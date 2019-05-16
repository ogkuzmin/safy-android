package com.devundefined.safy.di.modules

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @Singleton
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideNavigatorHolder(cicerone: Cicerone<Router>) = cicerone.navigatorHolder

    @Provides
    @Singleton
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router
}