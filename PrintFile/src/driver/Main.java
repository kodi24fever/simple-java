package driver;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static final String OUTPUT = System.getProperty("user.dir") + "/output/";

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(OUTPUT + "out.csv");

        out.println("Alex Martinez,98765,9999");
        out.println("Rose Gonzales,56789,9876543210");
        out.println("John Cruz,99999,1234567890");

        out.flush();
        out.close();
    }
}
