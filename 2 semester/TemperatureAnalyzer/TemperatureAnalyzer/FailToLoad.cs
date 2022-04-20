using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TemperatureAnalyzer
{
    public partial class FailToLoad : Form
    {
        public FailToLoad()
        {
            InitializeComponent();
        }

        private void quit_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void FailToLoad_Load(object sender, EventArgs e)
        {
            label1.Text = MainMenu.Messege;
        }
    }
}
