package com.devundefined.safy.domain.utils.dsl

import com.devundefined.safy.domain.Income
import com.devundefined.safy.domain.Money

class CreateIncome {
    private lateinit var incomeMoney: Money

    fun withAmount(incomeMoney: Money): CreateIncome {
        this.incomeMoney = incomeMoney
        return this
    }

    fun please(): Income {
        return Income(incomeMoney)
    }
}