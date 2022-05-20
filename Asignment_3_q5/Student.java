package Asignment_3_q5;

import Asignment_3_q5.Person;

public class Student extends Person {
    private int studentID;
    private double gpa;
    private String universityName;

    public Student( String firsName, String lastName, double weight, int studentID, double gpa, String universityName){
        super(firsName,lastName, weight);
        this.studentID = studentID;
        this.gpa = gpa;
        this.universityName = universityName;
    }

    // Get Methods
    public int getStudentID(){return studentID;}
    public double getGpa(){return gpa;}
    public String getUniversityName(){return universityName;}
}
