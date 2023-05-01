import java.util.Scanner;

abstract class Shape {
    private String color;
    private Boolean filled;

    public Shape() {
    }

    public Shape(String color, Boolean filled) {
        setColor(color);
        setFilled(filled);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public boolean isFilled() {
        if (this.filled == true)
            return true;
        else
            return false;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract String toString();
}

class Circle extends Shape {

    private double radius;

    public Circle() {
    }

    public Circle(double r) {
        super();
        setRadius(r);
    }

    public Circle(double r, String color, Boolean filled) {
        super(color, filled);
        setRadius(r);
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    public double getArea() {
        double area = Math.PI * (this.radius * this.radius);
        return area;
    }

    public double getPerimeter() {
        double perimeter = 2 * Math.PI * this.radius;
        return perimeter;
    }

    public String toString() {
        String str1 = "Shape is a circle" + " Circle area is " + getArea() + " Circle perimeter is " + getPerimeter();
        return str1;
    }
}

class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        setWidth(width);
        setLength(length);
    }

    public Rectangle(double width, double length, String color, Boolean filled) {
        super(color, filled);
        setWidth(width);
        setLength(length);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return this.width;
    }

    public double getLength() {
        return this.length;
    }

    public double getArea() {
        double area = this.width * this.length;
        return area;
    }

    public double getPerimeter() {
        double perimeter = 2 * (this.width + this.length);
        return perimeter;
    }

    public String toString() {
        String str1 = "test";
        return str1;
    }
}

public class ShapesTest {

    // 4 of question
    public static void shapeSummary(Shape sArray[]) {
        for (int i = 0; i < sArray.length; i++) {
            System.out.println(sArray[i].toString());
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // 1 and 2 of question
        Shape[] shapeArray = new Shape[] { new Circle(), new Circle(3.3, "red", true), new Circle(4), new Rectangle() };
        // 3 of question
        System.out.println("What shape data do you want to change: ");
        System.out.println("1 for circle and 2 for rectangle");
        int x = input.nextInt();

        double r = 0;
        double l = 0;
        double w = 0;
        if (x == 1) {
            System.out.println("Enter new radius of your circles");
            r = input.nextDouble();
        }
        if (x == 2) {
            System.out.println("Enter new length and width of your rectangle");
            l = input.nextDouble();
            w = input.nextDouble();
        }

        for (int i = 0; i < shapeArray.length; i++) {
            if (x == 1) {
                // checking if current element is a circle
                if (shapeArray[i] instanceof Circle) {
                    // downcasting so we can use setRadius and change the radius
                    Circle c = (Circle) shapeArray[i];
                    c.setRadius(r);
                }
            }
            if (x == 2) {
                // checking if current element is rectangle
                if (shapeArray[i] instanceof Rectangle) {
                    // downcasting so we can use setLength and setWidth
                    Rectangle rec = (Rectangle) shapeArray[i];
                    rec.setLength(l);
                    rec.setWidth(w);
                }
            }
        }
        // 5 of question
        shapeSummary(shapeArray);
    }
}
