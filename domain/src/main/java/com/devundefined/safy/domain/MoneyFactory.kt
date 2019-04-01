package com.devundefined.safy.domain

import java.util.*

class MoneyFactory(private val currency: Currency) {

    fun moneyWithAmount(amount: Double) = Money(amount, currency)

    fun empty() = Money(0.0, currency)
}