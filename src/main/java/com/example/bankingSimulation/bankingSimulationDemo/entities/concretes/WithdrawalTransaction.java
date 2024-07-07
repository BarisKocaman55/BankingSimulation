package com.example.bankingSimulation.bankingSimulationDemo.entities.concretes;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "withdrawal_transactions")
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(double amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return String.format("Withdrawal transaction amount equals %s", getAmount());
    }
}
