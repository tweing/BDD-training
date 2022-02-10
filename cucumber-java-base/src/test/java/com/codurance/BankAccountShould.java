package com.codurance;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountShould {

    @Test
    void store_a_deposit() {
        Account sut = new Account(null);
        sut.deposit(123);
        assertThat(sut.getBalance()).isEqualTo(123);
    }

    @Test
    void store_a_withdrawal() {
        Account sut = new Account(null);
        sut.withdraw(234);
        assertThat(sut.getBalance()).isEqualTo(-234);
    }

    @Test
    void deposit_transaction_check_amount() {
        Account sut = new Account(null);
        sut.deposit(345);
        assertThat(sut.getTransaction(0).getAmount()).isEqualTo(345);
    }

    @Test
    void deposit_transaction_check_date() {
        Account sut = new Account(null);
        sut.deposit(345);
        assertThat(sut.getTransaction(0).getLocalDate()).isEqualTo(LocalDate.now());
    }

    @Test
    void withdrawal_transaction_check_amount() {
        Account sut = new Account(null);
        sut.withdraw(42);
        assertThat(sut.getTransaction(0).getAmount()).isEqualTo(-42);
    }

    @Test
    void deposit_only_positive() {
        Account sut = new Account(null);
        assertThrows(IllegalArgumentException.class, () -> {
            sut.deposit(-42);
        });
    }

    @Test
    void withdraw_only_positive() {
        Account sut = new Account(null);
        assertThrows(IllegalArgumentException.class, () -> {
            sut.withdraw(-42);
        });
    }
}
