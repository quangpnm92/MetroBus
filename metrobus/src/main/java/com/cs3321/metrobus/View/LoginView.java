/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;
import java.util.Scanner;

/**
 *
 * @author phamt
 */
public class LoginView {

    
    public static void main(String[] args) {
        
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
        if(username.equals("user") && password.equals("user"))
        {
            System.out.println("   Authentication Successful");
        }
        else
        {
            System.out.println("   Authentication Failed");
        }
        
        System.out.printf(" --------------------------------%n");
    }
    
}
