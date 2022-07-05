package number;

public class Main{

    public static void g(int n, int b){

        if(n < b)

            System.out.print(n);

        else {

            System.out.print(n%b); // prints one's digit

            g(n/b, b); // n/b is all digits but one's digit

        }

    }

    public static void main(String[] args){

        g(85649, 10);

    }

}
