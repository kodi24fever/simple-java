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
                System.out.println("Wong ID. ID must be 5 digits. Try again!");
            }else isIDValid = false;
        }
        public void isPhoneNumberValid(){
            String convertIDtoString = Long.toString(this.phoneNumber);

            if(!(convertIDtoString.length() == 10)){
                System.out.println("Phone Number is not 10 digits. Try again!");
                isPhoneValid = false;
            }else isPhoneValid = true;
        }

        public boolean validateAll(){
            if(isIDValid && isPhoneValid){
                return true;
            }else return false;
        }


        public ValidateInformation(int ID, long phoneNumber){
            this.ID = ID;
            this.phoneNumber = phoneNumber;
        }
    }


    public static void main(String[] args){

        // Scanner object
        Scanner userInput = new Scanner(System.in);

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

                ValidateInformation val = new ValidateInformation(ID, phoneNUmber);

                if(val.validateAll()){

                    // Starts command phase
                    if(position.toLowerCase().matches("teacher")){
                        String last4Digits = splitted[4].substring((splitted[4].length() - 4), splitted[4].length());
                        Teacher teacher = new Teacher(firstName,lastName,ID,Integer.parseInt(last4Digits));

                    }

                    if(position.toLowerCase().matches("student")) {
                        Student student = new Student(firstName, lastName, ID, phoneNUmber);

                    }

                    if(position.toLowerCase().matches("ta")) {
                        TA ta = new TA(firstName, lastName, ID, phoneNUmber);

                    }

                }

            }





            // Total Lines decrease to close loop
            totalLines--;
        }

    }
}
