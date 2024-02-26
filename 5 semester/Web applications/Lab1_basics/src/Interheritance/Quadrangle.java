package Interheritance;

import java.util.Arrays;

public class Quadrangle extends Shape {

    protected double[] sides;
    protected double[] angles;

    @Override
    double getArea() {
        return -1;
    }

    @Override
    double getCircumference() {
        double sum = 0;

        for (double side:sides) {
            sum += side;
        }

        return sum;
    }

    public Quadrangle(String description, double[] sides, double[] angles) {

        super(description);
        this.sides = sides.clone();
        this.angles = angles;
    }

    @Override
    public String toString() {
        return  "sides=" + Arrays.toString(sides) +
                ", angles=" + Arrays.toString(angles) +
                ", description='" + description + '\'' +
                "} ";
    }
}
