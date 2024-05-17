package Interheritance;

import Interheritance.Quadrangle;

public class Rectangle extends Quadrangle {

    @Override
    double getArea() {
        return this.sides[0] * this.sides[1];
    }

    public Rectangle(double sideA, double sideB) {
        super("Rectangle",
                new double[]{sideA, sideB, sideA, sideB},
                new double[]{90.0, 90.0, 90.0, 90.0});
    }

}
