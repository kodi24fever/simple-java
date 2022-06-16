package util;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TA extends Student{

    private int IDOfTA;
    private long phone;


    public static final String OUTPUT = System.getProperty("user.dir") + "/output/";
    String fileName = OUTPUT + "out.csv";
    //printer object and using file writer to append info to file instead of erasing the old one
    PrintWriter out = new PrintWriter(new FileWriter(fileName, true));

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getID() {
        return IDOfTA;
    }

    @Override
    public void csvPrintln() {
        out.println(super.getName() + "," + getID() + "." + this.phone);

        out.flush();
        out.close();
    }

    // Constructor
    public TA(String firstName, String lastName, int studentID,long phoneNumber) throws IOException {
        super(firstName, lastName, studentID, phoneNumber);
        this.IDOfTA = studentID;
        this.phone = phoneNumber;
    }

}
