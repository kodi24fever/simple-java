package util;

import java.io.*;

public class Teacher implements CSVPrintable {

    public static final String OUTPUT = System.getProperty("user.dir") + "/output/";
    String fileName = OUTPUT + "out.csv";
    //printer object and using file writer to append info to file instead of erasing the old one
    PrintWriter out = new PrintWriter(new FileWriter(fileName, true));

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
        out.println(getName() + "," + getID() + "," + this.phoneNUmber);

        out.flush();
        out.close();
    }

    //Constructor
    public Teacher(String firstName, String lastName, int teacherID, int phoneNUmber) throws IOException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherID = teacherID;
        this.phoneNUmber = phoneNUmber;
    }

}
