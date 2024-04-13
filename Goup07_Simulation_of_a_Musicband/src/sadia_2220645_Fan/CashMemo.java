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
public class CashMemo implements Serializable {
    
    private String name,adderss,merchandiseInfo,paymentMode;
    private int phoneNum;

    public CashMemo(String name, String adderss, String merchandiseInfo, String paymentMode, int phoneNum) {
        this.name = name;
        this.adderss = adderss;
        this.merchandiseInfo = merchandiseInfo;
        this.paymentMode = paymentMode;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdderss() {
        return adderss;
    }

    public void setAdderss(String adderss) {
        this.adderss = adderss;
    }

    public String getMerchandiseInfo() {
        return merchandiseInfo;
    }

    public void setMerchandiseInfo(String merchandiseInfo) {
        this.merchandiseInfo = merchandiseInfo;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\nname:").append(name);
        sb.append(""
                + "\nadderss=").append(adderss);
        sb.append("\nmerchandiseInfo=").append(merchandiseInfo);
        sb.append("\npaymentMode=").append(paymentMode);
        sb.append("\nphoneNum=").append(phoneNum);
       
        return sb.toString();
    }
    
    
   
}
