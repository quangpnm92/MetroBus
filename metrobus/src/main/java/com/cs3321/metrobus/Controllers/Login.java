package com.cs3321.metrobus.Controllers;

import com.cs3321.metrobus.Entities.*;
import com.cs3321.metrobus.Controllers.CommonFunction;
import java.io.*;
import java.util.*;

public class Login {

    public static PaymentInfo payment = new PaymentInfo();

    public boolean checkLogin(String username, String password) {

        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "login.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");

                if ((username.equals(values[0].trim()) && (password.equals(values[1].trim())))) {
                    return true;
                }

            }
        } catch (FileNotFoundException ex) {
            ;
        }
        return false;
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

//public static void main(String[] args) throws Exception {
//        Login lg = new Login();
//
//        if (lg.checkLogin("quangph1", "123456789")) {
//            System.out.println("Successful");
//
//            Payment a = new Payment();
//            a.processPayment(payment, 20);
//
//        } else {
//            System.out.println("Wrong Info");
//        }
//    }
//}
