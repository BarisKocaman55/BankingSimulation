package com.example.bankingSimulation.bankingSimulationDemo.dataAccess.abstracts;

import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {
}
