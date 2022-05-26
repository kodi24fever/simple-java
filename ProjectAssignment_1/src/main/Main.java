package main;
import util.*;

import java.util.Scanner; // Import java.util.Scanner for getting user input
import java.util.ArrayList; // Import arrrayList to create studnets

public class Main {
    public static void main(String[] args) {

        // Variable declaration
        String splited[] = {};

        // Scanner for user input
        Scanner s = new Scanner(System.in); // Scanner for user input

        // Getting GradeBook obj
        Gradebook gradebook = new Gradebook();

        /**
         *  Welcome message for user
         *  This message should show when student list is empty
         */
        System.out.println("Welcome to my grade book!");


        // While loop for adding students to arrayList
        while(true){
            if(gradebook.getListOfStudents().size() < 1) {
                System.out.println("Please enter the information of the first student using the following format:");
                System.out.println("\"firstName lastName PID grade\"");
                System.out.println("Press Enter when you are done");

                // String to get user input
                String wholeStudent = s.nextLine();

                // Splits whole input string into separate strings in an array
                splited = wholeStudent.split(" ");

                if(wholeStudent.toLowerCase().matches("done")) {
                    break;
                }else if(splited.length != 4){
                    System.out.println("Student information is not complete or accurate.");
                    continue;
                } else {
                    //Getting Student OBJ
                    Student student = new Student(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));

                    //Validate student information
                    ValidateStudentInformation val = new ValidateStudentInformation(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));

                    if(val.studentMeetsRequirements()){
                        gradebook.addStudent(student);
                    }else {
                        if(!val.showFN()){System.out.println("Name is wrong! Try Again.");}
                        if(!val.showLN()){System.out.println("Last Name is wrong! Try Again.");}
                        if(!val.showPIDBol()){System.out.println("PID is wrong! Try Again.");}
                        if(!val.showGrade()){System.out.println("Grade is wrong! Try Again.");}
                    }
                }

            }
            if(gradebook.getListOfStudents().size() >= 1){
                /**
                 *  Repeated info to keep adding students
                 */
                System.out.println("Please enter the information of the next student in the same format.");
                System.out.println("if there is no more students, please enter the keyword \"DONE\"");
                System.out.println("Press Enter when you are done");

                //String to get user input
                String wholeStudent = s.nextLine();
                //Splits whole input string into separate strings in an array
                splited = wholeStudent.split(" ");

                // Splits whole input string into separate strings in an array
                splited = wholeStudent.split(" ");

                if(wholeStudent.toLowerCase().matches("done")){
                    break;
                }else if(splited.length != 4){
                    System.out.println("Student information is not complete or accurate.");
                    continue;
                } else {
                    //Getting Student OBJ
                    Student student = new Student(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));

                    //Validate student information
                    ValidateStudentInformation val = new ValidateStudentInformation(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));

                    if(val.studentMeetsRequirements()){
                        gradebook.addStudent(student);
                    }else {
                        if(!val.showFN()){System.out.println("Name is wrong! Try Again.");}
                        if(!val.showLN()){System.out.println("Last Name is wrong! Try Again.");}
                        if(!val.showPIDBol()){System.out.println("PID is wrong! Try Again.");}
                        if(!val.showGrade()){System.out.println("Grade is wrong! Try Again.");}
                    }
                }
            }
        }

        // While loop for entering commands
        while(true){
            System.out.println("Please enter any command for list");
            // String to get user input
            String wholeStudent = s.nextLine();

            // Splits whole input string into separate strings in an array
            splited = wholeStudent.split(" ");

            if(wholeStudent.toLowerCase().matches("quit")){break;}
            if(wholeStudent.toLowerCase().matches("min score")){
                System.out.println("The min score of all students is: " + gradebook.findMinScore());
            }
            if(wholeStudent.toLowerCase().matches("min letter")){
                System.out.println("The min letter of all students is: " + gradebook.findMinLetter());
            }
            if(wholeStudent.toLowerCase().matches("max score")){
                System.out.println("The max score of all students is: " + gradebook.findMaxScore());
            }
            if(wholeStudent.toLowerCase().matches("max letter")){
                System.out.println("The max letter of all students is: " + gradebook.findMaxLetter());
            }
            if(splited[0].matches("letter")){
                System.out.println(gradebook.findLetterGrade(Integer.parseInt(splited[1])));
            }
            if(splited[0].matches("name")){
                System.out.println(gradebook.findName(Integer.parseInt(splited[1])));
            }
            if(splited[0].matches("change")){
                System.out.println(gradebook.changeGrade(Integer.parseInt(splited[1]), Integer.parseInt(splited[2])));
            }
            if(wholeStudent.toLowerCase().matches("average score")){
                System.out.println(gradebook.calculateAvg());
            }
            if(wholeStudent.toLowerCase().matches("average letter")){
                System.out.println("Average letter is: " + gradebook.calculateAvgLetter());
            }
            if(wholeStudent.toLowerCase().matches("median score")){
                System.out.println("Median score is: " + gradebook.calculateMedian());
            }
            if(wholeStudent.toLowerCase().matches("median letter")){
                System.out.println("Median letter is: " + gradebook.calculateMedianLetter());
            }
            if(wholeStudent.toLowerCase().matches("tab scores")){
               gradebook.printAllStudents();
            }
            if(wholeStudent.toLowerCase().matches("tab letters")){
                gradebook.printAllStudentsLetters();
            }
        }

        System.out.println(gradebook.getListOfStudents());


    }
}
