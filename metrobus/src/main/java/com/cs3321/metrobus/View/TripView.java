/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.View;

import com.cs3321.metrobus.Controllers.CommonFunction;
import com.cs3321.metrobus.Controllers.Trip;
import com.cs3321.metrobus.Entities.TripInfo;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

//The following code outputs a table of all available Trips in the system



// Comment for trial - Rhett Oct 2022

/**
 *
 * @author Quan
 */

/*

//old code below


public class TripView{

//    public void TripList(TripInfo trip)
//    {
//        System.out.println("Welcome to trip: " + trip.getNameTrip());
//        System.out.println("Remaining seats: " + trip.getTaken() + "/" + trip.getAvailable() );
//        System.out.println("");
//    }
//    
//    public static void main(String[] args) {
//        TripInfo n = new TripInfo("Houston", 40);
//        
//        TripView view = new TripView();
//        
//        view.TripList(n);
//    }    
}

 */


//kate's code below

/**
 *
 * @author katelynshimek
 */



public class TripView extends Trip {

    public static void displayTable() {

        ArrayList<TripInfo> trips = CommonFunction.readCSV_TripInfo();
        AdminView myAdmin = new AdminView();
        String line = new String(new char[96]).replace('\0', '-');
        CommonFunction.readDiscounts();
        String departureCity;
        String arrivalCity;
        String id;
        int availableSeats;
        int totalSeats;
        double price;
        double promotion;
        double discount = 1.00;
        //if Promotion is enabled, calculate percentage price of ticket relative
        //to full price, ie 1.00
        if (myAdmin.getPromotionStatus()) {
            promotion = myAdmin.getPromotion();
            discount = discount - promotion; 
        }

        System.out.println(line);
        System.out.printf("|%s|%n",
                StringUtils.center("All Available Trips", 94));
        System.out.println(line);

        System.out.printf("|%s|%s|%s|%s|%s|%n",
                StringUtils.center("ID", 18),
                StringUtils.center("Departure City", 18),
                StringUtils.center("Arrival City", 18),
                StringUtils.center("Available Seats", 18),
                StringUtils.center("Seat Price", 18));
        System.out.println(line);

         //iterates through ArrayList of all trips
        for (int i = 0; i < trips.size(); i++) {
            id = trips.get(i).getTripID();
            departureCity = trips.get(i).getDepartureCity();
            arrivalCity = trips.get(i).getArrivalCity();
            availableSeats = trips.get(i).getAvailable();
            totalSeats = trips.get(i).getTotal();
            //apply discount by multiplying price with percentage price of ticket
            price = trips.get(i).getPrice() * discount;

            System.out.printf("|%s|%s|%s|%s|%s|%n",
                    StringUtils.center(id, 18),
                    StringUtils.center(departureCity, 18),
                    StringUtils.center(arrivalCity, 18),
                    StringUtils.center(availableSeats + "/" + totalSeats, 18),
                    StringUtils.center("$" + String.format("%,.2f", price), 18));
        }
        System.out.println(line);
    }
}
