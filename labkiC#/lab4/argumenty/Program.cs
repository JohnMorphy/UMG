using System;

namespace lab4
{
    class Program
    {
        static void Main(string[] args)
        {
            int start = 0;
            int end = 100;

            if(args.Length >= 2)
            {
                if(int.Parse(args[0])>int.Parse(args[1]))
                {
                    end = int.Parse(args[0]);
                    start = int.Parse(args[1]);
                }
                else
                {
                    start = int.Parse(args[0]);
                    end = int.Parse(args[1]);
                }
            }
            else if(args.Length == 1) end = int.Parse(args[0]);

            Console.WriteLine("start:" + start + " end:" + end);

            for(int i=start; i<end+1; i++)
            {
                Console.Write(i + " ");
            }

            
        }
    }
}
