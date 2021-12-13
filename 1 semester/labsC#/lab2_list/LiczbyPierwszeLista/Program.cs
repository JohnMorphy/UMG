using System;
using System.Collections.Generic;


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
            List<int> t1 = new List<int>();

            for(int i=2; i<n+1; i++)
            {
                t1.Add(i);
            }
             
            for(int i=0; i<Math.Sqrt(t1.Count)+1; i++)
            {                
                for(int j=i; j<t1.Count-1; j++)
                {   
                    if(t1[j+1]%t1[i]==0)
                    {
                        t1.RemoveAt(j+1);
                    }
                }
            }

            for(int i = 0; i < t1.Count; i++)
            {
                Console.Write(t1[i] + " ");
            }
        }
    }
}
