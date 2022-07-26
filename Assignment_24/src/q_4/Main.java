package q_4;

import java.util.Stack;

public class Main {


    // Q_1. CHeck if string has balanced operators () [] "in order"
    public static boolean isBalanced(String word){

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


    public static void main(String [] args){

        System.out.println(isBalanced("(((([]))))"));

    }




}
