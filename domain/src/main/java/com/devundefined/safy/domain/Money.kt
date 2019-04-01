package com.devundefined.safy.domain

import java.util.*

class Money(val amount: Double, val currency: Currency)


operator fun Money.plus(another: Money) = Money(amount + another.amount, currency)
operator fun Money.minus(another: Money) = Money(amount - another.amount, currency)