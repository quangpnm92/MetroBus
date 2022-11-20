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
public class Payment {

    public PaymentInfo payment = new PaymentInfo();

    MenuView menu = new MenuView();

    private void processPayment(PaymentInfo payment, TripInfo trip, int available, String cvc) {
        double price = trip.getPrice() * available;
        if (checkCard(payment, price,cvc )) {
            payment.setMoney(payment.getMoney() - price);
            trip.setAvailable(trip.getAvailable() - available);
            trip.setTaken(trip.getTaken() + available);
            ReceiptView.printReceipt(payment, trip,price, String.valueOf(available));
            CommonFunction.writeCSV_TripInfo(trip);
        } else {
            menu.runMenuUser();
        }
    }

    private boolean checkCard(PaymentInfo payment, double price, String cvc) {

        Date today = new Date();

        Date date_exp = CommonFunction.convertStringToDate(payment.getExpireDate());

        int a = today.compareTo(date_exp);

        if (payment.getCardNumber().length() != 19 || payment.getCardNumber().isBlank() || CommonFunction.isNumeric(payment.getCardNumber())) {
            return false;
        }

        if (payment.getCvc().length() != 3 || payment.getCvc().isBlank() || !CommonFunction.isNumeric(payment.getCvc()) || !cvc.equals(payment.getCvc())) {
            return false;
        }

        if (payment.getName().length() <= 3 || payment.getCvc().isBlank()) {
            return false;
        }

        if (payment.getMoney() < price) {
            System.out.println("This card is not enough money");
            System.out.println("You only have: " + payment.getMoney());
            return false;
        }

        if (payment.getExpireDate().length() <= 3 || payment.getExpireDate().isBlank() || today.compareTo(date_exp) != -1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        Payment a = new Payment();
//        PaymentInfo payment = new PaymentInfo("4567898751212548", "Quang", "01-01-2023", "456", 30000);
//        a.processPayment(payment, 20000);
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
                    String card = values[5].trim();
                    String exp_date = values[6].trim();
                    String cvc = values[7].trim();
                    Double money = Double.valueOf(values[8].trim());

                    payment = new PaymentInfo(card, name, exp_date, cvc, money, user_name, pass, role);

                    return payment;
                }
            }
        } catch (FileNotFoundException ex) {
            ;
        }

        return payment;

    }
}
