/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.View;
import com.cs3321.metrobus.Entities.TripInfo;
// Comment for trial - Rhett Oct 2022
/**
 *
 * @author Quan
 */
public class TripView{

    public void TripList(TripInfo trip)
    {
        System.out.println("Welcome to trip: " + trip.getDepartureCity());
        System.out.println("Remaining seats: " + trip.getTaken() + "/" + trip.getAvailable() );
        System.out.println("");
    }
    
    public static void main(String[] args) {
        TripInfo n = new TripInfo("Houston", "Dallas", 50, 2022, 10, 22, 20, 45);
        
        TripView view = new TripView();
        
        view.TripList(n);
    }    
}
