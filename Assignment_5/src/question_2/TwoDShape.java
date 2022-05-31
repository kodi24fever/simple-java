package question_2;

// Abstract classes can have methods but no instances
public abstract class TwoDShape {
    private String color;

    public TwoDShape(String color) {

        this.color = color;

    }

    public String getColor() {
        return color;
    }

    public double getArea(double width, double length) {
        return width * length;
    }

    public String toString(){
        return "Generic 2d object, color: " + this.color;
    }

    // An abstract method makes the whole class abstract
    public abstract double getPerimeter();
    public abstract double getArea();

}
