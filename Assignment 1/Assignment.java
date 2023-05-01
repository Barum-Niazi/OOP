import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

class LinearEquation {

    private double a, b, c, d, e, f;

    LinearEquation(double g, double h, double i, double j, double k, double l) {
        a = g;
        b = h;
        c = i;
        d = j;
        e = k;
        f = l;
    }

    public double geta() {
        return a;
    }

    public double getb() {
        return b;
    }

    public double getc() {
        return c;
    }

    public double getd() {
        return d;
    }

    public double gete() {
        return e;
    }

    public double getf() {
        return f;
    }

    public boolean isSolvable() {
        if ((geta() * getd()) - (getb() * getc()) != 0)
            return true;
        else
            return false;
    }

    public double getX() {
        double x = ((gete() * getd()) - (getb() * getf())) / ((geta() * getd()) - (getb() * getc()));
        return x;
    }

    public double getY() {
        double y = ((geta() * getf()) - (gete() * getc())) / ((geta() * getd()) - (getb() * getc()));
        return y;
    }
}

public class Assignment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat fmat = new DecimalFormat("#.0");
        Random rand = new Random();
        int random = rand.nextInt(4);

        System.out.println("Enter the values of a, b, c, d, e and f");
        LinearEquation le = new LinearEquation(input.nextDouble(), input.nextDouble(), input.nextDouble(),
                input.nextDouble(), input.nextDouble(), input.nextDouble());
        input.close();

        double a = le.geta();
        double b = le.getb();
        double c = le.getc();
        double d = le.getd();
        double e = le.gete();
        double f = le.getf();

        if (le.isSolvable() == true) {
            double x = le.getX();
            double y = le.getY();

            switch (random) {
                case 0:
                    System.out.println("X is: " + fmat.format(x) + " Y is: " + fmat.format(y));
                    break;
                case 1:
                    System.out.println("(x, y) = (" + fmat.format(x) + ", " + fmat.format(y) + ")");
                    break;
                case 2:
                    System.out.println("X = " + fmat.format(x) + " Y = " + fmat.format(y));
                    break;
                case 3:
                    System.out.println("The solution is (" + fmat.format(x) + ", " + fmat.format(y) + ")");
                    break;
            }
        }
        if (le.isSolvable() == false) {
            switch (random) {
                case 0:
                    System.out.println("The equation has no solution");
                    break;
                case 1:
                    System.out.println("The equation cannot be solved");
                    break;
                case 2:
                    System.out.println("Error: No solution exists for the equation");
                    break;
                case 3:
                    System.out.println("The equation with following co-efficients is unsolvable:");
                    System.out.println(
                            "A = " + fmat.format(a) + " B = " + fmat.format(b) + " C = " + fmat.format(c) + " D = "
                                    + fmat.format(d) + " E = " + fmat.format(e) + " F = " + fmat.format(f));
                    break;
            }

        }
    }
}
