/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.View;
import com.cs3321.metrobus.Controllers.Customer;
import com.cs3321.metrobus.Entities.PeopleInfo;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author katelynshimek
 */


public class CustomerView extends Customer {

    @Override
    public void displayCustomerTable(ArrayList<PeopleInfo> customers) {
        String line = new String(new char[39]).replace('\0', '-');
        
        String name;
        //String username;
        String gender;
        int numCustomers= customers.size()-1;
        

        
        System.out.println(line);
        System.out.printf("|%s|%n",
                StringUtils.center("All Customers", 38));
        System.out.println(line);
        
        System.out.printf("|%s|%s|%n",
                StringUtils.center("Name", 18),
                //StringUtils.center("Username", 18),
                StringUtils.center("Gender", 19));
        System.out.println(line);
        
        
       
        for(int i=0;i<numCustomers;i++){
        
            name= customers.get(i).getName();
            gender= customers.get(i).getGender();
            
        
        System.out.printf("|%s|%s|%n",
                StringUtils.center(name, 18),
                //StringUtils.center(username, 18),
                StringUtils.center(gender, 19));

        }
    
    
        System.out.println(line);
    }
}
