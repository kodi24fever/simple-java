package util;

public class ValidateStudentInformation {
    private String firstName;
    private String lastName;
    private int pid;
    private int grade;

    private boolean FNBol;
    private boolean LNBol;
    private boolean pidBol;

    private boolean gradeBol;


    // Checks for pid if is 7 digits number and does not start with 0
    public void validatePID(){
        String pid = Integer.toString(this.pid);

        if(String.valueOf(this.pid).length() == 7 && !(pid.startsWith("0")) || pid.startsWith("00")){
            this.pidBol = true;
        }else this.pidBol = false;
    }


    public void validateGrade() {
        if(this.grade >= 0 && this.grade <= 100){
            gradeBol = true;
        }else gradeBol = false;
    }


    // Validate Show
    public boolean showResult(){
        return pidBol;
    }

    // Constructor
    public ValidateStudentInformation(String firstName, String lastName, int pid, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;

        // Calling validator setters 
        validatePID();
        validateGrade();

    }
}
