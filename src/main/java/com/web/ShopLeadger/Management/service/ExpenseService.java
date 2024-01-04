package com.web.ShopLeadger.Management.service;

import com.web.ShopLeadger.Management.model.Expense;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense recordExpense(Expense expense);
    Expense getIExpenseById(Long expenseId);
    Expense saveExpense(Expense expense);
    Expense updateExpense(Long expenseId, Expense updatedExpense);
    void deleteExpense(Long expenseId);
    BigDecimal calculateTotalExpenses();
}
