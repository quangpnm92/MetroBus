
package com.cs3321.metrobus.Entities;


//The following code consists of setter/getter functions for users' Payment Info.
//In the real world, we would use a third party payment software to ensure
//security and privacy.

public class PaymentInfo extends AccountInfo {
    
    static public PaymentInfo paymentinfo_login;
    
    private String cardNumber;
    private String name;
    private String expireDate;
    private String cvc;
    private double money;
    
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

    public double getMoney() {
        return money;
    }

    public PaymentInfo() {
    }

    public void setMoney(double money) {
        this.money = money;
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

    public PaymentInfo(String cardNumber, String name, String expireDate, String cvc, double money, String username, String password, String role, String sex) {
        super(username, password, role, sex);
        this.cardNumber = cardNumber;
        this.name = name;
        this.expireDate = expireDate;
        this.cvc = cvc;
        this.money = money;
    }
    
    public PaymentInfo(PaymentInfo pay) {
        super(pay.getUsername(), pay.getPassword(), pay.getRole(), pay.getSex());
        this.cardNumber = pay.cardNumber;
        this.name = pay.name;
        this.expireDate = pay.expireDate;
        this.cvc = pay.cvc;
        this.money = pay.money;
    }
    
    
}
