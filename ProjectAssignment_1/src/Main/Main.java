package Main;
import util.*;

import java.util.Scanner; // Import java.util.Scanner for getting user input

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        // This message should show when student list is empty
        System.out.println("Welcome to my grade book!");
        System.out.println("Please enter the information of the first student using the following format:");
        System.out.println("\"firstName lastName PID grade\"");
        System.out.println("Press Enter when you are done");


        while(true) {
            System.out.println("Please enter the information of the next student in the same format.");
            System.out.println("if there is no more students, please enter the keyword \"DONE\"");
            System.out.println("Press Enter when you are done");
            String userName = myObj.nextLine();


            System.out.println("Username is: " + userName);
        }

    }

}
