import java.io.Serializable;
import java.util.List;

public class TechnicalSupportMessage implements Serializable {
    private String name;
    private String text;
    private List<String> instrumentNames; // Storing instrument names as a List<String>
    private List<String> roles; // Storing roles as a List<String>
    private String problemType; // Storing problem type as a string
    
    public TechnicalSupportMessage(String name, String text, List<String> instrumentNames, List<String> roles, String problemType) {
        this.name = name;
        this.text = text;
        this.instrumentNames = instrumentNames;
        this.roles = roles;
        this.problemType = problemType;
    }
    
    // Getters and setters
    
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

    public List<String> getInstrumentNames() {
        return instrumentNames;
    }

    public void setInstrumentNames(List<String> instrumentNames) {
        this.instrumentNames = instrumentNames;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
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
        return "TechnicalSupportMessage{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", instrumentNames=" + instrumentNames +
                ", roles=" + roles +
                ", problemType='" + problemType + '\'' +
                '}';
    }
}
