package com.devundefined.safy.domain

import java.util.*

class Account(private val currency: Currency) {

    var total: Money = MoneyFactory(currency).empty()
        private set

    constructor(total: Money) : this(total.currency) {
        this.total = total
    }

    fun add(income: Income) {
        total += income.amount
    }
}