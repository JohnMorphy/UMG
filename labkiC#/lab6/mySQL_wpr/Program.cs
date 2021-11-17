using System;
using System.Data;

using MySql.Data;
using MySql.Data.MySqlClient;


// dotnet add package MySql.Data --version 8.0.27 //dodanie MySql
public class mySQL_wpr
{
    static void AddUser(String username, String email, String password)
    {
      string connStr = "server=localhost;user=root;database=infa;port=3306;password=";
      MySqlConnection conn = new MySqlConnection(connStr);
      try
      {
        Console.WriteLine("Connecting to MySQL...");
        conn.Open();

        string sql = "INSERT INTO users VALUES (null, '" + username + "', '" + email + "', '" + password + "')";
        MySqlCommand cmd = new MySqlCommand(sql, conn);
        cmd.ExecuteNonQuery();
      }
      catch (Exception ex)
      {
        Console.WriteLine(ex.ToString());
      }
      conn.Close();
      Console.WriteLine("Done.");
    }
    static void CreateDatabase()
    {
      string connStr = "server=localhost;user=root;database=infa;port=3306;password=";
      MySqlConnection conn = new MySqlConnection(connStr);
      try
      {
        Console.WriteLine("Connecting to MySQL...");
        conn.Open();

        string sql = "CREATE TABLE users (id BIGINT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,login VARCHAR(32) UNIQUE NOT NULL,email VARCHAR(64) UNIQUE NOT NULL,password VARCHAR(32) NOT NULL,PRIMARY KEY (id))";
        MySqlCommand cmd = new MySqlCommand(sql, conn);
        cmd.ExecuteNonQuery();
      }
      catch (Exception ex)
      {
        Console.WriteLine(ex.ToString());
      }
      conn.Close();
      Console.WriteLine("Done.");
    }

  public static void Main()
  {
    /*
    string username = "siema";
    string email = "br@gmail.com";
    string password = "mrocznaDzielnica";
    */
    string choice="";
    while(true)
    {
      Console.WriteLine("Co chesz zrobić? \r\n[1] utwórz tabelę\r\n[2] dodaj użytkownika \r\n[dowolny znak] zakończ");
      choice=Console.ReadLine();
      switch(choice)
      {
        case "2":
            Console.WriteLine("Podaj username: ");
            string username = Console.ReadLine();
            Console.WriteLine("Podaj email: ");
            string email = Console.ReadLine();
            Console.WriteLine("Podaj hasło: ");
            string password = Console.ReadLine();
            AddUser(username, email, password);
            break;
        case "1":
            CreateDatabase();
            break;
      }
      if(choice!="1" && choice!="2")
      {
        break;
      }

    }
  }
}