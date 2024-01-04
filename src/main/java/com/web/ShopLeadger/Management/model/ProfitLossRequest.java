package com.web.ShopLeadger.Management.model;

import java.math.BigDecimal;

public class ProfitLossRequest {
    private BigDecimal totalIncome;
    private BigDecimal totalExpenses;

    public ProfitLossRequest() {
    }

    public ProfitLossRequest(BigDecimal totalIncome, BigDecimal totalExpenses) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }
}
