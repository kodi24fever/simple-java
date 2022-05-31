package question_2;

public class TwoDShape {
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
        return "Generic 2d shape color: " + this.color;
    }

}
