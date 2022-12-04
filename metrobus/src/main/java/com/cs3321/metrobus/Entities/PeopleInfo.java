/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Entities;

/**
 *
 * @author Quan
 */

//The following code consists of setters/getters for users' personal info

public class PeopleInfo extends AccountInfo {
    private String name;
    private String cardNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PeopleInfo(String name, String gender, String cardNumber) {
        this.name = name;
        this.setSex(gender);
        this.cardNumber = cardNumber;
    }

    public PeopleInfo() {
        this.name = "N/A";
        this.setSex("N/A");
        this.cardNumber = "N/A";
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    
}
