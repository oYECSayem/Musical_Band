package milad_2221768_bandPromoter;

import MainPkg.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Campaign implements Serializable{
    public String venue;
    public String details;
    public LocalDate date;

    public Campaign(String venue, String details, LocalDate date) {
        this.venue = venue;
        this.details = details;
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Campaign " + "\n"  + "Venue: " + venue + "\n" + "Details: " + details + "\n" + "Date=" + date;
        
    }
    
    

    public static void addCampaign(Campaign i){
        //productNameList.add(productFXMLName);
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Campaign.bin");
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
            Logger.getLogger(Campaign.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Campaign.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
