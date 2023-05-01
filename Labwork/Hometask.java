import java.util.*;

class QuadraticRoots {

    private double a;
    private double b;
    private double c;
    private double root1;
    private double root2;

    public void seta(double i) {
        a = i;
    }

    public double geta() {
        return a;
    }

    public void setb(double x) {
        b = x;
    }

    public double getb() {
        return b;
    }

    public void setc(double z) {
        c = z;
    }

    public double getc() {
        return c;
    }

    public void computeRoots(double a, double b, double c) {
        root1 = (-b + Math.sqrt(b * b - 4.0 * (a * c))) / 2.0 * a;
        root2 = (-b - Math.sqrt(b * b - 4.0 * (a * c))) / 2.0 * a;
    }

    public void displayRoots() {
        System.out.println("Root 1 is: " + root1);
        System.out.println("Root 2 is: " + root2);
    }
}

public class Hometask {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        QuadraticRoots qr = new QuadraticRoots();

        System.out.println("Input the value of a");
        double i = input.nextDouble();
        qr.seta(i);
        System.out.println("Value of a is: " + qr.geta());

        System.out.println("Input the value of b");
        double x = input.nextDouble();
        qr.setb(x);
        System.out.println("Value of b is: " + qr.getb());

        System.out.println("Input the value of c");
        double z = input.nextDouble();
        qr.setc(z);
        System.out.println("Value of c is: " + qr.getc());

        qr.computeRoots(qr.geta(), qr.getb(), qr.getc());
        qr.displayRoots();

    }
}