using System;
using System.Data;

using MySql.Data;
using MySql.Data.MySqlClient;


// dotnet add package MySql.Data --version 8.0.27 //dodanie MySql
// http://localhost/phpmyadmin/index.php?route=/&reload=1
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
    static void ShowTable()
            {
                string connStr = "server=localhost;user=root;database=infa;port=3306;password=";
                MySqlConnection conn = new MySqlConnection(connStr);
                try
                {
                    conn.Open();                  
                    string query = "SHOW TABLES FROM infa";
                    MySqlCommand cmd = new MySqlCommand(query, conn);
                    using (MySqlDataReader reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            Console.WriteLine(reader.GetString(0));
                        }
                    }
                    
                }
                catch (Exception exception)
                {
                    Console.WriteLine(exception.ToString());
                }
                conn.Close();
                Console.ReadLine();
            }

  public static void Main()
  {
    /*
    string username = "siema";
    string email = "br@gmail.com";
    string password = "mrocznaDzielnica";
    */
    int choice=0;
    while(true)
    {
      Console.WriteLine("Co chesz zrobić? \r\n[1] utwórz tabelę\r\n[2] dodaj użytkownika \r\n[3] wyświelt tabelę \r\n[dowolny znak] zakończ");
      int.TryParse(Console.ReadLine(), out choice);
      switch(choice)
      {
        case 3:
            Console.Clear();
            ShowTable();
            break;
        case 2:
            Console.WriteLine("Podaj username: ");
            string username = Console.ReadLine();
            Console.WriteLine("Podaj email: ");
            string email = Console.ReadLine();
            Console.WriteLine("Podaj hasło: ");
            string password = Console.ReadLine();
            AddUser(username, email, password);
            break;
        case 1:
            CreateDatabase();
            break;
      }
      if(choice!=1 || choice!=2 || choice!=3)
      {
        break;
      }

    }
  }
}