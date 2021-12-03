package com.company;

import java.text.Collator;
import java.util.Locale;
import java.util.Random;

public class Sortowanie {

    static Collator komparator = Collator.getInstance(new Locale("pl"));

    static void zapis(int[] tablica, int n)
    {
        for(int i=0; i<n; i++)
            tablica[i] = przypadkowe.nextInt();
    }

    static void drukuj(int[] tablica)
    {
        for (int j : tablica) System.out.print(j + " ");
        System.out.println();
    }

    static void drukuj(String[] tablica)
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

    static void MergeSortLASTSTEP(int[] tab)
    {
        int[] pomocnicza = new int[tab.length];
        int odPoz=0;
        int doPoz=tab.length-1;
        int srodek=doPoz/2;
        for(int i=odPoz; i<=doPoz; i++)
            pomocnicza[i]=tab[i];
        int k=odPoz;
        int i=odPoz;
        int j=srodek+1;
        while(k<=doPoz)
        {
            if(i>srodek)
                tab[k]=pomocnicza[j++];
            else if(j>doPoz)
                tab[k]=pomocnicza[i++];
            else if(pomocnicza[j]<pomocnicza[i])
                tab[k]=pomocnicza[j++];
            else
                tab[k]=pomocnicza[i++];
            k++;
        }

    }

    static Random przypadkowe = new Random();

    public static void main(String[] args) {
        int n = 5;
        int[] niePosortowane = new int[n];
        zapis(niePosortowane, n);
        String[] Napisy = {"witam", "hej", "A", "abc", "władza", "Łożysko", "Wołoszczyzna", "Osiem", "Dziewięć", "Dziesięć"};

        int[] tab1 = new int[n];
        zapis(tab1, n);
        InsertionSort(tab1);


        int[] tab2 = new int[n];
        zapis(tab2, n);
        InsertionSort(tab2);

        int[] tab3 = new int[2*n];

        System.arraycopy(tab1, 0, tab3, 0, n);
        System.arraycopy(tab2, n - n, tab3, n, 2 * n - n);

        drukuj(tab3);
        MergeSortLASTSTEP(tab3);
        drukuj(tab3);


        /*
        // sortowanie liczb przez insertion sort
        drukuj(niePosortowane);
        InsertionSort(niePosortowane);
        drukuj(niePosortowane);
        // sortowanie napisów przez bubble sort
        drukuj(Napisy);
        BubbleSort(Napisy);
        drukuj(Napisy);
         */
    }
}
