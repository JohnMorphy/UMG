using System;
using System.Collections.Generic;
using System.Linq;

namespace TemperatureAnalyzerFinal
{
    public class Data
    {
        public List<float> temperatureMeasure = new List<float>();
        public int temperatureMeasure_Count = 0;
        public string filePath = "";

        public void SetFileName(string name)
        {
            filePath = name;
        }

        public string GetFilePath()
        {
            return filePath;
        }

        public string GetFileName()
        {
            string[] convert = filePath.Split('\\');
            if(convert.Length > 0)
                return convert[convert.Length-1];
            return null;
        }

        public List<float> GetList()
        {
            return temperatureMeasure;
        }

        public void Clear()
        {
            temperatureMeasure.Clear();
            temperatureMeasure_Count=0;
        }
        public void AddValue(float value)
        {
            temperatureMeasure.Add(value);
            temperatureMeasure_Count++;
        }

        public int GetCount()
        {
            return temperatureMeasure_Count;
        }

        public float GetMin()
        {
            float MinValue = temperatureMeasure[0];
            foreach(float value in temperatureMeasure)
            {
                if(value < MinValue)
                    MinValue = value;
            }
            return MinValue;
        }

        public float GetMax()
        {
            float MaxValue = temperatureMeasure[0];
            foreach (float value in temperatureMeasure)
            {
                if (value > MaxValue)
                    MaxValue = value;
            }
            return MaxValue;
        }

        public float GetAvg()
        {
            float Average = 0;
            foreach(float value in temperatureMeasure)
            {
                Average += value;
            }
            Average /= temperatureMeasure_Count;
            return Average;
        }

        public float GetVar()
        {
            float variation = 0;
            foreach(float temp in temperatureMeasure)
            {
                variation += (float)Math.Pow(temp - temperatureMeasure.Average(),2) ;
            }
            variation /= temperatureMeasure_Count;
            return variation;
        }
    }
}
