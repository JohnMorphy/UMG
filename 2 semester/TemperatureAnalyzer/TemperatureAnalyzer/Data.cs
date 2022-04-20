using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TemperatureAnalyzer
{
    public static class Data
    {
        public static float[] Temperature = new float[10000];
        public static int TemperatureCount = 0;

        public static void Clear()
        {
            TemperatureCount = 0;
            for(int i=0; i < Temperature.Length; i++)
                Temperature[i] = 0;
        }
        public static void Add(string text)
        {
            string[] convert = new string[10000];
            convert = text.Split(';');
            for (int i = 0; i < convert.Length; i++)
            {
                bool isFloat = float.TryParse(convert[i], out Temperature[TemperatureCount]);
                if (isFloat)
                {
                    TemperatureCount++;
                }
            }          
        }

        public static float Average()
        {
            float average = 0;
            for(int i=0; i<=TemperatureCount;i++)
            {
                average+=Temperature[i]; 
            }
            if(average==0)
            {
                return 0;
            }
            average /= TemperatureCount;
            return average;
        }

        public static float MaxValue()
        {
            float max = Temperature[0];
            for(int i =1; i<TemperatureCount; i++)
            {
                if(Temperature[i] > max)
                    max = Temperature[i];
            }
            return max;
        }

        public static float MinValue()
        {
            float min = Temperature[0];
            for (int i = 1; i < TemperatureCount; i++)
            {
                if (Temperature[i] < min)
                    min = Temperature[i];
            }
            return min;
        }

        public static float Variation()
        {
            float variation = 0;
            for(int i=0; i < TemperatureCount; i++)
            {
                variation += (float)Math.Pow(Temperature[i]-Average(), 2);                
            }
            return variation/TemperatureCount;
        }
    }
}
