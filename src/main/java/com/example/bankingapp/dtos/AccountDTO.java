package com.example.bankingapp.dtos;

import lombok.Data;

@Data
public class AccountDTO {
    private Long id;
    private String accountHolderName;
    private double balance;

}
