/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Entities;

import java.util.Date;

/**
 *
 * @author Quang Pham
 */
public class TripInfo {
    private String tripID;
    private String departureCity;
    private String arrivalCity;
    private int seats;
    private int available;
    private int taken;
    private Date departureDate;
    private double price;

    public String getTripID() {
        return tripID;
    }

    public void setTripID(String tripID) {
        this.tripID = tripID;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getTaken() {
        return taken;
    }

    public void setTaken(int taken) {
        this.taken = taken;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TripInfo(String departureCity, String arrivalCity, int available, int taken, double price) {
        this.tripID = "N/A";
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.available = available;
        this.taken = taken;
        this.price = price;
    }
    

    public static void main(String[] args) {
//        TripInfo x = new TripInfo("Houston", "Dallas", 50, 2022, 10, 22, 20, 45);
        
    }
    
    
    
    
    
    

  
}
