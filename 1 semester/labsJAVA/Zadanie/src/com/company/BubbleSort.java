package com.company;

public class BubbleSort
{
    static void Sort(int[] list)
    {
        int poz=0;
        boolean posortowane;
        do
        {
            posortowane=true;
            for(int j=0; j<list.length-1-poz; j++)
            {
                if (list[j] > list[j + 1])
                {
                    int bufor = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = bufor;
                    posortowane = false;
                }
                poz++;
            }
        }while(!posortowane);
    }
}
