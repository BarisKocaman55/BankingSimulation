package com.example.bankingSimulation.bankingSimulationDemo.business.abstracts;

import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.DataResult;
import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.Result;
import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.BankAccount;
import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.Owner;

public interface BankAccountService {
    Result createAccount(Owner owner, String accountNumber);
    DataResult<BankAccount> getBankAccountByAccountNumber(String accountNumber);
}
