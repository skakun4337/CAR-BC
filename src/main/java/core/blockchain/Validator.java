package core.blockchain;

public class Validator {

    private String validator;
    private String isMandotory;
    private String role;
    private int priority;

    public Validator(String validator, String role, String isMandotory, int priority){
        this.validator = validator;
        this.role = role;
        this.setIsMandotory(isMandotory);
        this.priority = priority;
    }

    public String getValidator() {
        return validator;
    }

    public String isMandotory() {
        return getIsMandotory();
    }

    public String getRole() {
        return role;
    }

    public int getPriority() {
        return priority;
    }


    public void setValidator(String validator) {
        this.validator = validator;
    }

    public void setMandotory(String mandotory) {
        setIsMandotory(mandotory);
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getIsMandotory() {
        return isMandotory;
    }

    public void setIsMandotory(String isMandotory) {
        this.isMandotory = isMandotory;
    }


//    @Override
//    public String toString(){
//
//        return "'Validator:'" + this.validator+"'isMandatory:'" + this.isMandotory + "'role'" + this.role + "'Priority'" + this.priority;
//    }
//

}
