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
public class ReportView {

    static void printReport() {
        ArrayList<ReportInfo> reports = CommonFunction.readCSV_GeneralReport();
        String line = new String(new char[48]).replace('\0', '-');
        Date date = new Date();

        //delete the following once we pass parameters
//        String customerName=payment.getName();
//        String departureCity=trip.getDepartureCity();
//        String arrivalCity=trip.getArrivalCity();
        //**********************
        System.out.println(line);

        System.out.printf("|%s|%n",
                StringUtils.center("MetroBus Report", 46));
        System.out.printf("|%s|%n",
                StringUtils.center(date.toString(), 46));

        for (ReportInfo report : reports) {
            System.out.println(line);
            String customerName = report.getName();
            String card = report.getCard();
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
                    StringUtils.center("Seats buy", 22),
                    StringUtils.center(taken, 23));
        }
        System.out.println(line);

        System.out.printf("|%s|%n",
                StringUtils.center("Thank you for your purchase!", 46));
        System.out.printf("|%s|%n",
                StringUtils.center("Have a nice trip! :)", 46));

        System.out.println(line);
    }
}