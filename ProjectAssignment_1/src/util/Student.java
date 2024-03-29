/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;

    public String getFirstName() {return firstName;}
    public String getLastName() {
        return lastName;
    }
    public int getPid() {
        return pid;
    }
    public Grade getGrade() {
        return grade;
    }

    // Returns student information in String format
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.pid + " " + this.grade.getScore();
    }

    // Constructor for Student
    public Student(String firstName, String lastName, int pid, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = new Grade(grade);
    }
}
