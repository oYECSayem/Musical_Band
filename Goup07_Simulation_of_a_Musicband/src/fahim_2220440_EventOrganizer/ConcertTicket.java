/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fahim_2220440_EventOrganizer;

/**
 *
 * @author MOSTOFA FAHIM HASAN
 */
public class ConcertTicket extends EventOrganizer {
    
    public ConcertTicket(int ticketID, int ticketPrice, int ticketQuantity, String concertDeatils, String ticketType) {
        super(ticketID, ticketPrice, ticketQuantity, concertDeatils, ticketType);
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public String getConcertDeatils() {
        return concertDeatils;
    }

    public void setConcertDeatils(String concertDeatils) {
        this.concertDeatils = concertDeatils;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "ConcertTicket{" + '}';
    }

 
    
}
