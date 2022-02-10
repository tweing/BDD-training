package com.codurance.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {
    private final Printer printer;
    private int balance = 0;
    private List<Transaction> transactions;

    public Account(Printer printer) {
        this.printer = printer;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(int amount) {
        checkForPositiveNumber(amount);
        this.balance += amount;
        this.transactions.add(Transaction.createDepositTransaction(amount, LocalDate.now()));
    }

    private void checkForPositiveNumber(int amount) {
        if (amount < 0)
        {
            throw new IllegalArgumentException("Amount must be bigger than 0 in 'deposit'.");
        }
    }

    @Override
    public void withdraw(int amount) {
        checkForPositiveNumber(amount);
        this.balance -= amount;
        this.transactions.add(Transaction.createWithdrawalTransaction(amount, LocalDate.now()));
    }

    @Override
    public void printStatement() {
        printer.printLine("Date | Amount | Balance");
        this.transactions.stream().forEach(transaction -> printer.printLine(transaction.toString()));
    }

    public int getBalance() {
        return this.balance;
    }

    public Transaction getTransaction(int i) {
        return this.transactions.get(i);
    }
}
