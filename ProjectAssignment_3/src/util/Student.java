package util;

import java.io.PrintWriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Student implements CSVPrintable {

    public static final String OUTPUT = System.getProperty("user.dir") + "/output/";
    //printer object
    PrintWriter out = new PrintWriter(OUTPUT + "out.csv");
    private String firstName;
    private String lastName;
    private long phoneNUmber;
    private int studentID;

    @Override
    public String getName(){
        // Capitalize first and last name
        String firstName = this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1).toLowerCase();
        String lastName = this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1).toLowerCase();

        return firstName + "," + lastName;
    }

    @Override
    public int getID() {
        return this.studentID;
    }

    @Override
    public void csvPrintln() {
        // Here instead of printing PRINT to csv file directly
        out.println(getName() + "," + getID() + "," + this.phoneNUmber);

        out.flush();
        out.close();
    }

    public Student(String firstName, String lastName, int studentID, long phoneNumber) throws FileNotFoundException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.phoneNUmber = phoneNumber;
    }

}
