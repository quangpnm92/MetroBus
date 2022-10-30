
package com.cs3321.metrobus.Controllers;
import com.cs3321.metrobus.Entities.AccountInfo;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login{
    public boolean readCSV(String username, String password){
        try (Scanner sc = new Scanner(new File("C:\\Users\\thail\\Documents\\UHD\\Fall 2022\\CS 3321\\Project\\MetroBus\\metrobus\\src\\main\\java\\com\\cs3321\\metrobus\\Controllers\\login.csv"))) {
            sc.useDelimiter(",");
            while (sc.hasNext()){
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checkLogin(String username, String password){
        if (readCSV(username, password))
            return true;
        return false;
    }
    public static void main (String[] args) throws Exception{
        Login a = new Login();
        if(a.checkLogin("quangph1","123456789"))
            System.out.println("OK nha");
        else
            System.out.println("Sai");
        
        
    }
}

