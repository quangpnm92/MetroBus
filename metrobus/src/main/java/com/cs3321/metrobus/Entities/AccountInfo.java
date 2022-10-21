/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Entities;

/**
 *
 * @author Quang Pham
 */
public class AccountInfo {
  private String username; 
  private String password; // private = restricted access
  private int role;
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
  
  public int getRole() {
    return role;
  }
  public void setRole(int role) {
    this.role = role;
  }
  
  public int[][] getTickets() {
    return tickets;
  }
  public void setTickets(int[][] tickets) {
    this.tickets = tickets;
  }
    
  
 public void AccountInfo(String user, String pass, int role){
     this.username = user;
     this.password = pass;
     this.role = role;
 }
 
}

