package util;

public class Teacher implements CSVPrintable {

    private String firstName;
    private String lastName;
    private int teacherID;
    private int phoneNUmber;


    @Override
    public String getName() {
        return null;
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
