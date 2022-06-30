package q_2;

import com.sun.source.tree.ArrayAccessTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void removeCapitalLetters(String inputFileNAme, String outputFileName) throws FileNotFoundException {

        final String INPUT = System.getProperty("user.dir") + "/input/";
        final String OUTPUT = System.getProperty("user.dir") + "/output/";

        // Create File ob for scanner to read
        File file = new File(INPUT + inputFileNAme);

        // Create scanner obj
        Scanner readFile = new Scanner(file);

        //No Capital letters holder
        String noCapitalLetter = "";

        while(readFile.hasNextLine()){
            String wholeInput = readFile.nextLine();

            for(int i = 0; i < wholeInput.length(); i++){

                if(wholeInput.charAt(i) >= 'A' && wholeInput.charAt(i) <= 'Z'){

                    System.out.println("Capital letter " + wholeInput.charAt(i));
                    //noCapitalLetter = wholeInput.replace(Character.toString(wholeInput.charAt(i)), "");
                }
                else {
                    noCapitalLetter += Character.toString(wholeInput.charAt(i));
                }
            }
        }
        System.out.println(noCapitalLetter);
    }



    public static void main(String[] args) throws FileNotFoundException {



        removeCapitalLetters("input.csv", "output.txt");

    }


}
