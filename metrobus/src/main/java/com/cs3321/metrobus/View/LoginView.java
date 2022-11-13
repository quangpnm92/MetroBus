/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.cs3321.metrobus.View;
import com.cs3321.metrobus.Controllers.CommonFunction;
import com.cs3321.metrobus.Controllers.Login;
import com.cs3321.metrobus.Controllers.Payment;
import com.cs3321.metrobus.Entities.PaymentInfo;
import java.util.Scanner;

/**
 *
 * @author phamt
 */
public class LoginView {

    
    public static void main(String[] args) {
        Payment payment = new Payment();
        MenuView menu = new MenuView();
        Login lg = new Login();
        String username, password;
        Scanner s = new Scanner(System.in);
        
        do {
            System.out.printf(" --------------------------------%n");
            System.out.printf("          Login info      %n");
            System.out.printf(" --------------------------------%n");
            System.out.print("Username: ");
            username = s.nextLine();
            System.out.print("Password: ");
            password = s.nextLine();
            
            if(!lg.checkLogin(username, password)) {
                System.out.println("Username/Password combination does not match. Please try again.\n");
            }
            
        }while(!lg.checkLogin(username,password));
        
        PaymentInfo paymentinfo = payment.extractInfo(username, password);
        PaymentInfo.paymentinfo_login = new PaymentInfo(paymentinfo);
            
        if (paymentinfo.getRole().equals(CommonFunction.admin))
            menu.runMenuAdmin();
        else if (paymentinfo.getRole().equals(CommonFunction.staff))
            menu.runMenuStaff();
        else if (paymentinfo.getRole().equals(CommonFunction.customer))
            menu.runMenuUser();
        
        System.out.printf(" --------------------------------%n");
    }
    
}
