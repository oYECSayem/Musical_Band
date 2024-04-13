/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sadia_2220645_Fan;

import MainPkg.User;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sadia_2220645_InstrumentManager.Instrument;


/**
 *
 * @author USER
 */
public class Fan extends User implements Serializable {


    public Fan(String fullName, String userName, String phoneNumber, String password, LocalDate Dob) {
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
        sb.append("Fan{");
        sb.append('}');
        return sb.toString();
    }
    
    
    //----------------------------feedback write-----------------
    
       
    public static void giveFeedback(Feedback fb){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Feedback.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new MainPkg.AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(fb);

        } catch (IOException ex) {
            Logger.getLogger(Feedback .class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Feedback .class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    //-----------------------------Special Mgs AND lYRICS-------------------------------
    
    
     public static void submitSpecialMgsAndLyrics(LyricsAndSpecialMgs m){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("LyricsAndSpecialMgs.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new MainPkg.AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(m);

        } catch (IOException ex) {
            Logger.getLogger(Feedback .class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Feedback .class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     
     
     public static void Purchasemerchandise(CashMemo c){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("CashMemo.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new MainPkg.AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(c);

        } catch (IOException ex) {
            Logger.getLogger(CashMemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CashMemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
    
    
}
    
    
    




   