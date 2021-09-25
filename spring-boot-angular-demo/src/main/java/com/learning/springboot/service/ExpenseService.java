package com.learning.springboot.service;

import com.learning.springboot.entity.Expense;
import com.learning.springboot.error.ExpenseNotFoundException;

import java.util.List;

public interface ExpenseService {
    Expense saveExpense(Expense expense);

    List<Expense> getExpenses();

    Expense getExpense(Long expenseId) throws ExpenseNotFoundException;

    Expense updateExpense(Expense expense);

    void deleteExpense(Long expenseId);
}
