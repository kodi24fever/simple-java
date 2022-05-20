package Asignment_3_q5;

import Asignment_3_q5.Student;

public class TA extends Student {
    private String course;
    private String section;

    public TA(String firstName, String lastName, double weight, int studentID, double gpa, String universityName, String course, String section){
        super(firstName, lastName, weight, studentID, gpa, universityName);
        this. course = course;
        this. section = section;
    }

    // GEt Methods
    public String getCourse(){return course;}
    public String getSection(){return section;}

    // Set Methods
    public void setCourse(String course){this.course = course;}
    public void setSection(String section){this.course = section;}

}
