package main;

import util.*;

public class MainClass {


    private class ValidateInformation {
        private long phoneNumber;

        private int ID;



        public boolean isPhoneNumberValid(){
            return false;
        }



        public ValidateInformation(long phoneNumber, int ID){
            this.phoneNumber = phoneNumber;
            this.ID = ID;
        }




    }


    public static void main(String[] args){
        Student student = new Student("Alex", "rodriguez", 1234567890, 1234567);


        student.csvPrintln();



    }
}
