using System;

namespace argumenty2
{
    class Program
    {
        static void Main(string[] args)
        {
            if(args.Length < 3) return;

            double[] x = new double[args.Length - 2];
            double y = double.Parse(args[0]);
            string opt = args[1];

            for(int i = 0; i < args.Length-2; i++)
            {
                x[i] = double.Parse(args[i + 2]);
            }
            switch(opt)
            {
                case "+":
                    for(int i = 0; i < args.Length-2; i++)  x[i] += y;
                    break;
                case "_":
                    for(int i = 0; i < args.Length-2; i++)  x[i] -= y;
                    break;
                case "*":
                    for(int i = 0; i < args.Length-2; i++)  x[i] *= y;
                    break;
                case "/":
                    for(int i = 0; i < args.Length-2; i++)  x[i] /= y;
                    break;
                default:
                Console.WriteLine("Nieobsługiwana operacja!");
                return;
            }

            foreach(double x_i in x)
                Console.Write(x_i + " ");

        }
    }
}
