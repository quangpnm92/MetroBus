/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Controllers;

import com.cs3321.metrobus.Entities.PaymentInfo;
import com.cs3321.metrobus.View.ReceiptView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Quan
 */
public class Payment {

    public boolean processPayment(PaymentInfo payment, double price) {
        if (checkCard(payment, price)) {
            payment.setMoney(payment.getMoney() - price);
            ReceiptView.printReceipt(price);
            return true;
        }
        return false;
    }

    public boolean checkCard(PaymentInfo payment, double price) {
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date today = new Date();

        Date date_exp = null;
        try {
            date_exp = df.parse(payment.getExpireDate());
        } catch (Exception ex) {

        }

        int a = today.compareTo(date_exp);

        if (payment.getCardNumber().length() != 16 || payment.getCardNumber().isBlank() || !CommonFunction.isNumeric(payment.getCardNumber())) {
            return false;
        }

        if (payment.getCvc().length() != 3 || payment.getCvc().isBlank() || !CommonFunction.isNumeric(payment.getCvc())) {
            return false;
        }

        if (payment.getName().length() <= 3 || payment.getCvc().isBlank()) {
            return false;
        }

        if (payment.getMoney() < price) {
            return false;
        }

        if (payment.getExpireDate().length() <= 3 || payment.getExpireDate().isBlank() || today.compareTo(date_exp) != 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Payment a = new Payment();
        PaymentInfo payment = new PaymentInfo("4567898751212548", "Quang", "01-01-2023", "456", 30000);
        a.processPayment(payment, 20000);
    }
}
