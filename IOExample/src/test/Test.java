package test;

import java.io.*;

import java.util.*;

public class Test {
    public static final String INPUT = System.getProperty("user.dir") + "/input/";
    public static final String OUTPUT = System.getProperty("user.dir") + "/output/";


    public static void main(String[] args){

        Scanner in = null;

        File inputDirectory = new File(INPUT);
        for(File f: inputDirectory.listFiles())
            System.out.println();

        try {
            in = new Scanner(new File(INPUT + "test.txt"));
        } catch(FileNotFoundException exp){
            System.out.println("An exception occurred while reading sorting.pptx");
        }

        if(in == null){
            return;
        }
        for(int i = 1; in.hasNextLine() && i <= 10; i++){
            System.out.println("Line " + i + ": " + in.nextLine());
        }

        in.close();


        try{
            in = new Scanner(new File(INPUT + "number.txt"));
        }catch(FileNotFoundException e){
            System.out.println("numbers.txt " + "can't be opened");
            return;
        }


        while(in.hasNext()){
            int value = 0;
            double dValue = 0.0;

            try{
                value = in.nextInt();
                System.out.println("the next int value in the file is: " + value);
            }catch(InputMismatchException exp){
                try{
                    dValue = in.nextDouble();
                    System.out.println("The next double in the file is: " + dValue);
                }catch (InputMismatchException exp2){
                    System.out.println("Skipping " + in.next() + " b/c it's not an int nor a double.");
                }
            }
        }






    }


}
