package com.springstarthere.springdatach14.repositories;

import com.springstarthere.springdatach14.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Modifying
    @Query("UPDATE account SET amount = :senderNewAmount WHERE id = :id")
    void changeAmount(long id, BigDecimal senderNewAmount);
}
