namespace TemperatureAnalyzerFinal
{
    partial class ChartData
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.TemperatureChart_chart = new System.Windows.Forms.DataVisualization.Charting.Chart();
            ((System.ComponentModel.ISupportInitialize)(this.TemperatureChart_chart)).BeginInit();
            this.SuspendLayout();
            // 
            // TemperatureChart_chart
            // 
            chartArea1.Name = "ChartArea1";
            this.TemperatureChart_chart.ChartAreas.Add(chartArea1);
            legend1.Name = "Legend1";
            this.TemperatureChart_chart.Legends.Add(legend1);
            this.TemperatureChart_chart.Location = new System.Drawing.Point(37, 45);
            this.TemperatureChart_chart.Name = "TemperatureChart_chart";
            series1.ChartArea = "ChartArea1";
            series1.Legend = "Legend1";
            series1.Name = "Temperature";
            this.TemperatureChart_chart.Series.Add(series1);
            this.TemperatureChart_chart.Size = new System.Drawing.Size(587, 393);
            this.TemperatureChart_chart.TabIndex = 0;
            this.TemperatureChart_chart.Text = "chart1";
            // 
            // ChartData
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.TemperatureChart_chart);
            this.Name = "ChartData";
            this.Text = "Data chart";
            this.Load += new System.EventHandler(this.ChartData_Load);
            ((System.ComponentModel.ISupportInitialize)(this.TemperatureChart_chart)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataVisualization.Charting.Chart TemperatureChart_chart;
    }
}