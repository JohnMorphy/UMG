package com.company;

import java.text.Collator;
import java.util.Locale;
import java.util.Random;

public class InsertionSort {

    static Collator compare = Collator.getInstance(new Locale("pl"));

    static void FillIn(int[] list, int n)
    {
        for(int i=0; i<n; i++)
            list[i] = przypadkowe.nextInt();
    }

    static void PrintList(int[] list)
    {
        for (int j : list) System.out.print(j + " ");
        System.out.println();
    }

    static void PrintList(String[] list)
    {
        for (String j : list) System.out.print(j + " ");
        System.out.println();
    }

    static void BubbleSort(int[] list)
    {
        int poz=0;
        boolean posortowane;
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

    static void BubbleSort(String[] list)
    {
        int poz=0;
        boolean posortowane=true;
        do
        {
            posortowane=true;
            for(int j=0; j<list.length-1-poz; j++)
                if(compare.compare(list[j], list[j+1])>0)
                {
                    String bufor = list[j];
                    list[j]=list[j+1];
                    list[j+1]=bufor;
                    posortowane=false;
                }
            poz++;
        }while(!posortowane);
    }

    static void InsertionSort(String[] list) // od prawej strony
    {
        String bufor="";
        for(int i=list.length-1; i>=0; i--)
            for(int j = i; j <list.length-1 && compare.compare(list[j+1],list[j])>0; j++)
            {
                bufor=list[j];
                list[j]=list[j+1];
                list[j+1]=bufor;
            }
    }

    static void InsertionSort(int[] list) // od prawej strony
    {
        int bufor;
        for(int i=list.length-1; i>=0; i--)
            for(int j=i; j <list.length-1 && list[j+1]<list[j];j++)
            {
                bufor=list[j];
                list[j]=list[j+1];
                list[j+1]=bufor;
            }
    }

    static Random przypadkowe = new Random(100);

    public static void main(String[] args) {
        int n = 5;
        int[] niePosortowane = new int[n];
        FillIn(niePosortowane, n);
        String[] Napisy = {"witam", "hej", "A", "abc", "władza", "Łożysko", "Wołoszczyzna", "Osiem", "Dziewięć", "Dziesięć"};

        int[] tab1 = new int[n];
        FillIn(tab1, n);
        InsertionSort(tab1);


        int[] tab2 = new int[n];
        FillIn(tab2, n);
        InsertionSort(tab2);

        int[] tab3 = new int[2*n];

        System.arraycopy(tab1, 0, tab3, 0, n);
        System.arraycopy(tab2, 0, tab3, n, 2 * n - n);
    }
}
