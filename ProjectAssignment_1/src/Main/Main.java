package Main;
import util.*;

import java.util.Scanner; // Import java.util.Scanner for getting user input
import java.util.ArrayList; // Import arrrayList to create studnets

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> studentsList = new ArrayList<Student>();

        // Array to split user input in long string format
        String splited[];

        // Declaring variable for student
        int grade = 0;

        Scanner myObj = new Scanner(System.in); // Scanner for user input

        // This message should show when student list is empty
//        System.out.println("Welcome to my grade book!");
//        System.out.println("Please enter the information of the first student using the following format:");
//        System.out.println("\"firstName lastName PID grade\"");
//        System.out.println("Press Enter when you are done");


        System.out.println("Please enter the information of the next student in the same format.");
        System.out.println("if there is no more students, please enter the keyword \"DONE\"");
        System.out.println("Press Enter when you are done");
        String wholeStudent = myObj.nextLine();

        splited = wholeStudent.split(" ");

        System.out.println("Username is: " + wholeStudent + splited[0] + splited[1] + splited[2]);


        //Getting Student OBJ
        Student student = new Student(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));


        System.out.println(student.getPid());

        /**
         *  TESTING VALIDATE STUDENT
         */

        ValidateStudentInformation val = new ValidateStudentInformation(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));

//        System.out.println(val.showFN());
//        System.out.println(val.showLN());
//        System.out.println(val.showGrade());
//        System.out.println(val.showPIDBol());
//        System.out.println(val.studentMeetsRequirements());

        if(val.studentMeetsRequirements()){

        }else System.out.println("Sorry Try again!");



        studentsList.add(student);

        System.out.println(studentsList);






    }

}
