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
    
    public static void writeMgsList(ObservableList<LyricsAndSpecialMgs> mgsList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MgsList.bin"))) {
            for (LyricsAndSpecialMgs mgs : mgsList) {
                oos.writeObject(mgs);
            }
            System.out.println("Message list updated and written to MgsList.bin");
        } catch (IOException e) {
            System.out.println("Error writing updated message list to file");
            e.printStackTrace();
        }
    }

    public static void writeLyricsList(ObservableList<LyricsAndSpecialMgs> lyricsList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("LyricsList.bin"))) {
            for (LyricsAndSpecialMgs lyrics : lyricsList) {
                oos.writeObject(lyrics);
            }
            System.out.println("Lyrics list updated and written to LyricsList.bin");
        } catch (IOException e) {
            System.out.println("Error writing updated lyrics list to file");
            e.printStackTrace();
        }
    }

    public static ObservableList<LyricsAndSpecialMgs> readMgsList() {
        ObservableList<LyricsAndSpecialMgs> mgsList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MgsList.bin"))) {
            while (true) {
                try {
                    LyricsAndSpecialMgs mgs = (LyricsAndSpecialMgs) ois.readObject();
                    mgsList.add(mgs);
                } catch (EOFException e) {
                    // End of file reached, exit the loop
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mgsList;
    }

    public static ObservableList<LyricsAndSpecialMgs> readLyricsList() {
        ObservableList<LyricsAndSpecialMgs> lyricsList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("LyricsList.bin"))) {
            while (true) {
                try {
                    LyricsAndSpecialMgs lyrics = (LyricsAndSpecialMgs) ois.readObject();
                    lyricsList.add(lyrics);
                } catch (EOFException e) {
                    // End of file reached, exit the loop
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lyricsList;
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
    
    
    
    
    
}
    
    
    




   