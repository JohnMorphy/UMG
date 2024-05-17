package com.example.myfirstapp;

public class LeastCommonMultiple extends BiggestCommonDenominator {

    public static int calculate(int number1, int number2) {

        return number1 * number2 /
                BiggestCommonDenominator.calculate(number1, number2);
    }

}
