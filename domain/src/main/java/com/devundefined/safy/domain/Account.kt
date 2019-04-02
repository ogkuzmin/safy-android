package com.devundefined.safy.domain

import java.util.*

class Account(private val currency: Currency) {

    var total: Money = MoneyFactory(currency).empty()
        private set

    constructor(total: Money) : this(total.currency) {
        this.total = total
    }

    @Throws(IllegalArgumentException::class)
    fun add(income: Income) {
        if (currency != income.currency) {
            throw IllegalArgumentException("Can't add income with another currency")
        }
        total += income.amount
    }

    @Throws(IllegalArgumentException::class)
    fun add(expense: Expense) {
        if (currency != expense.currency) {
            throw IllegalArgumentException("Can't add expense with another currency")
        }
        total -= expense.amount
    }
}