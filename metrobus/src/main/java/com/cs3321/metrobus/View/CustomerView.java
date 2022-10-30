/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.View;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author katelynshimek
 */


public class CustomerView {

    public static void main(String[] args) {
        String line = new String(new char[59]).replace('\0', '-');
        
        String name;
        String username;
        String gender;
        

        
        System.out.println(line);
        System.out.printf("|%s|%n",
                StringUtils.center("All Customers", 57));
        System.out.println(line);
        
        System.out.printf("|%s|%s|%s|%n",
                StringUtils.center("Name", 18),
                StringUtils.center("Username", 18),
                StringUtils.center("Gender", 19));
        System.out.println(line);
        
        
        //needs to be in a for or while loop for AllCustomers data structure
        
            name="Kate Shimek";
            username="kshimek";
            gender="F";
        
        System.out.printf("|%s|%s|%s|%n",
                StringUtils.center(name, 18),
                StringUtils.center(username, 18),
                StringUtils.center(gender, 19));

    //} end of loop
    
    
        System.out.println(line);
    }
}
