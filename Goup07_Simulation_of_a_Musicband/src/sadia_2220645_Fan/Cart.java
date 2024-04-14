/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sadia_2220645_Fan;

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
public class Cart implements Serializable {
    private String selectedMerchandiseInfo;

    public Cart(String selectedMerchandiseInfo) {
        this.selectedMerchandiseInfo = selectedMerchandiseInfo;
    }

    public String getSelectedMerchandiseInfo() {
        return selectedMerchandiseInfo;
    }

    public void setSelectedMerchandiseInfo(String selectedMerchandiseInfo) {
        this.selectedMerchandiseInfo = selectedMerchandiseInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nselectedMerchandiseInfo:").append(selectedMerchandiseInfo);
        return sb.toString();
    }

    
      public static void addMerchandiseTotheCart(Cart c) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Cart.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new MainPkg.AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(c);

        } catch (IOException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
    
}
