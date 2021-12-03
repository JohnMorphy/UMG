package com.company;

public class Main {
    static int[]konwertuj(int x, int n2){
        int[]zw = new int[n2];
        for(int i=0;i<n2;i++){
            zw[n2-1-i]=x%2;
            x=x/2;
        }
        return zw;
    }

    static int konwertuj10(int[] lista){
        int waga=1;
        int wartosc10=0;
        int koniec=lista.length-1;
        waga=waga<<koniec;
        for(int i=0; i<=koniec;i++)
        {
            wartosc10+=lista[i]*waga;
            waga/=2;
        }
        return wartosc10;
    }

    public static void drukuj(int[] lista)
    {
        for(int i=0; i<lista.length; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] listaA=konwertuj(23, 6);
        drukuj(listaA);
        int[] listaB=konwertuj(52, 6);
        drukuj(listaB);
        int[] listaW={0,0,0,0,0,0,0};
        int przeniesienie=0;
        int sumaBit=0;
        System.out.println("======================");
        for(int i= listaA.length-1; i>=0; i--)
        {
            sumaBit=listaA[i]+listaB[i]+przeniesienie;
            switch (sumaBit) {
                case 0:
                    listaW[i + 1] = 0;
                    break;
                case 1:
                    listaW[i + 1] = 1;
                    przeniesienie = 0;
                    break;
                case 2:
                    listaW[i + 1] = 0;
                    przeniesienie = 1;
                    break;
                case 3:
                    listaW[i + 1] = 1;
                    przeniesienie = 1;
            }

        }
        listaW[0]=przeniesienie;
        drukuj(listaA);
        drukuj(listaB);
        drukuj(listaW);
        System.out.println(konwertuj10(listaW));
    }
}