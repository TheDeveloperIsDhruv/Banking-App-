/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.online_banking_system_cps406_projecct;

import javax.swing.JOptionPane;

/**
 *
 * @author dhairyapatel
 */
public class Account {
    
    public String Account_Type ;
    public float Account_Balance;
    
    public Account(){
        
        this.Account_Type = "" ;
        this.Account_Balance = 10000 ;
    }

    public void setAccount_Type(String Account_Type) {
        this.Account_Type = Account_Type;
    }
    
    public String getAccount_Type(){
        return this.Account_Type;
       
    }
    
    public float getAccount_Balance(){
        return this.Account_Balance;
    }
    
    
    public void setAccount_Balance(float Amount){
        this.Account_Balance = Amount;
        
    }
    
    
    public void depositAccount_Balance(float deposit){
        this.Account_Balance += deposit ;
    }
    
    public void withdrawAccount_Balance(float withdraw){
        
        if (withdraw < Account_Balance) {
            this.Account_Balance -= withdraw ;
        }
        else {
            System.out.println("Insufficient funds");
            JOptionPane.showMessageDialog(null, "Insufficient Funds", "Error", 1);
            
        }
    }
}