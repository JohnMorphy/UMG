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
        public Data data2;

        public System.Windows.Forms.CheckBox[] boxes = new System.Windows.Forms.CheckBox[3];
        public System.Windows.Forms.Label[] labels = new System.Windows.Forms.Label[3];

        public ChartData(Data data)
        {
            this.data2 = data;
            InitializeComponent();
        }

        private void FillChart(string series)
        {
            TemperatureChart.Series[series].Points.Clear();
            
            for (int i = 0; i < data2.GetCount(); i++)
            {
                TemperatureChart.Series[series].Points.AddXY(i, data2.temperatureMeasure[i]);
            }
        }

        private void ChartData_Load(object sender, EventArgs e)
        {
            boxes[0] = Temperature1_checkBox;
            boxes[1] = Temperature2_checkBox;
            boxes[2] = Temperature3_checkBox;
            labels[0] = Temperature1_label;
            labels[1] = Temperature2_label;
            labels[2] = Temperature3_label;

            FillChart("Temperature1");
            Legend_checkbox.CheckState = CheckState.Checked;
            Temperature1_checkBox.CheckState = CheckState.Checked;
            TemperatureChart.Series["Temperature1"].Enabled = true;
            TemperatureChart.Series["Temperature2"].Enabled = false;
            TemperatureChart.Series["Temperature3"].Enabled = false;
            Temperature2_checkBox.Enabled = false;
            Temperature3_checkBox.Enabled = false;
            Temperature1_label.Text = data2.GetFileName();
            Temperature2_label.Visible = false;
            Temperature3_label.Visible = false;
            DrawType_comboBox.SelectedIndex = 0;
        }

        private void Legend_checkbox_CheckedChanged(object sender, EventArgs e)
        {
            TemperatureChart.Legends["Legend"].Enabled = Legend_checkbox.Checked;
        }

        private void Temperature1_checkBox_CheckedChanged(object sender, EventArgs e)
        {
            TemperatureChart.Series["Temperature1"].Enabled = Temperature1_checkBox.Checked;
        }

        private void Temperature2_checkBox_CheckedChanged(object sender, EventArgs e)
        {
            TemperatureChart.Series["Temperature2"].Enabled = Temperature2_checkBox.Checked;
        }

        private void Temperature3_checkBox_CheckedChanged(object sender, EventArgs e)
        {
            TemperatureChart.Series["Temperature3"].Enabled = Temperature3_checkBox.Checked;
        }

        private void LoadData(string series, int index)
        {
            Data checking = MainMenu.LoadFile();
            if (checking != null)
            {
                data2 = checking;
                FillChart(series);
                boxes[index].Enabled = true;
                boxes[index].Checked = true;
                labels[index].Visible = true;
                labels[index].Text = data2.GetFileName();
            }
        }

        private void Temperature1_button_Click(object sender, EventArgs e)
        {
            LoadData("Temperature1",0);
        }

        private void Temperature2_button_Click(object sender, EventArgs e)
        {
            LoadData("Temperature2", 1);
        }

        private void Temperature3_button_Click(object sender, EventArgs e)
        {
            LoadData("Temperature3", 2);
        }

        private void DrawType_comboBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            string[] text = DrawType_comboBox.ValueMember.Split(';');
            int[] ID = new int[text.Length];
            for(int i=0; i<text.Length; i++)
            {
                ID[i] = int.Parse(text[i]);
            }
            TemperatureChart.Series["Temperature1"].ChartType = (SeriesChartType)ID[DrawType_comboBox.SelectedIndex];
            TemperatureChart.Series["Temperature2"].ChartType = (SeriesChartType)ID[DrawType_comboBox.SelectedIndex];
            TemperatureChart.Series["Temperature3"].ChartType = (SeriesChartType)ID[DrawType_comboBox.SelectedIndex];
        }
    }
}
