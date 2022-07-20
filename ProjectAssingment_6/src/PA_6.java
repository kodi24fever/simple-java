import java.util.*;


public class PA_6 {
    private static int getOp(String exp, int cur){
        Scanner s = new Scanner(exp.substring(cur));
        s.useDelimiter("[^0-9]");
        return s.nextInt();
    }
    private static int calculate(int prev, int val, char operand){
        if(operand == '+')
            return prev + val;

        return prev - val;
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

//               if(exp.charAt(cur) == '(') {
//                   operands.push(exp.charAt(cur));
//               }
//               else if(exp.charAt(cur) == ')'){
//
//
//                   while(operands.peek() != '('){
//
//                   }
//
//               }
               if (Character.isDigit(exp.charAt(cur))){

                    temp = getOp(exp, cur);

                    // Jumps to the next character that is not an integer
                    while(cur < exp.length() && Character.isDigit(exp.charAt(cur)))
                        cur++;
                    cur--;

                }
               else if(exp.charAt(cur) == '+' || exp.charAt(cur) == '-' || exp.charAt(cur) == '(' || exp.charAt(cur) == ')') {

                   operands.push(exp.charAt(cur));
                   numbers.push(temp);
                   temp = 0;

                   //System.out.println("THis is cur " + cur + " This is length " + exp.length() );

                   if(numbers.size() > 1){
                       int val = numbers.pop();
                       int prev = numbers.pop();
                       spot = operands.pop();
                       temp = calculate(prev,val,spot);
                       numbers.push(temp);
                       temp = 0;
                   }
               }

               else if(Character.isWhitespace(exp.charAt(cur))) {
                    continue;
                } else
                    throw new Exception("Error: bad input");
            }



            // Adding the rest of the stack until no more operands
            while(!operands.isEmpty()){
                int prev = numbers.pop();
                spot = operands.pop();

                result = calculate(prev,temp,spot);
            }


//            numbers.forEach(number  -> {
//                System.out.println("Number " + number);
//            });
//
//
//            operands.forEach(sum  -> {
//                System.out.println("Operand " + sum);
//            });


            System.out.println("The result is " + result);
        }
    }
}