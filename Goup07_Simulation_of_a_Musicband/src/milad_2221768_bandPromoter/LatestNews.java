
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


public class LatestNews implements Serializable{
   public String title;
   public String news;
   public LocalDate date;

    public LatestNews(String title, String news, LocalDate date) {
        this.title = title;
        this.news = news;
        this.date = date;
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "LatestNews " + "\n" + "Title: " + title + "\n" + "News: " + news + "\n" + "Date: " + date;
    }

    
        
   
    public static void addLatestNews(LatestNews i){
        //productNameList.add(productFXMLName);
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("LatestNews.bin");
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
            Logger.getLogger(LatestNews.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(LatestNews.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
