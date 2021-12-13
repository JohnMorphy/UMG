using System;

namespace lab3
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 nbr=Losowanie();
            
            Console.WriteLine("Program wygenerował liczbę z przedziału od losowych granicach z min od 0 do 9000 z max od 1000 do 10000");
            while(true)
            {
                Console.WriteLine("Podaj swój strzał");
                int n=int.Parse(Console.ReadLine());
                if(n==nbr)
                {
                    Console.WriteLine("Podałeś poprawny wynik!");
                    break;
                }
                else if(n>nbr)
                {
                    Console.WriteLine("Podałeś za dużą liczbę");
                }
                else
                {
                    Console.WriteLine("Podałeś za małą liczbę");
                }
            }
        }

        static Int32 Losowanie()
        {

            Random rng = new Random();
            int min = rng.Next() % (9001);
            int max = 1000 + rng.Next() % (9001);
            
            if(max-min<1000)
            {
                return Losowanie();
            }
            else
            {
                int nbr = rng.Next(min, max);
                Console.WriteLine(min + " " + max);
                return nbr;
            }
            
        }
    }
}
