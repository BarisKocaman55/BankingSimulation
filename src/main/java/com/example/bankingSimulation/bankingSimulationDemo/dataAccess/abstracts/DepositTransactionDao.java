package com.example.bankingSimulation.bankingSimulationDemo.dataAccess.abstracts;

import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.DepositTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositTransactionDao extends JpaRepository<DepositTransaction, Integer> {
}
