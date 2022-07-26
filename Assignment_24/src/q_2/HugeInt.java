package q_2;

import com.sun.source.tree.NewArrayTree;

import java.util.*;

public class HugeInt
{

    public LinkedList <Integer> digits;

    public HugeInt() {
        digits = new LinkedList <Integer>();
    }

    public void printWithThousandsSeperator()
    {

        ListIterator listIterator = this.digits.listIterator(digits.size());

        ArrayList<String> newlist = new ArrayList<String>();

        String addComma = ",";
        int count = 0;

        while(listIterator.hasPrevious()){


            if(count == 3){
                newlist.add(addComma);
                count = 0;
            }else {
                count++;
                newlist.add(String.valueOf(listIterator.previous()));
            }
        }

        for (int i = newlist.size() - 1; i >= 0 ; i--) {
            System.out.print(newlist.get(i));
        }
    }

}


