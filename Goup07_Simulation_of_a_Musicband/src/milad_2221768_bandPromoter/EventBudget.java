package milad_2221768_bandPromoter;

public class EventBudget {
    public String eventName;
    public String requirement;
    public int quantity;
    public int budget;

    public EventBudget(String eventName, String requirement, int quantity, int budget) {
        this.eventName = eventName;
        this.requirement = requirement;
        this.quantity = quantity;
        this.budget = budget;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
    
}
