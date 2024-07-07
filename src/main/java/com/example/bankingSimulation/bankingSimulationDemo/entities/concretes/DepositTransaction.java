package com.example.bankingSimulation.bankingSimulationDemo.entities.concretes;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "deposit_transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositTransaction extends Transaction {
    public DepositTransaction(double amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return String.format("Deposit transaction amount equals %s", getAmount());
    }
}
