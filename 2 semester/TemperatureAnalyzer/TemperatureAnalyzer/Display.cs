using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TemperatureAnalyzer
{
    public partial class Display : Form
    {
        public Display()
        {
            InitializeComponent();
        }

        private void Display_Load(object sender, EventArgs e)
        {
            label5.Text = "Number of measurements: " + TemperatureAnalyzer.Data.TemperatureCount;
            label1.Text = "Average temperature:    " + TemperatureAnalyzer.Data.Average();
            label2.Text = "Maximal value:          " + TemperatureAnalyzer.Data.MaxValue();
            label3.Text = "Minimal value:          " + TemperatureAnalyzer.Data.MinValue();
            label4.Text = "Variation:              " + TemperatureAnalyzer.Data.Variation();
        }

        private void SaveData_Click(object sender, EventArgs e)
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
                        streamWriter.WriteLine(label5.Text);
                        streamWriter.WriteLine(label1.Text);
                        streamWriter.WriteLine(label2.Text);
                        streamWriter.WriteLine(label3.Text);
                        streamWriter.WriteLine(label4.Text);
                    }
                }
            }
        }

    }
}
