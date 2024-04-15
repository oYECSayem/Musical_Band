/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sadia_2220645_Fan;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class LyricsAndSpecialMgs implements Serializable {
    String senderName,lyrics,massage;

    public LyricsAndSpecialMgs(String senderName, String lyrics, String massage) {
        this.senderName = senderName;
        this.lyrics = lyrics;
        this.massage = massage;
    }

   /* public LyricsAndSpecialMgs(String senderName, String massage) {
        this.senderName = senderName;
        this.massage = massage;
    }

   
    

    public LyricsAndSpecialMgs(String lyrics) {
        this.lyrics = lyrics;
    }*/

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\nsenderName :").append(senderName);
        sb.append("\n lyrics :").append(lyrics);
        sb.append("\nmassage :").append(massage);
        return sb.toString();
    }

    
    
    
    
}
