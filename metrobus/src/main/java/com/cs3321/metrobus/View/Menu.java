/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.cs3321.metrobus.View;

import java.util.Scanner;

/**
 *
 * @author huyph
 */
public class Menu {
 boolean exit;
  public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
        menu.runMenu1();
    }
  
  public void runMenu(){
      printHeader();
      while(!exit){
          printMenu();
          int choice=getInput();
          performAction(choice);
      }
  }
    public void runMenu1(){
      printHeader();
      while(!exit){
          printOption1();
          int choice=getInput1();
          performAction(choice);
      }
      
  }
   private void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|                Menu               |");
        System.out.println("+-----------------------------------+");
    }
    
   private void printMenu() {
         System.out.println("\nPlease make a selection");
   
        System.out.println("1) Customer");
        System.out.println("2) Staff");
        System.out.println("3) Admin");
        System.out.println("0) Exit");
    }
   
   private void printOption1(){
        System.out.println("\nPlease make a selection");
        System.out.println("1) Edit customer info");
        System.out.println("2) View Purchased trips");
        System.out.println("3) Purchase a New Trip");
        System.out.println("0) Exit");
   }
   
   private void printOption2(){
        System.out.println("\nPlease make a selection");
        System.out.println("1) View Customer table");
        System.out.println("2) Edit trip");
        System.out.println("3) Edit staff");
        System.out.println("0) Exit");
   }
   
   private void printOption3(){
        System.out.println("\nPlease make a selection");
        System.out.println("1) View staff table");
        System.out.println("2) Edit Admin info");
        System.out.println("0) Exit");
   }
   

    private int getInput(){
    Scanner kb=new Scanner(System.in);
    
   int choice=-1;
   while(choice<0 || choice>3){
       try{
          // System.out.print("\nEnter your choice: ");
          // choice= Integer.parseInt(kb.nextLine());
          choice= 1;
       }
       catch(NumberFormatException e){
           System.out.println("Invalid selection. Please try again.");
       }
       
   }
   return choice;
   }
     private int getInput1(){
    Scanner kb=new Scanner(System.in);
    
   int choice=-1;
   while(choice<0 || choice>3){
       try{
           System.out.print("\nEnter your choice: ");
           choice= Integer.parseInt(kb.nextLine());
         
       }
       catch(NumberFormatException e){
           System.out.println("Invalid selection. Please try again.");
       }
       
   }
   return choice;
   }
    
     private void performAction(int choice){
         
         switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                System.exit(0);
                break;
            case 1: {
                printOption1();
                getInput1();
                 switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                System.exit(0);
                break;
            case 1: {
                 System.exit(0);
                break;
            }
            case 2:
               System.exit(0);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Unknown error has occured.");
        }
                
                break;
            }
            case 2:
               {
                printOption2();
                getInput();
                 switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                System.exit(0);
                break;
            case 1: {
                 System.exit(0);
                break;
            }
            case 2:
               System.exit(0);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Unknown error has occured.");
        }
                
                break;
            }
            case 3:
               {
                printOption3();
                getInput();
                 switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                System.exit(0);
                break;
            case 1: {
                 System.exit(0);
                break;
            }
            case 2:
               System.exit(0);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Unknown error has occured.");
        }
                
                break;
            }
            default:
                System.out.println("Unknown error has occured.");
        }
     
     }
    
 }
