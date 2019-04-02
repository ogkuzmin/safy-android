package com.devundefined.safy.domain

class Expense(val amount: Money) {

    val currency = amount.currency
}