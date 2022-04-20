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
            this.SuspendLayout();
            // 
            // NumberOfMeasurementsLabel
            // 
            this.NumberOfMeasurementsLabel.AutoSize = true;
            this.NumberOfMeasurementsLabel.Location = new System.Drawing.Point(77, 240);
            this.NumberOfMeasurementsLabel.Name = "NumberOfMeasurementsLabel";
            this.NumberOfMeasurementsLabel.Size = new System.Drawing.Size(161, 16);
            this.NumberOfMeasurementsLabel.TabIndex = 0;
            this.NumberOfMeasurementsLabel.Text = "Number of measurements";
            // 
            // AverageTemperatureLabel
            // 
            this.AverageTemperatureLabel.AutoSize = true;
            this.AverageTemperatureLabel.Location = new System.Drawing.Point(76, 300);
            this.AverageTemperatureLabel.Name = "AverageTemperatureLabel";
            this.AverageTemperatureLabel.Size = new System.Drawing.Size(134, 16);
            this.AverageTemperatureLabel.TabIndex = 1;
            this.AverageTemperatureLabel.Text = "Average temperature";
            // 
            // VariationLabel
            // 
            this.VariationLabel.AutoSize = true;
            this.VariationLabel.Location = new System.Drawing.Point(367, 300);
            this.VariationLabel.Name = "VariationLabel";
            this.VariationLabel.Size = new System.Drawing.Size(60, 16);
            this.VariationLabel.TabIndex = 2;
            this.VariationLabel.Text = "Variation";
            // 
            // MaximalValueLabel
            // 
            this.MaximalValueLabel.AutoSize = true;
            this.MaximalValueLabel.Location = new System.Drawing.Point(367, 362);
            this.MaximalValueLabel.Name = "MaximalValueLabel";
            this.MaximalValueLabel.Size = new System.Drawing.Size(93, 16);
            this.MaximalValueLabel.TabIndex = 4;
            this.MaximalValueLabel.Text = "Maximal value";
            // 
            // MinimalValueLabel
            // 
            this.MinimalValueLabel.AutoSize = true;
            this.MinimalValueLabel.Location = new System.Drawing.Point(77, 362);
            this.MinimalValueLabel.Name = "MinimalValueLabel";
            this.MinimalValueLabel.Size = new System.Drawing.Size(91, 16);
            this.MinimalValueLabel.TabIndex = 3;
            this.MinimalValueLabel.Text = "Minimal Value";
            // 
            // LoadFileButton
            // 
            this.LoadFileButton.Location = new System.Drawing.Point(526, 83);
            this.LoadFileButton.Name = "LoadFileButton";
            this.LoadFileButton.Size = new System.Drawing.Size(101, 29);
            this.LoadFileButton.TabIndex = 5;
            this.LoadFileButton.Text = "Load file";
            this.LoadFileButton.UseVisualStyleBackColor = true;
            this.LoadFileButton.Click += new System.EventHandler(this.LoadFileButton_Click);
            // 
            // ChartData_button
            // 
            this.ChartData_button.Enabled = false;
            this.ChartData_button.Location = new System.Drawing.Point(645, 362);
            this.ChartData_button.Name = "ChartData_button";
            this.ChartData_button.Size = new System.Drawing.Size(101, 29);
            this.ChartData_button.TabIndex = 6;
            this.ChartData_button.Text = "Chart data";
            this.ChartData_button.UseVisualStyleBackColor = true;
            this.ChartData_button.Click += new System.EventHandler(this.ChartData_button_Click);
            // 
            // TemperatureAnalyzerLabel
            // 
            this.TemperatureAnalyzerLabel.AutoSize = true;
            this.TemperatureAnalyzerLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.TemperatureAnalyzerLabel.Location = new System.Drawing.Point(74, 46);
            this.TemperatureAnalyzerLabel.Name = "TemperatureAnalyzerLabel";
            this.TemperatureAnalyzerLabel.Size = new System.Drawing.Size(304, 25);
            this.TemperatureAnalyzerLabel.TabIndex = 7;
            this.TemperatureAnalyzerLabel.Text = "Welcome to temperature analyzer";
            // 
            // SaveData_button
            // 
            this.SaveData_button.Enabled = false;
            this.SaveData_button.Location = new System.Drawing.Point(645, 83);
            this.SaveData_button.Name = "SaveData_button";
            this.SaveData_button.Size = new System.Drawing.Size(101, 29);
            this.SaveData_button.TabIndex = 8;
            this.SaveData_button.Text = "Sava data";
            this.SaveData_button.UseVisualStyleBackColor = true;
            this.SaveData_button.Click += new System.EventHandler(this.SaveData_button_Click);
            // 
            // AverageTemperature_value
            // 
            this.AverageTemperature_value.AutoSize = true;
            this.AverageTemperature_value.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.AverageTemperature_value.Location = new System.Drawing.Point(76, 316);
            this.AverageTemperature_value.MinimumSize = new System.Drawing.Size(130, 2);
            this.AverageTemperature_value.Name = "AverageTemperature_value";
            this.AverageTemperature_value.Size = new System.Drawing.Size(130, 18);
            this.AverageTemperature_value.TabIndex = 9;
            // 
            // MinimalValue_value
            // 
            this.MinimalValue_value.AutoSize = true;
            this.MinimalValue_value.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.MinimalValue_value.Location = new System.Drawing.Point(76, 378);
            this.MinimalValue_value.MinimumSize = new System.Drawing.Size(130, 2);
            this.MinimalValue_value.Name = "MinimalValue_value";
            this.MinimalValue_value.Size = new System.Drawing.Size(130, 18);
            this.MinimalValue_value.TabIndex = 10;
            // 
            // MaximalValue_value
            // 
            this.MaximalValue_value.AutoSize = true;
            this.MaximalValue_value.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.MaximalValue_value.Location = new System.Drawing.Point(370, 378);
            this.MaximalValue_value.MinimumSize = new System.Drawing.Size(130, 2);
            this.MaximalValue_value.Name = "MaximalValue_value";
            this.MaximalValue_value.Size = new System.Drawing.Size(130, 18);
            this.MaximalValue_value.TabIndex = 12;
            // 
            // Variation_value
            // 
            this.Variation_value.AutoSize = true;
            this.Variation_value.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Variation_value.Location = new System.Drawing.Point(370, 316);
            this.Variation_value.MinimumSize = new System.Drawing.Size(130, 2);
            this.Variation_value.Name = "Variation_value";
            this.Variation_value.Size = new System.Drawing.Size(130, 18);
            this.Variation_value.TabIndex = 11;
            // 
            // NumberOfMeasurements_value
            // 
            this.NumberOfMeasurements_value.AutoSize = true;
            this.NumberOfMeasurements_value.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.NumberOfMeasurements_value.Location = new System.Drawing.Point(76, 256);
            this.NumberOfMeasurements_value.MinimumSize = new System.Drawing.Size(130, 2);
            this.NumberOfMeasurements_value.Name = "NumberOfMeasurements_value";
            this.NumberOfMeasurements_value.Size = new System.Drawing.Size(130, 18);
            this.NumberOfMeasurements_value.TabIndex = 13;
            // 
            // MainMenu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.NumberOfMeasurements_value);
            this.Controls.Add(this.MaximalValue_value);
            this.Controls.Add(this.Variation_value);
            this.Controls.Add(this.MinimalValue_value);
            this.Controls.Add(this.AverageTemperature_value);
            this.Controls.Add(this.SaveData_button);
            this.Controls.Add(this.TemperatureAnalyzerLabel);
            this.Controls.Add(this.ChartData_button);
            this.Controls.Add(this.LoadFileButton);
            this.Controls.Add(this.MaximalValueLabel);
            this.Controls.Add(this.MinimalValueLabel);
            this.Controls.Add(this.VariationLabel);
            this.Controls.Add(this.AverageTemperatureLabel);
            this.Controls.Add(this.NumberOfMeasurementsLabel);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "MainMenu";
            this.Text = "Temperature Analyzer";
            this.Load += new System.EventHandler(this.MainMenu_Load);
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
    }
}

