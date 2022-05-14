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
            System.Windows.Forms.DataVisualization.Charting.Series series2 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.Windows.Forms.DataVisualization.Charting.Series series3 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.Windows.Forms.DataVisualization.Charting.Title title1 = new System.Windows.Forms.DataVisualization.Charting.Title();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(ChartData));
            this.Temperature1_checkBox = new System.Windows.Forms.CheckBox();
            this.Temperature2_checkBox = new System.Windows.Forms.CheckBox();
            this.Temperature3_checkBox = new System.Windows.Forms.CheckBox();
            this.TemperatureChart = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.Temperature1_button = new System.Windows.Forms.Button();
            this.Temperature2_button = new System.Windows.Forms.Button();
            this.Temperature3_button = new System.Windows.Forms.Button();
            this.Temperature1_label = new System.Windows.Forms.Label();
            this.Temperature2_label = new System.Windows.Forms.Label();
            this.Temperature3_label = new System.Windows.Forms.Label();
            this.DrawType_comboBox = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.panel3 = new System.Windows.Forms.Panel();
            this.panel4 = new System.Windows.Forms.Panel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel5 = new System.Windows.Forms.Panel();
            this.Legend_checkbox = new System.Windows.Forms.CheckBox();
            this.tableLayoutPanel2 = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel3 = new System.Windows.Forms.TableLayoutPanel();
            this.panel6 = new System.Windows.Forms.Panel();
            ((System.ComponentModel.ISupportInitialize)(this.TemperatureChart)).BeginInit();
            this.tableLayoutPanel1.SuspendLayout();
            this.panel3.SuspendLayout();
            this.panel4.SuspendLayout();
            this.panel2.SuspendLayout();
            this.panel1.SuspendLayout();
            this.panel5.SuspendLayout();
            this.tableLayoutPanel2.SuspendLayout();
            this.tableLayoutPanel3.SuspendLayout();
            this.panel6.SuspendLayout();
            this.SuspendLayout();
            // 
            // Temperature1_checkBox
            // 
            this.Temperature1_checkBox.AutoSize = true;
            this.Temperature1_checkBox.Location = new System.Drawing.Point(0, 2);
            this.Temperature1_checkBox.Name = "Temperature1_checkBox";
            this.Temperature1_checkBox.Size = new System.Drawing.Size(117, 20);
            this.Temperature1_checkBox.TabIndex = 1;
            this.Temperature1_checkBox.Text = "Temperature 1";
            this.Temperature1_checkBox.UseVisualStyleBackColor = true;
            this.Temperature1_checkBox.CheckedChanged += new System.EventHandler(this.Temperature1_checkBox_CheckedChanged);
            // 
            // Temperature2_checkBox
            // 
            this.Temperature2_checkBox.AutoSize = true;
            this.Temperature2_checkBox.Location = new System.Drawing.Point(0, 3);
            this.Temperature2_checkBox.Name = "Temperature2_checkBox";
            this.Temperature2_checkBox.Size = new System.Drawing.Size(117, 20);
            this.Temperature2_checkBox.TabIndex = 2;
            this.Temperature2_checkBox.Text = "Temperature 2";
            this.Temperature2_checkBox.UseVisualStyleBackColor = true;
            this.Temperature2_checkBox.CheckedChanged += new System.EventHandler(this.Temperature2_checkBox_CheckedChanged);
            // 
            // Temperature3_checkBox
            // 
            this.Temperature3_checkBox.AutoSize = true;
            this.Temperature3_checkBox.Location = new System.Drawing.Point(0, 3);
            this.Temperature3_checkBox.Name = "Temperature3_checkBox";
            this.Temperature3_checkBox.Size = new System.Drawing.Size(117, 20);
            this.Temperature3_checkBox.TabIndex = 3;
            this.Temperature3_checkBox.Text = "Temperature 3";
            this.Temperature3_checkBox.UseVisualStyleBackColor = true;
            this.Temperature3_checkBox.CheckedChanged += new System.EventHandler(this.Temperature3_checkBox_CheckedChanged);
            // 
            // TemperatureChart
            // 
            this.TemperatureChart.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            chartArea1.Name = "ChartArea1";
            this.TemperatureChart.ChartAreas.Add(chartArea1);
            legend1.Name = "Legend";
            this.TemperatureChart.Legends.Add(legend1);
            this.TemperatureChart.Location = new System.Drawing.Point(16, 17);
            this.TemperatureChart.Name = "TemperatureChart";
            series1.ChartArea = "ChartArea1";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
            series1.Legend = "Legend";
            series1.Name = "Temperature1";
            series1.YValuesPerPoint = 2;
            series2.ChartArea = "ChartArea1";
            series2.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
            series2.Legend = "Legend";
            series2.MarkerStep = 2;
            series2.Name = "Temperature2";
            series3.ChartArea = "ChartArea1";
            series3.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
            series3.Legend = "Legend";
            series3.Name = "Temperature3";
            this.TemperatureChart.Series.Add(series1);
            this.TemperatureChart.Series.Add(series2);
            this.TemperatureChart.Series.Add(series3);
            this.TemperatureChart.Size = new System.Drawing.Size(631, 413);
            this.TemperatureChart.TabIndex = 4;
            title1.Name = "Temperature1";
            title1.Text = "Temperature Chart";
            this.TemperatureChart.Titles.Add(title1);
            // 
            // Temperature1_button
            // 
            this.Temperature1_button.Location = new System.Drawing.Point(140, -1);
            this.Temperature1_button.Name = "Temperature1_button";
            this.Temperature1_button.Size = new System.Drawing.Size(145, 23);
            this.Temperature1_button.TabIndex = 5;
            this.Temperature1_button.Text = "load temperature 1";
            this.Temperature1_button.UseVisualStyleBackColor = true;
            this.Temperature1_button.Click += new System.EventHandler(this.Temperature1_button_Click);
            // 
            // Temperature2_button
            // 
            this.Temperature2_button.Location = new System.Drawing.Point(140, 0);
            this.Temperature2_button.Name = "Temperature2_button";
            this.Temperature2_button.Size = new System.Drawing.Size(145, 23);
            this.Temperature2_button.TabIndex = 6;
            this.Temperature2_button.Text = "load temperature 2";
            this.Temperature2_button.UseVisualStyleBackColor = true;
            this.Temperature2_button.Click += new System.EventHandler(this.Temperature2_button_Click);
            // 
            // Temperature3_button
            // 
            this.Temperature3_button.Location = new System.Drawing.Point(140, 0);
            this.Temperature3_button.Name = "Temperature3_button";
            this.Temperature3_button.Size = new System.Drawing.Size(145, 23);
            this.Temperature3_button.TabIndex = 7;
            this.Temperature3_button.Text = "load temperature 3";
            this.Temperature3_button.UseVisualStyleBackColor = true;
            this.Temperature3_button.Click += new System.EventHandler(this.Temperature3_button_Click);
            // 
            // Temperature1_label
            // 
            this.Temperature1_label.AutoSize = true;
            this.Temperature1_label.BackColor = System.Drawing.SystemColors.Window;
            this.Temperature1_label.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Temperature1_label.Location = new System.Drawing.Point(0, 27);
            this.Temperature1_label.MaximumSize = new System.Drawing.Size(285, 18);
            this.Temperature1_label.MinimumSize = new System.Drawing.Size(285, 5);
            this.Temperature1_label.Name = "Temperature1_label";
            this.Temperature1_label.Size = new System.Drawing.Size(285, 18);
            this.Temperature1_label.TabIndex = 8;
            // 
            // Temperature2_label
            // 
            this.Temperature2_label.AutoSize = true;
            this.Temperature2_label.BackColor = System.Drawing.SystemColors.Window;
            this.Temperature2_label.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Temperature2_label.Location = new System.Drawing.Point(0, 27);
            this.Temperature2_label.MaximumSize = new System.Drawing.Size(285, 18);
            this.Temperature2_label.MinimumSize = new System.Drawing.Size(285, 5);
            this.Temperature2_label.Name = "Temperature2_label";
            this.Temperature2_label.Size = new System.Drawing.Size(285, 18);
            this.Temperature2_label.TabIndex = 9;
            // 
            // Temperature3_label
            // 
            this.Temperature3_label.AutoSize = true;
            this.Temperature3_label.BackColor = System.Drawing.SystemColors.Window;
            this.Temperature3_label.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Temperature3_label.Location = new System.Drawing.Point(0, 27);
            this.Temperature3_label.MaximumSize = new System.Drawing.Size(285, 18);
            this.Temperature3_label.MinimumSize = new System.Drawing.Size(285, 5);
            this.Temperature3_label.Name = "Temperature3_label";
            this.Temperature3_label.Size = new System.Drawing.Size(285, 18);
            this.Temperature3_label.TabIndex = 10;
            // 
            // DrawType_comboBox
            // 
            this.DrawType_comboBox.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.DrawType_comboBox.DisplayMember = "3;4;0;10";
            this.DrawType_comboBox.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.DrawType_comboBox.FormattingEnabled = true;
            this.DrawType_comboBox.Items.AddRange(new object[] {
            "Line",
            "Spline",
            "Points",
            "Column"});
            this.DrawType_comboBox.Location = new System.Drawing.Point(85, 15);
            this.DrawType_comboBox.Name = "DrawType_comboBox";
            this.DrawType_comboBox.Size = new System.Drawing.Size(61, 24);
            this.DrawType_comboBox.TabIndex = 11;
            this.DrawType_comboBox.ValueMember = "3;4;0;10";
            this.DrawType_comboBox.SelectedIndexChanged += new System.EventHandler(this.DrawType_comboBox_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(3, 18);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(76, 16);
            this.label1.TabIndex = 12;
            this.label1.Text = "Chart Type:";
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tableLayoutPanel1.ColumnCount = 1;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel1.Controls.Add(this.panel4, 0, 2);
            this.tableLayoutPanel1.Controls.Add(this.panel2, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.panel1, 0, 1);
            this.tableLayoutPanel1.Controls.Add(this.tableLayoutPanel3, 0, 3);
            this.tableLayoutPanel1.Location = new System.Drawing.Point(700, 12);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 5;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(350, 440);
            this.tableLayoutPanel1.TabIndex = 13;
            // 
            // panel3
            // 
            this.panel3.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.panel3.Controls.Add(this.label1);
            this.panel3.Controls.Add(this.DrawType_comboBox);
            this.panel3.Location = new System.Drawing.Point(3, 16);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(163, 50);
            this.panel3.TabIndex = 15;
            // 
            // panel4
            // 
            this.panel4.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.panel4.Controls.Add(this.Temperature3_checkBox);
            this.panel4.Controls.Add(this.Temperature3_button);
            this.panel4.Controls.Add(this.Temperature3_label);
            this.panel4.Location = new System.Drawing.Point(3, 197);
            this.panel4.Name = "panel4";
            this.panel4.Size = new System.Drawing.Size(285, 45);
            this.panel4.TabIndex = 15;
            // 
            // panel2
            // 
            this.panel2.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.panel2.Controls.Add(this.Temperature1_checkBox);
            this.panel2.Controls.Add(this.Temperature1_button);
            this.panel2.Controls.Add(this.Temperature1_label);
            this.panel2.Location = new System.Drawing.Point(3, 21);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(285, 45);
            this.panel2.TabIndex = 15;
            // 
            // panel1
            // 
            this.panel1.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.panel1.Controls.Add(this.Temperature2_checkBox);
            this.panel1.Controls.Add(this.Temperature2_button);
            this.panel1.Controls.Add(this.Temperature2_label);
            this.panel1.Location = new System.Drawing.Point(3, 109);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(285, 45);
            this.panel1.TabIndex = 14;
            // 
            // panel5
            // 
            this.panel5.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.panel5.Controls.Add(this.Legend_checkbox);
            this.panel5.Location = new System.Drawing.Point(175, 18);
            this.panel5.Name = "panel5";
            this.panel5.Size = new System.Drawing.Size(163, 45);
            this.panel5.TabIndex = 16;
            // 
            // Legend_checkbox
            // 
            this.Legend_checkbox.AutoSize = true;
            this.Legend_checkbox.Location = new System.Drawing.Point(18, 13);
            this.Legend_checkbox.Name = "Legend_checkbox";
            this.Legend_checkbox.Size = new System.Drawing.Size(75, 20);
            this.Legend_checkbox.TabIndex = 13;
            this.Legend_checkbox.Text = "Legend";
            this.Legend_checkbox.UseVisualStyleBackColor = true;
            this.Legend_checkbox.CheckedChanged += new System.EventHandler(this.Legend_checkbox_CheckedChanged);
            // 
            // tableLayoutPanel2
            // 
            this.tableLayoutPanel2.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tableLayoutPanel2.ColumnCount = 1;
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel2.Controls.Add(this.panel6, 0, 0);
            this.tableLayoutPanel2.Location = new System.Drawing.Point(12, 12);
            this.tableLayoutPanel2.Name = "tableLayoutPanel2";
            this.tableLayoutPanel2.RowCount = 1;
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel2.Size = new System.Drawing.Size(682, 440);
            this.tableLayoutPanel2.TabIndex = 14;
            // 
            // tableLayoutPanel3
            // 
            this.tableLayoutPanel3.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tableLayoutPanel3.ColumnCount = 2;
            this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel3.Controls.Add(this.panel3, 0, 0);
            this.tableLayoutPanel3.Controls.Add(this.panel5, 1, 0);
            this.tableLayoutPanel3.Location = new System.Drawing.Point(3, 267);
            this.tableLayoutPanel3.Name = "tableLayoutPanel3";
            this.tableLayoutPanel3.RowCount = 1;
            this.tableLayoutPanel3.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel3.Size = new System.Drawing.Size(344, 82);
            this.tableLayoutPanel3.TabIndex = 15;
            // 
            // panel6
            // 
            this.panel6.Controls.Add(this.TemperatureChart);
            this.panel6.Location = new System.Drawing.Point(3, 3);
            this.panel6.Name = "panel6";
            this.panel6.Size = new System.Drawing.Size(676, 434);
            this.panel6.TabIndex = 15;
            // 
            // ChartData
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1062, 473);
            this.Controls.Add(this.tableLayoutPanel1);
            this.Controls.Add(this.tableLayoutPanel2);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "ChartData";
            this.Text = "Data chart";
            this.Load += new System.EventHandler(this.ChartData_Load);
            ((System.ComponentModel.ISupportInitialize)(this.TemperatureChart)).EndInit();
            this.tableLayoutPanel1.ResumeLayout(false);
            this.panel3.ResumeLayout(false);
            this.panel3.PerformLayout();
            this.panel4.ResumeLayout(false);
            this.panel4.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel5.ResumeLayout(false);
            this.panel5.PerformLayout();
            this.tableLayoutPanel2.ResumeLayout(false);
            this.tableLayoutPanel3.ResumeLayout(false);
            this.panel6.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.CheckBox Temperature1_checkBox;
        private System.Windows.Forms.CheckBox Temperature2_checkBox;
        private System.Windows.Forms.CheckBox Temperature3_checkBox;
        private System.Windows.Forms.DataVisualization.Charting.Chart TemperatureChart;
        private System.Windows.Forms.Button Temperature1_button;
        private System.Windows.Forms.Button Temperature2_button;
        private System.Windows.Forms.Button Temperature3_button;
        private System.Windows.Forms.Label Temperature1_label;
        private System.Windows.Forms.Label Temperature2_label;
        private System.Windows.Forms.Label Temperature3_label;
        private System.Windows.Forms.ComboBox DrawType_comboBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Panel panel4;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel2;
        private System.Windows.Forms.Panel panel5;
        private System.Windows.Forms.CheckBox Legend_checkbox;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel3;
        private System.Windows.Forms.Panel panel6;
    }
}