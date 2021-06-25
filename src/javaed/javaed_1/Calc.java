package javaed.javaed_1;

public class Calc {
    public static double Add(double a, double b) {
        return a + b;
    }

    public static double Sub(double a, double b) {
        return a - b;
    }

    public static double Mult(double a, double b) {
        return a * b;
    }

    public static double Div(double a, double b) {
        double c = 0;
        try {
            c = a / b;
        } catch (Exception ex) {
            ex.getMessage();
        }

        return c;
    }
}
