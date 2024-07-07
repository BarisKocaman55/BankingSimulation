package com.example.bankingSimulation.bankingSimulationDemo.business.concretes;

import com.example.bankingSimulation.bankingSimulationDemo.business.abstracts.BankAccountService;
import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.*;
import com.example.bankingSimulation.bankingSimulationDemo.dataAccess.abstracts.BankAccountDao;
import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.BankAccount;
import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.Owner;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountManager implements BankAccountService {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public Result createAccount(Owner owner, String accountNumber) {
        try {
            if (owner != null) {
                BankAccount bankAccount = new BankAccount();
                bankAccount.setOwner(owner);
                bankAccount.setAccountNumber(accountNumber);
                bankAccount.setBalance(0.0);
                bankAccountDao.save(bankAccount);
                return new SuccessResult("Bank account has been successfully created...");
            }
            return new ErrorResult("Owner can not be null...");
        } catch (Exception exp) {
            return new ErrorResult(exp.getMessage());
        }
    }

    @Override
    public DataResult<BankAccount> getBankAccountByAccountNumber(String accountNumber) {
        try {
            BankAccount bankAccount = bankAccountDao.getByAccountNumber(accountNumber);
            if (bankAccount == null) {
                throw new EntityNotFoundException(String.format("Bank Account with accountNumber %s was not found...", accountNumber));
            }

            return new SuccessDataResult<BankAccount>(bankAccount, String.format("Bank Account with accountNumber %s was successfully found...", accountNumber));
        } catch (Exception exp) {
            return new ErrorDataResult<BankAccount>(exp.getMessage());
        }
    }
}
