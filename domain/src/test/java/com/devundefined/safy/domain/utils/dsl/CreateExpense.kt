package com.devundefined.safy.domain.utils.dsl

import com.devundefined.safy.domain.Expense
import com.devundefined.safy.domain.Money

class CreateExpense {

    private lateinit var expenseMoney: Money

    fun withAmount(expenseMoney: Money): CreateExpense {
        this.expenseMoney = expenseMoney
        return this
    }

    fun please(): Expense {
        return Expense(expenseMoney)
    }
}