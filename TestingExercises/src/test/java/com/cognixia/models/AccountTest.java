package com.cognixia.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AccountTest {
  //1. As a member(user), I should be able to view a list of my past claims so I can verify my claim status
    @Test
    @DisplayName("Testing the viewClaims method with no parameters.")
    void testGetClaims() throws ParseException {
        List<List<String>> claims = new ArrayList<>();
        List<String> claim1 = new ArrayList<>();
        List<String> claim2 = new ArrayList<>();
        List<String> claim3 = new ArrayList<>();


        claim1.add("01-17-2023");
        claim1.add("2000");
        claim2.add("04-15-2024");
        claim2.add("3000");
        claim3.add("06-09-2025");
        claim3.add("1000");

        claims.add(claim1);
        claims.add(claim2);
        claims.add(claim3);

        User accountTest = new User();
        Provider providerTest = new Provider();

        providerTest.addClaim(accountTest, "01-17-2023", "2000");
        providerTest.addClaim(accountTest, "04-15-2024", "3000");
        providerTest.addClaim(accountTest, "06-09-2025", "1000");

        accountTest.viewClaims();
        assertEquals(claims, accountTest.getClaims());
    }

  //2. As a user, I should be able to search claims within a range of dates
  @Test
  @DisplayName("Testing the viewClaims method with parameters (dates).")
  void testGetClaimsP() throws ParseException {
      List<List<String>> claims = new ArrayList<>();
      List<String> claim1 = new ArrayList<>();
      List<String> claim2 = new ArrayList<>();
      List<String> claim3 = new ArrayList<>();

      claim1.add("04-15-2024");
      claim1.add("3000");
      claim2.add("04-15-2024");
      claim2.add("2000");
      claim3.add("06-09-2025");
      claim3.add("1000");

      claims.add(claim1);
      claims.add(claim2);
      claims.add(claim3);

      User accountTest = new User();
      Provider providerTest = new Provider();

      //This test does not look at the balance, so duplicate dates may cause error if balance isn't the same in those duplicate dates
      providerTest.addClaim(accountTest, "01-17-2023", "2000");
      providerTest.addClaim(accountTest, "06-09-2025", "1000");
      providerTest.addClaim(accountTest, "04-15-2024", "2000");
      providerTest.addClaim(accountTest, "04-15-2024", "3000");
      providerTest.addClaim(accountTest, "05-20-2027", "3000");
      providerTest.addClaim(accountTest, "05-20-2027", "3000");

      //accountTest.quickSort(accountTest.allClaims, 0, accountTest.getNOofClaims() - 1);

      //accountTest.viewClaims();
      accountTest.viewClaims("01-01-2024", "01-01-2026");
      assertEquals(claims, accountTest.getClaims("01-01-2024", "01-01-2026"));
  }

  //3. As a provider, I should be able to upload several claims at once and add them to the database
  @Test
  @DisplayName("Testing the SubmitClaims method")
  void testSubmitClaims() throws ParseException {
      List<List> claims = new ArrayList<>();
      List<String> claim1 = new ArrayList<>();
      List<String> claim2 = new ArrayList<>();
      List<String> claim3 = new ArrayList<>();

      claim1.add("01-17-2023");
      claim1.add("2000");
      claim2.add("04-15-2024");
      claim2.add("3000");
      claim3.add("06-09-2025");
      claim3.add("1000");

      claims.add(claim1);
      claims.add(claim2);
      claims.add(claim3);

      User accountTest = new User();
      Provider providerTest = new Provider();

      providerTest.addClaim(accountTest, "01-17-2023", "2000");
      providerTest.addClaim(accountTest, "04-15-2024", "3000");
      providerTest.addClaim(accountTest, "06-09-2025", "1000");
  }

  @Test
  @DisplayName("Testing wether new accounts have different ID's when created")
  void testID(){
        User user1 = new User();
        User user2 = new User();

        int id1 = user1.getId();
        int id2 = user2.getId();

        System.out.println(id1);
        System.out.println(id2);

        assertNotEquals(id1, id2);

  }
}
