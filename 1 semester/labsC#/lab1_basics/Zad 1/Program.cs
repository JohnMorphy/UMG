using System;
namespace Zad_1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Program służy do wyliczania znajdowania właściwości funkcji kwadratowej");
            (Double A, Double B, Double C) Odczyt = (Double.Parse(Console.ReadLine()), Double.Parse(Console.ReadLine()), Double.Parse(Console.ReadLine()));

            if(Odczyt.A==0 && Odczyt.B!=0)
            {
                Console.WriteLine("Podana funkcja to funkcja liniowa\r\n1.Miejsce zerowe występuje dla x="+ (Double)(-Odczyt.C/Odczyt.B));
                if(Odczyt.B>0)
                {
                    Console.WriteLine("2.Podana funkcja jest rosnąca");
                }
                else
                {
                    Console.WriteLine("2.Podana funkcja jest malejąca");
                }
            }
            else if(Odczyt.A==0 && Odczyt.B==0)
            {
                Console.WriteLine("Podana funkcja to funkcja stała\r\nJej wartość wynosi "+ (Double)(Odczyt.C));
            }
            else
            {
                double delta=Math.Pow(Odczyt.B,2)-4*Odczyt.A*Odczyt.C;
                Console.WriteLine("Podana funkcja to funkcja kwadratowa\r\n1.Delta ma wartość "+ delta);
                if(delta>0)
                {
                    double x1=(-Odczyt.B-Math.Sqrt(delta))/(2*Odczyt.A);
                    double x2=(-Odczyt.B+Math.Sqrt(delta))/(2*Odczyt.A);

                    Console.WriteLine("2.Delta jest dodatnia, więc funkcja posiada dwa miejsca zerowe w "+ x1 + " i " + x2);
                }
                else if(delta==0)
                {
                    double x0=((-Odczyt.B)/(2*Odczyt.A));

                    Console.WriteLine("2.Delta jest równa zero, więc funkcja posiada jedno miejsce zerowe w "+ x0);
                }
                else
                {
                    Console.WriteLine("2.Delta jest ujemna, więc ta funkcja nie posiada miejsce zerowych");
                }
                double p=(-Odczyt.B)/(2*Odczyt.A);
                double q=(-delta)/(4*Odczyt.A);
                Console.WriteLine("3.Wierzchołek tej funkcji występuje w punkcie o współrzędnych (" + p + ";" + q + ")");

                if(Odczyt.A>0)
                {
                    Console.WriteLine("4.Minimum tej funkcji występuje w jej wierzchołku, funkcja nie posiada maksimum");
                    Console.WriteLine("5.Zbiór wartości funkcji należy do przedziału od " + q + " do nieskończoności");
                    Console.WriteLine("6.Podana funkcja jest malejąca w przedziale od (-nieskończoności) do " + p + " i rosnąca od " + p +" do nieskończoności");

                }
                else
                {
                    Console.WriteLine("4.Maksimum tej funkcji występuje w wierzchołku, funkcja nie posiada minimum");
                    Console.WriteLine("5.Zbiór wartości funkcji należy do przedziału od (-nieskończoności) do" + q);
                    Console.WriteLine("6.Podana funkcja jest rosnąca w przedziale od (-nieskończoności) do " + p + " i malejąca od " + p +" do nieskończoności");

                }
            }
        }

        //funkcja i referencja - odwołanie do lokalizacji
        /*public static void Odczyt(ref Double A, ref Double B, ref Double C)
        {
            Console.WriteLine("Podaj A");
            A = Double.Parse(Console.ReadLine());
            Console.WriteLine("Podaj B");
            B = Double.Parse(Console.ReadLine());
            Console.WriteLine("Podaj C");
            C = Double.Parse(Console.ReadLine());
        }
        */

    }
}
