using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace TemperatureAnalyzerFinal
{
    public partial class ChartData : Form
    {
        public Data data = new Data();
        public ChartData(Data measurements)
        {
            InitializeComponent();
            data = measurements;
        }

        private void ChartData_Load(object sender, EventArgs e)
        {
            FillChart();
        }

        private void FillChart()
        {
            float x = 0;

            foreach (float value in data.temperatureMeasure)
            {
                TemperatureChart_chart.Series["Temperature"].Points.AddXY(x, value);
                x++;
            }
            TemperatureChart_chart.Titles.Add(data.fileName);
        }
    }
}
