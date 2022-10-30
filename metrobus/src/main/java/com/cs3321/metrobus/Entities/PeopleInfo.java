/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Entities;

/**
 *
 * @author Quan
 */
public class PeopleInfo {
    private String name;
    private String gender;
    private String cardNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PeopleInfo(String name, String gender, String cardNumber) {
        this.name = name;
        this.gender = gender;
        this.cardNumber = cardNumber;
    }

    public PeopleInfo() {
         this.name = "N/A";
        this.gender = "N/A";
        this.cardNumber = "N/A";
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    
}
