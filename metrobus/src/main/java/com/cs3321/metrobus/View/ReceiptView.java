/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.View;
import com.cs3321.metrobus.Controllers.*;
import com.cs3321.metrobus.Entities.*;
import org.apache.commons.lang3.StringUtils;
import java.util.Date;


public class ReceiptView {

    public static void printReceipt(PaymentInfo payment,TripInfo trip){
        CommonFunction.clearConsole();
        String line = new String(new char[48]).replace('\0', '-');
        Date date = new Date();
        
        //delete the following once we pass parameters
        String customerName=payment.getName();
        String departureCity=trip.getDepartureCity();
        String arrivalCity=trip.getArrivalCity();
        //**********************
        
        System.out.println(line);
        
        System.out.printf("|%s|%n",
                StringUtils.center("MetroBus Receipt", 46));
        System.out.printf("|%s|%n",
                StringUtils.center(date.toString(),46));
        
        System.out.println(line);
        
        System.out.printf("|%s|%s|%n",
                StringUtils.center("Customer", 22),
                StringUtils.center(customerName, 23));
        
        System.out.printf("|%s|%s|%n",
                StringUtils.center("Departure City", 22),
                StringUtils.center(departureCity, 23));

        System.out.printf("|%s|%s|%n",
                StringUtils.center("Arrival City", 22),
                StringUtils.center(arrivalCity, 23));
        
        System.out.printf("|%s|%s|%n",
                StringUtils.center("Total Price", 22),
                StringUtils.center("$"+String.format("%,.2f", trip.getPrice()), 23));

        System.out.println(line);
        
        System.out.printf("|%s|%n",
                StringUtils.center("Thank you for your purchase!", 46));
        System.out.printf("|%s|%n",
                StringUtils.center("Have a nice trip! :)", 46));
        
        System.out.println(line);
        
    }
}