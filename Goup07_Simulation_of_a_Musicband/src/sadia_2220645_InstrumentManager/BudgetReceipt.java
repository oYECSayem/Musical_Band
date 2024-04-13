/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import MainPkg.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class BudgetReceipt implements Serializable {

    String BudgetDescription;

    public BudgetReceipt(String BudgetDescription) {
        this.BudgetDescription = BudgetDescription;
    }

    public String getBudgetDescription() {
        return BudgetDescription;
    }

    public void setBudgetDescription(String BudgetDescription) {
        this.BudgetDescription = BudgetDescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\nBudgetDescription :").append(BudgetDescription);
       
        return sb.toString();
    }
    
    
    public static void sendBudgetReceipt(BudgetReceipt  s ){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("BudgetReceipt.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(s);

        } catch (IOException ex) {
            Logger.getLogger(BudgetReceipt .class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(BudgetReceipt .class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    

}
