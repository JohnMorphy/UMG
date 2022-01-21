package com.company;

import java.util.Random;


public class Tools {
    public static int Init ()
    {
        System.out.println("tworzę tablice 1000 elementów wypełnioną losowymi wartościami w zakresie 0 do 99");
        return 1000;
    }
    static void FillIn(int[] list)
    {
        Random rand = new Random();
        for(int i=0; i<list.length; i++)
            list[i] = rand.nextInt(100000);
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
        System.out.println();
    }

}
