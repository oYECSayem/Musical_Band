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
public class Message implements Serializable {
    String name,Textdescription;
    LocalDate shcedule;

    public Message(String name, String Textdescription, LocalDate shcedule) {
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
        sb.append("Message{");
        sb.append("name=").append(name);
        sb.append(", Textdescription=").append(Textdescription);
        sb.append(", shcedule=").append(shcedule);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
