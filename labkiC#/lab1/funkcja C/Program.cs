using System;

namespace funkcja_C
{
    class Program
    {
        static void Main(string[] args)
        {

        double x = double.Parse(Console.ReadLine());
        double y;
        
        if(x<=-4 || x>=2)
        {
        y = -((double)x/3)+((double)2/3);
        }
        else
        {
        y =(2.0/7.0)*Math.Pow(x, 2)+(2.0/7.0)*x-(12.0/7.0);
        }
    
        Console.WriteLine(y);
        }
    }
}
