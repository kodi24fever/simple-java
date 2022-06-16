package util;

public class TA extends Student{

    private int IDOfTA;
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
        super.csvPrintln();
    }

    // Constructor
    public TA(String firstName, String lastName, int studentID,long phoneNumber){
        super(firstName, lastName, studentID, phoneNumber);
        this.IDOfTA = studentID;
    }

}
