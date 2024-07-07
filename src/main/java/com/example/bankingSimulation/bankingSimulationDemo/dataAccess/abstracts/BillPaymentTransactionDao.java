package com.example.bankingSimulation.bankingSimulationDemo.dataAccess.abstracts;

import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.BillPaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillPaymentTransactionDao extends JpaRepository<BillPaymentTransaction, Integer> {
}
