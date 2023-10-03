using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            
            try
            {
                ServiceReference1.ServiceSoapClient klient = new ServiceReference1.ServiceSoapClient("ServiceSoap12");
                double x, y, suma;
                x = Convert.ToDouble(TextBox1.Text);
                y = Convert.ToDouble(TextBox2.Text);
                suma = klient.dodawanie(x, y);
                TextBox3.Text = suma.ToString();
                Label1.Text = "";
            }

            catch (Exception ex)
            {
                Label1.Text = ex.Message;
            }
            
        }
       
        protected void Button2_Click(object sender, EventArgs e)
        {
           
            try
            {
                ServiceReference1.ServiceSoapClient klient = new ServiceReference1.ServiceSoapClient("ServiceSoap12");
                System.Data.DataTable tabela;
                tabela = klient.studenci();
                GridView1.DataSource = tabela;
                GridView1.DataBind();
                Label1.Text = "";
            }
            catch (Exception ex)
            {
                Label1.Text = ex.Message;
            }

        }
        
        
        protected void Button3_Click(object sender, EventArgs e)
        {
            try
            {
                ServiceReference2.ServiceSoapClient klient = new ServiceReference2.ServiceSoapClient("ServiceSoap121");
                System.Data.DataTable tabela;
                ServiceReference2.DataSet1 baza;
                baza = klient.bazaStudentow();
                tabela = baza.Tables["tableoceny"];
                GridView1.DataSource = tabela;
                GridView1.DataBind();
                Label1.Text = "";
            }
            catch (Exception ex)
            {
                Label1.Text = ex.Message;
            }
        }
    }
}