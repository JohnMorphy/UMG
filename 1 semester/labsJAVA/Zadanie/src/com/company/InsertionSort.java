package com.company;

public class InsertionSort
{
    static void Sort(int[] list) // od prawej strony
    {
        int bufor;
        for(int i=list.length-1; i>0; i--)
            for(int j=i-1; j <list.length-1 && list[j]>list[j+1];j++)
            {
                bufor=list[j];
                list[j]=list[j+1];
                list[j+1]=bufor;
            }
    }
}
