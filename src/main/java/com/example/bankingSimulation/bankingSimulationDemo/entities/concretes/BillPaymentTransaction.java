package com.example.bankingSimulation.bankingSimulationDemo.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "billPayment_transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillPaymentTransaction extends Transaction {
    @Column(name = "payee")
    private String payee;

    public BillPaymentTransaction(double amount, String payee) {
        super(amount);
        this.payee = payee;
    }

    @Override
    public String toString() {
        return String.format("Bill payment transaction amount equals %s and payee is %s", getAmount(), this.payee);
    }

    public String getPayee() {
        return this.payee;
    }
}
