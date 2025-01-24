package com.cognixia.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private int balance;
    private int id;
    List<List<String>> allClaims = new ArrayList<>();
    private static int idCounter = 0;


    public Account() {
        this.balance = 0;
        this.id = createID();
    }

    public int createID(){
        return idCounter++;
    }

    public int getId(){
        return this.id;
    }

    public List<List<String>> getClaims(){
        return this.allClaims;
    }

    public List<List<String>> getClaims(String earliestDate, String latestDate) throws ParseException {
        List<List<String>> claims = getClaims();
        List<List<String>> specificClaims = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

        Date earliest = format.parse(earliestDate);
        Date latest = format.parse(latestDate);

        int earliestIndex = 0;
        int latestIndex = 0;

        for(int i = 0; i < getNOofClaims(); i++){
            Date date = format.parse(claims.get(i).get(0));
            if(date.compareTo(earliest) >= 0){
                earliestIndex = i;
                break;
            }
        }

        for(int i = getNOofClaims() - 1; i >= 0; i--){
            Date date = format.parse(claims.get(i).get(0));
            if(date.compareTo(latest) <= 0){
                latestIndex = i;
                break;
            }
            else{
                latestIndex = earliestIndex;
            }
        }

        for (int i = earliestIndex; i < latestIndex+1; i++){
            specificClaims.add(claims.get(i));
        }

        return specificClaims;
    }

    public int getNOofClaims(){
        return getClaims().size();
    }

    public void quickSort(List<List<String>> arr, int low, int high) throws ParseException {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public int partition(List<List<String>> arr, int low, int high) throws ParseException {


        // Choose the pivot
        //int pivot = arr[high];
        String date1 = arr.get(high).get(0);

        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

        Date pivot = format.parse(date1);


        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low...high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {

            Date date2 = format.parse(arr.get(j).get(0));

            if (date2.compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap function
    public void swap(List<List<String>> arr, int i, int j) {
        List<String> temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public int getBalance() {
        return this.balance;
    }

}
