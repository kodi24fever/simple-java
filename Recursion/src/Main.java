public class Main {


    public static void myRecursiveMethod(String input){
        if(input.length() == 0)
            return;

        myRecursiveMethod(input.substring(1));

        System.out.print(input);

        //System.out.print(input.charAt(0));
    }

    public static int whatDoesThisDo(int a){
        if(a <= 1) // Base Case
            return 1;

        int intermediate = whatDoesThisDo(a - 1);
        return a * intermediate;
    }


    public static String whatAboutThis(String input){
        int l = input.length();

        if(l <= 1)
            return input;

        return input.substring(l/2) + input.substring(0,l/2);

    }


    public static void main(String[] args){
        //myRecursiveMethod("Message");
        //System.out.print(whatDoesThisDo(9));

        System.out.println(whatAboutThis("Hello World!"));
    }
}
