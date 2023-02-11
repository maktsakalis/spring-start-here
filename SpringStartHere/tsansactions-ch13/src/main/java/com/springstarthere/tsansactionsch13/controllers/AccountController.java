package com.springstarthere.tsansactionsch13.controllers;

import com.springstarthere.tsansactionsch13.model.Account;
import com.springstarthere.tsansactionsch13.model.TransferRequest;
import com.springstarthere.tsansactionsch13.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest){
        transferService.changeAmount(transferRequest.getSenderId(), transferRequest.getReceiverId(), transferRequest.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return transferService.getAllAccounts();
    }

}
