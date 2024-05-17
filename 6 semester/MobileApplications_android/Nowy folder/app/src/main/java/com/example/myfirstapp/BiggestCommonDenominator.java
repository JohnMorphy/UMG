package com.example.myfirstapp;

public class BiggestCommonDenominator {

    public static int calculate(int number1, int number2) {
        int biggestCommonDenominator = 1;
        for (int i = 1; i <= number1 && i <= number2; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                biggestCommonDenominator = i;
            }
        }
        return biggestCommonDenominator;
    }
}
