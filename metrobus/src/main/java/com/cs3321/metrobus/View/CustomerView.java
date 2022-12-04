/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.View;
import com.cs3321.metrobus.Controllers.CommonFunction;
import com.cs3321.metrobus.Controllers.Customer;
import com.cs3321.metrobus.Entities.PeopleInfo;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author katelynshimek
 */

//The following code displays a table of all Customers registered in the system,
//ie, in our ArrayList of all Customer objects


public class CustomerView extends Customer {

    @Override
    public void displayTable() {
        ArrayList<PeopleInfo> customers = CommonFunction.readCSV(CommonFunction.customer);
        //before 39
        String line = new String(new char[51]).replace('\0', '-');
        
        String name;
        //String username;
        String gender;     

        System.out.println(line);
        System.out.printf("|%s|%n",
                StringUtils.center("Customer List", 50)); //before 38
        System.out.println(line);
        
        System.out.printf("|%s|%s|%n",
                StringUtils.center("Name", 24), //before 18
                //StringUtils.center("Username", 18),
                StringUtils.center("Gender", 25)); //before 19
        System.out.println(line);
        
        
       
        for(int i=0;i<customers.size();i++){
        
            name= customers.get(i).getName();
            //gender= customers.get(i).getGender();
            gender = customers.get(i).getSex();
            
        
        System.out.printf("|%s|%s|%n",
                StringUtils.center(name, 24), //before 18
                //StringUtils.center(username, 18),
                StringUtils.center(gender, 25)); //before 19

        }
    
    
        System.out.println(line);
    }
}
