package com.learning.springboot.controller;

import com.learning.springboot.entity.Expense;
import com.learning.springboot.error.ExpenseNotFoundException;
import com.learning.springboot.model.Expenses;
import com.learning.springboot.service.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@CrossOrigin("*") // OR
//@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class ExpenseController {
    private final Logger LOGGER = LoggerFactory.getLogger(ExpenseController.class);

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expenses")
    public ResponseEntity<Expense> saveExpense(@Valid @RequestBody Expense expense) {
        LOGGER.info("Inside saveExpense of ExpenseController");
        Expense savedExpense = expenseService.saveExpense(expense);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping("/expenses")
    public ResponseEntity<Expenses> getExpenses() {
        List<Expense> expenseList = expenseService.getExpenses();
        Expenses expenses = new Expenses();
        expenses.setExpense(expenseList);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/expenses/{expenseId}")
    public ResponseEntity<Expense> getExpense(@PathVariable Long expenseId) throws ExpenseNotFoundException {
        Expense expense = expenseService.getExpense(expenseId);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @PutMapping("/expenses/{expenseId}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long expenseId, @RequestBody Expense expense) {
        expense.setExpenseId(expenseId);
        Expense updatedExpense = expenseService.updateExpense(expense);
        return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
    }

    @DeleteMapping("/expenses/{expenseId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long expenseId) {
        expenseService.deleteExpense(expenseId);
        return new ResponseEntity<>("Expense deleted successfully", HttpStatus.OK);
    }
}
