using System;
using System.IO;

namespace lab5
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] lines = File.ReadAllLines("./data.csv");

            double[] I = new double[lines.Length];
            double[] V = new double[lines.Length];
            double[] P = new double[lines.Length];
            double[] calka = new double[lines.Length];
            string[] temp = new string[2];

            for(int i = 1; i < lines.Length; i++)
            {
            temp = lines[i].Split(",");
            I[i] = double.Parse(temp[0].Replace(".", ","));
            V[i] = double.Parse(temp[1].Replace(".", ","));
            P[i] = Math.Round(I[i]*10*V[i],4);
            }

            for(int i = 1; i < lines.Length-1; i++)
            {
                calka[i] = Math.Round((P[i]+P[i+1])/2,4);
            }
            

            string output = "T[ms];I[A];U[V];P[W];całka" + "\r\n";

            for(int i = 1; i < lines.Length; i++)
                output += i + ";" +  Math.Round(I[i]*10,4) + ";" + V[i] + ";" + P[i] + ";" + calka[i] + "\r\n";


            File.WriteAllText("./output.csv", output);
            
            // Pobranie całego tekstu do stringa
            /*
            string text = File.ReadAllText("./data.csv"); // Load
            Console.WriteLine(text); // Display
            File.WriteAllText("./output.csv", text);
            */

            // pobieranie tekstu w liniach
            /*
            string[] lines = File.ReadAllLines("./data.csv"); // Load
            foreach (string line in lines) Console.Write(line + " "); // Display
            File.WriteAllLines("./output.csv", lines); // Save
            */
        }
    }
}
