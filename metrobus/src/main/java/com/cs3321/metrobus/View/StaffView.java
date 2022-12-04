/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.View;
import com.cs3321.metrobus.Controllers.CommonFunction;
import com.cs3321.metrobus.Controllers.Staff;
import com.cs3321.metrobus.Entities.PeopleInfo;
import com.cs3321.metrobus.Entities.AccountInfo;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import com.cs3321.metrobus.Controllers.Customer;
import com.cs3321.metrobus.Entities.PaymentInfo;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author katelynshimek
 */

//The following code outputs a table view of all Staff registered in the system


public class StaffView extends Staff {

    
    @Override
    public void displayTable() {
        ArrayList<PeopleInfo> staff = CommonFunction.readCSV(CommonFunction.staff);
        String line = new String(new char[39]).replace('\0', '-');
        
        String name;
        String gender;
        
        System.out.println(line);
        System.out.printf("|%s|%n",
                StringUtils.center("Staff List", 38));
        System.out.println(line);
        
        System.out.printf("|%s|%s|%n",
                StringUtils.center("Name", 18),
                //StringUtils.center("Username", 18),
                StringUtils.center("Gender", 19));
        System.out.println(line);
        
        
       //iterates through ArrayList of all staff
        for(int i=0;i<staff.size();i++){
        
            name= staff.get(i).getName();
            //gender= staff.get(i).getGender();
            gender = staff.get(i).getSex();
            
            
        
        System.out.printf("|%s|%s|%n",
                StringUtils.center(name, 18),
                //StringUtils.center(username, 18),
                StringUtils.center(gender, 19));

        }
    
    
        System.out.println(line);
    }
    
    public void addCustomerProfile() { //rhett 11-26-2022
        PaymentInfo newProfile = CommonFunction.getPersonLogin("2");
        System.out.println("\n\nSending to File: \n" + "Username: " + newProfile.getUsername() + "\n" + "Password: " + newProfile.getPassword() + "\n" + "Name: " + newProfile.getName() + "\n" + "Sex: " + newProfile.getSex() + "\n" + "Card: **** **** **** " + newProfile.getCardNumber().substring(12) + "\n" + "Expiry: " + newProfile.getExpireDate() + "\n" + "CVC: " + newProfile.getCvc() + "\n" + "Balance: " + newProfile.getMoney());
        CommonFunction.writeLogin(newProfile);
    }
}
