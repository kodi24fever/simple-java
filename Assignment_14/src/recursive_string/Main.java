package recursive_string;


public class Main{

    public static void f(int n){

        if(n == 0)

            System.out.print("A ");

        else {

            System.out.print("B ");

            f(n - 1);

            System.out.print("C ");
        }

    }

    public static void main(String[] args){

        f(3);

    }

}
