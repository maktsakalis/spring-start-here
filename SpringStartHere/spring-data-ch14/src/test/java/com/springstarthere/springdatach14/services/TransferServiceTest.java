package com.springstarthere.springdatach14.services;

import com.springstarthere.springdatach14.exceptions.AccountNotFoundException;
import com.springstarthere.springdatach14.model.Account;
import com.springstarthere.springdatach14.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TransferServiceTest {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    TransferService transferService;


    @Test
    void transferMoneyHappyFlow() {

        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(destination.getId())).willReturn(Optional.of(destination));

        transferService.transferMoney(sender.getId(), destination.getId(), new BigDecimal(100));

        verify(accountRepository).changeAmount(1, new BigDecimal(900));
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));
    }

    @Test
    void transferMoneyDestinationNotFoundFlow() {

        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(1L)).willReturn(Optional.of(sender));
        given(accountRepository.findById(2L)).willReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> transferService.transferMoney(1L, 2L, new BigDecimal(100)));

        verify(accountRepository, never()).changeAmount(anyLong(), any());

    }
}