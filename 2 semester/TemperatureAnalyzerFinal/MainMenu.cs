using System;
using System.IO;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TemperatureAnalyzerFinal
{
    public partial class MainMenu : Form
    {
        
        public MainMenu()
        {
            InitializeComponent();
        }
        public static string message;
        private void MainMenu_Load(object sender, EventArgs e)
        {

        }

        Data data = new Data();
                
        private void LoadFileButton_Click(object sender, EventArgs e)
        {
            OpenFileDialog LoadFile = new OpenFileDialog();
            LoadFile.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            var filePath = string.Empty;

            if (LoadFile.ShowDialog() == DialogResult.OK)
            {
                filePath = LoadFile.FileName;
                var fileStream = LoadFile.OpenFile();
                Data data = new Data();
                data.Clear();

                foreach (string line in System.IO.File.ReadLines(filePath))
                {
                    string[] convert = line.Split(';');
                    foreach (string text in convert)
                    {
                        bool tryToConvert = float.TryParse(text, out float bufor);
                        if (tryToConvert)
                        {
                            data.AddValue(bufor);
                        }
                    }
                }            

                if (data.GetCount() == 0)
                {
                    message = "Not enough data!";
                    Failure fail = new Failure();
                    fail.ShowDialog();
                }
                else
                {
                    NumberOfMeasurements_value.Text = data.GetCount().ToString();
                    MinimalValue_value.Text = data.GetMin().ToString();
                    MaximalValue_value.Text = data.GetMax().ToString();
                    AverageTemperature_value.Text = data.GetAvg().ToString();
                    Variation_value.Text = data.GetVar().ToString();

                    SaveData_button.Enabled = true;
                    ChartData_button.Enabled = true;
                }
            }
            else
            {
                message = "Failed to load data!";
                Failure fail = new Failure();
                fail.ShowDialog();
            }
        }

        private void SaveData_button_Click(object sender, EventArgs e)
        {
            Stream myStream;
            SaveFileDialog saveFile = new SaveFileDialog();

            saveFile.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            saveFile.FilterIndex = 2;
            saveFile.RestoreDirectory = true;

            if (saveFile.ShowDialog() == DialogResult.OK)
            {
                if ((myStream = saveFile.OpenFile()) != null)
                {
                    using (StreamWriter streamWriter = new StreamWriter(myStream))
                    {
                        streamWriter.WriteLine("Number of measuerements: " + NumberOfMeasurements_value);
                        streamWriter.WriteLine("Minimal value: " + MinimalValue_value);
                        streamWriter.WriteLine("Maximal value: " + MaximalValue_value);
                        streamWriter.WriteLine("Average value: " + AverageTemperature_value);
                        streamWriter.WriteLine("Variation: " + Variation_value);
                    }
                }
            }
        }

        private void ChartData_button_Click(object sender, EventArgs e)
        {
            ChartData chartData = new ChartData(data);
            chartData.ShowDialog();
        }
    }

    public class Data
    {
        public List<float> temperatureMeasure = new List<float>();
        public static int temperatureMeasure_Count = 0;
        public string fileName = "";

        public void SetFileName(string name)
        {
            fileName = name;
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
