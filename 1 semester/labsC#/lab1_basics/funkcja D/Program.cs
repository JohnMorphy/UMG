using System;

namespace funkcja_D
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj x funkcji: ");
            Double x=0;
            x=Double.Parse(Console.ReadLine());

            Double y=-(3.0/2.0)*x+6*(Math.Sign(x))*((int)(Math.Abs(x)+2)/4);

            Console.WriteLine("Dla x równego " + x + " wartość funkcji wynosi: " + y);
        }
    }
}
