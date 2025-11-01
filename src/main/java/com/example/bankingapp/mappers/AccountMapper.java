package com.example.bankingapp.mappers;

import com.example.bankingapp.dtos.AccountDTO;
import com.example.bankingapp.entities.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setBalance(accountDTO.getBalance());
        account.setAccountHolderName(accountDTO.getAccountHolderName());
        return account;
    }
    public static AccountDTO mapToAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setAccountHolderName(account.getAccountHolderName());
        return accountDTO;
    }
}


