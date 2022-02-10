package com.codurance.bank;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;

public class TransactionShould {

    @Test
    void factory_creates_deposit_transaction() {
        LocalDate date = LocalDate.of(2012, 03, 26);
        var sut = Transaction.createDepositTransaction(100, date);
        assertThat(sut.getAmount()).isEqualTo(100);
        assertThat(sut.getLocalDate()).isEqualTo(date);
    }

    @Test
    void factory_creates_withdrawal_transaction() {
        LocalDate date = LocalDate.of(2012, 03, 26);
        var sut = Transaction.createWithdrawalTransaction(50, date);
        assertThat(sut.getAmount()).isEqualTo(-50);
        assertThat(sut.getLocalDate()).isEqualTo(date);
    }
}


