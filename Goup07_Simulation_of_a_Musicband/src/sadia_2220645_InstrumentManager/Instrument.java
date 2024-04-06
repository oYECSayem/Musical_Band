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
    private int price;
    private String brandName;
    
    
    public Instrument(String name, String serialNumber, String model, int InstrumentID, int qantity) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.model = model;
        this.InstrumentID = InstrumentID;
        this.qantity = qantity;
    }

    public Instrument(String name, String model, int price, String brandName) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.brandName = brandName;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Instrument{" + "name=" + name + ", serialNumber=" + serialNumber + ", model=" + model + ", InstrumentID=" + InstrumentID + ", qantity=" + qantity + '}';
    }

  
    
}
