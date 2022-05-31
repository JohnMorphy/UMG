package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Heap<T extends Comparable<T>> {

    ArrayList<T> list = new ArrayList<>();

    public boolean isHeap() {
        int dlugosc = list.size();
        boolean jestKopcem=true;
        for(int k = 1; k< list.size(); k++){
            if(2*k>=dlugosc) return true;
            jestKopcem = list.get(k).compareTo(list.get(2*k))>=0;
            if(2*k+1>=dlugosc) return jestKopcem;
            jestKopcem = jestKopcem && list.get(k).compareTo(list.get(2*k+1))>=0;
            if(!jestKopcem) return false;
        }
        return true;
    }

    public void zanurzanie(int k) {
        int N = list.size() - 1;
        int j;
        while (2*k<=N) {
            j=2*k;
            if(j<N && list.get(j).compareTo(list.get(j+1))<0) j++;
            if(!(list.get(k).compareTo(list.get(j))<0)) break;
            T pom= list.get(k);
            list.set(k, list.get(j));
            list.set(j, pom);
            k=j;
        }
    }

    public void zanurzanie(int k, int N) {
        int j;
        while (2*k<=N) {
            j=2*k;
            if(j<N && list.get(j).compareTo(list.get(j+1))<0) j++;
            if(!(list.get(k).compareTo(list.get(j))<0)) break;
            T pom= list.get(k);
            list.set(k, list.get(j));
            list.set(j, pom);
            k=j;
        }
    }

    public void wynurzanie(int k) {
        T pom;
        while (k>1 && list.get(k/2).compareTo(list.get(k))<0) {
            pom = list.get(k);
            list.set(k, list.get(k/2));
            list.set(k/2, pom);
            k = k/2;
        }
    }

    public void utworzKopiec() {
        int N = list.size();
        for(int k=N/2; k>=1; k--) zanurzanie(k);
    }

    public void sortuj() {
        int N = list.size()-1;
        utworzKopiec();
        while (N>1) {
            T pom = list.get(1);
            list.set(1, list.get(N));
            list.set(N--, pom);
            zanurzanie(1, N);
        }
    }

    public void drukuj() {
        for (T t : list) System.out.print(t + " ");
        System.out.println();
    }

    public void dopisz(T dopisywany) {
        list.add(dopisywany);
        wynurzanie(list.size()-1);
    }

    public static void losuj(float[] losowe, int min, int max)
    {
        Random random = new Random();
        if(max<min)
        {
            int pomocnicza=min;
            min = max;
            max = pomocnicza;
        }
        for(int i=1; i< losowe.length; i++)
        {
            losowe[i]=random.nextFloat()*(max-min)+min;
        }
    }

    public void zabierz()
    {
        list.set(1, list.get(list.size()-1));
        list.remove(list.size()-1);
        zanurzanie(1, list.size()-1);
    }

    public static void main(String[] args) {
        Heap<Osoba> heap1 =new Heap<>();
        heap1.dopisz(new Osoba());
        heap1.dopisz(new Osoba("Nowak", "Kazimierz", "1998-3-11"));
        heap1.dopisz(new Osoba("Żabiński", "Mateusz", "1992-11-1"));
        heap1.dopisz(new Osoba("Angielska", "Anna", "1990-11-1"));
        heap1.dopisz(new Osoba("Wyczliński", "Krzysztof", "2002-1-1"));
        //kopiec0.zabierz();
        heap1.drukuj();


        /*
        Kopiec<Float> kopiec3 = new Kopiec<>();
        float[] losowe = new float[10];
        losuj(losowe, 0, 100);

        for (float v : losowe) {
            kopiec3.dopisz(v);
        }
        System.out.println("kopiec " + kopiec3.czyJestKopcem());
        kopiec3.drukuj();
        kopiec3.utworzKopiec();
        kopiec3.drukuj();
        System.out.println("kopiec3 " + kopiec3.czyJestKopcem());
        kopiec3.sortuj();
        kopiec3.drukuj();
        */

        /*
        Kopiec<String> kopiec = new Kopiec<>();
        String lista[] = {"", "Zbigniew", "Adam", "Daniel", "Celina", "Zosia"};
        Kopiec<Integer> kopiec2 = new Kopiec<>();
        Integer lista2[] = {0, 32, 15, 2, 45, 67, 65, 45, 78, 76};
        for(String s:lista) kopiec.dopisz(s);
        System.out.println("kopiec " + kopiec.czyJestKopcem());
        kopiec.utworzKopiec();
        kopiec.drukuj();
        System.out.println("kopiec " + kopiec.czyJestKopcem());

        for(z in lista2) kopiec2.dopisz(z);
        {
            kopiec2.dopisz(lista2[i]);
        }
        System.out.println("kopiec " + kopiec.czyJestKopcem());
        kopiec2.utworzKopiec();
        kopiec2.drukuj();
        System.out.println("kopiec2 " + kopiec2.czyJestKopcem());
        */
    }
}


