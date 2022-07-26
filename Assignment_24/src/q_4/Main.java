package q_4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    // Q_1. CHeck if string has balanced parenthesis operators () [] "in order"
    public static boolean isBalanced(String word){

        // Creating Stack Data Structure
        Stack<Character> operators = new Stack<Character>();

        // Add operators to stack
        for(int i = 0; i < word.length(); i++){

            if(word.charAt(i) == '(' || word.charAt(i) == '[')
                operators.push(word.charAt(i));
            else if(word.charAt(i) == ')'){
                if(operators.peek() == '(')
                    operators.pop();
                else
                    return false;
            }else if(word.charAt(i) == ']'){
                if(operators.peek() == '[')
                    operators.pop();
                else
                    return false;
            }
        }
        // return true if stack is empty meaning all operators matched
        return operators.isEmpty();
    }


    // Q_2 Potato winner using linkedList
    public static String winnerOfHotPotato(String[] names, int k){

        LinkedList<String> list = new LinkedList<String>();

        for(String name: names){
            list.add(name);
        }

        Iterator<String> it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next() + " started with the potato");

            for(int i = 0; i < k; i++){
                // Check if list hasNext
                if(it.hasNext()) {
                    System.out.println(it.next() + " has potato");

                }
                if (i == 2) {
                    it.remove();
                    System.out.println( + " has been removed from game");
                }

            }







            // resetting game list of players that still playing
            it = list.iterator();

        }



        return "Hello";
    }


    public static void main(String [] args){

        System.out.println(isBalanced("(((([]))))"));


        // Creating array and pass it to method
        String[] names = new String[]{"A",  "B", "C", "D", "E"};
        System.out.println(winnerOfHotPotato(names, 3));

    }
}
