package question_2;

import java.util.zip.CheckedInputStream;

public class Rectangle extends TwoDShape {
    private double width, length;

    // Children can't override width from parent with finals
    public final double getWidth(){
        return this.width;
    }
    public Rectangle(String color, double width, double length) {
        super(color);
        this.width = width;
        this.length = length;
    }

    public double getPerimeter(){return 2 * ( width * length);}
    public double getArea() {return super.getArea(width, length);}

    @Override
    public String toString(){
        return "Rectangle width: " + this.width + ", height: " + length + ", perimeter: " + getPerimeter() + ", area: " + getArea();
    }
}
