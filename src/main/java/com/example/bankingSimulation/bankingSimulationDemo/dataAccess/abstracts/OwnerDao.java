package com.example.bankingSimulation.bankingSimulationDemo.dataAccess.abstracts;

import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerDao extends JpaRepository<Owner, Integer> {
    Owner getByFirstNameAndLastName(String firstName, String lastName);
}
