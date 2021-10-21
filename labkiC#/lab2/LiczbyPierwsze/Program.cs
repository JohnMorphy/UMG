using System;

namespace LiczbyPierwsze
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Program podaje liczby pierwsze od 2 do liczby podanej przez użytkownika\r\nPodaj liczbę naturalną");
            Int32 n = Int32.Parse(Console.ReadLine());
            SitoEratostenesa(n);
        }

        public static void SitoEratostenesa(Int32 n)
        {
            Int32 bufor=0;
            Int32[] t1;
            t1=new Int32[n-1];

            for(int i=0; i<n-1; i++)
            {
                t1[i]=i+2;
            }

            for(int i=0; i<Math.Sqrt(n)+1; i++)
            {                
                for(int j=i; j<n-2-bufor; j++)
                {   
                    if(t1[j+1]%t1[i]==0)
                    {
                        //w tablicy nie ma metod do usuwanie jej elementów? trzeba skorzystać z innego sposobu przechowywania danych np. z listy?
                        //ta pętla służy do usuwania liczb nie pierwszych poprzez nadpisanie, więc nie jest to efektywne
                        for(int k=j; k<n-3-bufor; k++)
                        {
                            t1[k+1]=t1[k+2];
                        }
                        bufor++;
                    }
                }
            }

            for(int i=0; i<n-bufor-1; i++)
            {
               Console.Write(t1[i]+" ");
            }
        }
    }
}
