package Interheritance;

import Interheritance.Shape;

import java.util.Arrays;

public class Triangle extends Shape {

    protected double[] sides;
    protected double[] angles;

    @Override
    double getArea() {
        return 0;
    }

    @Override
    double getCircumference() {
        double sum = 0;

        for (double side:sides) {
            sum += side;
        }

        return sum;
    }

    public Triangle(double side1, double side2, double side3) {
        super("Triangle");
        this.sides = new double[]{side1, side2, side3};
    }

    @Override
    public String toString() {
        return  "sides=" + Arrays.toString(sides) +
                ", angles=" + Arrays.toString(angles) +
                ", description='" + description + '\'' +
                "} ";
    }
}
