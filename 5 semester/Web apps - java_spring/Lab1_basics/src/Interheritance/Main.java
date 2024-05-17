package Interheritance;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Rectangle(5, 15));
        shapes.add(new Square(5));
        shapes.add(new TrapezeIsosceles(5,10,6));
        shapes.add(new Triangle(2, 2, 2));


        shapes.forEach(System.out::println);

    }
}