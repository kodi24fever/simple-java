package main;

import java.io.*;
import java.util.*;
import util.*;

public class MainClass {
    public static final String OUTPUT = System.getProperty("user.dir") + "/output/";

    private static class ValidateInformation {
        public boolean isIDValid(int ID){
            String convertIDtoString = Integer.toString(ID);

            if(convertIDtoString.length() == 5 || (convertIDtoString.length() == 1 && convertIDtoString.charAt(0) == '0')){
                return true;
            }else return false;
        }

        public boolean isPhoneNumberValid(long phoneNumber){
            String convertIDtoString = Long.toString(phoneNumber);

            if(convertIDtoString.length() == 10){
                return true;
            }else return false;
        }
    }

    public static void main(String[] args) throws IOException, NumberFormatException {

        // Scanner object
        Scanner userInput = new Scanner(System.in);

        //printer object
        PrintWriter out = new PrintWriter(OUTPUT + "out.csv");

        //Array list to temporarily store ids to sort them for TA's and get maximum value
        ArrayList<Integer> saveAllIds = new ArrayList<>();

        String splitted[] = {};
        String splitFullName[] = {};
        String fullNameWithComma = "";
        String position = "";
        String firstName = "";
        String lastName = "";
        int studentID = 0;
        int teacherID = 0;
        long phoneNUmber = 0;
        int totalLines = 0;

        System.out.println("Please enter the total amount of students, teachers, and TA's in a number format");

        // Here I have to check if the value is an integer
        while(true){
            String totalStudentsToEnter = userInput.nextLine();
            try{
                totalLines = Integer.parseInt(totalStudentsToEnter);
                if(totalLines > 0){
                    break;
                }else System.out.println("It can't be negative or 0. Try Again!");

            }catch (NumberFormatException exception){
                System.out.println("Must be an Integer greater than 0. Try Again!");
            }
        }

        while(totalLines > 0){
            System.out.println("Enter Information in the format \"Position Firstname,Lastname StudentID TeacherID PhoneNumber\"");

            String inputInformation = userInput.nextLine();
            splitted = inputInformation.split(" ");

            if(splitted.length != 5){
                System.out.println("Information is not accurate. Try again!");
            }else {

                fullNameWithComma = splitted[1];
                splitFullName = fullNameWithComma.split(",");

                // Getting the tokens
                position = splitted[0];
                firstName = splitFullName[0];
                lastName = splitFullName[1];
                studentID = Integer.parseInt(splitted[2]);
                teacherID = Integer.parseInt(splitted[3]);
                phoneNUmber = Long.parseLong(splitted[4]);

                // Validate object
                ValidateInformation val = new ValidateInformation();


                if(val.isIDValid(studentID) && val.isIDValid(teacherID) && val.isPhoneNumberValid(phoneNUmber)){

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
                    } else if(position.toLowerCase().matches("student")) {

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
                    }else if(position.toLowerCase().matches("ta")) {

                        // Collections.max adds to TA the max value of ID's in the arrayList
                        TA ta = new TA(firstName, lastName, Collections.max(saveAllIds), phoneNUmber);

                        //Prints info to csv
                        ta.csvPrintln();

                        // Total Lines decrease to close loop
                        totalLines--;
                    } else System.out.println("Wrong position. Must be \"teacher, student, or ta\". Try again!");

                } else {
                    if(!val.isIDValid(studentID)) {System.out.println("Wrong ID. Student ID must be 5 digits or 0, depending of the position. Try again!");}
                    if(!val.isIDValid(teacherID)) {System.out.println("Wrong ID. Teacher ID must be 5 digits or 0, depending of the position. Try again!");}
                    if(!val.isPhoneNumberValid(phoneNUmber)) {System.out.println("Phone Number is not 10 digits. Try again!");}
                }

            }
        }

    }
}
