package com.example.bankingSimulation.bankingSimulationDemo.controller.bankAccount.request;

import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.Owner;

public record BankAccountCreateRequest(Owner owner, String accountNumber) {
}
