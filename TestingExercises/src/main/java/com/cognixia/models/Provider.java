package com.cognixia.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Provider extends Account {

    public void addClaim(User user,String date, String balance) throws ParseException {
        //TO DO: Throw exception if date is not valid

        List<String> claim = new ArrayList<>();
        claim.add(date);
        claim.add(balance);
        user.allClaims.add(claim);
        user.quickSort(user.allClaims, 0, user.getNOofClaims() - 1);
    }

    public void submitClaims(User user, List<List<String>> claims) throws ParseException {
        int NoOfClaims = claims.size();
        for(int i = 0; i < NoOfClaims; i++){
            this.addClaim(user, claims.get(i).get(0), claims.get(i).get(1));
        }

    }

}
