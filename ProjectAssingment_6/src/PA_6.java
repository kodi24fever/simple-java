import java.util.*;


public class PA_6 {
    private static int getOp(String exp, int cur){
        Scanner s = new Scanner(exp.substring(cur));
        s.useDelimiter("[^0-9]");
        return s.nextInt();
    }
    private static int calculate(int prev, int val, char operand){ // Calculations for sum and subs
        if(operand == '+')
            return prev + val;

        return prev - val;
    }

    private static int getPrecedence(char sign) { // Precedence for operations () ---> 2, +- ---> 1, return -1 if nothing is valid

        // In case of adding multiplication and division it should be added here
        if(sign == '+' || sign == '-'){
            return 1;
        }
        else if(sign == '(' || sign == ')'){
            return 2;
        }
        return -1;
    }

    public static void main(String args[]) throws Exception{

        Scanner s = new Scanner(System.in);

        while(true){
            System.out.println("Please enter a new expression: ");
            String exp = s.nextLine();

            if(exp.equals("DONE"))
                break;

            int temp = 0;
            char spot;
            int result = 0;

            Stack<Integer> numbers = new Stack<Integer>(); // numbers for 1,2,56
            Stack<Character> operands = new Stack<Character>(); // operands for + - ( )


            for(int cur = 0; cur < exp.length();cur++){

               if (Character.isDigit(exp.charAt(cur))){

                    temp = getOp(exp, cur);

                    // Jumps to the next character that is not an integer
                    while(cur < exp.length() && Character.isDigit(exp.charAt(cur)))
                        cur++;
                    cur--;

                }

               else if(exp.charAt(cur) == '+' || exp.charAt(cur) == '-' || exp.charAt(cur) == '(' || exp.charAt(cur) == ')') {// Validates the values of the characters
                   spot = exp.charAt(cur);

                   if(spot == '('){
                       operands.push(spot);
                   }
                   else if(numbers.isEmpty()){
                       numbers.push(temp);
                       operands.push(spot);
                       temp = 0;
                   }

                   else if(spot == ')'){
                       numbers.push(temp);
                       while(operands.peek() != '('){
                           int val = numbers.pop();
                           int prev = numbers.pop();
                           spot = operands.pop();
                           temp = calculate(prev,val,spot);
                           numbers.push(temp);
                       }
                       operands.pop();
                       numbers.pop();
                   }

                   else{
                       char prevChar = operands.peek();
                       if(getPrecedence(spot) > getPrecedence(prevChar)){
                           numbers.push(temp);
                           operands.push(spot);
                           temp = 0;
                       }
                       else if(getPrecedence(spot) < getPrecedence(prevChar)){
                           numbers.push(temp);
                           operands.push(spot);
                           temp = 0;
                       }
                       else{ // this case of precedence is == for both operands
                           int prevNumb = numbers.pop();
                           char prev = operands.pop();
                           prevNumb = calculate(prevNumb,temp,prev);
                           numbers.push(prevNumb);
                           operands.push(spot);
                           temp = 0;
                       }
                   }
               }

               else if(Character.isWhitespace(exp.charAt(cur))) {
                    continue;
                } else
                    throw new Exception("Error: bad input");
            }


            if(operands.isEmpty() && numbers.isEmpty()){// Very rare case that both stacks are empty. Tough it could happen.
                result = temp;
            }else {
                while(!operands.isEmpty()){
                    if(numbers.isEmpty()){
                        result = temp;
                        break;
                    }
                    else {
                        int prev = numbers.pop();
                        spot = operands.pop();
                        if (operands.size() == 1 && spot == ')' && operands.peek() == '(') {
                            result = prev;
                            break;
                        } else if (spot == '+') {
                            result = temp * 1;
                        } else if (spot == '-') {
                            result = temp * -1;
                        } else {
                            result = prev;
                            break;
                        }
                        result = calculate(prev,temp,spot);
                    }
                }
            }

            System.out.println("The result is " + result);
        }
    }
}

/**
 *  TESTS I HAVE TRIED AND WORK
 *  -0021 good output -21
 *  0021  good output  21
 *  ((2)) good  output: 2
 *  ((-2)) good output: -2
 *  -(2-3-4)    output: 5 good
 *  (+34) good  output: 34
 *  (-34) good  output: -34
 *
 *  2+(1-(3+((4-1)+(12-6)))) output: -9 good
 *
 *  1+(2-(3+4-(5+(6-(7+(8-9)))))) output: 1 good
 *
 *  95-(12+33) good output: 50
 *
 */