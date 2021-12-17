package com.company;

import java.text.Collator;
import java.util.Locale;
import java.util.Random;

public class Sortowanie {

    static Collator komparator = Collator.getInstance(new Locale("pl"));

    static void FillIn(int[] tablica, int n)
    {
        for(int i=0; i<n; i++)
            tablica[i] = przypadkowe.nextInt();
    }

    static void PrintList(int[] tablica)
    {
        for (int j : tablica) System.out.print(j + " ");
        System.out.println();
    }

    static void PrintList(String[] tablica)
    {
        for (String j : tablica) System.out.print(j + " ");
        System.out.println();
    }

    static void BubbleSort(int[] tablica)
    {
        int poz=0;
        boolean posortowane;
        {
            posortowane=true;
            for(int j=0; j<tablica.length-1-poz; j++)
            {
                if (tablica[j] > tablica[j + 1])
                {
                    int bufor = tablica[j];
                    tablica[j] = tablica[j + 1];
                    tablica[j + 1] = bufor;
                    posortowane = false;
                }
                poz++;
            }
        }while(!posortowane);
    }

    static void BubbleSort(String[] tablica)
    {
        int poz=0;
        boolean posortowane=true;
        do
        {
            posortowane=true;
            for(int j=0; j<tablica.length-1-poz; j++)
                if(komparator.compare(tablica[j], tablica[j+1])>0)
                {
                    String bufor = tablica[j];
                    tablica[j]=tablica[j+1];
                    tablica[j+1]=bufor;
                    posortowane=false;
                }
            poz++;
        }while(!posortowane);
    }

    static void InsertionSort(String[] tablica) // od prawej strony
    {
        String bufor="";
        for(int i=tablica.length-1; i>=0; i--)
            for(int j=i; j <tablica.length-1 && komparator.compare(tablica[j+1],tablica[j])>0;j++)
            {
                bufor=tablica[j];
                tablica[j]=tablica[j+1];
                tablica[j+1]=bufor;
            }
    }

    static void InsertionSort(int[] tablica) // od prawej strony
    {
        int bufor;
        for(int i=tablica.length-1; i>=0; i--)
            for(int j=i; j <tablica.length-1 && tablica[j+1]<tablica[j];j++)
            {
                bufor=tablica[j];
                tablica[j]=tablica[j+1];
                tablica[j+1]=bufor;
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
