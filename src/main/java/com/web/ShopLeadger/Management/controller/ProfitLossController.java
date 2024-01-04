package com.web.ShopLeadger.Management.controller;

import com.web.ShopLeadger.Management.model.ProfitLossRequest;
import com.web.ShopLeadger.Management.service.ExpenseService;
import com.web.ShopLeadger.Management.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculate-profit-loss")
public class ProfitLossController {

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<String> calculateProfitLoss(@RequestBody ProfitLossRequest request) {
        BigDecimal totalIncome = request.getTotalIncome();
        BigDecimal totalExpenses = request.getTotalExpenses();

        BigDecimal profitLoss = totalIncome.subtract(totalExpenses);

        String result;
        if (profitLoss.compareTo(BigDecimal.ZERO) > 0) {
            result = "Profit: " + profitLoss.toString();
        } else if (profitLoss.compareTo(BigDecimal.ZERO) < 0) {
            result = "Loss: " + profitLoss.abs().toString();
        } else {
            result = "No Profit, No Loss";
        }

        return ResponseEntity.ok(result);
    }
}


