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
            System.Windows.Forms.DataVisualization.Charting.Series series4 = new System.Windows.Forms.DataVisualization.Charting.Series();
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
            this.tableLayoutPanel4 = new System.Windows.Forms.TableLayoutPanel();
            this.panel7 = new System.Windows.Forms.Panel();
            this.Temperature1_dif_colorMarker = new System.Windows.Forms.Label();
            this.Temperature1_dif_color = new System.Windows.Forms.Button();
            this.Temperature1_dif_chechBox = new System.Windows.Forms.CheckBox();
            this.panel4 = new System.Windows.Forms.Panel();
            this.Temperature3_colorMarker = new System.Windows.Forms.Label();
            this.Temperature3_color = new System.Windows.Forms.Button();
            this.panel2 = new System.Windows.Forms.Panel();
            this.Temperature1_colorMarker = new System.Windows.Forms.Label();
            this.Temperature1_color = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.Temperature2_colorMarker = new System.Windows.Forms.Label();
            this.Temperature2_color = new System.Windows.Forms.Button();
            this.tableLayoutPanel3 = new System.Windows.Forms.TableLayoutPanel();
            this.panel3 = new System.Windows.Forms.Panel();
            this.panel5 = new System.Windows.Forms.Panel();
            this.Legend_checkbox = new System.Windows.Forms.CheckBox();
            this.tableLayoutPanel5 = new System.Windows.Forms.TableLayoutPanel();
            this.panel6 = new System.Windows.Forms.Panel();
            this.Boldness_trackBar = new System.Windows.Forms.TrackBar();
            this.label2 = new System.Windows.Forms.Label();
            this.colorDialog1 = new System.Windows.Forms.ColorDialog();
            ((System.ComponentModel.ISupportInitialize)(this.TemperatureChart)).BeginInit();
            this.tableLayoutPanel1.SuspendLayout();
            this.tableLayoutPanel4.SuspendLayout();
            this.panel7.SuspendLayout();
            this.panel4.SuspendLayout();
            this.panel2.SuspendLayout();
            this.panel1.SuspendLayout();
            this.tableLayoutPanel3.SuspendLayout();
            this.panel3.SuspendLayout();
            this.panel5.SuspendLayout();
            this.tableLayoutPanel5.SuspendLayout();
            this.panel6.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Boldness_trackBar)).BeginInit();
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
            this.TemperatureChart.Location = new System.Drawing.Point(3, 3);
            this.TemperatureChart.Name = "TemperatureChart";
            series1.ChartArea = "ChartArea1";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
            series1.Legend = "Legend";
            series1.LegendText = "Temp1";
            series1.Name = "Temperature1";
            series2.ChartArea = "ChartArea1";
            series2.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
            series2.Legend = "Legend";
            series2.LegendText = "Temp2";
            series2.MarkerStep = 2;
            series2.Name = "Temperature2";
            series3.ChartArea = "ChartArea1";
            series3.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
            series3.Legend = "Legend";
            series3.LegendText = "Temp3";
            series3.Name = "Temperature3";
            series4.ChartArea = "ChartArea1";
            series4.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
            series4.Legend = "Legend";
            series4.LegendText = "Temp1 - dif";
            series4.Name = "Temperature1_dif";
            this.TemperatureChart.Series.Add(series1);
            this.TemperatureChart.Series.Add(series2);
            this.TemperatureChart.Series.Add(series3);
            this.TemperatureChart.Series.Add(series4);
            this.TemperatureChart.Size = new System.Drawing.Size(858, 442);
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
            this.Temperature1_label.Location = new System.Drawing.Point(0, 32);
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
            this.Temperature2_label.Location = new System.Drawing.Point(0, 32);
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
            this.Temperature3_label.Location = new System.Drawing.Point(0, 32);
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
            this.DrawType_comboBox.Size = new System.Drawing.Size(79, 24);
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
            this.tableLayoutPanel1.Controls.Add(this.tableLayoutPanel4, 0, 3);
            this.tableLayoutPanel1.Controls.Add(this.panel4, 0, 2);
            this.tableLayoutPanel1.Controls.Add(this.panel2, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.panel1, 0, 1);
            this.tableLayoutPanel1.Controls.Add(this.tableLayoutPanel3, 0, 4);
            this.tableLayoutPanel1.Location = new System.Drawing.Point(876, 12);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 5;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(375, 560);
            this.tableLayoutPanel1.TabIndex = 13;
            // 
            // tableLayoutPanel4
            // 
            this.tableLayoutPanel4.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tableLayoutPanel4.ColumnCount = 1;
            this.tableLayoutPanel4.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel4.Controls.Add(this.panel7, 0, 0);
            this.tableLayoutPanel4.Location = new System.Drawing.Point(3, 339);
            this.tableLayoutPanel4.Name = "tableLayoutPanel4";
            this.tableLayoutPanel4.RowCount = 1;
            this.tableLayoutPanel4.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel4.Size = new System.Drawing.Size(369, 106);
            this.tableLayoutPanel4.TabIndex = 16;
            // 
            // panel7
            // 
            this.panel7.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.panel7.Controls.Add(this.Temperature1_dif_colorMarker);
            this.panel7.Controls.Add(this.Temperature1_dif_color);
            this.panel7.Controls.Add(this.Temperature1_dif_chechBox);
            this.panel7.Location = new System.Drawing.Point(3, 25);
            this.panel7.Name = "panel7";
            this.panel7.Size = new System.Drawing.Size(363, 55);
            this.panel7.TabIndex = 15;
            // 
            // Temperature1_dif_colorMarker
            // 
            this.Temperature1_dif_colorMarker.AutoSize = true;
            this.Temperature1_dif_colorMarker.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Temperature1_dif_colorMarker.Location = new System.Drawing.Point(342, 20);
            this.Temperature1_dif_colorMarker.MaximumSize = new System.Drawing.Size(15, 15);
            this.Temperature1_dif_colorMarker.MinimumSize = new System.Drawing.Size(15, 15);
            this.Temperature1_dif_colorMarker.Name = "Temperature1_dif_colorMarker";
            this.Temperature1_dif_colorMarker.Size = new System.Drawing.Size(15, 15);
            this.Temperature1_dif_colorMarker.TabIndex = 17;
            // 
            // Temperature1_dif_color
            // 
            this.Temperature1_dif_color.Location = new System.Drawing.Point(284, 0);
            this.Temperature1_dif_color.Name = "Temperature1_dif_color";
            this.Temperature1_dif_color.Size = new System.Drawing.Size(55, 55);
            this.Temperature1_dif_color.TabIndex = 14;
            this.Temperature1_dif_color.Text = "color";
            this.Temperature1_dif_color.UseVisualStyleBackColor = true;
            this.Temperature1_dif_color.Click += new System.EventHandler(this.Temperature1_dif_color_Click);
            // 
            // Temperature1_dif_chechBox
            // 
            this.Temperature1_dif_chechBox.AutoSize = true;
            this.Temperature1_dif_chechBox.Location = new System.Drawing.Point(6, 18);
            this.Temperature1_dif_chechBox.Name = "Temperature1_dif_chechBox";
            this.Temperature1_dif_chechBox.Size = new System.Drawing.Size(209, 20);
            this.Temperature1_dif_chechBox.TabIndex = 13;
            this.Temperature1_dif_chechBox.Text = "Show temperature 1 difference";
            this.Temperature1_dif_chechBox.UseVisualStyleBackColor = true;
            this.Temperature1_dif_chechBox.CheckedChanged += new System.EventHandler(this.Temperature1_dif_chechBox_CheckedChanged);
            // 
            // panel4
            // 
            this.panel4.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.panel4.Controls.Add(this.Temperature3_colorMarker);
            this.panel4.Controls.Add(this.Temperature3_color);
            this.panel4.Controls.Add(this.Temperature3_checkBox);
            this.panel4.Controls.Add(this.Temperature3_button);
            this.panel4.Controls.Add(this.Temperature3_label);
            this.panel4.Location = new System.Drawing.Point(3, 252);
            this.panel4.Name = "panel4";
            this.panel4.Size = new System.Drawing.Size(365, 55);
            this.panel4.TabIndex = 15;
            // 
            // Temperature3_colorMarker
            // 
            this.Temperature3_colorMarker.AutoSize = true;
            this.Temperature3_colorMarker.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Temperature3_colorMarker.Location = new System.Drawing.Point(345, 20);
            this.Temperature3_colorMarker.MaximumSize = new System.Drawing.Size(15, 15);
            this.Temperature3_colorMarker.MinimumSize = new System.Drawing.Size(15, 15);
            this.Temperature3_colorMarker.Name = "Temperature3_colorMarker";
            this.Temperature3_colorMarker.Size = new System.Drawing.Size(15, 15);
            this.Temperature3_colorMarker.TabIndex = 16;
            // 
            // Temperature3_color
            // 
            this.Temperature3_color.Location = new System.Drawing.Point(287, 0);
            this.Temperature3_color.Name = "Temperature3_color";
            this.Temperature3_color.Size = new System.Drawing.Size(55, 55);
            this.Temperature3_color.TabIndex = 11;
            this.Temperature3_color.Text = "color";
            this.Temperature3_color.UseVisualStyleBackColor = true;
            this.Temperature3_color.Click += new System.EventHandler(this.Temperature3_color_Click);
            // 
            // panel2
            // 
            this.panel2.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.panel2.Controls.Add(this.Temperature1_colorMarker);
            this.panel2.Controls.Add(this.Temperature1_color);
            this.panel2.Controls.Add(this.Temperature1_checkBox);
            this.panel2.Controls.Add(this.Temperature1_button);
            this.panel2.Controls.Add(this.Temperature1_label);
            this.panel2.Location = new System.Drawing.Point(3, 28);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(365, 55);
            this.panel2.TabIndex = 15;
            // 
            // Temperature1_colorMarker
            // 
            this.Temperature1_colorMarker.AutoSize = true;
            this.Temperature1_colorMarker.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Temperature1_colorMarker.Location = new System.Drawing.Point(345, 20);
            this.Temperature1_colorMarker.MaximumSize = new System.Drawing.Size(15, 15);
            this.Temperature1_colorMarker.MinimumSize = new System.Drawing.Size(15, 15);
            this.Temperature1_colorMarker.Name = "Temperature1_colorMarker";
            this.Temperature1_colorMarker.Size = new System.Drawing.Size(15, 15);
            this.Temperature1_colorMarker.TabIndex = 15;
            // 
            // Temperature1_color
            // 
            this.Temperature1_color.Location = new System.Drawing.Point(287, 0);
            this.Temperature1_color.Name = "Temperature1_color";
            this.Temperature1_color.Size = new System.Drawing.Size(55, 55);
            this.Temperature1_color.TabIndex = 9;
            this.Temperature1_color.Text = "color";
            this.Temperature1_color.UseVisualStyleBackColor = true;
            this.Temperature1_color.Click += new System.EventHandler(this.Temperature1_color_Click);
            // 
            // panel1
            // 
            this.panel1.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.panel1.Controls.Add(this.Temperature2_colorMarker);
            this.panel1.Controls.Add(this.Temperature2_color);
            this.panel1.Controls.Add(this.Temperature2_checkBox);
            this.panel1.Controls.Add(this.Temperature2_button);
            this.panel1.Controls.Add(this.Temperature2_label);
            this.panel1.Location = new System.Drawing.Point(3, 140);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(365, 55);
            this.panel1.TabIndex = 14;
            // 
            // Temperature2_colorMarker
            // 
            this.Temperature2_colorMarker.AutoSize = true;
            this.Temperature2_colorMarker.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Temperature2_colorMarker.Location = new System.Drawing.Point(345, 20);
            this.Temperature2_colorMarker.MaximumSize = new System.Drawing.Size(15, 15);
            this.Temperature2_colorMarker.MinimumSize = new System.Drawing.Size(15, 15);
            this.Temperature2_colorMarker.Name = "Temperature2_colorMarker";
            this.Temperature2_colorMarker.Size = new System.Drawing.Size(15, 15);
            this.Temperature2_colorMarker.TabIndex = 16;
            // 
            // Temperature2_color
            // 
            this.Temperature2_color.Location = new System.Drawing.Point(287, 0);
            this.Temperature2_color.Name = "Temperature2_color";
            this.Temperature2_color.Size = new System.Drawing.Size(55, 55);
            this.Temperature2_color.TabIndex = 10;
            this.Temperature2_color.Text = "color";
            this.Temperature2_color.UseVisualStyleBackColor = true;
            this.Temperature2_color.Click += new System.EventHandler(this.Temperature2_color_Click);
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
            this.tableLayoutPanel3.Location = new System.Drawing.Point(3, 451);
            this.tableLayoutPanel3.Name = "tableLayoutPanel3";
            this.tableLayoutPanel3.RowCount = 1;
            this.tableLayoutPanel3.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel3.Size = new System.Drawing.Size(369, 106);
            this.tableLayoutPanel3.TabIndex = 15;
            // 
            // panel3
            // 
            this.panel3.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.panel3.Controls.Add(this.label1);
            this.panel3.Controls.Add(this.DrawType_comboBox);
            this.panel3.Location = new System.Drawing.Point(3, 28);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(178, 50);
            this.panel3.TabIndex = 15;
            // 
            // panel5
            // 
            this.panel5.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.panel5.Controls.Add(this.Legend_checkbox);
            this.panel5.Location = new System.Drawing.Point(187, 30);
            this.panel5.Name = "panel5";
            this.panel5.Size = new System.Drawing.Size(179, 45);
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
            // tableLayoutPanel5
            // 
            this.tableLayoutPanel5.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tableLayoutPanel5.ColumnCount = 1;
            this.tableLayoutPanel5.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel5.Controls.Add(this.panel6, 0, 1);
            this.tableLayoutPanel5.Controls.Add(this.TemperatureChart, 0, 0);
            this.tableLayoutPanel5.Location = new System.Drawing.Point(12, 12);
            this.tableLayoutPanel5.Name = "tableLayoutPanel5";
            this.tableLayoutPanel5.RowCount = 2;
            this.tableLayoutPanel5.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 80F));
            this.tableLayoutPanel5.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tableLayoutPanel5.Size = new System.Drawing.Size(864, 560);
            this.tableLayoutPanel5.TabIndex = 0;
            // 
            // panel6
            // 
            this.panel6.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.panel6.Controls.Add(this.Boldness_trackBar);
            this.panel6.Controls.Add(this.label2);
            this.panel6.Location = new System.Drawing.Point(317, 462);
            this.panel6.Name = "panel6";
            this.panel6.Size = new System.Drawing.Size(230, 84);
            this.panel6.TabIndex = 16;
            // 
            // Boldness_trackBar
            // 
            this.Boldness_trackBar.Location = new System.Drawing.Point(109, 13);
            this.Boldness_trackBar.Minimum = 1;
            this.Boldness_trackBar.Name = "Boldness_trackBar";
            this.Boldness_trackBar.Size = new System.Drawing.Size(101, 56);
            this.Boldness_trackBar.TabIndex = 13;
            this.Boldness_trackBar.Value = 1;
            this.Boldness_trackBar.Scroll += new System.EventHandler(this.Boldness_trackBar_Scroll);
            // 
            // label2
            // 
            this.label2.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(3, 35);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(100, 16);
            this.label2.TabIndex = 12;
            this.label2.Text = "Chart boldness:";
            // 
            // ChartData
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1263, 573);
            this.Controls.Add(this.tableLayoutPanel5);
            this.Controls.Add(this.tableLayoutPanel1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "ChartData";
            this.Text = "Data chart";
            this.Load += new System.EventHandler(this.ChartData_Load);
            ((System.ComponentModel.ISupportInitialize)(this.TemperatureChart)).EndInit();
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel4.ResumeLayout(false);
            this.panel7.ResumeLayout(false);
            this.panel7.PerformLayout();
            this.panel4.ResumeLayout(false);
            this.panel4.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.tableLayoutPanel3.ResumeLayout(false);
            this.panel3.ResumeLayout(false);
            this.panel3.PerformLayout();
            this.panel5.ResumeLayout(false);
            this.panel5.PerformLayout();
            this.tableLayoutPanel5.ResumeLayout(false);
            this.panel6.ResumeLayout(false);
            this.panel6.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Boldness_trackBar)).EndInit();
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
        private System.Windows.Forms.Panel panel5;
        private System.Windows.Forms.CheckBox Legend_checkbox;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel3;
        private System.Windows.Forms.Button Temperature1_color;
        private System.Windows.Forms.Button Temperature2_color;
        private System.Windows.Forms.ColorDialog colorDialog1;
        private System.Windows.Forms.Button Temperature3_color;
        private System.Windows.Forms.Label Temperature1_colorMarker;
        private System.Windows.Forms.Label Temperature3_colorMarker;
        private System.Windows.Forms.Label Temperature2_colorMarker;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel4;
        private System.Windows.Forms.Panel panel7;
        private System.Windows.Forms.Label Temperature1_dif_colorMarker;
        private System.Windows.Forms.Button Temperature1_dif_color;
        private System.Windows.Forms.CheckBox Temperature1_dif_chechBox;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel5;
        private System.Windows.Forms.TrackBar Boldness_trackBar;
        private System.Windows.Forms.Panel panel6;
        private System.Windows.Forms.Label label2;
    }
}