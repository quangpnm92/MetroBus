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

    private boolean checkSeat(String id, int available) {
        if (checkID(id)) {
            TripInfo trip_extract = extractInfo(id);
            
            if (trip_extract.getAvailable() >= available)
                return true;
        }
        else {
            System.out.println("We dont' have ID " + id + " for trip");
            return false;
        }
        return false;
    }

    private boolean checkID(String id) {
        ArrayList<TripInfo> trips = CommonFunction.readCSV_TripInfo();

        for (int i = 0; i < trips.size(); i++) {
            if (id.equals(trips.get(i).getTripID())) {
                return true;
            }
        }
        return false;
    }

    public TripInfo extractInfo(String id) {
        Admin myAdmin = new Admin();
        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "trip.csv"))) {
            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");

                if ((id.equals(values[0].trim()))) {
                    String departure = values[1].trim();
                    String arrival = values[2].trim();
                    int taken = Integer.parseInt(values[3].trim());
                    int available = Integer.parseInt(values[4].trim());
                    Double price = Double.parseDouble(values[5].trim()) * (1 - myAdmin.getPromotion());

                    trip = new TripInfo(id, departure, arrival, available, taken, price);

                    return trip;
                }
            }
        } catch (FileNotFoundException ex) {
            ;
        }

        return trip;
    }
    
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
            System.out.println("Available is not enough");
            PaymentView.displayPayment();
        }
    }
            
}
