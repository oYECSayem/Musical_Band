/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sayem_2221728_BandMember;

import java.io.Serializable;


public class ExpenseEarningInfo implements Serializable{
    String eventName;
    float expense;
    float earningAmount;

    public ExpenseEarningInfo(String eventName, float expense, float earningAmount) {
        this.eventName = eventName;
        this.expense = expense;
        this.earningAmount = earningAmount;
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

    public float getEarningAmount() {
        return earningAmount;
    }

    public void setEarningAmount(float earningAmount) {
        this.earningAmount = earningAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExpenseEarningInfo: ");
        sb.append("\neventName=").append(eventName);
        sb.append("\nexpense=").append(expense);
        sb.append("\nearningAmount=").append(earningAmount);
        sb.append("\n");
        return sb.toString();
    }
    
}
