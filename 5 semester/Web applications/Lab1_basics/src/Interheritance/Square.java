package Interheritance;

import Interheritance.Quadrangle;

public class Square extends Quadrangle {

    @Override
    double getArea() {
        return Math.pow(this.sides[0],2);
    }

    public Square(double sideLength) {
        super("Square",
                new double[]{sideLength, sideLength, sideLength, sideLength},
                new double[]{90.0, 90.0, 90.0, 90.0});
//        Arrays.fill(this.diagonals, Math.sqrt(Math.pow(sideLength, 2) * Math.pow(sideLength, 2)));
    }

}
