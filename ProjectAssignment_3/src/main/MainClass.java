package main;

import util.Student;

public class MainClass {
    public static void main(String[] args){

        Student student = new Student("Alex", "rodriguez", 1234567890, 1234567);

        
        student.csvPrintln();



    }
}
