package question_2;
import java.util.*;

public class Main {
    public static void main(String[] args){

        ArrayList<TwoDShape> shapes = new ArrayList<>();

        shapes.add(new Circle("Blue", 3));
        shapes.add(new Rectangle("Pink", 6, 7));
        shapes.add(new Square("Orange", 5));
        shapes.add(new TwoDShape("Red"));

        for(TwoDShape shape: shapes)
            System.out.println(shape);
    }
}
