/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Controllers;

import com.cs3321.metrobus.Entities.PaymentInfo;
import com.cs3321.metrobus.Entities.PeopleInfo;
import com.cs3321.metrobus.Entities.TripInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Quan
 */
public class CommonFunction {

    static public String path = new File("").getAbsolutePath() + "\\src\\main\\java\\com\\cs3321\\metrobus\\Controllers\\";
    static public String admin = "0";
    static public String staff = "1";
    static public String customer = "2";

    static public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static public Date convertStringToDate(String str) {
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        str = str.substring(0, 2) + "-01-" + "20" + str.substring(2);

        Date date = null;
        try {
            date = df.parse(str);
        } catch (Exception ex) {

        }
        return date;
    }

    static public ArrayList<PeopleInfo> readCSV(String choice) {
        ArrayList<PeopleInfo> peoples = new ArrayList<PeopleInfo>();

        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "login.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");

                if (choice.equals(values[2].trim())) {
                    String name = values[3].trim();
                    String gender = values[4].trim();
                    String card = values[5].trim();
                    
                    PeopleInfo people = new PeopleInfo(name,gender,card);
                    peoples.add(people);
                }
            }
        } catch (FileNotFoundException ex) {
            ;
        }
        return peoples;
    }

    static ArrayList<TripInfo> readCSV_TripInfo(String str) {
        ArrayList<TripInfo> trips = new ArrayList<TripInfo>();

        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "trip.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");

                if (values[0].trim() == "2") {
                    String departure = values[0].trim();
                    String arrival = values[1].trim();
                    int taken = Integer.parseInt(values[2].trim());
                    int available = Integer.parseInt(values[3].trim());
                    Double price = Double.parseDouble(values[4].trim());
                    TripInfo trip = new TripInfo(departure, arrival, available, taken, price);
                    trips.add(trip);
                }
            }
        } catch (FileNotFoundException ex) {
            ;
        }
        return trips;
    }
}
