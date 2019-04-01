package com.devundefined.safy.domain.utils.dsl

import com.devundefined.safy.domain.Account
import com.devundefined.safy.domain.Money

class CreateAccount {

    private lateinit var accountMoney: Money

    fun withTotal(accountMoney: Money): CreateAccount {
        this.accountMoney = accountMoney
        return this
    }

    fun please(): Account {
        return Account(accountMoney)
    }
}