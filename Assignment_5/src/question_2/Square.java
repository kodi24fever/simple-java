package question_2;

public class Square extends Rectangle {
    public Square(String color, double side) {
        super(color, side, side);
    }

    public Square(String color){
        super(color);
    }

    public String toString(){
        return "Square of side: " + getWidth() + ", perimeter: " + getPerimeter() + ", area: " + getArea();
    }
}
