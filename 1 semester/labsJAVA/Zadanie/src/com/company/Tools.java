package com.company;

import java.util.Random;


public class Tools {

    static void FillIn(int[] list)
    {
        Random rand = new Random();
        for(int i=0; i<list.length; i++)
            list[i] = rand.nextInt(10001);
    }
    static void AuxList(int[] list, int[] auxList )
    {
        for(int i=0; i<=list.length-1; i++)
            auxList[i]=list[i];
    }

    static void PrintList(int[] list)
    {
        for (int j : list) System.out.print(j + " ");
        System.out.println();
    }
    static void Test(int x)
    {
        System.out.println("Czasy sortowań dla tablicy "+ x +" elementowej wypełnionej losowymi wartościami w zakresie 0 do 10000");
        int list[] = new int[x];
        int auxList[] = new int[x];
        Tools.FillIn(list);
        Tools.AuxList(list, auxList);

        long start = System.nanoTime();
        BubbleSort.Sort(list);
        long finish = System.nanoTime();
        long elapsedTime = finish - start;
        //Tools.PrintList(list);
        System.out.println("Czas posortowania metodą sortowania bąbelkowego w milisekundach: " + elapsedTime/1000000);
        Tools.AuxList(auxList, list);
        //Tools.PrintList(list);

        start = System.nanoTime();
        InsertionSort.Sort(list);
        finish = System.nanoTime();
        elapsedTime = finish - start;
        //Tools.PrintList(list);
        System.out.println("Czas posortowania metodą sortowania przez wstawianie w milisekundach: " + elapsedTime/1000000);
        Tools.AuxList(auxList, list);
        //Tools.PrintList(list);

        start = System.nanoTime();
        MergeSort.Sort(list);
        finish = System.nanoTime();
        elapsedTime = finish - start;
        //Tools.PrintList(list);
        System.out.println("Czas posortowania metodą sortowania przez scalanie w milisekundach: " + elapsedTime/1000000);
        Tools.AuxList(auxList, list);
        //Tools.PrintList(list);
    }

}
