package com.company;

public class Main {
    public static void main(String[] args) {
        int n = Tools.Init();
        int list[] = new int[n];
        int auxList[] = new int[n];
        Tools.FillIn(list);
        Tools.AuxList(list, auxList);
        System.out.println("Tablica przed sortowaniem: ");
        Tools.PrintList(list);

        long start = System.nanoTime();
        BubbleSort.Sort(list);
        long finish = System.nanoTime();
        long elapsedTime = finish - start;
        System.out.println("Czas posortowania metodą sortowania bąbelkowego w milisekundach: " + elapsedTime/1000);
        Tools.AuxList(auxList, list);

        start = System.nanoTime();
        InsertionSort.Sort(list);
        finish = System.nanoTime();
        elapsedTime = finish - start;
        System.out.println("Czas posortowania metodą sortowania przez wstawianie w milisekundach: " + elapsedTime/1000);
        Tools.AuxList(auxList, list);

        start = System.nanoTime();
        MergeSort.Sort(list);
        finish = System.nanoTime();
        elapsedTime = finish - start;
        System.out.println("Czas posortowania metodą sortowania przez scalanie w milisekundach: " + elapsedTime/1000);
        Tools.AuxList(auxList, list);
    }
}