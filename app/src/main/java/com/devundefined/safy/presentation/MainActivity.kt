package com.devundefined.safy.presentation

import androidx.appcompat.app.AppCompatActivity
import com.devundefined.safy.R
import com.devundefined.safy.SafyApp
import com.devundefined.safy.di.DependencyManager
import com.devundefined.safy.di.DependencyManagerImpl
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : AppCompatActivity() {

    private val navigator: Navigator by lazy {
        SupportAppNavigator(this, R.id.fragment_container)
    }

    private val app = SafyApp.INSTANCE

    val dependencyManager = createDependencyManager()

    override fun onResumeFragments() {
        super.onResumeFragments()
    }

    private fun createDependencyManager(): DependencyManager = DependencyManagerImpl()
}