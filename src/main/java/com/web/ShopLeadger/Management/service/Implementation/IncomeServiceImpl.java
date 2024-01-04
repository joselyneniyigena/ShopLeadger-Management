package com.web.ShopLeadger.Management.service.Implementation;

import com.web.ShopLeadger.Management.model.Expense;
import com.web.ShopLeadger.Management.model.Income;
import com.web.ShopLeadger.Management.repo.IncomeRepo;
import com.web.ShopLeadger.Management.service.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private IncomeRepo incomeRepo;

    @Override
    public List<Income> getAllIncome() {
        return incomeRepo.findAll();
    }

    @Override
    public Income recordIncome(Income income) {
        return incomeRepo.save(income);
    }

    @Override
    public Income getIncomeById(Long incomeId) {
        return incomeRepo.findById(incomeId).orElse(null);
    }

    @Override
    public Income saveIncome(Income income) {
        return incomeRepo.save(income);
    }

    @Override
    public Income updateIncome(Long incomeId, Income updatedIncome) {
        Optional<Income> existingIncomeOptional = incomeRepo.findById(incomeId);

        if (existingIncomeOptional.isPresent()) {
            Income existingIncome = existingIncomeOptional.get();
            existingIncome.setAmount(updatedIncome.getAmount());
            existingIncome.setDate(updatedIncome.getDate());
            existingIncome.setDescription(updatedIncome.getDescription());

            return incomeRepo.save(existingIncome);
        } else {
            throw new EntityNotFoundException("Income not found with ID: " + incomeId);
        }
    }

    @Override
    public void deleteIncome(Long incomeId) {
        incomeRepo.deleteById(incomeId);
    }

    @Override
    public BigDecimal calculateTotalIncome() {
        List<Income> incomes = getAllIncome();
        return incomes.stream().map(Income::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
