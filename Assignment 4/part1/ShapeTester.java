package assignment4.part1;

public class ShapeTester {
    public static void main(String[] args) {
        Shape s = new Shape();
        Rectangle r = new Rectangle(2.0, 3.0);
        Circle c = new Circle(4.0);
        Square sq = new Square(4.0);
        System.out.println(r.getArea()); // should print 6.0
        System.out.println(r.getPerimeter());// should print 10.0
        System.out.println(c.getArea());// should print 50.26
        System.out.println(c.getPerimeter());// should print 25.13
        System.out.println(sq.getArea());// should print 16.0
        System.out.println(sq.getPerimeter());// should print 16.0
        r.draw();// should print “Drawing rectangle”
        c.draw();// should print “Drawing Circle”
        s.draw();// should print “Drawing Shape”
        sq.draw(); // should print “Drawing Square”
    }
}
