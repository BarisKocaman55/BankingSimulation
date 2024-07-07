package com.example.bankingSimulation.bankingSimulationDemo.dataAccess.abstracts;

import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.WithdrawalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalTransactionDao extends JpaRepository<WithdrawalTransaction, Integer> {
}
