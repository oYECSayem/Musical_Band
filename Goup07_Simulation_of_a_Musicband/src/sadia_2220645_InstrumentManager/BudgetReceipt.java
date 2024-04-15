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

   private String BudgetDescription;

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
    
    
    
    
    

}
