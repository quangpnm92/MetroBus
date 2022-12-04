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

//The following code enables customers to purchase ticket(s) to a trip by prompting for
//trip ID, number of tickets, and CVC

public class PaymentView {

    
    public static void displayPayment() {   
        System.out.printf(" --------------------------------%n");
        System.out.printf("          Payment info      %n");
        System.out.printf(" --------------------------------%n");
     //   System.out.printf("| %-10s | %-10s |%n", " USER NAME", "PASSWORD");
        String id, cvc;
        //many variable initialized to 0 tickets being purchased for input validation
        int many = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Trip ID to purchase:");//username:user
        id = s.nextLine();
        Trip trip = new Trip();
        while (!trip.checkID(id)){
            System.out.print("Invalid ID---Try again: ");
            id = s.nextLine();
        }
        System.out.print("How many ticket(s) you want:");//password:user
        String ticket = s.nextLine();
        boolean validInt=false;
        //loop with try-catch for input validation; user must enter a numerical
        //value greater than 0
        while(!validInt){
            try{
                many = Integer.parseInt(ticket);
                while(many<=0){ 
                    System.out.print("Incorrect input---Try again: ");
                    many = Integer.parseInt(s.nextLine());
                }
                break;
            }  
            catch(NumberFormatException e){
                System.out.println( "not Valid Number---Try again");
                System.out.print("How many ticket(s) you want:");
                ticket = s.nextLine();
            }
        }
        System.out.printf(" --------------------------------%n");
        
        System.out.print("Enter your CVC:");//password:user
        cvc = s.nextLine();
        System.out.printf(" --------------------------------%n");
        //Sends information received about desired purchase to function to
        //execute desired purchase
        trip.readyPayment(id, many,cvc);
        
    }
}
