package util;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TA extends Student{

    private int studentID;
    private int teacherID;
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
        if(this.studentID > this.teacherID){
            this.IDOfTA = studentID;
        }else if(this.teacherID > this.studentID){
            this.IDOfTA = teacherID;
        }else if(this.studentID == this.teacherID){
            this.IDOfTA = this.studentID;
        }
        return IDOfTA;
    }

    /**
     * Teacher Alex,Martinez 0 98765 3053489999
     *     Student Rose,Gonzales 56789 0 9876543210
     *     TA John,Cruz 88888 99999 1234567890
     *
     */


    @Override
    public void csvPrintln() {
        out.println(super.getName() + "," + getID() + "," + this.phone);

        out.flush();
        out.close();
    }

    // Constructor
    public TA(String firstName, String lastName, int studentID,int teacherID, long phoneNumber) throws IOException {
        super(firstName, lastName, studentID, phoneNumber);
        this.studentID = studentID;
        this.teacherID = teacherID;
        this.phone = phoneNumber;
    }

}
