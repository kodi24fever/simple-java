package util;

public class Student implements CSVPrintable {
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
        System.out.println(getName() + "," + getID() + "," + this.phoneNUmber);
    }

    public Student(String firstName, String lastName, long phoneNumber, int studentID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNUmber = phoneNumber;
        this.studentID = studentID;
    }

}
