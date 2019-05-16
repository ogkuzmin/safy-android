package com.devundefined.safy

import android.app.Application
import com.devundefined.safy.di.DependencyManager
import com.devundefined.safy.di.DependencyManagerImpl

class SafyApp private constructor() : Application() {
    companion object {
        lateinit var INSTANCE: SafyApp
            private set
    }

    val dependencyManager = createDependencyManager()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    private fun createDependencyManager(): DependencyManager = DependencyManagerImpl()
}
