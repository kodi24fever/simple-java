import java.util.LinkedList;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Queue<String> queue = new LinkedList<String>();

        queue.add("first");
        queue.add("second");
        queue.add("third");

        System.out.print("The dequeue operation applied on " + queue + " returns ");
        System.out.println(queue.remove());
        queue.add("fourth");
        System.out.println("After removing Fourth, we get " + queue);


        Stack<String> stack = new Stack<String>();
        stack.push("first");
        stack.push("second");
        stack.push("third");

        System.out.print("The stack operation applied on " + stack + " returns ");
        System.out.println(stack.pop());
        stack.push("fourth");
        System.out.println("After removing Fourth, we get " + stack);


    }
}
