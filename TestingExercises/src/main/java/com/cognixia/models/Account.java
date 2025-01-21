package com.cognixia.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int balance;
    private int id;
    private List<List<String>> allClaims = new ArrayList<>();
    private static int idCounter = 0;


    public Account() {
        this.balance = 0;
        this.id = createID();
    }

    public int createID(){
        return idCounter++;
    }

    public void addClaim(List<String> claim){
        this.allClaims.add(claim);
    }

    public List<List<String>> getClaims(){
        return this.allClaims;
    }

    public int getNOofClaims(){
        return getClaims().size();
    }

    public void viewClaims(){
        int claimsSize = getNOofClaims();
        for(int i=0; i < claimsSize; i++){
            System.out.println(this.allClaims.get(i));
        }
    }

    public void sortClaims(){
        //check if dates are valid
        //find out how to compare dates with each other
        //start sorting from newest to oldest
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
