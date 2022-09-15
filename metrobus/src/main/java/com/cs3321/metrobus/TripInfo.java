/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus;

/**
 *
 * @author Quang Pham
 */
public class TripInfo {
    private String name;
    private int seats;
    private int available;
    private int taken;
    
    public String getNameTrip() {
        return name;
    }
    public void setSeats(String name) {
        this.name = name;
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
        this.available = seats;
    }
    
    public int getTaken() {
        return taken;
    }
    public void setTaken(int taken) {
        this.taken = taken;
    }
    
    public void TripInfo(String name, int seats){
        this.name = name;
        this.seats = seats;
        this.available = seats;
        this.taken = 0;
 }
}
