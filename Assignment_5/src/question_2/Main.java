package question_2;
import java.util.*;

public class Main {
    public static void main(String[] args){

        ArrayList<TwoDShape> shapes = new ArrayList<>();

        shapes.add(new Circle("Blue", 3));
        shapes.add(new Rectangle("Pink", 6, 7));
        shapes.add(new Square("Orange", 5));
        shapes.add(new Circle());
        shapes.add(new Circle(5.0));
        shapes.add(new Circle("Orange"));

        for(TwoDShape shape: shapes)
            System.out.println(shape);

        // Casting parent object to child obj
        TwoDShape temp = shapes.get(0);
        System.out.println("Area of " + temp + " is "+ ((Circle)temp).getArea());
        System.out.println("Perimeter of " + temp + " is "+ temp.getPerimeter());
        temp = shapes.get(1);
        System.out.println("Area of " + temp + " is "+ ((Rectangle)temp).getArea());
        System.out.println("Perimeter of " + temp + " is "+ temp.getPerimeter());

    }
}
