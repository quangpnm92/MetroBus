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
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

                    PeopleInfo people = new PeopleInfo(name, gender, card);
                    peoples.add(people);
                }
            }
        } catch (FileNotFoundException ex) {
            ;
        }
        return peoples;
    }

    static public ArrayList<TripInfo> readCSV_TripInfo() {
        ArrayList<TripInfo> trips = new ArrayList<TripInfo>();

        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "trip.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");
                String id = values[0].trim();
                String departure = values[1].trim();
                String arrival = values[2].trim();
                int taken = Integer.parseInt(values[3].trim());
                int available = Integer.parseInt(values[4].trim());
                Double price = Double.parseDouble(values[5].trim());
                TripInfo trip = new TripInfo(id, departure, arrival, available, taken, price);
                trips.add(trip);

            }
        } catch (FileNotFoundException ex) {
            ;
        }
        return trips;
    }

    static public void writeCSV_TripInfo(TripInfo trip) {
        String bigString = "";
        try ( Scanner sc = new Scanner(new File(path + "trip.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");
                String id = values[0].trim();

                if (trip.getTripID().equals(id)) {
                    values[3] = String.valueOf(trip.getTaken());
                    values[4] = String.valueOf(trip.getAvailable());
                }

                for (int i = 0; i < values.length; i++) {
                    bigString += values[i] + ",";
                }
                bigString = bigString.substring(0, bigString.length() - 1);
                bigString += "\n";
            }

            bigString = bigString.substring(0, bigString.length() - 1);

            FileWriter myWriter = new FileWriter(path + "trip.csv", false);
            myWriter.write(bigString);
            myWriter.close();

        } catch (FileNotFoundException ex) {
            ;
        } catch (IOException ex) {
        }

    }
    
    public static void readDiscounts(){
        Admin myAdmin = new Admin();
        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "discount.csv"))) {
            myAdmin.setPromotionStatus(sc.next());
            myAdmin.editPromotion(sc.nextDouble());
        }catch(IOException ex) {
            System.err.print("Discount input error");
        }
    }
    
    public static void writeDiscounts(boolean promotionStatus, Double promotionValue) {
        Admin myAdmin = new Admin();
        try {
            FileWriter myWriter = new FileWriter(CommonFunction.path + "discount.csv");
            myWriter.write(String.valueOf(promotionStatus) + '\n');
            myWriter.write(String.valueOf(promotionValue) + '\n');
            myWriter.close();
        }catch(IOException ex) {
            System.err.print("Discount writing error");
        }
    }
}
