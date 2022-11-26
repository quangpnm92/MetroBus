/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.View;
import com.cs3321.metrobus.Controllers.Admin;
import com.cs3321.metrobus.Controllers.CommonFunction;
import java.util.Scanner;
/**
 *
 * @author rhett
 */
public class AdminView extends Admin {
    
    public void displayEnablePromotion() {
        CommonFunction.readDiscounts();
        System.out.println("Current promotion status: " + (this.getPromotionStatus()?"Enabled":"Disabled"));
        this.setPromotion();
        System.out.println("Setting promotion to.. " + (this.getPromotionStatus()?"Enabled":"Disabled"));
        CommonFunction.writeDiscounts(this.getPromotionStatus(), this.getPromotion());
    }
    
    public void setNewPromotion() {
        Scanner myScan = new Scanner(System.in);
        CommonFunction.readDiscounts();
        Double newPromotion;
        System.out.println("Current promotion value: " + this.getPromotion());
        System.out.print("New promotion value: ");
        newPromotion = myScan.nextDouble();
        this.editPromotion(newPromotion);
        CommonFunction.writeDiscounts(this.getPromotionStatus(), newPromotion);
        System.out.println("New promotion: " + this.getPromotion() + " is set.");
    }
    
    public void displayTable() {
        TripView.displayTable();
    }
    
}
