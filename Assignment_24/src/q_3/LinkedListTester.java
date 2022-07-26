package q_3;


import java.util.*;
public class LinkedListTester

{

    public static void main(String []args)

    {

        int [] array = new int [] {12,2,32,43,54,6};
        LinkedList <Integer> list = new LinkedList <Integer> ();
        for (int i: array)

            list.addFirst(i);

        ListIterator <Integer> it = list.listIterator();
        while (it.hasNext())

        {

            System.out.println(it.next());
            it.next();
            it.next();

        }

    }

}
