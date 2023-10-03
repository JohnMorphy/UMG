using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Reflection.Emit;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsForms_netService
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)

        {

            try
            {
                ServiceReference2.ServiceSoapClient klient = new ServiceReference2.ServiceSoapClient("ServiceSoap121");
                System.Data.DataTable tabela;
                ServiceReference2.DataSet1 baza;
                baza = klient.bazaStudentow();
                tabela = baza.Tables["studenci"];
                dataGridView1.DataSource = tabela;
                label1.Text = "Załadowano nowe dane";
            }

            catch (Exception ex)
            {
                label1.Text = ex.Message;
            }

        }

    }
}
