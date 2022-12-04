/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.View;

import com.cs3321.metrobus.Controllers.CommonFunction;
import com.cs3321.metrobus.Entities.ReportInfo;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Quan
 */

//The following code prints a Receipt-style report of all trips purchased

public class ReportView {

    static void printReport() {
        ArrayList<ReportInfo> reports = CommonFunction.readCSV_GeneralReport();
        String line = new String(new char[48]).replace('\0', '-');
        Date date = new Date();


        System.out.println(line);

        System.out.printf("|%s|%n",
                StringUtils.center("MetroBus Report", 46));
        System.out.printf("|%s|%n",
                StringUtils.center(date.toString(), 46));

        //iterates through ArrayList of all purchased trip reports
        for (ReportInfo report : reports) {
            System.out.println(line);
            String customerName = report.getName();
            //String card = report.getCard();
            String card = "**** **** **** " + report.getCard().substring(12);
            String id = report.getTripID();
            String departureCity = report.getDeparture();
            String arrivalCity = report.getArrival();
            String price = report.getPrice();
            String taken = report.getSeatTaken();

            System.out.printf("|%s|%s|%n",
                    StringUtils.center("Customer", 22),
                    StringUtils.center(customerName, 23));

            System.out.printf("|%s|%s|%n",
                    StringUtils.center("Card Number", 22),
                    StringUtils.center(card, 23));

            System.out.printf("|%s|%s|%n",
                    StringUtils.center("Trip ID", 22),
                    StringUtils.center(id, 23));

            System.out.printf("|%s|%s|%n",
                    StringUtils.center("Departure City", 22),
                    StringUtils.center(departureCity, 23));

            System.out.printf("|%s|%s|%n",
                    StringUtils.center("Arrival City", 22),
                    StringUtils.center(arrivalCity, 23));

            System.out.printf("|%s|%s|%n",
                    StringUtils.center("Price", 22),
                    StringUtils.center(price, 23));

            System.out.printf("|%s|%s|%n",
                    StringUtils.center("Seats purchased", 22),
                    StringUtils.center(taken, 23));
        }
        System.out.println(line);

        System.out.printf("|%s|%n",
                StringUtils.center("General Ticket Report", 46));
        System.out.printf("|%s|%n",
                StringUtils.center("VC Ticketing Company", 46));

        System.out.println(line);
    }
}
