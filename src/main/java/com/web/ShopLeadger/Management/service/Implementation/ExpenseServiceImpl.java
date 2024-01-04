package com.web.ShopLeadger.Management.service.Implementation;

import com.web.ShopLeadger.Management.model.Expense;
import com.web.ShopLeadger.Management.repo.ExpenseRepo;
import com.web.ShopLeadger.Management.service.ExpenseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseRepo expenseRepo;
    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    @Override
    public Expense recordExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    @Override
    public Expense getIExpenseById(Long expenseId) {
        return expenseRepo.findById(expenseId).orElse(null);
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    @Override
    public Expense updateExpense(Long expenseId, Expense updatedExpense) {
        Optional<Expense> existingExpenseOptional = expenseRepo.findById(expenseId);

        if (existingExpenseOptional.isPresent()) {
            Expense existingExpense = existingExpenseOptional.get();
            existingExpense.setAmount(updatedExpense.getAmount());
            existingExpense.setDate(updatedExpense.getDate());
            existingExpense.setDescription(updatedExpense.getDescription());

            return expenseRepo.save(existingExpense);
        } else {
            throw new EntityNotFoundException("Expense not found with ID: " + expenseId);

        }
    }

    @Override
    public void deleteExpense(Long expenseId) {
        expenseRepo.deleteById(expenseId);
    }

    @Override
    public BigDecimal calculateTotalExpenses() {
        List<Expense> expenses = getAllExpenses();
        return expenses.stream().map(Expense::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
