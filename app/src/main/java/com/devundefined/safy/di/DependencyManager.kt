package com.devundefined.safy.di

import com.devundefined.safy.SafyApp
import com.devundefined.safy.di.modules.ContextModule

interface DependencyManager {

    fun appComponent(): AppComponent
}

class DependencyManagerImpl : DependencyManager {

    val appComponent = DaggerAppComponent
        .builder()
        .contextModule(ContextModule(SafyApp.INSTANCE))
        .build()

    override fun appComponent() = appComponent
}