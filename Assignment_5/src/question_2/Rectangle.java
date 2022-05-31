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

    public Rectangle(String color) {
        super(color);
        this.width = 5.0;
        this.length = 7.0;
    }

    public double getPerimeter(){return 2 * ( width * length);}
    public double getArea() {return super.getArea(width, length);}


    public void horizontalMarriage(Rectangle another){
        this.width += another.width;
        if(this.length < another.length)
            this.length = another.length;
    }

    public void horizontalMarriage(Rectangle[] list){
        for(Rectangle another: list)
            this.width += another.width;

    }



    @Override
    public String toString(){
        return "Rectangle width: " + this.width + ", height: " + length + ", perimeter: " + getPerimeter() + ", area: " + getArea();
    }
}
