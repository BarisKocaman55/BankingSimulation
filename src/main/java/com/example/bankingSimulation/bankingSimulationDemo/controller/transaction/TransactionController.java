package com.example.bankingSimulation.bankingSimulationDemo.controller.transaction;

import com.example.bankingSimulation.bankingSimulationDemo.business.abstracts.TransactionService;
import com.example.bankingSimulation.bankingSimulationDemo.controller.transaction.request.TransactionProcessRequest;
import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.DataResult;
import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transaction")
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/save")
    public DataResult<BankAccount> saveTransaction(TransactionProcessRequest request) {
        return this.transactionService.processTransactions(request.bankAccountId(), request.transactionType(), request.transaction());
    }
}
