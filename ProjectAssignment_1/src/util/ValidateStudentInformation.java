package util;

public class ValidateStudentInformation {
    private String firstName;
    private String lastName;
    private int pid;
    private int grade;

    // Boolean variables to check if student info meets requirements
    private boolean FNBol;
    private boolean LNBol;
    private boolean pidBol;
    private boolean gradeBol;

    /**
     *  Checks if firstName meets the requirements
     *
     * 1.String.matches("[a-zA-Z]+") to check it it has alphabet characters
     * 2.Character.isUpperCase(name.charAt(0)) to check if first character is upper case
     * 3."ABC".isBlank() ); ===> false  to check if it has white spaces or empty string
     */
    public void validateFirstName(){
        if(this.firstName.matches("[a-zA-Z]+") && Character.isUpperCase(this.firstName.charAt(0)) && !this.firstName.isBlank()){
            FNBol = true;
        }else FNBol = false;
    }

    /**
     *  Checks if lastName meets the requirements
     *
     * 1.String.matches("[a-zA-Z]+") to check it it has alphabet characters
     * 2.Character.isUpperCase(name.charAt(0)) to check if first character is upper case
     * 3."ABC".isBlank() ); ===> false  to check if it has white spaces or empty string
     * 4.String.contains(".") to check if contains a dot
     */
    public void validateLastName() {
        if(this.lastName.matches("[a-zA-Z]+") && Character.isUpperCase(this.lastName.charAt(0)) && !this.lastName.isBlank()){
            LNBol = true;
        }else LNBol = false;
    }

    // Checks for pid if is 7 digits number and does not start with 0
    public void validatePID(){
        String pid = Integer.toString(this.pid);

        if(String.valueOf(this.pid).length() == 7 && !(pid.startsWith("0")) || pid.startsWith("00")){
            this.pidBol = true;
        }else this.pidBol = false;
    }

    // Checks if grade is in the range of 0 to 100 including 0 and 100
    public void validateGrade() {
        if(this.grade >= 0 && this.grade <= 100){
            gradeBol = true;
        }else gradeBol = false;
    }

    /**
     * Checks for all boolean to be true to create Student object
     */
    public boolean studentMeetsRequirements(){
        if(FNBol && LNBol && pidBol && gradeBol){
            return true;
        }else return false;
    }

//    Validate Show for testing purposes only
//    public boolean showFN(){
//        return FNBol;
//    }
//    public boolean showLN(){
//            return LNBol;
//        }
//    public boolean showGrade(){
//        return gradeBol;
//    }
//    public boolean showPIDBol(){
//        return pidBol;
//    }

    // Constructor for student information validation
    public ValidateStudentInformation(String firstName, String lastName, int pid, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;

        // Calling validator setters
        validateFirstName();
        validateLastName();
        validatePID();
        validateGrade();
    }
}
