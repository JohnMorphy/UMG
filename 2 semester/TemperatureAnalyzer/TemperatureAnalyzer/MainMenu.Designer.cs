namespace TemperatureAnalyzer
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
            this.label1 = new System.Windows.Forms.Label();
            this.openFile = new System.Windows.Forms.Button();
            this.Instrucion = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(287, 77);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(215, 16);
            this.label1.TabIndex = 0;
            this.label1.Text = "Welcome to Temperature Analyzer";
            // 
            // openFile
            // 
            this.openFile.Location = new System.Drawing.Point(102, 258);
            this.openFile.Name = "openFile";
            this.openFile.Size = new System.Drawing.Size(154, 151);
            this.openFile.TabIndex = 1;
            this.openFile.Text = "Open file";
            this.openFile.UseVisualStyleBackColor = true;
            this.openFile.Click += new System.EventHandler(this.openFile_Click);
            // 
            // Instrucion
            // 
            this.Instrucion.Location = new System.Drawing.Point(526, 258);
            this.Instrucion.Name = "Instrucion";
            this.Instrucion.Size = new System.Drawing.Size(154, 151);
            this.Instrucion.TabIndex = 2;
            this.Instrucion.Text = "Data format";
            this.Instrucion.UseVisualStyleBackColor = true;
            this.Instrucion.Click += new System.EventHandler(this.Instrucion_Click);
            // 
            // MainMenu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.Instrucion);
            this.Controls.Add(this.openFile);
            this.Controls.Add(this.label1);
            this.Name = "MainMenu";
            this.Text = "Temperature Analyzer";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button openFile;
        private System.Windows.Forms.Button Instrucion;
    }
}

