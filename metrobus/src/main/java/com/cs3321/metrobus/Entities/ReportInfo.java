/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Entities;

/**
 *
 * @author Quan
 */

//The following code consists of setters/getters for attributes related to each Trip for use
//in generating the Report of all trips

public class ReportInfo {
    private String name;
    private String card;
    private String tripID;
    private String departure;
    private String arrival;
    private String price;
    private String seatTaken;

    public ReportInfo(String name, String card, String tripID, String departure, String arrival, String price, String seatTaken) {
        this.name = name;
        this.card = card;
        this.tripID = tripID;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.seatTaken = seatTaken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getTripID() {
        return tripID;
    }

    public void setTripID(String tripID) {
        this.tripID = tripID;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeatTaken() {
        return seatTaken;
    }

    public void setSeatTaken(String seatTaken) {
        this.seatTaken = seatTaken;
    }
    
}
