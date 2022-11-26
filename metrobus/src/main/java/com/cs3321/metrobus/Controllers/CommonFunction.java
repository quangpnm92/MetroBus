/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Controllers;

import com.cs3321.metrobus.Entities.PaymentInfo;
import com.cs3321.metrobus.Entities.PeopleInfo;
import com.cs3321.metrobus.Entities.ReportInfo;
import com.cs3321.metrobus.Entities.TripInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
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
        } catch (ParseException ex) {

        }
        return date;
    }

    static public ArrayList<PeopleInfo> readCSV(String choice) {
        ArrayList<PeopleInfo> peoples = new ArrayList<>();

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
        ArrayList<TripInfo> trips = new ArrayList<>();

        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "trip.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");
                String id = values[0].trim();
                String departure = values[1].trim();
                String arrival = values[2].trim();
                int available = Integer.parseInt(values[3].trim());
                int total = Integer.parseInt(values[4].trim());
                Double price = Double.parseDouble(values[5].trim());
                TripInfo trip = new TripInfo(id, departure, arrival, available, total, price);
                trips.add(trip);

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
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
                    values[3] = String.valueOf(trip.getAvailable());
                    values[4] = String.valueOf(trip.getTotal());
                }

                for (String value : values) {
                    bigString += value + ",";
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

    public static void readDiscounts() {
        Admin myAdmin = new Admin();
        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "discount.csv"))) {
            myAdmin.setPromotionStatus(sc.next());
            myAdmin.editPromotion(sc.nextDouble());
        } catch (IOException ex) {
            System.err.print("Discount input error");
        }
    }

    public static void writeDiscounts(boolean promotionStatus, Double promotionValue) {
        try {
            FileWriter myWriter = new FileWriter(CommonFunction.path + "discount.csv");
            myWriter.write(String.valueOf(promotionStatus) + '\n');
            myWriter.write(String.valueOf(promotionValue) + '\n');
            myWriter.close();
        } catch (IOException ex) {
            System.err.print("Discount writing error");
        }
    }

    static public void writeCSV_ReportInfo(PaymentInfo payment, TripInfo trip, String total) {
        String bigString = "";

        try ( Scanner sc = new Scanner(new File(path + "report.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String read = sc.nextLine();
                read = read.replaceAll("(\\r)", "");
                
                bigString += read + "\r\n";
            }

            bigString += String.valueOf(payment.getName()) + " ,";
            bigString += String.valueOf(payment.getCardNumber()) + " ,";
            bigString += String.valueOf(trip.getTripID()) + " ,";
            bigString += String.valueOf(trip.getDepartureCity()) + " ,";
            bigString += String.valueOf(trip.getArrivalCity()) + " ,";
            bigString += String.valueOf(String.format("%.2f", trip.getPrice())) + " ,";
            bigString += String.valueOf(total);

            FileWriter myWriter = new FileWriter(path + "report.csv", false);
            myWriter.write(bigString);
            myWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(CommonFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public ArrayList<ReportInfo> readCSV_GeneralReport() {
        ArrayList<ReportInfo> reports = new ArrayList<>();

        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "report.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");

                String name = values[0].trim();
                String card = values[1].trim();
                String id = values[2].trim();
                String departure = values[3].trim();
                String arrival = values[4].trim();
                String price = values[5].trim();
                String taken = values[6].trim();

                ReportInfo report = new ReportInfo(name, card, id, departure, arrival, price, taken);
                reports.add(report);

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        return reports;
    }

}
