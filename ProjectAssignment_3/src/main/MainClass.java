package main;


import java.util.*;
import util.*;

public class MainClass {


    private static class ValidateInformation {
        private long phoneNumber;
        private int ID;

        private boolean isIDValid;
        private boolean isPhoneValid;

        public void isIDValid(){
            String convertIDtoString = Integer.toString(this.ID);

            if(convertIDtoString.length() == 5 || convertIDtoString == "0"){
                isIDValid = true;

            }else isIDValid = false;
        }
        public void isPhoneNumberValid(){
            String convertIDtoString = Long.toString(this.phoneNumber);

            if(convertIDtoString.length() == 10){

                isPhoneValid = true;
            }else isPhoneValid = false;
        }

        public boolean validateAll(){
            if(isIDValid && isPhoneValid){
                return true;
            }else return false;
        }

        // Getters for booleans
        public boolean getIsIDValid(){
            return isIDValid;
        }
        public boolean getIsPhoneValid(){
            return isPhoneValid;
        }

        // ValidateInformation class constructor
        public ValidateInformation(int ID, long phoneNumber){
            this.ID = ID;
            this.phoneNumber = phoneNumber;


            // Run local methods to check for validation
            this.isIDValid();
            this.isPhoneNumberValid();
        }
    }


    public static void main(String[] args){

        // Scanner object
        Scanner userInput = new Scanner(System.in);

        //Array list to temporarily store ids to sort them for TA's and get maximum value
        ArrayList<Integer> saveAllIds = new ArrayList<>();

        String splitted[] = {};
        String position = "";
        String firstName = "";
        String lastName = "";
        int ID = 0;
        long phoneNUmber = 0;

        int totalLines = 0;

        System.out.println("Please enter the total amount of students, teachers, and TA's in a number format");

        // Here I have to check if the value is an integer
        String totalStudentsToEnter = userInput.nextLine();

        totalLines = Integer.parseInt(totalStudentsToEnter);

        while(totalLines > 0){
            System.out.println("Enter Information in the format Firstname Lastname ID PhoneNumber");

            String inputInformation = userInput.nextLine();
            splitted = inputInformation.split(" ");

            if(splitted.length != 5){
                System.out.println("Information is not accurate. Try again!");
                continue;

            }else {

                position = splitted[0];
                firstName = splitted[1];
                lastName = splitted[2];
                ID = Integer.parseInt(splitted[3]);
                phoneNUmber = Long.parseLong(splitted[4]);

                // Validate object
                ValidateInformation val = new ValidateInformation(ID, phoneNUmber);

                if(val.validateAll()){
                    // Starts command phase
                    if(position.toLowerCase().matches("teacher")){
                        String last4Digits = splitted[4].substring((splitted[4].length() - 4), splitted[4].length());
                        Teacher teacher = new Teacher(firstName,lastName,ID,Integer.parseInt(last4Digits));

                        // Add id to ArrayList
                        saveAllIds.add(ID);



                        teacher.csvPrintln();

                        // Total Lines decrease to close loop
                        totalLines--;

                    }

                    if(position.toLowerCase().matches("student")) {
                        Student student = new Student(firstName, lastName, ID, phoneNUmber);

                        // Add id to ArrayList
                        saveAllIds.add(ID);

                        student.csvPrintln();

                        // Total Lines decrease to close loop
                        totalLines--;

                    }

                    if(position.toLowerCase().matches("ta")) {

                        // Collections.max adds to TA the max value of ID's in the arrayList
                        TA ta = new TA(firstName, lastName, Collections.max(saveAllIds), phoneNUmber);


                        ta.csvPrintln();

                        // Total Lines decrease to close loop
                        totalLines--;

                    }

                } else {

                    if(!val.getIsIDValid()) {System.out.println("Wong ID. ID must be 5 digits. Try again!");}
                    if(!val.getIsPhoneValid()) {System.out.println("Phone Number is not 10 digits. Try again!");}
                }

            }
        }

    }
}
