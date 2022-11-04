/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs3321.metrobus.Controllers;

import com.cs3321.metrobus.Entities.AccountInfo;
import com.cs3321.metrobus.Entities.PeopleInfo;
import java.util.ArrayList;

/**
 *
 * @author Quan
 */
interface Account {
    public void add(AccountInfo staffAccount, AccountInfo custAccount, String userInput, String passInput, String roleInput);
    public void edit(AccountInfo staffAccount, AccountInfo customerAccount);
    public void remove(AccountInfo staffAccount, AccountInfo customerAccount);
    public void displayTable();
    public boolean checkRole(AccountInfo account);
}
