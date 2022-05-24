package main;
import util.*;

import java.util.Scanner; // Import java.util.Scanner for getting user input
import java.util.ArrayList; // Import arrrayList to create studnets

public class Main {
    // ArrayList of students but I should use gradebook class to add students to gradebook class
    private static ArrayList<Student> studentsList = new ArrayList<Student>();

    // Method to check student information and add it to arraylist
    private static void addStudent(String wholeStudent){
        String splited[];
        // Splits whole input string into separate strings in an array
        splited = wholeStudent.split(" ");

        //Getting Student OBJ
        Student student = new Student(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));

        //Validate student information
        ValidateStudentInformation val = new ValidateStudentInformation(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));

        if(val.studentMeetsRequirements()){
            studentsList.add(student);
            System.out.println(studentsList);
        }else System.out.println("Sorry, the information provided is not correct.\n Try again!\n");
    }

    /**
     * MAIN: Where all starts!!
     */
    public static void main(String[] args) {
        // Scanner for user input
        Scanner myObj = new Scanner(System.in); // Scanner for user input

        // While loop when list is empty
        while(studentsList.size() < 1){
            /**
             *  Welcome message for user
             */
            // This message should show when student list is empty
            System.out.println("Welcome to my grade book!");
            System.out.println("Please enter the information of the first student using the following format:");
            System.out.println("\"firstName lastName PID grade\"");
            System.out.println("Press Enter when you are done");

            // String to get user input
            String wholeStudent = myObj.nextLine();
            String splited[];
            // Splits whole input string into separate strings in an array
            splited = wholeStudent.split(" ");

            if(splited.length != 4){
                System.out.println("Student information is not complete or accurate");
                continue;
            } else addStudent(wholeStudent);
        }

        while(studentsList.size() >= 1){
            /**
             *  Repeated info to keep adding students
             */
            System.out.println("Please enter the information of the next student in the same format.");
            System.out.println("if there is no more students, please enter the keyword \"DONE\"");
            System.out.println("Press Enter when you are done");

            // String to get user input
            String wholeStudent = myObj.nextLine();
            String splited[];
            // Splits whole input string into separate strings in an array
            splited = wholeStudent.split(" ");

            if(wholeStudent.toLowerCase().matches("done")){
                break;
            }else if(splited.length != 4){
                System.out.println("Student information is not complete or accurate");
                continue;
            } else addStudent(wholeStudent);

        }
    }




}
