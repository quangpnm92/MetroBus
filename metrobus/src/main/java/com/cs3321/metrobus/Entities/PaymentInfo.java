
package com.cs3321.metrobus.Entities;

public class PaymentInfo {
    private String cardNumber;
    private String name;
    private String expireDate;
    private String cvc;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public PaymentInfo(String cardNumber, String name, String expireDate, String cvc) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.expireDate = expireDate;
        this.cvc = cvc;
    }
    
}