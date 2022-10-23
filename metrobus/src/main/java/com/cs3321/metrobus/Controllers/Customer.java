/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Controllers;

import com.cs3321.metrobus.Entities.AccountInfo;
import java.util.Scanner;

/**
 *
 * @author rhett Oct 23, 2022
 */

public class Customer {
    Scanner myScan = new Scanner(System.in);
    
    public boolean checkRole(AccountInfo account) {
        return account.getRole() == 1;
    }

    public void addCustomer(AccountInfo account, String userInput, String passInput, int roleInput) {
        //AccountInfo(user, pass, role);
        if (checkRole(account)) {
            account.setUsername(userInput);
            account.setPassword(passInput);
            account.setRole(roleInput);
            System.out.println("Customer account created - Username: " + account.getUsername() + " Password: " + account.getPassword());
        }
        else {
            System.out.println("You do not have staff access.");
        }    
    }
    
    public void removeCustomer(AccountInfo staffAccount, AccountInfo customerAccount) {
        String choice = "";
        if (checkRole(staffAccount)) {
            System.out.print("Confirm deletion of profile, " + customerAccount.getUsername() + "(Y/N): ");
            choice = myScan.next();
            if(choice.equals("Y") || choice.equals("y")) {
                customerAccount = null;
                System.out.println("Account deleted");
            }
        }
        else {
            System.out.println("You do not have staff level access.");
        }
    }
    
    public void editCustomer(AccountInfo staffAccount, AccountInfo customerAccount) {
        
        String toEdit;
        String temp;
        String temp2;
        
        System.out.print("Which attribute would you like to edit? (Username/Password): ");
        toEdit = myScan.next();
        
        switch (toEdit) {
            case "Username" -> {
                System.out.print("Enter current username: ");
                temp = myScan.next();
                if (temp == null ? customerAccount.getUsername() == null : temp.equals(customerAccount.getUsername())) {
                    System.out.print("Enter new username: ");
                    temp = myScan.next();
                    customerAccount.setUsername(temp);
                    System.out.println("New username set: " + customerAccount.getUsername());
                }
                else {
                    System.out.println("Wrong current username.");
                }
            }
            case "Password" -> {
                System.out.print("Enter current password: ");
                temp = myScan.next();
                if (temp.equals(customerAccount.getPassword())) {
                    System.out.print("Enter new password: ");
                    temp = myScan.next();
                    System.out.print("Re-enter new password: ");
                    temp2 = myScan.next();
                    if (temp.equals(temp2)) {
                        customerAccount.setPassword(temp2);
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
    
    public static void main(String[] args) {
        AccountInfo staff = new AccountInfo("rhett", "123456", 1);
        AccountInfo customer = new AccountInfo("cusRhett", "000000",2);
        Customer customerOperation = new Customer();
        
        customerOperation.addCustomer(staff, "newRhett", "000000", 2);
        customerOperation.editCustomer(staff, customer);
        customerOperation.removeCustomer(staff, customer);
        
    }
}