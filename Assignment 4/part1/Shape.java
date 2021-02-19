package assignment4.part1;

public class Shape {

    private String name = "Shape";
    private double perimeter;
    private double area;

    public Shape(){ }

    public Shape(String name){ this.name = name; }

    public void draw(){
        System.out.println("Drawing " + name);
    }

    public double getArea(){
        return area;
    }

    public double getPerimeter(){
        return perimeter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
