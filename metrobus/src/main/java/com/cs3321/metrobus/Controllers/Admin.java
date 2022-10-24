/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Controllers;

/**
 *
 * @author rhett
 */
public class Admin {
    private Double promotion = 0.00;
    private boolean ongoingPromotion = false;

    public Double getPromotion() {
        return promotion;
    }

    public void editPromotion(Double promotion) {
        this.promotion = promotion;
    }
    
    public void removePromotion() {
        this.ongoingPromotion = false;
    }
    
    public void addPromotion() {
        this.ongoingPromotion = true;
    }
    
}
