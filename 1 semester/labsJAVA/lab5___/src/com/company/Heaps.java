package com.company;

public class Heaps {
    public static boolean Heap(int[] list)
    {
        int length = list.length;
        boolean isHeap;
        for(int i=1; i<list.length; i++)
        {
            if(2*i>=length) return true;
            isHeap=list[i]>=list[2*i];
            if(2*i+1>=length) return isHeap;
            isHeap=isHeap && list[i]>=list[2*i+1];
            if(!isHeap) return false;
        }
        return true;
    }
    public static void isHeap(boolean isHeap)
    {
        if(!isHeap)
        {
            System.out.println("Second list is not a Heap");
        }
        else
        {
            System.out.println("Second list is a Heap");
        }
    }
    public static void wynurzanie(int[] list, int i)
    {
        int pom;
        while(i>1 && list[i/2]<list[i])
        {
            pom=list[i];
            list[i]=list[i/2];
            list[i/2]=pom;
            i=i/2;
        }
    }
}
