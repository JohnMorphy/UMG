package com.company;

public class BubbleSort
{
    static void Sort(int[] list)
    {
        int poz=0;
        int n=list.length-1;
        boolean posortowane;
        do
        {
            posortowane=true;
            for(int j=0; j<n-poz; j++)
            {
                if (list[j] > list[j + 1]) {
                    int bufor = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = bufor;
                    posortowane = false;
                }
            }
            poz++;
        }while(posortowane==false);
    }
}
