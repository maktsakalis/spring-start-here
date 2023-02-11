package com.springstarthere.springdatach14.services;

import com.springstarthere.springdatach14.exceptions.AccountNotFoundException;
import com.springstarthere.springdatach14.model.Account;
import com.springstarthere.springdatach14.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;


    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    @Transactional
    public void transferMoney(long senderId, long receiverId, BigDecimal amount) {
        Account sender = accountRepository.findById(senderId).orElseThrow(() -> new AccountNotFoundException("Sender id is not valid!"));
        Account receiver = accountRepository.findById(receiverId).orElseThrow(() -> new AccountNotFoundException("Sender id is not valid!"));

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(sender.getId(), senderNewAmount);
        accountRepository.changeAmount(receiver.getId(), receiverNewAmount);
    }

}
