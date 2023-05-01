import java.util.Scanner;

class Square {

    double s;

    Square() { // non parameteried constructor
        Scanner sq = new Scanner(System.in);
        System.out.println("Assign value to non parameterized square: ");
        s = sq.nextDouble();
    }

    Square(double i) { // parameterized constructor
        s = i;
    }

    public double computePerimeter() {
        double perimeter = 4 * s;
        return perimeter;
    }
}

class Rectangle {

    double length;
    double width;

    Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    Rectangle() {

    }

    public double computePerimeter() {
        double perimeter = 2 * length + 2 * width;
        return perimeter;
    }

    public static void computePerimeter(double l, double w) {

        double perimeter = 2 * l + 2 * w;
        System.out.println("Perimeter is " + perimeter);
    }
}

class Triangle {

    double a;
    double b;
    double c;

    public double computePerimeter(double i, double y, double z) {
        a = i;
        b = y;
        c = z;
        double perimeter = a + b + c;
        return perimeter;
    }

    public int computePerimeter(int i, int y, int z) { // overloading
        int a = i;
        int b = y;
        int c = z;
        int perimeter = a + b + c;
        return perimeter;
    }

    public double rcomputePerimeter(double i, double y) { // for right triangle
        a = i;
        b = y;
        double perimeter = a + b + (Math.sqrt(a * a + b * b));
        return perimeter;
    }
}

class Circle {

    double radius;

    public double computePerimeter(double i) {
        radius = i;
        double perimeter = 2 * 3.14 * radius;
        return perimeter;
    }

}

public class Quiz {

    public static void main() {
        System.out.println("Main test");
    }

    public static void main(String args) {
        System.out.println("Main overload");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Square nsqre = new Square();
        System.out.println("Assign value to parameterized square: ");
        Square sqre = new Square(input.nextDouble());

        System.out.println("Perimeter of non parameterized square is: " + nsqre.computePerimeter());
        System.out.println("Perimeter of parameterized square is: " + sqre.computePerimeter());

        System.out.println("Enter the length and width of your rectangle");
        Rectangle r = new Rectangle(input.nextDouble(), input.nextDouble());
        Rectangle rStat = new Rectangle();

        System.out.println("Perimeter of your rectangle is: " + r.computePerimeter());
        System.out.println("Enter length and width for static perimeter: ");
        Rectangle.computePerimeter(input.nextDouble(), input.nextDouble());

        Triangle tri = new Triangle();
        Triangle rtri = new Triangle();
        System.out.println("Enter the values of a, b and c in double form");
        System.out.println(" " + tri.computePerimeter(input.nextDouble(), input.nextDouble(), input.nextDouble()));

        System.out.println("Enter the values of a, b and c in integer form to get perimeter in int");
        System.out.println(" " + tri.computePerimeter(input.nextInt(), input.nextInt(), input.nextInt()));

        System.out.println("Enter a and b for right triangle");
        System.out.println("P of right triangle is: " + rtri.rcomputePerimeter(input.nextDouble(), input.nextDouble()));

        Circle cir = new Circle();
        System.out.println("Enter radius of your circle");
        System.out.println("Perimeter of your circle is: " + cir.computePerimeter(input.nextDouble()));

        main();
        main("test");
    }
}
