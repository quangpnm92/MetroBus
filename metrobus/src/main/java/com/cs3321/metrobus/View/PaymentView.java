/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.cs3321.metrobus.View;
import com.cs3321.metrobus.Controllers.Trip;
import java.util.Scanner;

/**
 *
 * @author phamt
 */
public class PaymentView {

    
    public static void displayPayment() {   
        System.out.printf(" --------------------------------%n");
        System.out.printf("          Payment info      %n");
        System.out.printf(" --------------------------------%n");
     //   System.out.printf("| %-10s | %-10s |%n", " USER NAME", "PASSWORD");
        String id, cvc;
        int many;
        Scanner s = new Scanner(System.in);
        System.out.print("What trip you are:");//username:user
        id = s.nextLine();
        System.out.print("How many ticket(s) you want:");//password:user
        many = Integer.parseInt(s.nextLine());
        while(many<=0){
            System.out.print("Incorrect input---Try again: ");
            many = Integer.parseInt(s.nextLine());
        }
            
        System.out.printf(" --------------------------------%n");
        
        System.out.print("Enter your CVC:");//password:user
        cvc = s.nextLine();
        System.out.printf(" --------------------------------%n");
        
        Trip trip = new Trip();
        trip.readyPayment(id, many,cvc);
        
    }
    
}
