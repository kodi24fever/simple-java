import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static final String INPUT = System.getProperty("user.dir") + "/input/";
    public static final String OUTPUT = System.getProperty("user.dir") + "/output/";


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(INPUT + "input.csv");
        Scanner readScn = new Scanner(file);

        //printer object
        PrintWriter out = new PrintWriter(OUTPUT + "output.txt");


        while(readScn.hasNextLine()){
            String wholeInput = readScn.nextLine();

            String[] split = wholeInput.split(",");

            int counter = split.length;

            for(String word: split){
                counter--;
                try{
                    int nextInt = Integer.parseInt(word);

                    out.printf("%+5d", nextInt);
                }catch (NumberFormatException exp){
                    try{
                        double nextDouble = Double.parseDouble(word);
                        out.printf("%-10.2g", nextDouble);
                    }catch (NumberFormatException exp1){
                        out.printf("%10.5s", word);
                    }
                }
            }

            System.out.println(counter == 0);

            if(counter == 0){
                if(readScn.hasNextLine())
                    out.println();
                out.flush();
            }else{

                System.out.println("Tabs used");
                out.println('\t');
            }
        }

        out.close();
        readScn.close();
    }
}
