package com.cognixia.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import au.com.bytecode.opencsv.CSVWriter;

public class Provider extends Account {

    File file = new File("src/test/resources2/submitClaimsTest.csv");

    public void addClaim(User user,String date, String amount) throws ParseException {
        //TO DO: Throw exception if date is not valid

        List<String> claim = new ArrayList<>();
        claim.add(date);
        claim.add(amount);
        user.allClaims.add(claim);
        user.quickSort(user.allClaims, 0, user.getNOofClaims() - 1);
    }

    public void submitClaims(User user, List<List<String>> claims) throws ParseException, IOException {
        int NoOfClaims = claims.size();

        for(int i = 0; i < NoOfClaims; i++){
            String date = claims.get(i).get(0);
            String amount = claims.get(i).get(1);

            try {
                // create FileWriter object with file as parameter
                FileWriter outputfile = new FileWriter(file, true);

                // create CSVWriter object filewriter object as parameter
                CSVWriter writer = new CSVWriter(outputfile);

                // adding header to csv
                //String[] header = { "Date", "Class", "Marks" };
                //writer.writeNext(header);

                // add data to csv
                String[] data1 = {date, amount};
                writer.writeNext(data1);

                // closing writer connection
                writer.close();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            this.addClaim(user, date, amount);
        }
    }

}
