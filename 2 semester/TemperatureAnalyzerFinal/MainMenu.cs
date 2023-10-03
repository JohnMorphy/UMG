using System;
using System.IO;
using System.ComponentModel;
using System.Data;
using System.Drawing;
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
        private void MainMenu_Load(object sender, EventArgs e)
        {

        }

        public static Data LoadFile()
        {
            OpenFileDialog LoadFile = new OpenFileDialog();
            LoadFile.Filter = "txt files (*.txt)|*.txt";
            var filePath = string.Empty;

            if(LoadFile.ShowDialog() != DialogResult.OK)
            return null;
            try
            {
                filePath = LoadFile.FileName;
                var fileStream = LoadFile.OpenFile();
                Data measurements = new Data();
                measurements.Clear();

                foreach (string line in System.IO.File.ReadLines(filePath)) {
                    string[] convert = line.Split(';');
                    foreach (string text in convert)
                    {
                        bool tryToConvert = float.TryParse(text, out float bufor);
                        if (tryToConvert)
                        {
                            measurements.AddValue(bufor);
                        }
                    }
                }
                fileStream.Close();
                if (measurements.GetCount() <= 0)
                {
                    MessageBox.Show("Not enough data");
                    return null;
                }
                else
                {
                    measurements.SetFileName(filePath);
                    MessageBox.Show("Successfully loaded a file");
                    return measurements;
                }
            }
            catch {
                MessageBox.Show("Can't load the file");
                return null;
            }
        }

        public Data data;
        private void LoadFileButton_Click(object sender, EventArgs e)
        {
            Data checking = LoadFile();
            if (checking == null) return;

            data = checking;
            NumberOfMeasurements_value.Text = data.GetCount().ToString();
            MinimalValue_value.Text = data.GetMin().ToString();
            MaximalValue_value.Text = data.GetMax().ToString();
            AverageTemperature_value.Text = data.GetAvg().ToString();
            Variation_value.Text = data.GetVar().ToString();            

            SaveData_button.Enabled = true;
            ChartData_button.Enabled = true;
        }

        private void SaveData_button_Click(object sender, EventArgs e)
        {
            Stream myStream;
            SaveFileDialog saveFile = new SaveFileDialog();

            saveFile.Filter = "txt files (*.txt)|*.txt";
            saveFile.FilterIndex = 2;
            saveFile.RestoreDirectory = true;

            if (saveFile.ShowDialog() != DialogResult.OK) return;            
            try
            {
                myStream = saveFile.OpenFile();
                using (StreamWriter streamWriter = new StreamWriter(myStream))
                {
                    streamWriter.WriteLine("File Path: " + data.GetFilePath().ToString());
                    streamWriter.WriteLine("Number of measuerements: " + NumberOfMeasurements_value.Text);
                    streamWriter.WriteLine("Minimal value: " + MinimalValue_value.Text);
                    streamWriter.WriteLine("Maximal value: " + MaximalValue_value.Text);
                    streamWriter.WriteLine("Average value: " + AverageTemperature_value.Text);
                    streamWriter.WriteLine("Variation: " + Variation_value.Text);
                }
                MessageBox.Show("Successfully saved a file");
            }
            catch
            { MessageBox.Show("Can't save the file"); }
            
        }

        private void ChartData_button_Click(object sender, EventArgs e)
        {
            ChartData chartData = new ChartData(data);
            chartData.ShowDialog();
        }
    }
}
