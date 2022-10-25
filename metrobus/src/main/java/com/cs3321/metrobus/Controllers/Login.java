package com.cs3321.metrobus.Controllers;

import com.cs3321.metrobus.Entities.AccountInfo;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {

    ArrayList<AccountInfo> accounts = new ArrayList<AccountInfo>();

    public ArrayList<AccountInfo> readCSV() {

        try ( Scanner sc = new Scanner(new File("C:\\Users\\thail\\Documents\\UHD\\Fall 2022\\CS 3321\\Project\\MetroBus\\metrobus\\src\\main\\java\\com\\cs3321\\metrobus\\Controllers\\login.csv"))) {
       
            sc.useDelimiter("\n");
            while (sc.hasNextLine()) {
                AccountInfo account = new AccountInfo();
                String[] values=sc.next().split(",");
                account.setUsername(values[0].trim());
                account.setPassword(values[1].trim());
                account.setRole(values[2].trim());
                accounts.add(account);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }

    public boolean checkLogin(String username, String password) {
        ArrayList<AccountInfo> list_acc = readCSV();
        
        for (int i = 0; i <= list_acc.size(); i++){
            if ((username.equals(list_acc.get(i).getUsername()))&&(password.equals(list_acc.get(i).getPassword())))
            
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Login lg = new Login();
        if (lg.checkLogin("quangph1", "123456789")) {
            System.out.println("Successful");
        } else {
            System.out.println("Wrong Info");
        }
    }
}
