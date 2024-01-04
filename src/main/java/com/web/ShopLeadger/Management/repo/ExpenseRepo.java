package com.web.ShopLeadger.Management.repo;

import com.web.ShopLeadger.Management.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
}
