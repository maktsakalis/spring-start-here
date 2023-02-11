package com.springstarthere.tsansactionsch13.services;

import com.springstarthere.tsansactionsch13.model.Account;
import com.springstarthere.tsansactionsch13.repositories.AccountRepository;
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
        return accountRepository.findAllAccounts();
    }

    @Transactional
    public void changeAmount(long senderId, long receiverId, BigDecimal amount) {
        Account sender = accountRepository.findAccountById(senderId);
        Account receiver = accountRepository.findAccountById(receiverId);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(sender.getId(), senderNewAmount);
        accountRepository.changeAmount(receiver.getId(), receiverNewAmount);
    }

}
