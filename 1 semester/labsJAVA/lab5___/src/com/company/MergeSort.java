package com.company;

public class MergeSort {

    static Three[] ListOfThrees = new Three[100];

    static int CreateThrees(int n)
    {
        int number=0;
        int tr1 = 0, tr2, tr3, pzakres;
        for(int zakres=2; zakres<n+1; zakres*=2)
        {
            for(int x=0; x<n; x+=zakres)
            {
                tr1=x; tr2=x+(zakres-1)/2;
                pzakres=zakres;
                while(tr2>n-1)
                {
                    pzakres=pzakres/2;
                    tr2=x+(pzakres-1)/2;
                }
                tr3=x+zakres-1;
                if(tr3>n-1) tr3=n-1;
                ListOfThrees[number++]=new Three(tr1, tr2, tr3);
                ListOfThrees[number-1].Print();
            }
        }
        ListOfThrees[number++] = new Three(0, tr1-1, n - 1);
        ListOfThrees[number-1].Print();
        return number;
    }

    public static void MergeSortExecute(int[] tab, int[] pomocnicza)
    {
        int n= CreateThrees(tab.length);
        for(int i=0; i<n; i++)
        {
            Scalanie(tab, pomocnicza, ListOfThrees, i);
        }
    }


    public static void Scalanie(int[] tab, int[] pomocnicza, Three[] listOfThrees, int lok)
    {
        int odPoz=listOfThrees[lok].x;
        int doPoz=listOfThrees[lok].z;
        int srodek=listOfThrees[lok].y;
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
}

class Three
{
    int x, y, z;
    public Three(int x, int y, int z)
    {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public void Print()
    {
        System.out.println(this.x + " " + this.y + " " + this.z);
    }

    //public Three() {}
}