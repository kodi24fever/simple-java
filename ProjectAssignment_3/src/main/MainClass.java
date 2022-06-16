package main;


import java.util.*;
import util.*;

public class MainClass {


    private static class ValidateInformation {
        private long phoneNumber;
        private int ID;

        public boolean isIDValid(){
            String convertIDtoString = Integer.toString(this.ID);

            if(convertIDtoString.length() == 5 || convertIDtoString == "0"){
                return true;
            }else return false;
        }
        public boolean isPhoneNumberValid(){
            String convertIDtoString = Long.toString(this.phoneNumber);

            if(convertIDtoString.length() == 10){
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

                if(val.isIDValid() && val.isIDValid()){



                    if(position.toLowerCase().matches("teacher")){

                        String last4Digits = splitted[4].substring((splitted[4].length() - 4), splitted[4].length());

                        Teacher teacher = new Teacher(firstName,lastName,ID,Integer.parseInt(last4Digits));

                        System.out.println(teacher.getID());
                    } else if(position.toLowerCase().matches("student")) {

                        Student student = new Student(firstName, lastName, ID, phoneNUmber);

                        System.out.println(student.getID());
                    }

                }

            }





            // Total Lines decrease to close loop
            totalLines--;
        }

    }
}
