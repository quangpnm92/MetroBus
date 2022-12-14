/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Controllers;

import com.cs3321.metrobus.Entities.PaymentInfo;
import com.cs3321.metrobus.Entities.TripInfo;
import com.cs3321.metrobus.View.MenuView;
import com.cs3321.metrobus.View.ReceiptView;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Quan
 */

//The following code implements functions needed to validate and execute purchases
//In order for a purchase to be successful, the credit card and CVC info must be
//validated against the csv file and the customer's balance (the 'money' variable)
//must be greater than or equal to the amount to be deducted

public class Payment {

    public PaymentInfo payment = new PaymentInfo();

    MenuView menu = new MenuView();

    private void processPayment(PaymentInfo payment, TripInfo trip, int ticket, String cvc) {
        double price = trip.getPrice() * ticket;
        if (checkCard(payment, price,cvc )) {
            payment.setMoney(payment.getMoney() - price);
            trip.setAvailable(trip.getAvailable() - ticket);
            ReceiptView.printReceipt(payment, trip,price, String.valueOf(ticket));
            CommonFunction.writeCSV_TripInfo(trip);
        } else {
            menu.runMenuUser();
        }
    }

    private boolean checkCard(PaymentInfo payment, double price, String cvc) {

        Date today = new Date();
        Date date_exp = CommonFunction.convertStringToDate(payment.getExpireDate());

        int a = today.compareTo(date_exp);
         
        if (!CommonFunction.validitychk(Long.parseLong(payment.getCardNumber()))|| payment.getCardNumber().isBlank()) {
            System.out.println("Invalid Credit Card");
            return false;
        }

        if (payment.getCvc().length() != 3 || !CommonFunction.isNumeric(payment.getCvc()) || !cvc.equals(payment.getCvc())) {
            System.out.println("---Invalid CVC---");
            return false;
        }

        if (payment.getName().length() <= 3 || payment.getName().isBlank()) {
            return false;
        }

        if (payment.getMoney() < price) {
            System.out.println("Insufficient balance.");
            System.out.println("Current balance is: " + payment.getMoney());
            return false;
        }

        if (payment.getExpireDate().length() <= 3 || payment.getExpireDate().isBlank() || today.compareTo(date_exp) != -1) {
            System.out.println("error2");
            return false;
        }

        return true;
    }

    public void makePayment(TripInfo trip, int available, String cvc) // -ghe
    {
        processPayment(PaymentInfo.paymentinfo_login, trip, available, cvc);

    }

    public PaymentInfo extractInfo(String username, String password) {

        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "login.csv"))) {
            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");

                if ((username.equals(values[0].trim()) && (password.equals(values[1].trim())))) {
                    String user_name = values[0].trim();
                    String pass = values[1].trim();
                    String role = values[2].trim();
                    String name = values[3].trim();
                    String sex = values[4].trim();
                    String card = values[5].trim();
                    String exp_date = values[6].trim();
                    String cvc = values[7].trim();
                    Double money = Double.valueOf(values[8].trim());

                    payment = new PaymentInfo(card, name, exp_date, cvc, money, user_name, pass, role, sex);

                    return payment;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

        return payment;

    }
}
