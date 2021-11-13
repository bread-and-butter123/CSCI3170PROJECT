/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci3170project;

import java.util.Scanner;
import java.sql.*;


/**
 *
 * @author USER
 */
class UI {
    public void mainmenu(){
     int choice;
     Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Library Inquiry System!\n\n");
    System.out.println("-----Main menu-----\n");
    System.out.println("What kind of operations would you like to perform?\n");
    System.out.println("1. Operations for Administrator\n");
    System.out.println("2. Operations for Library User\n");
    System.out.println("3. Operations for Librarian\n");
    System.out.println("Enter Your Choice:");
    choice = scanner.nextInt();
    if(choice==1){
        this.operationsforadministratormunu();
    }
    /*
    else if(choice==2){
        this.operationsforlibraryuser();
    }
    else{
        this.operationsforlibrarian();
    }
    */
    }
    
    public void operationsforadministratormunu(){
     int choice;
     Scanner scanner = new Scanner(System.in);
    System.out.println("-----Operations for administrator menu-----\n");
    System.out.println("What kind of operations would you like to perform?\n");
    System.out.println("1. Create all tables\n");
    System.out.println("2. Delete all tables\n");
    System.out.println("3. Load from datafile\n");
    System.out.println("4. Show number of records in each table\n");
    System.out.println("5. Return to the main menu\n");
    choice = scanner.nextInt();
    if(choice==1){
  String sql = "CREATE TABLE user_category " +
                   "(ucid INTEGER not NULL, " +
                   " max INTEGER, " + 
                   "period INTEGER, "+
                   " PRIMARY KEY ( ucid ))"; 
    Connection con=CSCI3170PROJECT.getconnection();
 try{
    Statement stmt= con.createStatement();
    stmt.executeUpdate(sql);
 }
 catch(java.sql.SQLException e){
 System.out.println(e);
 }

 sql = "DESCRIBE user_category "; 
 try{
    Statement stmt= con.createStatement();
    stmt.executeUpdate(sql);
 }
 catch(java.sql.SQLException e){
 System.out.println(e);
 }
 
}
    /*else if(choice==2){
        
    }
    else if(choice==3){
        
    }
    else if(choice==4){
        
    }
    */
    else if(choice==5){
        
    }
    
    }
 }

 
class connection{

}


public class CSCI3170PROJECT {

    /**
     * @param args the command line arguments
     */     
public static final String dbAddress="jdbc:mysql://projgw.cse.cuhk.edu.hk:2633/db4";
public static final String dbUsername="Group4";
public static final String dbPassword="CSCI3170";
private static Connection con = null;
 static{
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
        }catch(ClassNotFoundException e){
            System.out.println("[Error]:Java MySQL DB Driver not found!!");
            System.exit(0);
        }catch(SQLException e){
        System.out.println(e);
        }
        System.out.println("Connected database successfully...");//Notifications used for debugging
 }
public static Connection getconnection(){
return con;
}

public static void main(String[] args) {
     UI create=new UI();
     create.mainmenu();
    }
    
}
