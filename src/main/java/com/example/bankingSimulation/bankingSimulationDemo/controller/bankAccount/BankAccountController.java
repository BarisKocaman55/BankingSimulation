package com.example.bankingSimulation.bankingSimulationDemo.controller.bankAccount;


import com.example.bankingSimulation.bankingSimulationDemo.business.abstracts.BankAccountService;
import com.example.bankingSimulation.bankingSimulationDemo.controller.bankAccount.request.BankAccountByAccountNumberRequest;
import com.example.bankingSimulation.bankingSimulationDemo.controller.bankAccount.request.BankAccountCreateRequest;
import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.DataResult;
import com.example.bankingSimulation.bankingSimulationDemo.core.utilities.results.Result;
import com.example.bankingSimulation.bankingSimulationDemo.entities.concretes.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/bankAccount")
@CrossOrigin
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/getByAccountNumber")
    public DataResult<BankAccount> getByAccountNumber(BankAccountByAccountNumberRequest request) {
        return this.bankAccountService.getBankAccountByAccountNumber(request.accountNumber());
    }

    @PostMapping("/create")
    public Result create(BankAccountCreateRequest request) {
        return this.bankAccountService.createAccount(request.owner(), request.accountNumber());
    }
}
