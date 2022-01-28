package com.company;

public class Main {
    public static void main(String[] args) {

        System.out.println("Skuteczność algorytmów sortowania dla różnych rozmiarów tablic");
        Tools.Set();
        /*
        Funkcje przy pierwszym wywołaniu są wolniejsze, dlatego korzystam z funkcji Set która wywołuje wszystkie
        algorytmy sortowania bez mierzenia ich czasu
         */

        System.out.println("");
        Tools.Test(100,5);
        Tools.Test(1000,5);
        Tools.Test(10000,5);
        System.out.println("");
        Tools.Test(100,100);
        Tools.Test(1000,100);
        Tools.Test(10000,100);
        //Tools.Test(100000);
        System.out.println("");
        Tools.Test(100,10000);
        Tools.Test(1000,10000);
        Tools.Test(10000,10000);
    }
}