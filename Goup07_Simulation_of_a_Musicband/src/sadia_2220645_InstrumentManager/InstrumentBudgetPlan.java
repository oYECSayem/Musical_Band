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
public class InstrumentBudgetPlan implements Serializable {
    
    private String name,model,brandname;
    private int price, qantity,totalprice;

    public InstrumentBudgetPlan(String name, String model, String brandname, int price, int qantity, int totalprice) {
        this.name = name;
        this.model = model;
        this.brandname = brandname;
        this.price = price;
        this.qantity = qantity;
        this.totalprice = totalprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQantity() {
        return qantity;
    }

    public void setQantity(int qantity) {
        this.qantity = qantity;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InstrumentBudgetPlan{");
        sb.append("name=").append(name);
        sb.append(", model=").append(model);
        sb.append(", brandname=").append(brandname);
        sb.append(", price=").append(price);
        sb.append(", qantity=").append(qantity);
        sb.append(", totalprice=").append(totalprice);
        sb.append('}');
        return sb.toString();
    }
    
    
   
    
    
}
