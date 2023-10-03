package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Heaps<T extends Comparable<T>> {

    ArrayList<T> list = new ArrayList<>();

    public boolean isHeap() {
        int length = list.size();
        boolean isHeap=true;
        for(int k = 1; k< list.size(); k++){
            if(2*k>=length) return true;
            isHeap = list.get(k).compareTo(list.get(2*k))>=0;
            if(2*k+1>=length) return isHeap;
            isHeap = isHeap && list.get(k).compareTo(list.get(2*k+1))>=0;
            if(!isHeap) return false;
        }
        return true;
    }

    public void submerge(int k) {
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

    public void submerge(int k, int N) {
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

    public void emerge(int k) {
        T pom;
        while (k>1 && list.get(k/2).compareTo(list.get(k))<0) {
            pom = list.get(k);
            list.set(k, list.get(k/2));
            list.set(k/2, pom);
            k = k/2;
        }
    }

    public void createHeap() {
        int N = list.size();
        for(int k=N/2; k>=1; k--) submerge(k);
    }

    public void sort() {
        int N = list.size()-1;
        createHeap();
        while (N>1) {
            T pom = list.get(1);
            list.set(1, list.get(N));
            list.set(N--, pom);
            submerge(1, N);
        }
    }

    public void print() {
        for (T t : list) System.out.print(t + " ");
        System.out.println();
    }

    public void add(T added) {
        list.add(added);
        emerge(list.size()-1);
    }

    public static void randomize(float[] randomized, int min, int max)
    {
        Random random = new Random();
        if(max<min)
        {
            int buffer=min;
            min = max;
            max = buffer;
        }
        for(int i=1; i< randomized.length; i++)
        {
            randomized[i]=random.nextFloat()*(max-min)+min;
        }
    }

    public void take()
    {
        list.set(1, list.get(list.size()-1));
        list.remove(list.size()-1);
        submerge(1, list.size()-1);
    }

    public static void main(String[] args) {

    }
}


