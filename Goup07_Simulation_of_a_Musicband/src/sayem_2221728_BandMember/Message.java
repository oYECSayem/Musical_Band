package sayem_2221728_BandMember;

import java.io.Serializable;


public class Message implements Serializable {
    String senderName, text;

    public Message(String senderName, String text) {
        this.senderName = senderName;
        this.text = text;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" + "senderName=" + senderName + ", text=" + text + '}';
    }
    
}
