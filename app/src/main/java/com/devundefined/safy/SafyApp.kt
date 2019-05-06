package com.devundefined.safy

import android.app.Application

class SafyApp private constructor() : Application() {
    companion object {
        lateinit var INSTANCE: SafyApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}
