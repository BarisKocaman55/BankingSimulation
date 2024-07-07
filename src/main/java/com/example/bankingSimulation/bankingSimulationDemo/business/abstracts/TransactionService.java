package com.example.bankingSimulation.bankingSimulationDemo.business.abstracts;

import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.DataResult;
import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.BankAccount;
import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.Transaction;
import com.example.bankingSimulation.bankingSimulationDemo.enums.TransactionEnum;

public interface TransactionService {
    DataResult<BankAccount> processTransactions(int id, TransactionEnum transactionType, Transaction transaction);
}
