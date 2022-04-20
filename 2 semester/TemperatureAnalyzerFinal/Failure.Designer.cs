namespace TemperatureAnalyzerFinal
{
    partial class Failure
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
            this.Quit_button = new System.Windows.Forms.Button();
            this.FailMessage_Label = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // Quit_button
            // 
            this.Quit_button.Location = new System.Drawing.Point(133, 109);
            this.Quit_button.Name = "Quit_button";
            this.Quit_button.Size = new System.Drawing.Size(75, 23);
            this.Quit_button.TabIndex = 0;
            this.Quit_button.Text = "Ok";
            this.Quit_button.UseVisualStyleBackColor = true;
            this.Quit_button.Click += new System.EventHandler(this.Quit_button_Click);
            // 
            // FailMessage_Label
            // 
            this.FailMessage_Label.AutoSize = true;
            this.FailMessage_Label.Location = new System.Drawing.Point(99, 42);
            this.FailMessage_Label.Name = "FailMessage_Label";
            this.FailMessage_Label.Size = new System.Drawing.Size(89, 16);
            this.FailMessage_Label.TabIndex = 1;
            this.FailMessage_Label.Text = "Fail Message";
            // 
            // Failure
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(344, 144);
            this.Controls.Add(this.FailMessage_Label);
            this.Controls.Add(this.Quit_button);
            this.Name = "Failure";
            this.Text = "Failure";
            this.Load += new System.EventHandler(this.Failure_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button Quit_button;
        private System.Windows.Forms.Label FailMessage_Label;
    }
}