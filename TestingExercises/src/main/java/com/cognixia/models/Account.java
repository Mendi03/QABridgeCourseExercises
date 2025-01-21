package com.cognixia.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int balance;
    private List<List> allClaims = new ArrayList<>();
    private int id;

    public Account() {
        this.balance = 0;
    }

    public int getBalance() {
        return this.balance;
    }

    public String deposit(int amount) {

        if (amount < 0) {
            return "Deposit Failed: Deposit Amount bust be zero";
        }

        this.balance += amount;
        return "Deposit successful";
    }
}
