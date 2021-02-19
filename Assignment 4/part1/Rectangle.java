package assignment4.part1;

public class Rectangle extends Shape{

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        setWidth(width);
        setHeight(height);
    }

    @Override
    public double getArea(){
        return Math.round(width * height * 100.0) / 100.0;
    }

    @Override
    public double getPerimeter(){
        return Math.round(2 * (width + height) * 100.0) / 100.0;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
