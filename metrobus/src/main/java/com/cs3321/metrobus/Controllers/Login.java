package com.cs3321.metrobus.Controllers;

import com.cs3321.metrobus.Entities.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {

    String path = new File("").getAbsolutePath() + "\\src\\main\\java\\com\\cs3321\\metrobus\\Controllers\\";
    public static AccountInfo account = new AccountInfo();
    public static PeopleInfo people = new PeopleInfo();
    public static PaymentInfo payment = new PaymentInfo();

    public boolean checkLogin(String username, String password) {

        try ( Scanner sc = new Scanner(new File(path + "login.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");

                if ((username.equals(values[0].trim()) && (password.equals(values[1].trim())))) {
                    String user_name = values[0].trim();
                    String pass = values[1].trim();
                    String role = values[2].trim();
                    String name = values[3].trim();
                    String gender = values[4].trim();
                    String card = values[5].trim();
                    String exp_date = values[6].trim();
                    String cvc = values[7].trim();
                    Double money = Double.parseDouble(values[8].trim());

                    account = new AccountInfo(user_name, pass, role);
                    people = new PeopleInfo(name, gender, card);
                    payment = new PaymentInfo(card, name, exp_date, cvc, money);

                    return true;
                }

            }
        } catch (FileNotFoundException ex) {
           ;
        }
        return false;
    }

//    public void extractInfo(String username, String password) {
//        ArrayList<AccountInfo> list_acc = readCSV();
//        for (int i = 0; i <= list_acc.size(); i++) {
//            if ((username.equals(list_acc.get(i).getUsername())) && (password.equals(list_acc.get(i).getPassword()))) {
//                
//            }
//        }
//    }
    public static void main(String[] args) throws Exception {
        Login lg = new Login();

        if (lg.checkLogin("quangph1", "123456789")) {
            System.out.println("Successful");

            Payment a = new Payment();
            a.processPayment(payment, 20);

        } else {
            System.out.println("Wrong Info");
        }
    }
}
