package com.company;

public class BinaryNumbers {
    static int[] ConvertToBinary(int x, int n2){
        int[]zw = new int[n2];
        for(int i=0;i<n2;i++){
            zw[n2-1-i]=x%2;
            x=x/2;
        }
        return zw;
    }

    static int ConvertToDecimal(int[] list){
        int scale=1;
        int value10=0;
        int length=list.length-1;
        scale=scale<<length;
        for(int i=0; i<=length;i++)
        {
            value10+=list[i]*scale;
            scale/=2;
        }
        return value10;
    }

    public static void PrintList(int[] list)
    {
        for (int j : list) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void BinarySum()
    {
        int[] listA= ConvertToBinary(23, 6);
        PrintList(listA);
        int[] listB= ConvertToBinary(52, 6);
        PrintList(listB);
        int[] listW={0,0,0,0,0,0,0};
        int carryOver=0;
        int sumBit;
        System.out.println("======================");
        for(int i= listA.length-1; i>=0; i--)
        {
            sumBit=listA[i]+listB[i]+carryOver;
            switch (sumBit) {
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
        PrintList(listA);
        PrintList(listB);
        PrintList(listW);
        System.out.println(ConvertToDecimal(listW));
    }
}
