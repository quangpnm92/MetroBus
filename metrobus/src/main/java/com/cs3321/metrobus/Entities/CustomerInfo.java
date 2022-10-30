/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Entities;

/**
 *
 * @author Quang Pham
 */

// role 0 = admin, role 1 = staff, role 2 = customer
public class CustomerInfo {
  private String username; 
  private String password; // private = restricted access
  private String role;
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
    
  
 public CustomerInfo(String user, String pass, String role){
     this.username = user;
     this.password = pass;
     this.role = role;
 }
 
 public CustomerInfo() {
     
 }
 
}

