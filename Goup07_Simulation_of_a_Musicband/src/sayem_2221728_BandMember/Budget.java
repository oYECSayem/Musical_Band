package sayem_2221728_BandMember;

import java.io.Serializable;
import java.time.LocalDate;


public class Budget implements Serializable{
    LocalDate date;
    int ID;
    String event;
    float taxes, amount;

    public Budget(LocalDate date, int ID, String event, float taxes, float amount) {
        this.date = date;
        this.ID = ID;
        this.event = event;
        this.taxes = taxes;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setTaxes(float taxes) {
        this.taxes = taxes;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Budget: ");
        sb.append("\ndate=").append(date);
        sb.append("\n ID=").append(ID);
        sb.append("\n event=").append(event);
        sb.append("\n taxes=").append(taxes);
        sb.append("\n amount=").append(amount);
        sb.append("\n");
        return sb.toString();
    }
    
}
