
package com.cs3321.metrobus.Controllers;
import com.cs3321.metrobus.Entities.AccountInfo;
import java.io.*;
import java.util.*;

public class Login{
    public void readCSV() throws Exception{
        try (Scanner sc = new Scanner(new File("C:\\Users\\thail\\Documents\\UHD\\Fall 2022\\CS 3321\\Project\\MetroBus\\metrobus\\src\\main\\java\\com\\cs3321\\metrobus\\Controllers\\login.csv"))) {
            sc.useDelimiter(",");
            while (sc.hasNext()){
                System.out.print(sc.next());
                //
            }
        }
    }
    public boolean checkLogin(String username, String password){
        
        return false;
    }
    public static void main (String[] args) throws Exception{
        
    }
}

