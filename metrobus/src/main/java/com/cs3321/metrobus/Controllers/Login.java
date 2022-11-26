package com.cs3321.metrobus.Controllers;


import java.io.*;
import java.util.*;

public class Login {

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
            System.out.println("File not found");
        }
        return false;
    }
}
