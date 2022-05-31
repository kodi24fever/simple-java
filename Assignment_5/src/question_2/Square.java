package question_2;

public class Square extends Rectangle {
    private double side;

    public Square(String color, double side) {
        super(color, side, side);
    }

    public String toString(){
        return "Square side: " + this.side;
    }
}
