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
        public Data data;

        public System.Windows.Forms.Button[] colorButtons = new System.Windows.Forms.Button[4];
        public System.Windows.Forms.CheckBox[] boxes = new System.Windows.Forms.CheckBox[4];
        public System.Windows.Forms.Label[] labels = new System.Windows.Forms.Label[3];
        public System.Windows.Forms.Label[] colorMarkers = new System.Windows.Forms.Label[4];

        public ChartData(Data data)
        {
            this.data = data;
            InitializeComponent();
        }

        private void FillChart(string series)
        {
            TemperatureChart.Series[series].Points.Clear();
            
            for (int i = 0; i < data.GetCount(); i++)
            {
                TemperatureChart.Series[series].Points.AddXY(i, data.temperatureMeasure[i]);
            }
        }

        private void FillChart_dif()
        {
            TemperatureChart.Series["Temperature1_dif"].Points.Clear();

            if (data.GetCount() > 1)
            {
                for (int i = 0; i < data.GetCount() - 1; i++)
                {
                    TemperatureChart.Series["Temperature1_dif"].Points.AddXY(i + 1, data.temperatureMeasure[i + 1] - data.temperatureMeasure[i]);
                }
            }
        }

        private void ChartData_Load(object sender, EventArgs e)
        {
            colorButtons[0] = Temperature1_color;
            colorButtons[1] = Temperature2_color;
            colorButtons[2] = Temperature3_color;
            colorButtons[3] = Temperature1_dif_color;
            boxes[0] = Temperature1_checkBox;
            boxes[1] = Temperature2_checkBox;
            boxes[2] = Temperature3_checkBox;
            boxes[3] = Temperature1_dif_chechBox;
            labels[0] = Temperature1_label;
            labels[1] = Temperature2_label;
            labels[2] = Temperature3_label;
            colorMarkers[0] = Temperature1_colorMarker;
            colorMarkers[1] = Temperature2_colorMarker;
            colorMarkers[2] = Temperature3_colorMarker;
            colorMarkers[3] = Temperature1_dif_colorMarker;

            Temperature1_checkBox.CheckState = CheckState.Checked;
            Legend_checkbox.CheckState = CheckState.Checked;

            FillChart("Temperature1");
            FillChart_dif();

            TemperatureChart.Series["Temperature1"].Enabled = true;
            TemperatureChart.Series["Temperature2"].Enabled = false;
            TemperatureChart.Series["Temperature3"].Enabled = false;
            TemperatureChart.Series["Temperature1_dif"].Enabled = false;

            Temperature2_checkBox.Enabled = false;
            Temperature3_checkBox.Enabled = false;

            Temperature2_color.Enabled = false;
            Temperature3_color.Enabled = false;
            Temperature1_dif_color.Enabled = false;

            Temperature1_label.Text = data.GetFileName();
            Temperature2_label.Visible = false;
            Temperature3_label.Visible = false;

            TemperatureChart.Series["Temperature1"].Color = Color.Red;
            TemperatureChart.Series["Temperature2"].Color = Color.Green;
            TemperatureChart.Series["Temperature3"].Color = Color.Blue;
            TemperatureChart.Series["Temperature1_dif"].Color = Color.Black;

            Temperature1_colorMarker.BackColor = Color.Red;
            Temperature2_colorMarker.BackColor = Color.Green;
            Temperature3_colorMarker.BackColor = Color.Blue;
            Temperature1_dif_colorMarker.BackColor = Color.Black;

            Temperature2_colorMarker.Visible = false;
            Temperature3_colorMarker.Visible = false;
            Temperature1_dif_colorMarker.Visible = false;

            DrawType_comboBox.SelectedIndex = 0;
        }

        private void ChechBoxChanged(string series, int index)
        {
            TemperatureChart.Series[series].Enabled = boxes[index].Checked;
            colorButtons[index].Enabled = boxes[index].Checked;
            colorMarkers[index].Visible = boxes[index].Checked;
        }

        private void Temperature1_checkBox_CheckedChanged(object sender, EventArgs e)
        {
            ChechBoxChanged("Temperature1", 0);
        }

        private void Temperature2_checkBox_CheckedChanged(object sender, EventArgs e)
        {
            ChechBoxChanged("Temperature2", 1);
        }

        private void Temperature3_checkBox_CheckedChanged(object sender, EventArgs e)
        {
            ChechBoxChanged("Temperature3", 2);
        }

        private void Temperature1_dif_chechBox_CheckedChanged(object sender, EventArgs e)
        {   
            ChechBoxChanged("Temperature1_dif", 3);
        }

        private Boolean LoadData(string series, int index)
        {
            Data checking = MainMenu.LoadFile();
            if (checking != null)
            {
                data = checking;
                FillChart(series);
                boxes[index].Enabled = true;
                boxes[index].Checked = true;
                labels[index].Visible = true;
                labels[index].Text = data.GetFileName();
                return true;
            }
            return false;
        }

        private void Temperature1_button_Click(object sender, EventArgs e)
        {
            if (LoadData("Temperature1", 0))
            {
                FillChart_dif();
            }
        }

        private void Temperature2_button_Click(object sender, EventArgs e)
        {
            LoadData("Temperature2", 1);
        }

        private void Temperature3_button_Click(object sender, EventArgs e)
        {
            LoadData("Temperature3", 2);
        }

        private void ChangeColor(string series, int index)
        {
            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                TemperatureChart.Series[series].Color = colorDialog1.Color;
                colorMarkers[index].BackColor = colorDialog1.Color;
            }
        }

        private void Temperature1_color_Click(object sender, EventArgs e)
        {
            ChangeColor("Temperature1",0);
        }

        private void Temperature2_color_Click(object sender, EventArgs e)
        {
            ChangeColor("Temperature2",1);
        }

        private void Temperature3_color_Click(object sender, EventArgs e)
        {
            ChangeColor("Temperature3",2);
        }

        private void Temperature1_dif_color_Click(object sender, EventArgs e)
        {
            ChangeColor("Temperature1_dif", 3);
        }

        private void Legend_checkbox_CheckedChanged(object sender, EventArgs e)
        {
            TemperatureChart.Legends["Legend"].Enabled = Legend_checkbox.Checked;
        }

        private void DrawType_comboBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            string[] text = DrawType_comboBox.ValueMember.Split(';');
            int[] ID = new int[text.Length];
            for (int i = 0; i < text.Length; i++)
            {
                ID[i] = int.Parse(text[i]);
            }
            TemperatureChart.Series["Temperature1"].ChartType = (SeriesChartType)ID[DrawType_comboBox.SelectedIndex];
            TemperatureChart.Series["Temperature2"].ChartType = (SeriesChartType)ID[DrawType_comboBox.SelectedIndex];
            TemperatureChart.Series["Temperature3"].ChartType = (SeriesChartType)ID[DrawType_comboBox.SelectedIndex];
            TemperatureChart.Series["Temperature1_dif"].ChartType = (SeriesChartType)ID[DrawType_comboBox.SelectedIndex];
        }

        private void Boldness_trackBar_Scroll(object sender, EventArgs e)
        {
            TemperatureChart.Series["Temperature1"].BorderWidth = Boldness_trackBar.Value;
            TemperatureChart.Series["Temperature2"].BorderWidth = Boldness_trackBar.Value;
            TemperatureChart.Series["Temperature3"].BorderWidth = Boldness_trackBar.Value;
            TemperatureChart.Series["Temperature1_dif"].BorderWidth = Boldness_trackBar.Value;

        }
    }
}