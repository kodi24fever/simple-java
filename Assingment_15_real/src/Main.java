import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++)
            numbers.addLast(i);
        ListIterator<Integer> it = numbers.listIterator();
        while (it.hasNext())
            System.out.print(it.next() + (it.hasNext() ? " -> " : "\n"));
        while (it.hasPrevious()) {
            it.previous();
            if (it.hasPrevious()) {
                it.previous();
                it.remove();
            }
        }

        System.out.println("This is the list " + numbers);

        int count = 1;
        for (int number : numbers)
            System.out.print(count + ": " + number + (count++ < numbers.size() ? " -> " : ""));
    }
}
