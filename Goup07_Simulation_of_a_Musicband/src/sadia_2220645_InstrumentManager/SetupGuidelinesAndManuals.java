/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class SetupGuidelinesAndManuals implements Serializable {
    String instrumentName,guidelines,manuals;

    public SetupGuidelinesAndManuals(String instrumentName, String guidelines, String manuals) {
        this.instrumentName = instrumentName;
        this.guidelines = guidelines;
        this.manuals = manuals;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(String guidelines) {
        this.guidelines = guidelines;
    }

    public String getManuals() {
        return manuals;
    }

    public void setManuals(String manuals) {
        this.manuals = manuals;
    }

    @Override
    public String toString() {
        return  "\nInstrumentName=" + instrumentName + "\n Guidelines :" + guidelines + "\n Manuals :" + manuals ;
    }
    
    
    
}
