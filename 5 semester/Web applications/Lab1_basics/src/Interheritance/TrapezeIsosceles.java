package Interheritance;

public class TrapezeIsosceles extends Quadrangle {

    private double height;
    private double bottom;
    private double top;

    @Override
    double getArea() {
        return (bottom + top)/2 * height;
    }

    private static double getSideLength(double bottom, double height, double top) {

        return Math.sqrt(Math.pow((bottom - top), 2) + Math.pow(height, 2));
    }

    public TrapezeIsosceles(double height, double bottom, double top) {
        super("Isosceles triangle",
                new double[]{bottom, height, top, TrapezeIsosceles.getSideLength(bottom, height, top)},
                new double[]{90.0, 90.0, 90.0, 90.0});;
        this.height = height;
        this.bottom = bottom;
        this.top = top;
    }
}
