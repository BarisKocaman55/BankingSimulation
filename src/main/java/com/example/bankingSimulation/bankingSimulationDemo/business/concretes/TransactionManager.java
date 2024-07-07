package com.example.bankingSimulation.bankingSimulationDemo.business.concretes;

import com.example.bankingSimulation.bankingSimulationDemo.business.abstracts.TransactionService;
import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.DataResult;
import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.ErrorDataResult;
import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.SuccessDataResult;
import com.example.bankingSimulation.bankingSimulationDemo.dataAccess.abstracts.*;
import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.*;
import com.example.bankingSimulation.bankingSimulationDemo.enums.TransactionEnum;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionManager implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private DepositTransactionDao depositTransactionDao;

    @Autowired
    private WithdrawalTransactionDao withdrawalTransactionDao;

    @Autowired
    private BillPaymentTransactionDao billPaymentTransactionDao;

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public DataResult<BankAccount> processTransactions(int id, TransactionEnum transactionType, Transaction transaction) {
        try {
            BankAccount bankAccount = bankAccountDao.findById(id).orElseThrow(
                    () -> new EntityNotFoundException(
                            String.format("Bank Account with id %s was not found...", id))
            );
            switch (transactionType) {
                case TransactionEnum.Deposit: {
                    processDepositTransaction((DepositTransaction) transaction, bankAccount);
                    break;
                }
                case TransactionEnum.Withdrawal: {
                    processWithdrawalTransaction((WithdrawalTransaction) transaction, bankAccount);
                    break;
                }
                case TransactionEnum.BillPayment: {
                    double balance = bankAccount.getBalance();
                    balance = balance - transaction.getAmount();
                    if (balance < 0) {
                        throw new IllegalArgumentException("balance can not be less than zero...");
                    }
                    bankAccount.setBalance(balance);
                    bankAccountDao.save(bankAccount);
                    processBillPaymentTransaction((BillPaymentTransaction) transaction, bankAccount);
                    break;
                }
            }

            return new SuccessDataResult<BankAccount>(bankAccount, "Proccess on bank account has been successfully completed...");
        } catch (Exception exception) {
            return new ErrorDataResult<BankAccount>(exception.getMessage());
        }
    }

    private void processDepositTransaction(DepositTransaction depositTransaction, BankAccount bankAccount) {
        // Process deposit transaction
        double balance = bankAccount.getBalance();
        balance = balance + depositTransaction.getAmount();
        bankAccount.setBalance(balance);
        bankAccountDao.save(bankAccount);

        depositTransaction.setDate(new Date());
        DepositTransaction savedDepositTransaction = depositTransactionDao.save(depositTransaction);

        Transaction transaction = new Transaction(savedDepositTransaction.getAmount());
        transaction.setTransactionId(savedDepositTransaction.getId());
        transaction.setType(TransactionEnum.Deposit.name());

        System.out.println("Processing deposit transaction: " + depositTransaction);
    }

    private void processWithdrawalTransaction(WithdrawalTransaction withdrawalTransaction, BankAccount bankAccount) {
        // Process withdrawal transaction
        double balance = bankAccount.getBalance();
        balance = balance - withdrawalTransaction.getAmount();
        if (balance < 0) {
            throw new IllegalArgumentException("balance can not be less than zero...");
        }
        bankAccount.setBalance(balance);
        bankAccountDao.save(bankAccount);
        WithdrawalTransaction savedWiwithdrawalTransaction = withdrawalTransactionDao.save(withdrawalTransaction);

        Transaction transaction = new Transaction(savedWiwithdrawalTransaction.getAmount());
        transaction.setTransactionId(savedWiwithdrawalTransaction.getId());
        transaction.setType(TransactionEnum.Withdrawal.name());

        System.out.println("Processing withdrawal transaction: " + withdrawalTransaction);
    }

    private void processBillPaymentTransaction(BillPaymentTransaction billPaymentTransaction, BankAccount bankAccount) {
        // Process withdrawal transaction
        double balance = bankAccount.getBalance();
        balance = balance - billPaymentTransaction.getAmount();
        if (balance < 0) {
            throw new IllegalArgumentException("balance can not be less than zero...");
        }
        bankAccount.setBalance(balance);
        bankAccountDao.save(bankAccount);
        BillPaymentTransaction savedBillPaymentTransaction = billPaymentTransactionDao.save(billPaymentTransaction);

        Transaction transaction = new Transaction(savedBillPaymentTransaction.getAmount());
        transaction.setTransactionId(savedBillPaymentTransaction.getId());
        transaction.setType(TransactionEnum.BillPayment.name());

        System.out.println("Processing bill transaction: " + billPaymentTransaction);
    }
}
