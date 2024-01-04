package com.web.ShopLeadger.Management.controller;

import com.web.ShopLeadger.Management.model.Income;
import com.web.ShopLeadger.Management.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeController {
        private final IncomeService incomeService;

        @Autowired
        public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }
        @GetMapping
        public List<Income> getAllIncome() {
            return incomeService.getAllIncome();
        }

        @PostMapping
        public Income recordIncome(@RequestBody Income income) {
            return incomeService.recordIncome(income);
        }

        @PutMapping("/{incomeId}")
        public ResponseEntity<Income> updateIncome(@PathVariable Long incomeId, @RequestBody Income updatedIncome) {
            try {
                Income income = incomeService.updateIncome(incomeId, updatedIncome);
                return ResponseEntity.ok(income);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(500).build();
            }
        }

        @DeleteMapping("/{incomeId}")
        public ResponseEntity<Void> deleteIncome(@PathVariable Long incomeId) {
            try {
                incomeService.deleteIncome(incomeId);
                return ResponseEntity.noContent().build();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(500).build();
            }
        }

}


