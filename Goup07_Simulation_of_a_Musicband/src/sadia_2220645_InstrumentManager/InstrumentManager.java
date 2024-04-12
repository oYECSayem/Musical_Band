/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import MainPkg.AppendableObjectOutputStream;
import MainPkg.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class InstrumentManager extends User implements Serializable  {
    
    public InstrumentManager(String fullName, String userName, String phoneNumber, String password, LocalDate Dob) {
        super(fullName, userName, phoneNumber, password, Dob);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate Dob) {
        this.Dob = Dob;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InstrumentManager{");
        sb.append('}');
        return sb.toString();
    }
    
    
    //------------------------Instrument Track file-----------------
    public static void addInstrument(Instrument i){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Instrument.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(Instrument.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Instrument.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
    //----------------------------New updated Instrument---------------------------
    
     public static void makeNewUpdatedInstrumentPurchasePlan(Instrument ni){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("NewUpdatedInstrument.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(ni);

        } catch (IOException ex) {
            Logger.getLogger(Instrument.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Instrument.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     
     //--------------------- Budge plan file write------------------
     
     public static void makeBudgetForIntrument(Instrument budget){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("InstrumentBudgetPlan.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(budget);

        } catch (IOException ex) {
            Logger.getLogger(Instrument.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Instrument.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     
 //-------------------------------  Defacted Instrumens---------------------------------------
      public static void makeDefactedIntrumentList(DefectedInstrument di ){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("DefectedInstrument.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(di);

        } catch (IOException ex) {
            Logger.getLogger(DefectedInstrument.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(DefectedInstrument.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
      
      
     
    
}


