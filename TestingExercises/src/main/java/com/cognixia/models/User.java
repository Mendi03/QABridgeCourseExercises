package com.cognixia.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class User extends Account {
    //private List<List<String>> allClaims = new ArrayList<>();
    public void viewClaims(){
        int claimsSize = getNOofClaims();
        System.out.println("The following list are all the claims filed for this account, from newest to oldest:");
        for(int i = claimsSize-1; i >= 0; i--){
            System.out.println(this.allClaims.get(i));
        }
    }
    public void viewClaims(String earliestDate, String latestDate) throws ParseException {
        List<List<String>> claims = getClaims(earliestDate, latestDate);
        System.out.println("The following list are all the claims filed for this account, from " + earliestDate + " to " + latestDate + " from newest to oldest.");
        int lastIndex = claims.size() - 1;
        for(int i = lastIndex; i >= 0; i--){
            System.out.println(claims.get(i));
        }
    }
}
