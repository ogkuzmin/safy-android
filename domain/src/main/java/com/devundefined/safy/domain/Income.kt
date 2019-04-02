package com.devundefined.safy.domain

class Income(val amount: Money) {

    val currency = amount.currency
}