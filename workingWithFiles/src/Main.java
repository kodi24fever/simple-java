
import java.io.*;
import java.util.*;


public class Main {

    private static final String INPUT = System.getProperty("user.dir") + "/input/";
    private static final String OUTPUT = System.getProperty("user.dir")+ "/output/";

    public static void main(String[] args) throws FileNotFoundException{

        // File object
        File file = new File(INPUT + "input.txt");

        // File not found exception
        Scanner readFile;
        try{
            readFile = new Scanner(file);
            System.out.println("File in System.");
        }catch (FileNotFoundException fileNotFound){
            System.out.println("File not found. Try again!");
            return;
        }

        // Basic file reading
        while(readFile.hasNextLine()){

            String line = readFile.nextLine();

            System.out.println(line);
        }

        // Close file reader
        readFile.close();


        //Basic file writing
        PrintWriter printFile = new PrintWriter(OUTPUT + "output.txt");

        printFile.println("Hello: ");
        printFile.println("This is a new line");

        //printFile.flush();
        //printFile.close();



    }
}
