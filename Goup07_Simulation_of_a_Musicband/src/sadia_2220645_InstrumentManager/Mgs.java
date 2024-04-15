/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class Mgs implements Serializable {
    String name,Textdescription;
    LocalDate shcedule;

    public Mgs(String name, String Textdescription, LocalDate shcedule) {
        this.name = name;
        this.Textdescription = Textdescription;
        this.shcedule = shcedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextdescription() {
        return Textdescription;
    }

    public void setTextdescription(String Textdescription) {
        this.Textdescription = Textdescription;
    }

    public LocalDate getShcedule() {
        return shcedule;
    }

    public void setShcedule(LocalDate shcedule) {
        this.shcedule = shcedule;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMessage :");
        sb.append("\nSender Name :").append(name);
        sb.append("\nText Description=").append(Textdescription);
        sb.append("\nMeet shcedule :").append(shcedule);
        //sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
