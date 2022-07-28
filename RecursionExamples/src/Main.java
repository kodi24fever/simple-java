import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(reverse1("Hello"));
        //String x= "world";
        //System.out.println(x.charAt(5));
//        for(String s: allPermutations("world"))
//            System.out.println(s);
    }
    public static String reverse(String input) {
        char[] inputArray = input.toCharArray();
        char[] outputArray = new char[inputArray.length];
        for(int i = 0; i < inputArray.length;i++)
            outputArray[i] = inputArray[inputArray.length-1-i];
        return new String(outputArray);
    }
    public static String reverse1(String input) {
        if(input.length()<=1)//base case...
            return input;
        return reverse1(input.substring(1))+input.charAt(0);
    }
    public static String reverse2(String input) {
        if(input.length()<=1)//base case...
            return input;
        return reverse2(input.substring(input.length()/2,input.length()))+//right half
                reverse2(input.substring(0,input.length()/2));//left half
    }
    public static String reverse3(String input) {
        if(input.length()<=1)//base case...
            return input;
        return reverse3(input.substring(2*input.length()/3,input.length()))+//last third
                reverse3(input.substring(input.length()/3,2*input.length()/3))+//middle third
                reverse3(input.substring(0,input.length()/3));//first third
    }

    public static ArrayList<String> allPermutations(String input){
        ArrayList<String> result = new ArrayList<String>();
        if(input.length() == 1) {
            result.add(input);
            return result;
        }
        for(int i = 0; i < input.length();i++) {
            String shorterWord = input.substring(0,i)+input.substring(i+1);
            ArrayList<String>subResult = allPermutations(shorterWord);
            for(String s: subResult)
                result.add(input.charAt(i)+s);
        }
        return result;
    }
}
