package com.example.bankingapp.controllers;

import com.example.bankingapp.dtos.AccountDTO;
import com.example.bankingapp.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add account rest api
    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }

    //Get account rest api
    @GetMapping("{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
        AccountDTO accountDTO = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDTO);
    }

    //deposit rest api
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDTO accountDTO = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDTO);
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDTO accountDTO = accountService.withDraw(id, amount);
        return ResponseEntity.ok(accountDTO);
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts(){
        List<AccountDTO> accountDTOS = accountService.getAllAccounts();
        return ResponseEntity.ok(accountDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
        accountService.deleteAccountById(id);
        return ResponseEntity.ok("Account deleted");
    }
}
