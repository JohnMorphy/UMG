package com.company;

import java.util.Random;


public class Tools {

    static void Set()
    {
        int list[] = new int[10];
        int auxList[] = new int[10];
        Tools.FillIn(list, 11);
        Tools.AuxList(list, auxList);
        BubbleSort.Sort(list);
        InsertionSort.Sort(list);
        MergeSort.Sort(list);
    }

    static void FillIn(int[] list, int y)
    {
        Random rand = new Random();
        for(int i=0; i<list.length; i++)
            list[i] = rand.nextInt(y);
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
    static void Test(int x, int y)
    {
        System.out.println("Czasy sortowań dla tablicy "+ x +" elementowej wypełnionej losowymi wartościami w zakresie od 0 do " + y);
        int list[] = new int[x];
        int auxList[] = new int[x];
        Tools.FillIn(list, y+1);
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
