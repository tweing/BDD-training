package com.codurance;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate localDate;
    private final int amount;

    public static Transaction createDepositTransaction(int amount, LocalDate date) {
        return new Transaction(amount, date);
    }

    private Transaction(int amount, LocalDate localDate) {
        this.amount = amount;
        this.localDate = localDate;
    }

    public static Transaction createWithdrawalTransaction(int amount, LocalDate date) {
        return new Transaction(-amount, date);
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        // TODO: Date | Amount | Balance
        // 14/01/2012 | -500   | 2500
        return "Transaction{" +
                "localDate=" + localDate +
                ", amount=" + amount +
                '}';
    }
}
