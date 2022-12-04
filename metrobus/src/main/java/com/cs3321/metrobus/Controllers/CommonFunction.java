/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Controllers;

import com.cs3321.metrobus.Entities.PaymentInfo;
import com.cs3321.metrobus.Entities.PeopleInfo;
import com.cs3321.metrobus.Entities.ReportInfo;
import com.cs3321.metrobus.Entities.TripInfo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quan
 */


//The following code is a variety of common functions used throughout the program

public class CommonFunction {
 
    //The line below is for Kate's Mac due to different pathing format
    //static public String path = "/Users/katelynshimek/NetBeansProjects/MetroBus/metrobus/src/main/java/com/cs3321/metrobus/Controllers/";
   
    //The line below is for Windows users
    static public String path = new File("").getAbsolutePath() + "\\src\\main\\java\\com\\cs3321\\metrobus\\Controllers\\";
    static public String admin = "0";
    static public String staff = "1";
    static public String customer = "2";

    //Tests if values are able to be converted to a double, used in exception handling/input validation
    static public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    static public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static public Date convertStringToDate(String str) {
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        str = str.substring(0, 2) + "-01-" + "20" + str.substring(2);

        Date date = null;
        try {
            date = df.parse(str);
        } catch (ParseException ex) {

        }
        return date;
    }

    static public ArrayList<PeopleInfo> readCSV(String choice) {
        ArrayList<PeopleInfo> peoples = new ArrayList<>();

        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "login.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");

