package com.devundefined.safy.presentation

import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.devundefined.safy.R
import com.devundefined.safy.SafyApp
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MainView, MvpAppCompatActivity() {

    private val navigator: Navigator by lazy {
        SupportAppNavigator(this, R.id.fragment_container)
    }

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = MainPresenter(SafyApp.INSTANCE.dependencyManager.appComponent().router())

    private val navigatorHolder = SafyApp.INSTANCE.dependencyManager.appComponent().navigatorHolder()

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}