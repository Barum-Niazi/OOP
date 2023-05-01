import java.util.ArrayList;
import java.util.Scanner;

class Complex {

    double real;
    double imaginary;

    Complex(double r, double i) {

        this.real = r;
        this.imaginary = i;
    }

    Complex() {
    }

    static Complex addComplex(Complex A, Complex B) {

        Complex sum = new Complex();

        sum.real = A.real + B.real;
        sum.imaginary = A.imaginary + B.imaginary;

        return sum;
    }

    static Complex subtractComplex(Complex A, Complex B) {

        Complex difference = new Complex();

        difference.real = A.real - B.real;
        difference.imaginary = A.imaginary - B.imaginary;

        return difference;
    }

    void multiply(Complex C2) {

        Complex temp = new Complex();
        temp.real = C2.real;
        temp.imaginary = C2.imaginary;

        C2.imaginary = (this.real * temp.imaginary) + (this.imaginary * temp.real);
        C2.real = (this.real * temp.real) - (this.imaginary * temp.imaginary);

        System.out.println("A * B = " + C2.toString());
    }

    public double modulus() {

        double modulus;
        modulus = Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
        return modulus;
    }

    public String toString() {

        String str = "(" + this.real + " + " + this.imaginary + "i)";
        return str;
    }
}

class ComplexPolynomial {

    ArrayList<Complex> coefficients = new ArrayList<Complex>();

    ComplexPolynomial(Complex c[]) {

        for (Complex copy : c) {
            coefficients.add(copy);
        }
    }

    ComplexPolynomial() {

    }

    ComplexPolynomial(double d[][]) {
        double[] array1 = new double[5];
        double[] array2 = new double[5];

        for (int i = 0; i < d.length; i++) {
            array1[i] = d[0][i]; // real part in one array
        }

        for (int i = 0; i < d.length; i++) {
            array2[i] = d[1][i]; // imaginary part in one array
        }

        for (int i = 0; i < d.length; i++) {
            Complex c = new Complex(array1[i], array2[i]);
            coefficients.add(c);
        }
    }

    public double evaluate(double x) {
        double value = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            Complex eval = new Complex();
            eval = coefficients.get(i);
            double modulus = eval.modulus();
            value += modulus * Math.pow(x, (i + 1));
        }
        return value;
    }

    void addComplexPolynomials(ComplexPolynomial p2) {

        if (coefficients.size() == p2.coefficients.size()) {
            for (int i = 0; i < coefficients.size(); i++) {
                coefficients.set(i, Complex.addComplex(coefficients.get(i), p2.coefficients.get(i)));
            }

        } else if (coefficients.size() > p2.coefficients.size()) {
            for (int i = 0; i < coefficients.size(); i++) {
                if (i < p2.coefficients.size())
                    coefficients.set(i, Complex.addComplex(coefficients.get(i), p2.coefficients.get(i)));
            }
        } else {
            for (int i = 0; i < p2.coefficients.size(); i++) {
                if (i < coefficients.size()) {
                    coefficients.set(i, Complex.addComplex(coefficients.get(i), p2.coefficients.get(i)));
                } else {
                    coefficients.add(p2.coefficients.get(i));
                }
            }
        }
    }

    public static ComplexPolynomial addComplexPolynomial(ComplexPolynomial p1, ComplexPolynomial p2) {
        ComplexPolynomial psum = new ComplexPolynomial();
        if (p1.coefficients.size() == p2.coefficients.size()) {
            for (int i = 0; i < p1.coefficients.size(); i++) {
                psum.coefficients.add(Complex.addComplex(p1.coefficients.get(i), p2.coefficients.get(i)));
            }
        } else if (p1.coefficients.size() > p2.coefficients.size()) {

            for (int i = 0; i < p1.coefficients.size(); i++) {
                if (i < p2.coefficients.size()) {
                    psum.coefficients.add(Complex.addComplex(p1.coefficients.get(i), p2.coefficients.get(i)));
                } else {
                    psum.coefficients.add(p1.coefficients.get(i));
                }
            }
        } else {
            for (int i = 0; i < p2.coefficients.size(); i++) {
                if (i < p1.coefficients.size()) {
                    psum.coefficients.add(Complex.addComplex(p1.coefficients.get(i), p2.coefficients.get(i)));
                } else {
                    psum.coefficients.add(p2.coefficients.get(i));
                }
            }
        }

        return psum;
    }

    public String toString() {
        String str1 = "P(x) = ";
        String str2 = null;
        for (int i = 0; i < coefficients.size(); i++) {
            str2 = coefficients.get(i) + "x^" + (i + 1);
            str1 = str1.concat(str2);

            if (i < (this.coefficients.size() - 1)) {
                String str3 = " + ";
                str1 = str1.concat(str3);
            }
        }

        return str1;
    }

}

public class Test {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Complex a = new Complex(5, 5);
        Complex b = new Complex(4, 3);
        Complex c = new Complex(2, 1);
        Complex d = new Complex();

        d.real = b.real;
        d.imaginary = b.imaginary;

        Complex[] arr = { a, b, c };

        double array[][] = {
                { 5, 4, },
                { 5, 3 }
        };

        ComplexPolynomial p1 = new ComplexPolynomial(array);
        ComplexPolynomial p2 = new ComplexPolynomial(arr);
        ComplexPolynomial sum = new ComplexPolynomial();

        System.out.println("Complex number A is " + a.toString());
        System.out.println("Complex number B is " + b.toString());

        a.multiply(d);

        System.out.println("Modulus of Complex number is: " + a.modulus());
        System.out.println();
        System.out.println();

        System.out.println("Polynomial p1 is: " + p1.toString());
        System.out.println("p1(x) for x = 2 is: " + p1.evaluate(2));

        System.out.println("Polynomial p2 is: " + p2.toString());
        System.out.println("p2(x) for x = 3 is: " + p2.evaluate(3));
        System.out.println();

        sum = ComplexPolynomial.addComplexPolynomial(p1, p2);
        System.out.println("p1 + p2 = " + sum.toString());

        input.close();
    }

}