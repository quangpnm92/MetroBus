package com.cs3321.metrobus.Controllers;


import java.io.*;
import java.util.*;

//The following code validates users' usernames and passwords based on the CSV file we have with
//users' login information.

public class Login {

    public boolean checkLogin(String username, String password) {

        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "login.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");

                if ((username.equals(values[0].trim()) && (password.equals(values[1].trim())))) {
                    return true; //Returns true if both username and password match the CSV file
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        return false; //Returns false if username and/or password do not match values in file
    }
}
