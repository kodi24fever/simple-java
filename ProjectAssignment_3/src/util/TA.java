package util;

import java.io.FileNotFoundException;

public class TA extends Student{

    private int IDOfTA;
    private long phone;

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
        System.out.println(super.getName() + "," + getID() + "." + this.phone);
    }

    // Constructor
    public TA(String firstName, String lastName, int studentID,long phoneNumber) throws FileNotFoundException{
        super(firstName, lastName, studentID, phoneNumber);
        this.IDOfTA = studentID;
        this.phone = phoneNumber;
    }

}
