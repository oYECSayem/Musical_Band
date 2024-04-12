package milad_2221768_marchendiseManager;

import MainPkg.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Merchant implements Serializable{
    public String productName;
    public int quantity;
    public int investedPrice;
    public int sellingPrice;
    public String description;

    public Merchant() {
        this.productName = null;
        this.quantity = 0;
        this.investedPrice = 0;
        this.sellingPrice = 0;
        this.description = null;
    }
    public Merchant(String productName, int quantity, int investedPrice, int sellingPrice, String description) {
        this.productName = productName;
        this.quantity = quantity;
        this.investedPrice = investedPrice;
        this.sellingPrice = sellingPrice;
        this.description = description;
    }
    

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getInvestedPrice() {
        return investedPrice;
    }

    public void setInvestedPrice(int investedPrice) {
        this.investedPrice = investedPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public static void addMerchant(Merchant i){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Merchant.bin");
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
            Logger.getLogger(Merchant.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Merchant.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
   
    
}
