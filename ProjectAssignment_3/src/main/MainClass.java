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

    public static void main(String[] args) throws IOException, NumberFormatException, NullPointerException {

        // Scanner object
        Scanner userInput = new Scanner(System.in);

        //printer object
        PrintWriter out = new PrintWriter(OUTPUT + "out.csv");

        // Validate object
        ValidateInformation val = new ValidateInformation();

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

        // This while loop checks if the value is an integer
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

        //Array of CSVPrintable objects to be able to have multiple input lines
        Integer[] inputLines = new Integer[totalLines];

        // Welcoming message
        System.out.println("Enter Information in the format \"Position Firstname,Lastname StudentID TeacherID PhoneNumber\"");
        System.out.println("If the position entered is Teacher, StudentID must be 0. If position entered is Student, TeacherID must be 0.");

        for(int i = 0; i < inputLines.length; i++){
            int errorLine = i + 1;

            String inputInformation = userInput.nextLine();
            splitted = inputInformation.split(" ");

            // Assigning position token
            position = splitted[0];

            if(splitted.length != 5){
                System.out.println("Information is not accurate in line " + errorLine + ". The format is \"Position Firstname,Lastname StudentID TeacherID PhoneNumber\" Try again!");
                i--;
                continue;
            }else {
                // Here check if names contains comma if not throw error
                // Getting the tokens. Tokens for firstname and lastname.
                fullNameWithComma = splitted[1];
                if(!fullNameWithComma.contains(",")){
                    System.out.println("Name is not well formatted at line " + errorLine + ". Make sure is Firstname\",\"Lastname with the comma in between and no spaces.");
                    System.out.println("Example: \"John,Doe\"");
                    i--;
                    continue;
                }else {
                    /**
                     *  This part validates the firstname and lastname are not numbers
                     *  just alphabetic letters
                     */
                    splitFullName = fullNameWithComma.split(",");
                    if(!splitFullName[0].matches("[a-zA-Z.]+")){
                        System.out.println("Name is not well formatted at line " + errorLine + ". Make sure FirstName must be written with alphabetic letters not numbers.");
                        i--;
                        continue;
                    }else if(!splitFullName[1].matches("[a-zA-Z.]+")){
                        System.out.println("Name is not well formatted at line " + errorLine + ". Make sure LastName must be written with alphabetic letters not numbers.");
                        i--;
                        continue;
                    }else {
                        // Assigns firstname and lastname to variables if everything is correct
                        firstName = splitFullName[0];
                        lastName = splitFullName[1];
                    }
                }

                // Error handling for ID's and phone if user input other variables besides Integers
                try{
                    studentID = Integer.parseInt(splitted[2]);
                }catch (NumberFormatException exception){
                    System.out.println("Student ID must be an integer value of 5 digits at line " + errorLine);
                    i--;
                    continue;
                }
                try{
                    teacherID = Integer.parseInt(splitted[3]);
                }catch (NumberFormatException exception){
                    System.out.println("Teacher ID must be an integer value of 5 digits at line " + errorLine);
                    i--;
                    continue;
                }
                try{
                    phoneNUmber = Long.parseLong(splitted[4]);
                }catch (NumberFormatException exception){
                    System.out.println("Phone number must be written as integer values of 10 digits at line " + errorLine);
                    i--;
                    continue;
                }

                // Validates ID's and phone number for each position
                if(val.isIDValid(studentID) && val.isIDValid(teacherID) && val.isPhoneNumberValid(phoneNUmber)){

                    // Starts command phase
                    if(position.toLowerCase().matches("teacher")){

                        if(String.valueOf(teacherID).length() != 5){
                            System.out.println("TeacherID must be a number of 5 digits.");
                            i--;
                            continue;
                        }else if(studentID != 0){
                            System.out.println("Error at line " + errorLine + ".When position is teacher student ID must be 0. Try again!");
                            i--;
                            continue;
                        }else{
                            // Writes teacher to csv
                            String last4Digits = splitted[4].substring((splitted[4].length() - 4), splitted[4].length());
                            new Teacher(firstName,lastName,teacherID,Integer.parseInt(last4Digits)).csvPrintln();

                            System.out.println("Teacher information successfully stored at line " + errorLine);
                        }
                    } else if(position.toLowerCase().matches("student")) {

                        if(String.valueOf(studentID).length() != 5){
                            System.out.println("StudentID must be a number of 5 digits.");
                            i--;
                            continue;
                        }else if(teacherID != 0){
                            System.out.println("Error at line " + errorLine + ". When position is student, teacher ID must be 0. Try again!");
                            i--;
                            continue;
                        }else {
                            // Writes student to csv
                            new Student(firstName, lastName, studentID, phoneNUmber).csvPrintln();
                            System.out.println("Student information successfully stored at line " + errorLine);
                        }
                    }else if(position.toLowerCase().matches("ta")) {

                        if(String.valueOf(studentID).length() != 5) {
                            System.out.println("StudentID must be a number of 5 digits.");
                            i--;
                            continue;
                        }else if(String.valueOf(teacherID).length() != 5) {
                            System.out.println("TeacherID must be a number of 5 digits.");
                            i--;
                            continue;
                        }else {
                            // Writes TA to csv
                            new TA(firstName, lastName, studentID, teacherID, phoneNUmber).csvPrintln();
                            System.out.println("TA information successfully stored at line " + errorLine);
                        }
                    } else {
                        System.out.println("Wrong position at line " + errorLine + ". Must be \"teacher, student, or ta\", instead of " + "\"" +  position + "\"" +" Try again!");
                        i--;
                        continue;
                    }

                } else {
                    // General error handling if ids and phone numbers are wrong
                    if(!val.isIDValid(studentID)) {
                        if(position.toLowerCase().matches("teacher")){
                            System.out.println("Wrong StudentID at line " + errorLine + ". Student ID must be 0, instead of \"" + studentID + "\".Try again!");
                        }else System.out.println("Wrong StudentID at line " + errorLine + ". Student ID must be 5 digits, instead of \"" + studentID + "\".Try again!");
                        i--;
                        continue;
                    }
                    if(!val.isIDValid(teacherID)) {
                        if(position.toLowerCase().matches("student")){
                            System.out.println("Wrong TeacherID at line " + errorLine + ". Teacher ID must be 0, instead of \"" + teacherID + "\".Try again!");
                        }else System.out.println("Wrong TeacherID at line " + errorLine + ". Teacher ID must be 5 digits, instead of \"" + teacherID + "\".Try again!");
                        i--;
                        continue;
                    }
                    if(!val.isPhoneNumberValid(phoneNUmber)) {
                        System.out.println("Phone Number is not 10 digits at line " + errorLine + ". Try again!");
                        i--;
                        continue;
                    }
                }

            }
        }
    }
}
