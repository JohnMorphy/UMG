package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Kopiec<T extends Comparable<T>> {

    ArrayList<T> lista = new ArrayList<>();

    public boolean czyJestKopcem() {
        int dlugosc = lista.size();
        boolean jestKopcem=true;
        for(int k = 1; k< lista.size(); k++){
            if(2*k>=dlugosc) return true;
            jestKopcem = lista.get(k).compareTo(lista.get(2*k))>=0;
            if(2*k+1>=dlugosc) return jestKopcem;
            jestKopcem = jestKopcem && lista.get(k).compareTo(lista.get(2*k+1))>=0;
            if(!jestKopcem) return false;
        }
        return true;
    }

    public void zanurzanie(int k) {
        int N = lista.size() - 1;
        int j;
        while (2*k<=N) {
            j=2*k;
            if(j<N && lista.get(j).compareTo(lista.get(j+1))<0) j++;
            if(!(lista.get(k).compareTo(lista.get(j))<0)) break;
            T pom=lista.get(k);
            lista.set(k, lista.get(j));
            lista.set(j, pom);
            k=j;
        }
    }

    public void zanurzanie(int k, int N) {
        int j;
        while (2*k<=N) {
            j=2*k;
            if(j<N && lista.get(j).compareTo(lista.get(j+1))<0) j++;
            if(!(lista.get(k).compareTo(lista.get(j))<0)) break;
            T pom=lista.get(k);
            lista.set(k, lista.get(j));
            lista.set(j, pom);
            k=j;
        }
    }

    public void wynurzanie(int k) {
        T pom;
        while (k>1 && lista.get(k/2).compareTo(lista.get(k))<0) {
            pom = lista.get(k);
            lista.set(k, lista.get(k/2));
            lista.set(k/2, pom);
            k = k/2;
        }
    }

    public void utworzKopiec() {
        int N = lista.size();
        for(int k=N/2; k>=1; k--) zanurzanie(k);
    }

    public void sortuj() {
        int N = lista.size()-1;
        utworzKopiec();
        while (N>1) {
            T pom = lista.get(1);
            lista.set(1, lista.get(N));
            lista.set(N--, pom);
            zanurzanie(1, N);
        }
    }

    public void drukuj() {
        for (T t : lista) System.out.print(t + " ");
        System.out.println();
    }

    public void dopisz(T dopisywany) {
        lista.add(dopisywany);
        wynurzanie(lista.size()-1);
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
        lista.set(1, lista.get(lista.size()-1));
        lista.remove(lista.size()-1);
        zanurzanie(1, lista.size()-1);
    }

    public static void main(String[] args) {
        Kopiec<Osoba> kopiec0=new Kopiec<>();
        kopiec0.dopisz(new Osoba());
        kopiec0.dopisz(new Osoba("Nowak", "Kazimierz", "1998-3-11"));
        kopiec0.dopisz(new Osoba("Żabiński", "Mateusz", "1992-11-1"));
        kopiec0.dopisz(new Osoba("Angielska", "Anna", "1990-11-1"));
        kopiec0.dopisz(new Osoba("Wyczliński", "Krzysztof", "2002-1-1"));
        //kopiec0.zabierz();
        kopiec0.drukuj();


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


