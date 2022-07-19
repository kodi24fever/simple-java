import java.util.*;


public class Main {
    public static void main(String []args) {

        Stack <Integer> s = new Stack <Integer>();
        int [] data = new int[] {5,4,6,3,2,9,13};
        for (int i = 0; i < data.length; i++) {


            System.out.println(data[i++] + " this is i " + i++ + " , " + data[0]);


            System.out.println(i);

            s.push(data[i++]);

            if (i < data.length)
                s.push(data[i]);

            System.out.print(s.pop( ) + "," );

        }
        while(!s.empty())
            System.out.print(s.pop()+".");

    }

}