                if (choice.equals(values[2].trim())) {
                    String name = values[3].trim();
                    String gender = values[4].trim();
                    String card = values[5].trim();

                    PeopleInfo people = new PeopleInfo(name, gender, card);
                    peoples.add(people);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FIle not found");
        }
        return peoples;
    }

    static public ArrayList<TripInfo> readCSV_TripInfo() {
        ArrayList<TripInfo> trips = new ArrayList<>();

        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "trip.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");
                String id = values[0].trim();
                String departure = values[1].trim();
                String arrival = values[2].trim();
                int available = Integer.parseInt(values[3].trim());
                int total = Integer.parseInt(values[4].trim());
                Double price = Double.parseDouble(values[5].trim());
                TripInfo trip = new TripInfo(id, departure, arrival, available, total, price);
                trips.add(trip);

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        return trips;
    }

    static public void writeCSV_TripInfo(TripInfo trip) {
        String bigString = "";
        try ( Scanner sc = new Scanner(new File(path + "trip.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");
                String id = values[0].trim();

                if (trip.getTripID().equals(id)) {
                    values[3] = String.valueOf(trip.getAvailable());
                    values[4] = String.valueOf(trip.getTotal());
                }

                for (String value : values) {
                    bigString += value + ",";
                }
                bigString = bigString.substring(0, bigString.length() - 1);
                bigString += "\n";
            }

            bigString = bigString.substring(0, bigString.length() - 1);

            FileWriter myWriter = new FileWriter(path + "trip.csv", false);
            myWriter.write(bigString);
            myWriter.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        } catch (IOException ex) {
            System.out.println("File error.");
        }

    }
    
    static public void adjustCustomerMoney(PaymentInfo payment) {
        String bigString = "";
        try ( Scanner sc = new Scanner(new File(path + "login.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");
                String cardNumber = values[5].trim();

                if (payment.getCardNumber().equals(cardNumber)) {
                    values[8] = String.format("%,.2f", payment.getMoney());
                }

                for (String value : values) {
                    bigString += value + ",";
                }
                
                bigString = bigString.substring(0, bigString.length() - 1);
                bigString += "\n";
            }

            bigString = bigString.substring(0, bigString.length() - 1);

            FileWriter myWriter = new FileWriter(path + "login.csv", false);
            myWriter.write(bigString);
            myWriter.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        } catch (IOException ex) {
            System.out.println("File error.");
        }

    }

    public static void readDiscounts() {
        Admin myAdmin = new Admin();
        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "discount.csv"))) {
            myAdmin.setPromotionStatus(sc.next());
            myAdmin.editPromotion(sc.nextDouble());
        } catch (IOException ex) {
            System.err.print("Discount input error");
        }
    }

    public static void writeDiscounts(boolean promotionStatus, Double promotionValue) {
        try {
            FileWriter myWriter = new FileWriter(CommonFunction.path + "discount.csv");
            myWriter.write(String.valueOf(promotionStatus) + '\n');
            myWriter.write(String.valueOf(promotionValue) + '\n');
            myWriter.close();
        } catch (IOException ex) {
            System.err.print("Discount writing error");
        }
    }

    static public void writeCSV_ReportInfo(PaymentInfo payment, TripInfo trip, String total) {
        String bigString = "";

        try ( Scanner sc = new Scanner(new File(path + "report.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String read = sc.nextLine();
                read = read.replaceAll("(\\r)", "");
                
                bigString += read + "\r\n";
            }

            bigString += String.valueOf(payment.getName()) + " ,";
            bigString += String.valueOf(payment.getCardNumber()) + " ,";
            bigString += String.valueOf(trip.getTripID()) + " ,";
            bigString += String.valueOf(trip.getDepartureCity()) + " ,";
            bigString += String.valueOf(trip.getArrivalCity()) + " ,";
            bigString += String.valueOf(String.format("%.2f", trip.getPrice())) + " ,";
            bigString += String.valueOf(total);

            FileWriter myWriter = new FileWriter(path + "report.csv", false);
            myWriter.write(bigString);
            myWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(CommonFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public ArrayList<ReportInfo> readCSV_GeneralReport() {
        ArrayList<ReportInfo> reports = new ArrayList<>();

        try ( Scanner sc = new Scanner(new File(CommonFunction.path + "report.csv"))) {

            sc.useDelimiter("\n");

            while (sc.hasNextLine()) {
                String[] values = sc.next().split(",");

                String name = values[0].trim();
                String card = values[1].trim();
                String id = values[2].trim();
                String departure = values[3].trim();
                String arrival = values[4].trim();
                String price = values[5].trim();
                String taken = values[6].trim();

                ReportInfo report = new ReportInfo(name, card, id, departure, arrival, price, taken);
                reports.add(report);

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        return reports;
    }
    
    // Return true if the card number is valid
    public static boolean validitychk(long cnumber) {
        return (thesize(cnumber) >= 13 && thesize(cnumber) <= 16) && (prefixmatch(cnumber, 4)
            || prefixmatch(cnumber, 5) || prefixmatch(cnumber, 37) || prefixmatch(cnumber, 6))
            && ((sumdoubleeven(cnumber) + sumodd(cnumber)) % 10 == 0);
    }
    
    // Get the result from Step 2
    public static int sumdoubleeven(long cnumber) {
        int sum = 0;
        String num = cnumber + "";
        for (int i = thesize(cnumber) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        return sum;
    }
    
    // Return this cnumber if it is a single digit, otherwise,
    // return the sum of the two digits
    public static int getDigit(int cnumber) {
        if (cnumber < 9)
            return cnumber;
        return cnumber / 10 + cnumber % 10;
    }
   
    // Return sum of odd-place digits in cnumber
    public static int sumodd(long cnumber) {
        int sum = 0;
        String num = cnumber + "";
        for (int i = thesize(cnumber) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }
     
   // Return true if the digit d is a prefix for cnumber
    public static boolean prefixmatch(long cnumber, int d) {
        return getprefx(cnumber, thesize(d)) == d;
    }
    
   // Return the number of digits in d
    public static int thesize(long d) {
      String num = d + "";
      return num.length();
    }
   
    // Return the first k number of digits from
    // number. If the number of digits in number
    // is less than k, return number.
    public static long getprefx(long cnumber, int k) {
      if (thesize(cnumber) > k) {
         String num = cnumber + "";
         return Long.parseLong(num.substring(0, k));
      }
      return cnumber;
    }
    
    public static boolean validateSex(String input) {
        return input.equals("Male") || input.equals("Female");
    }

    public static void writeLogin(PaymentInfo newProfile) {
        try(FileWriter fw = new FileWriter(CommonFunction.path + "login.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
                out.print("\n");
                out.print(newProfile.getUsername() + ",");
                out.print(newProfile.getPassword() + ",");
                out.print(newProfile.getRole() + ",");
                out.print(newProfile.getName() + ",");
                out.print(newProfile.getSex() + ",");
                out.print(newProfile.getCardNumber() + ",");
                out.print(newProfile.getExpireDate() + ",");
                out.print(newProfile.getCvc() + ",");
                out.print(newProfile.getMoney());
                out.close();
        } catch (IOException e) {
            System.err.println("Error loading file");
        }
    }
    
    public static PaymentInfo getPersonLogin(String role) {
        PaymentInfo newPerson = new PaymentInfo();
        String input = new String();
        String input2 = new String();
        String pass1 = "";
        String pass2 = "";
        String expDate = new String();
        String cvc = new String();
        Double balance;
        long creditCardNumber = 0;
        String stringCreditCardNumber = new String();
        Scanner sc = new Scanner(System.in);
        boolean validCVC = false;
       
       
        System.out.println("Adding a new profile.");
        System.out.print("Enter the username: ");
        newPerson.setUsername(sc.nextLine());
        
        do {
            System.out.print("Enter the customer's password: ");
            pass1 = sc.nextLine();
            System.out.print("Re-enter the customer's password: ");
            pass2 = sc.nextLine();
            
            if (!pass1.equals(pass2)) {
                System.out.println("Passwords do not match. Please enter again.");
            }
        }while(!pass1.equals(pass2));
        
        newPerson.setPassword(pass1);
        newPerson.setRole(role);
        System.out.print("Enter the customer's whole name: ");
        newPerson.setName(sc.nextLine());
        
        do {
            System.out.print("Enter the customer's sex, Male/Female: ");
            input = sc.nextLine();
            if(!(input.equals("Male") || input.equals("Female"))) {
                System.out.println("Invalid input. Please try again.");
            }
        }while(!(input.equals("Male") || input.equals("Female")));
        
        newPerson.setSex(input);
        do {
            if (creditCardNumber != 0) {
                System.out.println("Invalid credit card. Please enter again");
            }
            System.out.print("Enter credit card number: ");
            creditCardNumber = sc.nextLong();
            
        }while(!CommonFunction.validitychk(creditCardNumber));
        
        stringCreditCardNumber = Long.toString(creditCardNumber);
        newPerson.setCardNumber(stringCreditCardNumber);
        sc.nextLine(); // cleaning the input buffer stream
        System.out.print("Enter expiry date in format MMYY: ");
        expDate = sc.nextLine();
        newPerson.setExpireDate(expDate);
        do {
            System.out.print("Enter card CVC: ");
            cvc = sc.nextLine();
            try {
                Integer.parseInt(cvc);
                validCVC = true;
            }catch(NumberFormatException e) {
                System.out.println("Invalid CVC. Please try again.");
            }
        }while(!(cvc.length() == 3) || !validCVC);
        
        newPerson.setCvc(cvc);
        System.out.print("Enter load balance: ");
        balance = sc.nextDouble();
        newPerson.setMoney(balance);
        
        return newPerson;
    }
}
