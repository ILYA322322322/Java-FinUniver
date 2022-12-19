interface Calling {
    public double clc(double x);


}
public class Procedure {

    public static double bisect(Calling f, double a, double b, double fa, double fb, double eps) {
        double c, fc;
        c = 0.5 * (a + b);
        if (Math.abs(a - b) < eps) return c;
        fc = f.clc(c);
        if (fc * fa < 0)
            return bisect(f, a, c, fa, fc, eps);
        else
            return bisect(f, c, b, fc, fb, eps);
    }

    public static void main(String[] args) {
        Calling Regl_zad = new Calling() {
            public double clc(double x) {
                return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
            }
        };
        System.out.println("x=" + bisect(Regl_zad, 0.0, 10.0, Regl_zad.clc(0.0), Regl_zad.clc(10.0), 1.0e-6));
    }
}