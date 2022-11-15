/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.cs3321.metrobus.View;

import com.cs3321.metrobus.Controllers.CommonFunction;
import static com.cs3321.metrobus.View.PaymentView.displayPayment;
import com.cs3321.metrobus.Controllers.Admin;
import java.util.Scanner;

/**
 *
 * @author huyph
 */
public class MenuView {

    boolean exit;

    public static void main(String[] args) {
        MenuView menu = new MenuView();

    }

    public void runMenuAdmin() {
        printHeader();
        while (!exit) {
            printAdminView();
            int choice = getInput1();
            performAdminAction(choice);
        }
    }

    public void runMenuStaff() {
        printHeader();
        while (!exit) {
            printStaffView();
            int choice = getInput1();
            performStaffAction(choice);
        }
    }

    public void runMenuUser() {
        printHeader();
        while (!exit) {
            printUserView();
            int choice = getInput1();
            performUserAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|                Menu               |");
        System.out.println("+-----------------------------------+");
    }

    private void printAdminView() {
        System.out.println("\nPlease make a selection");
        System.out.println("1) View Staffs info");
        System.out.println("2) Enable/Disable Promotional Discounts");
        System.out.println("3) Modify Promotional Discount");
        System.out.println("4) View Trip table");
        System.out.println("0) Exit");
    }

    private void printStaffView() {
        System.out.println("\nPlease make a selection");
        System.out.println("1) View Customer info");
        System.out.println("2) Edit trip");
        System.out.println("3) Edit staff");
        System.out.println("0) Exit");
    }

    private void printUserView() {
        System.out.println("\nPlease make a selection");
        System.out.println("1) View Trip table");
        System.out.println("2) Make payment for Trip");
        System.out.println("0) Exit");
    }

    private int getInput1() {
        Scanner kb = new Scanner(System.in);

        int choice = -1;
        while (choice < 0 || choice > 4) {
            try {
                System.out.print("\nEnter your choice: ");
                choice = Integer.parseInt(kb.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please try again.");
            }

        }
        return choice;
    }

    private void performAdminAction(int choice) {
        AdminView myAdmin = new AdminView();

        switch (choice) {
            case 0 -> {
                System.out.println("Thank you for using our application.");
                System.exit(0);
            }
            case 1 -> {
                StaffView staff = new StaffView();
                staff.displayTable();
            }
            case 2 -> { //rhett 11-11-2022
                  myAdmin.displayEnablePromotion();
            }

            case 3 -> { //rhett 11-11-2022
                myAdmin.setNewPromotion();
            }
            case 4 -> {
                myAdmin.displayTable();
            }
            default ->
                System.out.println("Unknown error has occured.");
        }

    }

    private void performStaffAction(int choice) {

        switch (choice) {
            case 0 -> {
                System.out.println("Thank you for using our application.");
                System.exit(0);
            }
            case 1 -> {
                CustomerView customer = new CustomerView();
                customer.displayTable();
            }
            case 2 -> {
                System.out.println("Out for 2");
            }

            case 3 -> {
                System.out.println("Out for 3");
            }
            default ->
                System.out.println("Unknown error has occured.");
        }
    }

    private void performUserAction(int choice) {

        switch (choice) {
            case 0 -> {
                System.out.println("Thank you for using our application.");
                System.exit(0);
            }
            case 1 -> {
                TripView.displayTable();
            }
            case 2 -> {
                TripView.displayTable();
                PaymentView.displayPayment();
            }

            case 3 -> {
                System.out.println("Out for 3");

            }
            default ->
                System.out.println("Unknown error has occured.");
        }
    }
}
