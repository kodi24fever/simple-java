package main;

import java.io.IOException;
import java.util.*;
import util.*;

//import printer objects
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainClass {

    public static final String OUTPUT = System.getProperty("user.dir") + "/output/";


    private static class ValidateInformation {
        private long phoneNumber;
        private int studentID;
        private int teacherID;

        private boolean isStudentIDValid;
        private boolean isTeacherIDValid;
        private boolean isPhoneValid;

        public void isStudentIDValid(){
            String convertIDtoString = Integer.toString(this.studentID);

            if(convertIDtoString.length() == 5 || convertIDtoString == "0"){
                isStudentIDValid = true;

            }else isStudentIDValid = false;
        }

        public void isTeacherIDValid(){
            String convertIDtoString = Integer.toString(this.teacherID);

            if(convertIDtoString.length() == 5 || convertIDtoString == "0"){
                isTeacherIDValid = true;

            }else isTeacherIDValid = false;
        }

        public void isPhoneNumberValid(){
            String convertIDtoString = Long.toString(this.phoneNumber);

            if(convertIDtoString.length() == 10){

                isPhoneValid = true;
            }else isPhoneValid = false;
        }

        public boolean validateAll(){
            if(isTeacherIDValid && isStudentIDValid && isPhoneValid){
                return true;
            }else return false;
        }

        // Getters for booleans
        public boolean getIsTeacherIDValid(){
            return isTeacherIDValid;
        }
        public boolean getIsStudentIDValid(){
            return isStudentIDValid;
        }
        public boolean getIsPhoneValid(){
            return isPhoneValid;
        }

        // ValidateInformation class constructor
        public ValidateInformation(int studentID,int teacherID, long phoneNumber){
            this.teacherID = teacherID;
            this.studentID = studentID;
            this.phoneNumber = phoneNumber;


            // Run local methods to check for validation
            this.isStudentIDValid();
            this.isTeacherIDValid();
            this.isPhoneNumberValid();
        }
    }


    public static void main(String[] args) throws IOException {

        // Scanner object
        Scanner userInput = new Scanner(System.in);

        //printer object
        PrintWriter out = new PrintWriter(OUTPUT + "out.csv");

        //Array list to temporarily store ids to sort them for TA's and get maximum value
        ArrayList<Integer> saveAllIds = new ArrayList<>();

        String splitted[] = {};
        String position = "";
        String firstName = "";
        String lastName = "";
        int studentID = 0;
        int teacherID = 0;
        long phoneNUmber = 0;

        int totalLines = 0;

        System.out.println("Please enter the total amount of students, teachers, and TA's in a number format");

        // Here I have to check if the value is an integer
        String totalStudentsToEnter = userInput.nextLine();

        totalLines = Integer.parseInt(totalStudentsToEnter);

        while(totalLines > 0){
            System.out.println("Enter Information in the format \"Firstname,Lastname ID PhoneNumber\"");

            String inputInformation = userInput.nextLine();
            splitted = inputInformation.split(" ");

            if(splitted.length != 6){
                System.out.println("Information is not accurate. Try again!");
                continue;

            }else {

                // Getting the tokens
                position = splitted[0];
                firstName = splitted[1];
                lastName = splitted[2];
                studentID = Integer.parseInt(splitted[3]);
                teacherID = Integer.parseInt(splitted[4]);
                phoneNUmber = Long.parseLong(splitted[5]);

                // Validate object
                ValidateInformation val = new ValidateInformation(studentID, teacherID, phoneNUmber);

                if(val.validateAll()){

                    // Checks that positions are well entered
                    if(!position.toLowerCase().matches("teacher") || !position.toLowerCase().matches("student") || !position.toLowerCase().matches("ta")){System.out.println("Wrong position. Must be \"teacher, student, or ta\". Try again!");}

                    // Starts command phase
                    if(position.toLowerCase().matches("teacher")){
                        if(studentID != 0){
                            System.out.println("When position is teacher student ID must be 0. Try again!");
                        }else {
                            String last4Digits = splitted[4].substring((splitted[4].length() - 4), splitted[4].length());
                            Teacher teacher = new Teacher(firstName,lastName,teacherID,Integer.parseInt(last4Digits));

                            // Add id to ArrayList
                            saveAllIds.add(teacherID);
                            //Print info to csv
                            teacher.csvPrintln();
                            // Total Lines decrease to close loop
                            totalLines--;
                        }
                    }

                    if(position.toLowerCase().matches("student")) {

                        if(teacherID != 0){
                            System.out.println("When position is student, teacher ID must be 0. Try again!");
                        }else {
                            Student student = new Student(firstName, lastName, studentID, phoneNUmber);

                            // Add id to ArrayList
                            saveAllIds.add(studentID);

                            //Prints info to csv
                            student.csvPrintln();

                            // Total Lines decrease to close loop
                            totalLines--;
                        }
                    }

                    if(position.toLowerCase().matches("ta")) {

                        // Collections.max adds to TA the max value of ID's in the arrayList
                        TA ta = new TA(firstName, lastName, Collections.max(saveAllIds), phoneNUmber);

                        //Prints info to csv
                        ta.csvPrintln();

                        // Total Lines decrease to close loop
                        totalLines--;

                    }

                } else {
                    if(!val.getIsStudentIDValid()) {System.out.println("Wong ID. Student ID must be 5 digits or 0, depending in the position. Try again!");}
                    if(!val.getIsTeacherIDValid()) {System.out.println("Wong ID. Teacher ID must be 5 digits or 0, depending in the position. Try again!");}
                    if(!val.getIsPhoneValid()) {System.out.println("Phone Number is not 10 digits. Try again!");}
                }

            }
        }

    }
}
