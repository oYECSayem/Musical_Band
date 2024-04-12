package sayem_2221728_BandMember;

import MainPkg.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BandMember extends User implements Serializable {
    
    public BandMember(String fullName, String userName, String phoneNumber,
            String password, LocalDate Dob) {
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
    
    public static void replyMessage(Message msg){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("fanFeedBackMessage.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new MainPkg.AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(msg);

        } catch (IOException ex) {
            Logger.getLogger(Message .class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Message .class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public static void giveCollabrationSchedule(EventSchedule eSc){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("EventSchedule.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new MainPkg.AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(eSc);

        } catch (IOException ex) {
            Logger.getLogger(EventSchedule .class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(EventSchedule .class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public static void askForTechnicalSupport(Message msg){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("TechnicalSupportMessage.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new MainPkg.AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(msg);

        } catch (IOException ex) {
            Logger.getLogger(Message .class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Message .class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
