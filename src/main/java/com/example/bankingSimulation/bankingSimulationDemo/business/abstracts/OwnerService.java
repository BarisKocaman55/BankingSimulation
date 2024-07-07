package com.example.bankingSimulation.bankingSimulationDemo.business.abstracts;

import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.DataResult;
import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.Result;
import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.Owner;

import javax.xml.crypto.Data;
import java.util.List;

public interface OwnerService {
    Result add(Owner owner);
    DataResult<List<Owner>> getAll();
    DataResult<Owner> getByNationalId(String nationId);
}
