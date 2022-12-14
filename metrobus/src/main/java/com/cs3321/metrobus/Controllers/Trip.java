/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Controllers;

import com.cs3321.metrobus.Entities.TripInfo;
import com.cs3321.metrobus.View.PaymentView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quan
 */
public class Trip {

    public TripInfo trip = new TripInfo();

    //check if number of seats is available for specified trip by first validating
    //trip ID and then checking desired seats against current available seats
    //registered for that trip
    private boolean checkSeat(String id, int available) {
        if (checkID(id)) {
            TripInfo trip_extract = extractInfo(id);
            
            if (trip_extract.getAvailable() >= available)
                return true;
        }
        else {
            System.out.println("Unavailable seats for ID " + id);
            return false;
        }
        return false;
    }

    //verifies trip ID is registered to an available Trip in system, ie exists
    //in our ArrayList of all Trips
    public boolean checkID(String id) {
        ArrayList<TripInfo> trips = CommonFunction.readCSV_TripInfo();

        for (int i = 0; i < trips.size(); i++) {
            if (id.equals(trips.get(i).getTripID())) {
                return true;
            }
        }
        return false;
    }

    //reads info from CSV about trip and applies promotional discount, if enabled
    public TripInfo extractInfo(String id) {
        Admin myAdmin = new Admin();
        CommonFunction.readDiscounts();
        Double promotion;
        Double discount = 1.00;
        if (myAdmin.getPromotionStatus()) {
            promotion = myAdmin.getPromotion();
            discount = discount - promotion; 
        }
        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "trip.csv"))) {
            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                //delimiting csv lines by commas and storing in appropriate variables
                String[] values = sc.next().split(",");
                
                if ((id.equals(values[0].trim()))) {
                    String departure = values[1].trim();
                    String arrival = values[2].trim();
                    int available = Integer.parseInt(values[3].trim());
                    int total = Integer.parseInt(values[4].trim());
                    //adjusts price with promotional discount if enabled
                    Double price = Double.parseDouble(values[5].trim()) * discount;
                    trip = new TripInfo(id, departure, arrival, available, total, price);

                    return trip;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

        return trip;
    }
    
    //function receives validated info about desired purchase and validates
    //purchase possible based on available seats on trip
    public void readyPayment(String id, int available, String cvc)
    {
        Payment payment = new Payment();
        if (checkSeat(id, available))
        {
            TripInfo trip_extract = extractInfo(id);
            payment.makePayment(trip_extract, available, cvc);
        }
        else
        {
            System.out.println("Purchase exceeds available seats. Please try again.");
            PaymentView.displayPayment();
        }
    }
            
}
