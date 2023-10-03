package com.company;

public class Main {

    public static void main(String[] args) {
        ReversePN.display("2 + 2 * 2");
        ReversePN.display("( 2 + 2 ) * 2");
        ReversePN.display("10 - 5 * 2 / 5");
        ReversePN.display("100 - ( ( 10 - 2 + 12 ) / 20 - 20 - 5 * 2 / 10 )");
        ReversePN.display("4 * 10 + 7");
    }
}
