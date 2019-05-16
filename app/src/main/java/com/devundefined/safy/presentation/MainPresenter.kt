package com.devundefined.safy.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

}