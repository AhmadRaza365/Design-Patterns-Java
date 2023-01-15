import java.util.ArrayList;

// Composite Design Pattern

interface Shape {
    public void position(int x, int y);

    public void draw();

    public void add(Shape s);

    public void remove(Shape s);

    public Shape getChild(int i);

}

class Circle implements Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        System.out.println("Circle at (" + x + "," + y + ") with radius " + radius);
    }

    public void add(Shape s) {
        System.out.println("Cannot add to a Circle");
    }

    public void remove(Shape s) {
        System.out.println("Cannot remove from a Circle");
    }

    public Shape getChild(int i) {
        System.out.println("Cannot get child from a Circle");
        return null;
    }
}

class Composite implements Shape {
    private ArrayList<Shape> children = new ArrayList<Shape>();

    public void position(int x, int y) {
        System.out.println("Cannot position a Composite");
    }

    public void draw() {
        for (Shape component : children) {
            component.draw();
        }
    }

    public void add(Shape s) {
        children.add(s);
    }

    public void remove(Shape s) {
        children.remove(s);
    }

    public Shape getChild(int i) {
        return children.get(i);
    }
}

public class Task1 {
    public static void main(String[] args) {
        Shape s1 = new Circle(10, 20, 30);
        Shape s2 = new Circle(15, 25, 35);

        Shape s3 = new Composite();
        s3.add(s1);
        s3.add(s2);

        s3.draw();
    }
}