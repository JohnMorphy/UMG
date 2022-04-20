using System;
using System.IO;
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
    public partial class MainMenu : Form
    {
        public MainMenu()
        {
            InitializeComponent();
        }

        public static string Messege { get; internal set; }

        private void openFile_Click(object sender, EventArgs e)
        {
            TemperatureAnalyzer.Data.Clear();
            OpenFileDialog LoadFile = new OpenFileDialog();
            LoadFile.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            var filePath = string.Empty;

            if (LoadFile.ShowDialog() == DialogResult.OK)
            {
                filePath = LoadFile.FileName;
                var fileStream = LoadFile.OpenFile();
                
                using (StreamReader reader = new StreamReader(fileStream))
                {              
                    string text = System.IO.File.ReadAllText(filePath);
                    TemperatureAnalyzer.Data.Add(text);
                }               

                if (TemperatureAnalyzer.Data.TemperatureCount < 1)
                {
                    Messege = "Not enough data!";
                    FailToLoad quit = new FailToLoad();
                    quit.ShowDialog();
                }
                else
                {
                    Display display = new Display();
                    display.ShowDialog();
                }
            }
            /*
            else
            {
                Messege = "Failed to load data!";
                FailToLoad quit = new FailToLoad();
                quit.ShowDialog();
            }
            */
        }

        private void Instrucion_Click(object sender, EventArgs e)
        {
            Instructions instructions = new Instructions();
            instructions.ShowDialog();
        }
    }
}
