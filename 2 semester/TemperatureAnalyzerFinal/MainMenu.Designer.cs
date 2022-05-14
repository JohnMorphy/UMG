namespace TemperatureAnalyzerFinal
{
    partial class MainMenu
    {
        /// <summary>
        /// Wymagana zmienna projektanta.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Wyczyść wszystkie używane zasoby.
        /// </summary>
        /// <param name="disposing">prawda, jeżeli zarządzane zasoby powinny zostać zlikwidowane; Fałsz w przeciwnym wypadku.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Kod generowany przez Projektanta formularzy systemu Windows

        /// <summary>
        /// Metoda wymagana do obsługi projektanta — nie należy modyfikować
        /// jej zawartości w edytorze kodu.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainMenu));
            this.NumberOfMeasurementsLabel = new System.Windows.Forms.Label();
            this.AverageTemperatureLabel = new System.Windows.Forms.Label();
            this.VariationLabel = new System.Windows.Forms.Label();
            this.MaximalValueLabel = new System.Windows.Forms.Label();
            this.MinimalValueLabel = new System.Windows.Forms.Label();
            this.LoadFileButton = new System.Windows.Forms.Button();
            this.ChartData_button = new System.Windows.Forms.Button();
            this.TemperatureAnalyzerLabel = new System.Windows.Forms.Label();
            this.SaveData_button = new System.Windows.Forms.Button();
            this.AverageTemperature_value = new System.Windows.Forms.Label();
            this.MinimalValue_value = new System.Windows.Forms.Label();
            this.MaximalValue_value = new System.Windows.Forms.Label();
            this.Variation_value = new System.Windows.Forms.Label();
            this.NumberOfMeasurements_value = new System.Windows.Forms.Label();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel2 = new System.Windows.Forms.TableLayoutPanel();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.groupBox6 = new System.Windows.Forms.GroupBox();
            this.panel1 = new System.Windows.Forms.Panel();
            this.tableLayoutPanel1.SuspendLayout();
            this.tableLayoutPanel2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox6.SuspendLayout();
            this.SuspendLayout();
            // 
            // NumberOfMeasurementsLabel
            // 
            this.NumberOfMeasurementsLabel.AutoSize = true;
            this.NumberOfMeasurementsLabel.Location = new System.Drawing.Point(3, 0);
            this.NumberOfMeasurementsLabel.Name = "NumberOfMeasurementsLabel";
            this.NumberOfMeasurementsLabel.Size = new System.Drawing.Size(161, 16);
            this.NumberOfMeasurementsLabel.TabIndex = 0;
            this.NumberOfMeasurementsLabel.Text = "Number of measurements";
            // 
            // AverageTemperatureLabel
            // 
            this.AverageTemperatureLabel.AutoSize = true;
            this.AverageTemperatureLabel.Location = new System.Drawing.Point(6, 0);
            this.AverageTemperatureLabel.Name = "AverageTemperatureLabel";
            this.AverageTemperatureLabel.Size = new System.Drawing.Size(134, 16);
            this.AverageTemperatureLabel.TabIndex = 1;
            this.AverageTemperatureLabel.Text = "Average temperature";
            // 
            // VariationLabel
            // 
            this.VariationLabel.AutoSize = true;
            this.VariationLabel.Location = new System.Drawing.Point(6, 0);
            this.VariationLabel.Name = "VariationLabel";
            this.VariationLabel.Size = new System.Drawing.Size(60, 16);
            this.VariationLabel.TabIndex = 2;
            this.VariationLabel.Text = "Variation";
            // 
            // MaximalValueLabel
            // 
            this.MaximalValueLabel.AutoSize = true;
            this.MaximalValueLabel.Location = new System.Drawing.Point(6, 0);
            this.MaximalValueLabel.Name = "MaximalValueLabel";
            this.MaximalValueLabel.Size = new System.Drawing.Size(93, 16);
            this.MaximalValueLabel.TabIndex = 4;
            this.MaximalValueLabel.Text = "Maximal value";
            // 
            // MinimalValueLabel
            // 
            this.MinimalValueLabel.AutoSize = true;
            this.MinimalValueLabel.Location = new System.Drawing.Point(6, 0);
            this.MinimalValueLabel.Name = "MinimalValueLabel";
            this.MinimalValueLabel.Size = new System.Drawing.Size(91, 16);
            this.MinimalValueLabel.TabIndex = 3;
            this.MinimalValueLabel.Text = "Minimal Value";
            // 
            // LoadFileButton
            // 
            this.LoadFileButton.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.LoadFileButton.Location = new System.Drawing.Point(468, 11);
            this.LoadFileButton.Name = "LoadFileButton";
            this.LoadFileButton.Size = new System.Drawing.Size(101, 29);
            this.LoadFileButton.TabIndex = 5;
            this.LoadFileButton.Text = "Load file";
            this.LoadFileButton.UseVisualStyleBackColor = true;
            this.LoadFileButton.Click += new System.EventHandler(this.LoadFileButton_Click);
            // 
            // ChartData_button
            // 
            this.ChartData_button.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.ChartData_button.Enabled = false;
            this.ChartData_button.Location = new System.Drawing.Point(468, 63);
            this.ChartData_button.Name = "ChartData_button";
            this.ChartData_button.Size = new System.Drawing.Size(101, 29);
            this.ChartData_button.TabIndex = 6;
            this.ChartData_button.Text = "Chart data";
            this.ChartData_button.UseVisualStyleBackColor = true;
            this.ChartData_button.Click += new System.EventHandler(this.ChartData_button_Click);
            // 
            // TemperatureAnalyzerLabel
            // 
            this.TemperatureAnalyzerLabel.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.TemperatureAnalyzerLabel.AutoSize = true;
            this.TemperatureAnalyzerLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.TemperatureAnalyzerLabel.Location = new System.Drawing.Point(76, 13);
            this.TemperatureAnalyzerLabel.Name = "TemperatureAnalyzerLabel";
            this.TemperatureAnalyzerLabel.Size = new System.Drawing.Size(304, 25);
            this.TemperatureAnalyzerLabel.TabIndex = 7;
            this.TemperatureAnalyzerLabel.Text = "Welcome to temperature analyzer";
            // 
            // SaveData_button
            // 
            this.SaveData_button.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.SaveData_button.Enabled = false;
            this.SaveData_button.Location = new System.Drawing.Point(591, 11);
            this.SaveData_button.Name = "SaveData_button";
            this.SaveData_button.Size = new System.Drawing.Size(101, 29);
            this.SaveData_button.TabIndex = 8;
            this.SaveData_button.Text = "Sava file";
            this.SaveData_button.UseVisualStyleBackColor = true;
            this.SaveData_button.Click += new System.EventHandler(this.SaveData_button_Click);
            // 
            // AverageTemperature_value
            // 
            this.AverageTemperature_value.AutoSize = true;
            this.AverageTemperature_value.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.AverageTemperature_value.Location = new System.Drawing.Point(6, 16);
            this.AverageTemperature_value.MinimumSize = new System.Drawing.Size(130, 2);
            this.AverageTemperature_value.Name = "AverageTemperature_value";
            this.AverageTemperature_value.Size = new System.Drawing.Size(130, 18);
            this.AverageTemperature_value.TabIndex = 9;
            // 
            // MinimalValue_value
            // 
            this.MinimalValue_value.AutoSize = true;
            this.MinimalValue_value.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.MinimalValue_value.Location = new System.Drawing.Point(5, 16);
            this.MinimalValue_value.MinimumSize = new System.Drawing.Size(130, 2);
            this.MinimalValue_value.Name = "MinimalValue_value";
            this.MinimalValue_value.Size = new System.Drawing.Size(130, 18);
            this.MinimalValue_value.TabIndex = 10;
            // 
            // MaximalValue_value
            // 
            this.MaximalValue_value.AutoSize = true;
            this.MaximalValue_value.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.MaximalValue_value.Location = new System.Drawing.Point(9, 16);
            this.MaximalValue_value.MinimumSize = new System.Drawing.Size(130, 2);
            this.MaximalValue_value.Name = "MaximalValue_value";
            this.MaximalValue_value.Size = new System.Drawing.Size(130, 18);
            this.MaximalValue_value.TabIndex = 12;
            // 
            // Variation_value
            // 
            this.Variation_value.AutoSize = true;
            this.Variation_value.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Variation_value.Location = new System.Drawing.Point(9, 16);
            this.Variation_value.MinimumSize = new System.Drawing.Size(130, 2);
            this.Variation_value.Name = "Variation_value";
            this.Variation_value.Size = new System.Drawing.Size(130, 18);
            this.Variation_value.TabIndex = 11;
            // 
            // NumberOfMeasurements_value
            // 
            this.NumberOfMeasurements_value.AutoSize = true;
            this.NumberOfMeasurements_value.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.NumberOfMeasurements_value.Location = new System.Drawing.Point(6, 16);
            this.NumberOfMeasurements_value.MinimumSize = new System.Drawing.Size(130, 2);
            this.NumberOfMeasurements_value.Name = "NumberOfMeasurements_value";
            this.NumberOfMeasurements_value.Size = new System.Drawing.Size(130, 18);
            this.NumberOfMeasurements_value.TabIndex = 13;
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tableLayoutPanel1.BackColor = System.Drawing.Color.Transparent;
            this.tableLayoutPanel1.ColumnCount = 3;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 124F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 121F));
            this.tableLayoutPanel1.Controls.Add(this.TemperatureAnalyzerLabel, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.LoadFileButton, 1, 0);
            this.tableLayoutPanel1.Controls.Add(this.SaveData_button, 2, 0);
            this.tableLayoutPanel1.Controls.Add(this.ChartData_button, 1, 1);
            this.tableLayoutPanel1.Location = new System.Drawing.Point(24, 29);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 2;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 52F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(702, 104);
            this.tableLayoutPanel1.TabIndex = 14;
            // 
            // tableLayoutPanel2
            // 
            this.tableLayoutPanel2.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tableLayoutPanel2.BackColor = System.Drawing.Color.Transparent;
            this.tableLayoutPanel2.ColumnCount = 2;
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel2.Controls.Add(this.groupBox3, 1, 2);
            this.tableLayoutPanel2.Controls.Add(this.groupBox1, 0, 0);
            this.tableLayoutPanel2.Controls.Add(this.groupBox4, 0, 2);
            this.tableLayoutPanel2.Controls.Add(this.groupBox2, 1, 1);
            this.tableLayoutPanel2.Controls.Add(this.groupBox6, 0, 1);
            this.tableLayoutPanel2.Location = new System.Drawing.Point(24, 157);
            this.tableLayoutPanel2.Name = "tableLayoutPanel2";
            this.tableLayoutPanel2.RowCount = 3;
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.tableLayoutPanel2.Size = new System.Drawing.Size(702, 290);
            this.tableLayoutPanel2.TabIndex = 15;
            // 
            // groupBox3
            // 
            this.groupBox3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.groupBox3.BackColor = System.Drawing.Color.Transparent;
            this.groupBox3.Controls.Add(this.MaximalValueLabel);
            this.groupBox3.Controls.Add(this.MaximalValue_value);
            this.groupBox3.Location = new System.Drawing.Point(419, 223);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(215, 35);
            this.groupBox3.TabIndex = 22;
            this.groupBox3.TabStop = false;
            // 
            // groupBox1
            // 
            this.groupBox1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.groupBox1.BackColor = System.Drawing.Color.Transparent;
            this.groupBox1.Controls.Add(this.NumberOfMeasurementsLabel);
            this.groupBox1.Controls.Add(this.NumberOfMeasurements_value);
            this.groupBox1.Location = new System.Drawing.Point(68, 30);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(215, 35);
            this.groupBox1.TabIndex = 16;
            this.groupBox1.TabStop = false;
            // 
            // groupBox4
            // 
            this.groupBox4.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.groupBox4.BackColor = System.Drawing.Color.Transparent;
            this.groupBox4.Controls.Add(this.MinimalValueLabel);
            this.groupBox4.Controls.Add(this.MinimalValue_value);
            this.groupBox4.Location = new System.Drawing.Point(68, 223);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(215, 35);
            this.groupBox4.TabIndex = 21;
            this.groupBox4.TabStop = false;
            // 
            // groupBox2
            // 
            this.groupBox2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.groupBox2.BackColor = System.Drawing.Color.Transparent;
            this.groupBox2.Controls.Add(this.VariationLabel);
            this.groupBox2.Controls.Add(this.Variation_value);
            this.groupBox2.Location = new System.Drawing.Point(419, 126);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(215, 35);
            this.groupBox2.TabIndex = 20;
            this.groupBox2.TabStop = false;
            // 
            // groupBox6
            // 
            this.groupBox6.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.groupBox6.BackColor = System.Drawing.Color.Transparent;
            this.groupBox6.Controls.Add(this.AverageTemperatureLabel);
            this.groupBox6.Controls.Add(this.AverageTemperature_value);
            this.groupBox6.Location = new System.Drawing.Point(68, 126);
            this.groupBox6.Name = "groupBox6";
            this.groupBox6.Size = new System.Drawing.Size(215, 35);
            this.groupBox6.TabIndex = 19;
            this.groupBox6.TabStop = false;
            // 
            // panel1
            // 
            this.panel1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.panel1.AutoSize = true;
            this.panel1.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.panel1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel1.Location = new System.Drawing.Point(12, 12);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(2, 2);
            this.panel1.TabIndex = 16;
            // 
            // MainMenu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(752, 473);
            this.Controls.Add(this.tableLayoutPanel1);
            this.Controls.Add(this.tableLayoutPanel2);
            this.Controls.Add(this.panel1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "MainMenu";
            this.Text = "Temperature Analyzer";
            this.Load += new System.EventHandler(this.MainMenu_Load);
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            this.tableLayoutPanel2.ResumeLayout(false);
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox6.ResumeLayout(false);
            this.groupBox6.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label NumberOfMeasurementsLabel;
        private System.Windows.Forms.Label AverageTemperatureLabel;
        private System.Windows.Forms.Label VariationLabel;
        private System.Windows.Forms.Label MaximalValueLabel;
        private System.Windows.Forms.Label MinimalValueLabel;
        private System.Windows.Forms.Button LoadFileButton;
        private System.Windows.Forms.Button ChartData_button;
        private System.Windows.Forms.Label TemperatureAnalyzerLabel;
        private System.Windows.Forms.Button SaveData_button;
        private System.Windows.Forms.Label AverageTemperature_value;
        private System.Windows.Forms.Label MinimalValue_value;
        private System.Windows.Forms.Label MaximalValue_value;
        private System.Windows.Forms.Label Variation_value;
        private System.Windows.Forms.Label NumberOfMeasurements_value;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel2;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox6;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.Panel panel1;
    }
}

