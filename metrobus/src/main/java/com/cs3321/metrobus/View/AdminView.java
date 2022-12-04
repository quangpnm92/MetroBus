/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.View;
import com.cs3321.metrobus.Controllers.Admin;
import com.cs3321.metrobus.Controllers.CommonFunction;
import com.cs3321.metrobus.Entities.PaymentInfo;
import java.util.Scanner;
/**
 *
 * @author rhett
 */

//The following code consists of functions for Admin-role users

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
        Double newPromotion = Double.MAX_VALUE;
        System.out.println("Current promotion value: " + this.getPromotion());
        do {
            System.out.print("New promotion value: ");
            newPromotion = myScan.nextDouble();
            if (newPromotion > 1.00 || newPromotion < 0.00) {
                System.out.println("Invalid input. Please try again.");
            }
        }while (newPromotion > 1.00 || newPromotion < 0.00);
        this.editPromotion(newPromotion);
        CommonFunction.writeDiscounts(this.getPromotionStatus(), newPromotion);
        System.out.println("New promotion: " + this.getPromotion() + " is set.");
    }
    
    public void displayTable() {
        TripView.displayTable();
    }
    
    public void addAdmin() {
        PaymentInfo newProfile = CommonFunction.getPersonLogin("1");
        System.out.println("\n\nSending to File: \n" + "Username: " + newProfile.getUsername() + "\n" + "Password: " + newProfile.getPassword() + "\n" + "Name: " + newProfile.getName() + "\n" + "Sex: " + newProfile.getSex() + "\n" + "Card: **** **** **** " + newProfile.getCardNumber().substring(12) + "\n" + "Expiry: " + newProfile.getExpireDate() + "\n" + "CVC: " + newProfile.getCvc() + "\n" + "Balance: " + newProfile.getMoney());
        CommonFunction.writeLogin(newProfile);
    }
    
    public void addStaff() {
        PaymentInfo newProfile = CommonFunction.getPersonLogin("2");
        System.out.println("\n\nSending to File: \n" + "Username: " + newProfile.getUsername() + "\n" + "Password: " + newProfile.getPassword() + "\n" + "Name: " + newProfile.getName() + "\n" + "Sex: " + newProfile.getSex() + "\n" + "Card: **** **** **** " + newProfile.getCardNumber().substring(12) + "\n" + "Expiry: " + newProfile.getExpireDate() + "\n" + "CVC: " + newProfile.getCvc() + "\n" + "Balance: " + newProfile.getMoney());
        CommonFunction.writeLogin(newProfile);
    }
}
