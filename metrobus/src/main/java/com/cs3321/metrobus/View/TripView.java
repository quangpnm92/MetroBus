/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.View;
import com.cs3321.metrobus.Entities.TripInfo;
import org.apache.commons.lang3.StringUtils;
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


public class TripView{

    public static void main(String[] args) {
        String line = new String(new char[77]).replace('\0', '-');
        
        String departureCity;
        String arrivalCity;
        int availableSeats;
        int totalSeats;
        double price;
        

        
        System.out.println(line);
        System.out.printf("|%s|%n",
                StringUtils.center("All Available Trips", 75));
        System.out.println(line);
        
        System.out.printf("|%s|%s|%s|%s|%n",
                StringUtils.center("Departure City", 18),
                StringUtils.center("Arrival City", 18),
                StringUtils.center("Available Seats", 18),
                StringUtils.center("Seat Price", 18));
        System.out.println(line);
        
        
        //needs to be in a for or while loop for AllTrips data structure{
        
            departureCity="Houston";
            arrivalCity="Dallas";
            availableSeats=30;
            totalSeats=50;
            price=100;
        
        System.out.printf("|%s|%s|%s|%s|%n",
                StringUtils.center(departureCity, 18),
                StringUtils.center(arrivalCity, 18),
                StringUtils.center(availableSeats+"/"+totalSeats, 18),
                StringUtils.center("$"+String.format("%,.2f", price), 18));


    //} end of loop
    
    
        System.out.println(line);
    }
}
