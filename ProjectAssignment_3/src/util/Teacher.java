package util;

public class Teacher implements CSVPrintable {

    private String firstName;
    private String lastName;
    private int teacherID;
    private int phoneNUmber;


    @Override
    public String getName(){
        // Capitalize first and last name
        String firstName = this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1).toLowerCase();
        String lastName = this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1).toLowerCase();

        return firstName + "," + lastName;
    }

    @Override
    public int getID() {
        return this.teacherID;
    }

    @Override
    public void csvPrintln() {

    }

    //Constructor
    public Teacher(String firstName, String lastName, int teacherID, int phoneNUmber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherID = teacherID;
        this.phoneNUmber = phoneNUmber;
    }

}
