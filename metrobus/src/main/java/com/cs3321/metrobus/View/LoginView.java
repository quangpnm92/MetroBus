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
        
        System.out.printf(" --------------------------------%n");
        System.out.printf("          Login info      %n");
        System.out.printf(" --------------------------------%n");
     //   System.out.printf("| %-10s | %-10s |%n", " USER NAME", "PASSWORD");
        String username, password;
        Scanner s = new Scanner(System.in);
        System.out.print("   Username:");//username:user
        username = s.nextLine();
        System.out.print("   Password:");//password:user
        password = s.nextLine();
        if(lg.checkLogin(username, password))
        {
            PaymentInfo paymentinfo = payment.extractInfo(username, password);
            PaymentInfo.paymentinfo_login = new PaymentInfo(paymentinfo);
            
            if (paymentinfo.getRole().equals(CommonFunction.admin))
                menu.runMenuAdmin();
            else if (paymentinfo.getRole().equals(CommonFunction.staff))
                menu.runMenuStaff();
            else if (paymentinfo.getRole().equals(CommonFunction.customer))
                menu.runMenuUser();
        }
        else
        {
            System.out.println("   Authentication Failed");
        }
        
        System.out.printf(" --------------------------------%n");
    }
    
}
