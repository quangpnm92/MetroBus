/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Controllers;
import static com.cs3321.metrobus.Controllers.CommonFunction.staff;
import com.cs3321.metrobus.Entities.AccountInfo;
import java.util.Scanner;

/**
 *
 * @author rhett Oct 23, 2022
 */

//The following code contains functions used to manipulate Staff objects, ie adding/removing/editing

public class Staff implements Account {
    Scanner myScan = new Scanner(System.in);
    
    @Override
    public boolean checkRole(AccountInfo account) {
        return staff.equals(account.getRole());
    }
    
    @Override
    public void add(AccountInfo adminAccount, AccountInfo staffAccount, String userInput, String passInput, String roleinput) {
        if(checkRole(adminAccount)) {
            staffAccount.setUsername(userInput);
            staffAccount.setPassword(passInput);
            staffAccount.setRole(roleinput);
            System.out.println("Staff account created - Username: " + staffAccount.getUsername() + ", Password: " + staffAccount.getPassword());
        }
        else {
            System.out.println("You do not have admin access.");
        }
    }
    
    @Override
    public void remove(AccountInfo adminAccount, AccountInfo staffAccount) {
        String choice = "";
        if (checkRole(adminAccount)) {
            System.out.print("Confirm deletion of profile, " + staffAccount.getUsername() + "(Y/N): ");
            choice = myScan.next();
            if(choice.equals("Y") || choice.equals("y")) {
                staffAccount = null;
                System.out.println("Account deleted");
            }
        }
        else {
            System.out.println("You do not have administrator level access.");
        }
    }
    
    @Override
    public void edit(AccountInfo adminAccount, AccountInfo staffAccount) {
        String toEdit;
        String temp;
        String temp2;
        
        System.out.print("Which attribute would you like to edit? (Username/Password): ");
        toEdit = myScan.next();
        
        if (checkRole(adminAccount)) {
                switch (toEdit) {
                    case "Username" -> {
                        System.out.print("Enter current username: ");
                        temp = myScan.next();
                        if (temp == null ? staffAccount.getUsername() == null : temp.equals(staffAccount.getUsername())) {
                            System.out.print("Enter new username: ");
                            temp = myScan.next();
                            staffAccount.setUsername(temp);
                            System.out.println("New username set: " + staffAccount.getUsername());
                        }
                        else {
                            System.out.println("Wrong current username.");
                        }
                    }
                    case "Password" -> {
                        System.out.print("Enter current password: ");
                        temp = myScan.next();
                        if (temp.equals(staffAccount.getPassword())) {
                            System.out.print("Enter new password: ");
                            temp = myScan.next();
                            System.out.print("Re-enter new password: ");
                            temp2 = myScan.next();
                            if (temp.equals(temp2)) {
                                staffAccount.setPassword(temp2);
                                System.out.println("New password set.");
                            }
                            else {
                            System.out.println("Unable to change. Mistaching passwords.");
                            }
                        }
                        else {
                            System.out.println("Invalid current password.");
                        }
                    }
                    default -> System.out.println("Invalid input/operation");
                }
        }
        else {
            System.out.println("You do not have admin access.");
        }
    }
    
    @Override
    public void displayTable(){};
}
