/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Entities;

/**
 *
 * @author Quang Pham
 */

//The following code consists of setter/getter functions for users' Account Info.
//User role is classified as 0 = admin, 1 = staff, 2 = customer.
//This is how the program determines which menu to display to the user.

public class AccountInfo {
    private String username; 
    private String password; // private = restricted access. In the real world, password would be encrypted
    private String role;
    private String sex;
    private int tickets[][];
  
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
  
    public String getPassword() {
        return password;
    }
  
    public void setPassword(String password) {
        this.password = password;
    }
  
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
  
    public int[][] getTickets() {
        return tickets;
    }
    public void setTickets(int[][] tickets) {
        this.tickets = tickets;
    }
    
    public AccountInfo(String user, String pass, String role, String sex){
        this.username = user;
        this.password = pass;
        this.role = role;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
 
    public AccountInfo() {
     
    }
}

