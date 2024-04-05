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
public class Instrument implements Serializable {
    private String name, serialNumber, model;
    private int InstrumentID, qantity;

    public Instrument(String name, String serialNumber, String model, int InstrumentID, int qantity) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.model = model;
        this.InstrumentID = InstrumentID;
        this.qantity = qantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getInstrumentID() {
        return InstrumentID;
    }

    public void setInstrumentID(int InstrumentID) {
        this.InstrumentID = InstrumentID;
    }

    public int getQantity() {
        return qantity;
    }

    public void setQantity(int qantity) {
        this.qantity = qantity;
    }

    @Override
    public String toString() {
        return "Instrument{" + "Name=" + name + ", SerialNumber=" + serialNumber + ", Model=" + model + ", InstrumentID=" + InstrumentID + ", Qantity=" + qantity + '}';
    }
    
    

}
