/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 *
 * @author USER
 */
public class DefectedInstrument implements Serializable {
    
    int defectedInstrumentId ;
    String defectedInstrumentName,problemDescription,defectCatagory;

    public DefectedInstrument(int defectedInstrumentId, String defectedInstrumentName, String problemDescription, String defectCatagory) {
        this.defectedInstrumentId = defectedInstrumentId;
        this.defectedInstrumentName = defectedInstrumentName;
        this.problemDescription = problemDescription;
        this.defectCatagory = defectCatagory;
    }

    public int getDefectedInstrumentId() {
        return defectedInstrumentId;
    }

    public void setDefectedInstrumentId(int defectedInstrumentId) {
        this.defectedInstrumentId = defectedInstrumentId;
    }

    public String getDefectedInstrumentName() {
        return defectedInstrumentName;
    }

    public void setDefectedInstrumentName(String defectedInstrumentName) {
        this.defectedInstrumentName = defectedInstrumentName;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getDefectCatagory() {
        return defectCatagory;
    }

    public void setDefectCatagory(String defectCatagory) {
        this.defectCatagory = defectCatagory;
    }

    @Override
    public String toString() {
        return "DefectedInstrument{" + "DefectedInstrument Id=" + defectedInstrumentId + ", defectedInstrument Name=" + defectedInstrumentName +
                ", Problem Description=" + problemDescription + ", Defect Catagory=" + defectCatagory + '}';
    }
    
    
    public static boolean checkDefectedInstrumentExixtance(DefectedInstrument x) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
            DefectedInstrument i;
            ois = new ObjectInputStream(new FileInputStream("DefectedInstrument.bin.bin"));

            while (true) {
                i = (DefectedInstrument) ois.readObject();
                if (i.getDefectedInstrumentId() == x.getDefectedInstrumentId()) {
                    result = true;
                }

            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return result;
    
    }
    
}
