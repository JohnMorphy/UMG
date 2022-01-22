package com.company;

public class Main {
    public static void main(String[] args) {

        System.out.println("Skuteczność algorytmów sortowania dla różnych rozmiarów tablic");
        System.out.println("Tablice wypełnione losowymi wartościami w zakresie od 0 do 10000");
        Tools.Test(100);
        Tools.Test(1000);
        Tools.Test(10000);
        Tools.Test(100000);
    }
}