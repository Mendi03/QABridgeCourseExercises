package com.cognixia.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
  //1. As a member(user), I should be able to view a list of my past claims so I can verify my claim status
    @Test
    @DisplayName("Testing the viewClaims method with no parameters.")
    void testGetClaims() {
        List<List<String>> claims = new ArrayList<>();
        List<String> claim1 = new ArrayList<>();
        List<String> claim2 = new ArrayList<>();
        List<String> claim3 = new ArrayList<>();


        claim1.add("01-17-2025");
        claim1.add("2000");
        claim2.add("04-15-2024");
        claim2.add("3000");
        claim3.add("06-09-2023");
        claim3.add("1000");

        claims.add(claim1);
        claims.add(claim2);
        claims.add(claim3);

        Account accountTest = new Account();
        accountTest.addClaim(claim1);
        accountTest.addClaim(claim2);
        accountTest.addClaim(claim3);

        assertEquals(claims, accountTest.getClaims());
        accountTest.viewClaims();
    }

  //2. As a user, I should be able to search claims within a range of dates
  @Test
  @DisplayName("Testing the viewClaims method with parameters (dates).")
  void testViewClaimsP() {
      List<List<String>> claims = new ArrayList<>();
      List<String> claim1 = new ArrayList<>();
      List<String> claim2 = new ArrayList<>();
      List<String> claim3 = new ArrayList<>();

      claim1.add("1000");
      claim1.add("01-17-2025");
      claim2.add("2000");
      claim2.add("04-15-2024");
      claim3.add("3000");
      claim3.add("06-09-2023");

      claims.add(claim1);
      claims.add(claim2);
      claims.add(claim3);

      //Collections.sort(claims);

      Account accountTest = new Account();
      accountTest.addClaim(claim1);
      accountTest.addClaim(claim2);
      accountTest.addClaim(claim3);

      //assertEquals(claims, accountTest.viewClaims("01-01-2024", "01-01-2026"));
  }
}
  //3. As a provider, I should be able to upload several claims at once and add them to the database
//  @Test
//  @DisplayName("Testing the viewClaims method with parameters (dates).")
//  void testViewClaimsP() {
//      List<List> claims = new ArrayList<>();
//      List<String> claim1 = new ArrayList<>();
//      List<String> claim2 = new ArrayList<>();
//      List<String> claim3 = new ArrayList<>();
//
//      claim1.add("1000");
//      claim1.add("01-17-2025");
//      claim2.add("2000");
//      claim2.add("04-15-2024");
//      claim3.add("3000");
//      claim3.add("06-09-2023");
//
//      claims.add(claim1);
//      claims.add(claim2);
//      claims.add(claim3);
//
//      Account accountTest = new Account();
//      accountTest.addClaim(claim1);
//      accountTest.addClaim(claim2);
//      accountTest.addClaim(claim3);
//
//      assertEquals(claims, accountTest.viewClaims("01-01-2024", "01-01-2026"));
//  }
//}
