package assignment4.part1;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        super("Circle");
        setRadius(radius);
    }

    @Override
    public double getArea(){
        return Math.round(Math.PI * Math.pow(radius,2) * 100.0) / 100.0;
    }

    @Override
    public double getPerimeter(){
        return Math.round(2 * Math.PI * radius * 100.0) / 100.0;
    }

    public double getRadius() { return radius; }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

