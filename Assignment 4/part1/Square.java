package assignment4.part1;

public class Square extends Shape{

    private double side;

    public Square(double side) {
        super("Square");
        setSide(side);
    }

    @Override
    public double getArea(){
        return Math.round(side * side * 100.0) / 100.0;
    }

    @Override
    public double getPerimeter(){
        return Math.round(4 * side * 100.0) / 100.0;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
