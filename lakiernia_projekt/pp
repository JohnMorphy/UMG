using System;
using System.Data.SQLite;


string cs = @"URI=file:E:\test\DB_test\DB_test\sqliteDB.db";


using var con = new SQLiteConnection(cs);
con.Open();
int exit=0;

while (true)
{
    Console.Clear();
    Console.WriteLine("Menu");
    Console.WriteLine("[1] Oblicz");
    Console.WriteLine("[2] Wyświetl bazę klientów");
    Console.WriteLine("[3] Dodaj klienta do bazy");
    Console.WriteLine("[4] Zamknij program");
    int answer = int.Parse(Console.ReadLine());

    

    if (answer == 1)
    {
        Console.WriteLine("Wybierz samochod:");
        string stm = "SELECT * FROM Brand";

        using var cmd = new SQLiteCommand(stm, con);
        using SQLiteDataReader reader = cmd.ExecuteReader();

        while (reader.Read())
        {

            Console.WriteLine($"{reader.GetInt32(0)} {reader.GetString(1)}");

        }
        //reader.Close();
        int brand = int.Parse(Console.ReadLine());


        if (brand == 1)
        {

            string stm1 = "SELECT * FROM Audi_model";

            using var cmd1 = new SQLiteCommand(stm1, con);
            using SQLiteDataReader rdr1 = cmd1.ExecuteReader();


            Console.WriteLine("Wybierz model");
            while (rdr1.Read())
            {

                Console.WriteLine($"{rdr1.GetInt32(0)} {rdr1.GetString(1)}");

            }
            int model = int.Parse(Console.ReadLine());

        }
    }


    else if (answer == 2)
    {
        string stm2 = "SELECT * FROM Client";

        using var cmd2 = new SQLiteCommand(stm2, con);
        using SQLiteDataReader reader2 = cmd2.ExecuteReader();

        while (reader2.Read())
        {

            Console.WriteLine($"{reader2.GetInt32(0)} {reader2.GetString(1)}");

        }
        Console.WriteLine("Chcesz zamknąć program? [1] Tak   [2] Nie");
        exit = int.Parse(Console.ReadLine());
        if (exit == 1)
        {
            Environment.Exit(0);
        }
    }


    else if (answer == 3)
    {

        using var cmd3 = new SQLiteCommand(con);
        cmd3.CommandText = "INSERT INTO Client(name) VALUES(@name)";
        Console.Write("Podaj imie i nazwisko: ");
        string name = Console.ReadLine();
        cmd3.Parameters.AddWithValue("@name", name);
        cmd3.Prepare();

        cmd3.ExecuteNonQuery();

        Console.WriteLine("Klient został dodany");

        Console.WriteLine("Chcesz zamknąć program? [1] Tak   [2] Nie");
        exit = int.Parse(Console.ReadLine());
        if(exit==1)
        {
            Environment.Exit(0);
        }

    }


    else if (answer==4)
    {
        Environment.Exit(0);
    }


    else
    {
        Console.WriteLine("Wystąpił błąd,spróbuj ponownie");
        Console.ReadLine();
    }
    
    
}
