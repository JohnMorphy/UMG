package com.company;

public class Main {
    static int[] convertTo2(int x, int n){
        int[]zw = new int[n];
        for(int i=0;i<n;i++){
            zw[n-1-i]=x%2;
            x=x/2;
        }
        return zw;
    }

    static int convertTo10(int[] list){
        int weigh=1;
        int value10=0;
        int end=list.length-1;
        weigh=weigh<<end;
        for(int i=0; i<=end;i++)
        {
            value10+=list[i]*weigh;
            weigh/=2;
        }
        return value10;
    }

    public static void print(int[] list)
    {
        for(int i=0; i<list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] listA = convertTo2(23,6);
        print(listA);
        int[] listB = convertTo2(52,6);
        print(listB);
        int[] listW={0,0,0,0,0,0,0};
        int carryOver=0;
        int bitSum=0;
        System.out.println("======================");
        for(int i= listA.length-1; i>=0; i--)
        {
            bitSum=listA[i]+listB[i]+carryOver;
            switch (bitSum) {
                case 0:
                    listW[i + 1] = 0;
                    break;
                case 1:
                    listW[i + 1] = 1;
                    carryOver = 0;
                    break;
                case 2:
                    listW[i + 1] = 0;
                    carryOver = 1;
                    break;
                case 3:
                    listW[i + 1] = 1;
                    carryOver = 1;
            }

        }
        listW[0]=carryOver;
        print(listW);
    }
}