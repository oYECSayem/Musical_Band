package sayem_2221728_BandMember;

import java.io.Serializable;

public class TechnicalSupportMessage implements Serializable {
    String name, text, instrumentNames, roles, problemType;

    public TechnicalSupportMessage(String name, String text, String instrumentNames, String roles, String problemType) {
        this.name = name;
        this.text = text;
        this.instrumentNames = instrumentNames;
        this.roles = roles;
        this.problemType = problemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInstrumentNames() {
        return instrumentNames;
    }

    public void setInstrumentNames(String instrumentNames) {
        this.instrumentNames = instrumentNames;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TechnicalSupportMessage: ");
        sb.append("\nname=").append(name);
        sb.append("\n text=").append(text);
        sb.append("\n instrumentNames=").append(instrumentNames);
        sb.append("\n roles=").append(roles);
        sb.append("\n problemType=").append(problemType);
        sb.append("\n");
        return sb.toString();
    }
    
    
}