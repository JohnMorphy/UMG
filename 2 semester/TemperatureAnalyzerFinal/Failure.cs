using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TemperatureAnalyzerFinal
{
    public partial class Failure : Form
    {
        public Failure()
        {
            InitializeComponent();
        }

        private void Quit_button_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void Failure_Load(object sender, EventArgs e)
        {
            FailMessage_Label.Text = MainMenu.message;
        }
    }
}
