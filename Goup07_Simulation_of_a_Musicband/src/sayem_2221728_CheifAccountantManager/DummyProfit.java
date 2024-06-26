package sayem_2221728_CheifAccountantManager;

import java.time.LocalDate;


public class DummyProfit {
    LocalDate date;
    String eventName;
    float expense;
    float income;
    float profit;

    public DummyProfit(LocalDate date, String eventName, float expense, float income, float profit) {
        this.date = date;
        this.eventName = eventName;
        this.expense = expense;
        this.income = income;
        this.profit = profit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public float getExpense() {
        return expense;
    }

    public void setExpense(float expense) {
        this.expense = expense;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "DummyProfit{" + "date=" + date + ", eventName=" + eventName + ", expense=" + expense + ", income=" + income + ", profit=" + profit + '}';
    }
    
}
