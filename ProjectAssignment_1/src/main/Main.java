package main;
import util.*;

import java.util.Scanner; // Import java.util.Scanner for getting user input
import java.util.ArrayList; // Import arrrayList to create studnets

public class Main {
    public static void main(String[] args) {

        // Variable declaration
        String splited[] = {};
        String firstName = "";
        String lastName = "";
        int pid = 0;
        double grade = 0.0;

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
                    //Validate student information
                    firstName = splited[0];
                    lastName = splited[1];
                    pid = Integer.parseInt(splited[2]);
                    grade = Double.parseDouble(splited[3]);
                    ValidateStudentInformation val = new ValidateStudentInformation(firstName, lastName, pid, grade);

                    if(val.studentMeetsRequirements()){
                        // Creates new Student obj to be added to gradebook
                        Student student = new Student(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));

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
                    firstName = splited[0];
                    lastName = splited[1];
                    pid = Integer.parseInt(splited[2]);
                    grade = Double.parseDouble(splited[3]);
                    ValidateStudentInformation val = new ValidateStudentInformation(firstName, lastName, pid, grade);

                    if(val.studentMeetsRequirements()){
                        // Creates new Student obj to be added to gradebook
                        Student student = new Student(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));

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
            else if(wholeStudent.toLowerCase().matches("min score")){
                System.out.println("The min score of all students is: " + gradebook.findMinScore());
            }
            else if(wholeStudent.toLowerCase().matches("min letter")){
                System.out.println("The min letter of all students is: " + gradebook.findMinLetter());
            }
            else if(wholeStudent.toLowerCase().matches("max score")){
                System.out.println("The max score of all students is: " + gradebook.findMaxScore());
            }
            else if(wholeStudent.toLowerCase().matches("max letter")){
                gradebook.findMaxLetter();
            }
            if(splited.length == 2 && splited[0].matches("letter")){
                System.out.println(gradebook.findLetterGrade(Integer.parseInt(splited[1])));
            }
            else if(splited.length == 2 && splited[0].matches("name")){
                System.out.println(gradebook.findName(Integer.parseInt(splited[1])));
            }
            else if(splited.length == 3 && splited[0].matches("change")){
                System.out.println(gradebook.changeGrade(Integer.parseInt(splited[1]), Double.parseDouble(splited[2])));
            }
            else if(wholeStudent.toLowerCase().matches("average score")){
                System.out.println(gradebook.calculateAvg());
            }
            else if(wholeStudent.toLowerCase().matches("average letter")){
                System.out.println("Average letter is: " + gradebook.calculateAvgLetter());
            }
            else if(wholeStudent.toLowerCase().matches("median score")){
                System.out.println("Median score is: " + gradebook.calculateMedian());
            }
            else if(wholeStudent.toLowerCase().matches("median letter")){
                System.out.println("Median letter is: " + gradebook.calculateMedianLetter());
            }
            else if(wholeStudent.toLowerCase().matches("tab scores")){
               gradebook.showTabScores();
            }
            else if(wholeStudent.toLowerCase().matches("tab letters")){
                gradebook.showLetterGrades();
            }
            else {System.out.println("Wrong command. Try again!!");}
        }

        /**
         *  End of programs but still inside main
         *  Something else could run in here
         */

    }
}
