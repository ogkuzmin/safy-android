package com.devundefined.safy.domain.utils

import com.devundefined.safy.domain.MoneyFactory
import com.devundefined.safy.domain.minus
import com.devundefined.safy.domain.plus
import com.devundefined.safy.domain.utils.dsl.CreateAccount
import com.devundefined.safy.domain.utils.dsl.CreateExpense
import com.devundefined.safy.domain.utils.dsl.CreateIncome
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.*

class AccountTests {

    private val moneyFactory = MoneyFactory(Currency.getInstance("USD"))

    @Test
    fun whenAddIncome_totalOfAccountShouldBeIncreased_byAmountOfIncome() {
        val accountMoney = moneyFactory.moneyWithAmount(100.0)
        val incomeMoney = moneyFactory.moneyWithAmount(20.0)
        val account = CreateAccount().withTotal(accountMoney).please()
        val income = CreateIncome().withAmount(incomeMoney).please()

        account.add(income)

        assertEquals((accountMoney + incomeMoney).amount, account.total.amount)
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenAddIncome_shouldFail_ifIncomeAndAccountWithDifferentCurrencies() {
        val accountMoney = moneyFactory.moneyWithAmount(100.0)
        val account = CreateAccount().withTotal(accountMoney).please()
        val incomeMoney = MoneyFactory(Currency.getInstance("RUB")).moneyWithAmount(1000.0)
        val income = CreateIncome().withAmount(incomeMoney).please()

        account.add(income)
    }

    @Test
    fun whenAddExpense_totalOfAccountShouldBeDecreased_byAmountOfExpense() {
        val accountMoney = moneyFactory.moneyWithAmount(100.0)
        val expenseMoney = moneyFactory.moneyWithAmount(20.0)
        val account = CreateAccount().withTotal(accountMoney).please()
        val expense = CreateExpense().withAmount(expenseMoney).please()

        account.add(expense)

        assertEquals((accountMoney - expenseMoney).amount, account.total.amount)
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenAddExpense_shouldFail_ifExpenseAndAccountWithDifferentCurrencies() {
        val accountMoney = moneyFactory.moneyWithAmount(100.0)
        val account = CreateAccount().withTotal(accountMoney).please()
        val expenseMoney = MoneyFactory(Currency.getInstance("RUB")).moneyWithAmount(1000.0)
        val expense = CreateExpense().withAmount(expenseMoney).please()

        account.add(expense)
    }
}