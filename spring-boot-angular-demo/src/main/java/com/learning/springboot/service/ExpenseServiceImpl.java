package com.learning.springboot.service;

import com.learning.springboot.entity.Expense;
import com.learning.springboot.error.ExpenseNotFoundException;
import com.learning.springboot.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpense(Long expenseId) throws ExpenseNotFoundException {
        Optional<Expense> optionalExpense = expenseRepository.findById(expenseId);
        if (!optionalExpense.isPresent()) {
            throw new ExpenseNotFoundException("Expense not found for Expense Id : " + expenseId);
        }
        return optionalExpense.get();
    }

    @Override
    public Expense updateExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);    // OR
        /*Expense expense = getExpense(expenseId);
        expenseRepository.delete(expense); */
    }
}
