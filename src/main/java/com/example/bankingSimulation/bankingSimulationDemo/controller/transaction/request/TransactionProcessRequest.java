package com.example.bankingSimulation.bankingSimulationDemo.controller.transaction.request;

import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.Transaction;
import com.example.bankingSimulation.bankingSimulationDemo.enums.TransactionEnum;

public record TransactionProcessRequest(int bankAccountId, TransactionEnum transactionType, Transaction transaction) {
}
