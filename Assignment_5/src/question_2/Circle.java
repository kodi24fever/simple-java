package question_2;

public class Circle extends TwoDShape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public Circle(String color){
        super(color);
        radius = 1.0;
    }

    public Circle(double radius){
        super("Blue");
        this.radius = radius;
    }


    public double getPerimeter(){return Math.PI * 2 * radius;}
    public double getArea() {return Math.PI * super.getArea(radius, radius);}

    @Override
    public String toString(){return "Circle radius: " + radius;}
}
