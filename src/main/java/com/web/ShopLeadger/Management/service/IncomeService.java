package com.web.ShopLeadger.Management.service;

import com.web.ShopLeadger.Management.model.Income;

import java.math.BigDecimal;
import java.util.List;

public interface IncomeService {
    List<Income> getAllIncome();
    Income recordIncome(Income income);
    Income getIncomeById(Long incomeId);
    Income saveIncome(Income income);
    Income updateIncome(Long incomeId, Income updatedIncome);
    void deleteIncome(Long incomeId);
    BigDecimal calculateTotalIncome();
}
