using System;
using System.Data.SQLite;

namespace projekt_func_test
{
    class Program
    {
        
        static void Main(string[] args)
        {
            string cs = "Data Source=./sqliteDB.db"; //connection string  (wskazuje sciezke do bazy danych)
            using var con = new SQLiteConnection(cs);
            con.Open();

            string stm = "SELECT * FROM Brand";

            string client = "SELECT * FROM Client";
            string[] clients = new string[100];
            int exit = 0;
            bool znizka = false;
            int i = 0;

            while (true)
            {
                Console.Clear();
                Console.WriteLine("Menu");
                Console.WriteLine("[1] Oblicz");
                Console.WriteLine("[2] Wyświetl bazę klientów");
                Console.WriteLine("[3] Dodaj klienta do bazy");
                Console.WriteLine("[4] Usun klienta z bazy");
                Console.WriteLine("[5] Zamknij program");
                Console.Write(": ");

                int answer;
                int.TryParse(Console.ReadLine(), out answer);            //zabezpieczenie przed wpisaniem czegos innego niz int , TryParse to sprawdza
                
                i = 0;



                if (answer == 1)
                {

                    Console.Write("Podaj imie i nazwisko klienta: ");
                    string new_name = Console.ReadLine();



                    using var cmd1 = new SQLiteCommand(client, con);               //odwolanie sie okreslonej tablicy (w tym przypadku zmiennej "client" ktora jest zdefiniowana na poczatku)
                    using SQLiteDataReader reader3 = cmd1.ExecuteReader();         //funcja ExecuteReader() uruchamia czytanie zawartosci wskazanej tablicy



                    while (reader3.Read())
                    {
                        clients[i] = reader3.GetString(1);            //GetString(1) w tym przypadku to sa imiona klientow n.p GetInt32(0) wyswietli numer porzadkowy (bo ma indeks 0), Int32 bo to jest liczba
                        i++;
                    }
                    i = 0;
                    for (i = 0; i < clients.Length; i++)
                    {

                        if (new_name == clients[i])
                        {
                            Console.WriteLine(new_name + " Juz jest w naszej bazie, przysluguje mu znizka 5%");   //sprawdzam czy klient jest w bazie
                            Console.ReadLine();

                            znizka = true;                                              //jesli jest----> ma znizke
                            break;
                        }

                    }

                    if (!znizka)
                    {
                        Console.WriteLine("Klienta nie ma w bazie, chcesz go dodac? [1] Tak  [2] Nie");
                        Console.Write(": ");
                        int ans;
                        int.TryParse(Console.ReadLine(), out ans);
                        if (ans == 1)
                        {
                            Console.Write("Podaj date urodzenia: ");
                            string birth = Console.ReadLine();
                            Console.Write("Podaj adres zamieszkania: ");
                            string address = Console.ReadLine();
                            using var cmd4 = new SQLiteCommand(con);
                            cmd4.CommandText = "INSERT INTO Client(name,birth,address) VALUES(@name,@birth,@address)"; //tutaj wskazuje teblice oraz miejsca w tej tablicy w ktore chce wpisac dane klienta (jak widac nie wpisuje liczby porzadkowej,poniewaz w ustawieniach bazy ona automatycznie sie zwieksza)
                            cmd4.Parameters.AddWithValue("@name", new_name); //imie ,nazwisko
                            cmd4.Parameters.AddWithValue("@birth", birth);   //adres
                            cmd4.Parameters.AddWithValue("@address", address);
                            cmd4.Prepare();      //"doslownie" przygotowuje dane
                            cmd4.ExecuteNonQuery();   //wysylam , NonQuery-czyli baza nic mi nie zwraca
                            Console.WriteLine("Klient " + new_name + " dodany");
                            Console.ReadLine();
                        }
                    }

                    Console.Clear();
                    Console.WriteLine("Wybierz samochod:");


                    using var cmd = new SQLiteCommand(stm, con);
                    using SQLiteDataReader reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {

                        Console.WriteLine($"{reader.GetInt32(0)} {reader.GetString(1)}");  //getint(0) getstring(1) jak pisalem wczesniej tu trzeba okreslic typ zwrazanych dannych oraz indek okresla co to sa za dane(np 0 to indeks, 1 to nazwa)

                    }
                    Console.Write(": ");
                    
                    int brand;
                    int.TryParse(Console.ReadLine(),out brand);
                    if (brand != 0)
                    {
                        brandChoice(brand);
                    }
                    else
                    {
                        Console.WriteLine("Wprowadziles niepoprawne dane,sprobuj ponownie");
                        Console.ReadKey();
                    }
                }


                else if (answer == 2)
                {


                    using var cmd2 = new SQLiteCommand(client, con);
                    using SQLiteDataReader reader2 = cmd2.ExecuteReader();
                    Console.WriteLine();
                    while (reader2.Read())
                    {

                        Console.WriteLine($"{reader2.GetInt32(0)} {reader2.GetString(1)} {reader2.GetString(2)} {reader2.GetString(3)}");

                    }
                    Console.WriteLine("Chcesz zamknąć program? [1] Tak   [2] Nie");
                    Console.Write(": ");
                    int.TryParse(Console.ReadLine(),out exit);
                    if (exit == 1)
                    {
                        Environment.Exit(0);
                    }
                }    //ZROBIONE


                else if (answer == 3)
                {

                    using var cmd3 = new SQLiteCommand(con);
                    cmd3.CommandText = "INSERT INTO Client(name,birth,address) VALUES(@name,@birth,@address)"; //dodawanie klienta, o tym juz bylo
                    Console.Write("Podaj imie i nazwisko: ");
                    string name = Console.ReadLine();
                    Console.WriteLine();
                    Console.Write("Podaj date urodzenia n.p.[xx.xx.xxxx]: ");
                    string birth = Console.ReadLine();
                    Console.WriteLine();
                    Console.Write("Podaj adres zamieszkania: ");
                    string address = Console.ReadLine();
                    cmd3.Parameters.AddWithValue("@name", name);
                    cmd3.Parameters.AddWithValue("@Birth", birth);
                    cmd3.Parameters.AddWithValue("@address", address);
                    cmd3.Prepare();
                    cmd3.ExecuteNonQuery();

                    Console.WriteLine("Klient został dodany");
                    Console.WriteLine("Chcesz zamknąć program? [1] Tak   [2] Nie");
                    Console.Write(": ");
                    int.TryParse(Console.ReadLine(), out exit);
                    if (exit == 1)
                    {
                        Environment.Exit(0);
                    }

                }    //ZROBIONE


                else if (answer == 4)
                {
                    Console.WriteLine("Podaj ID klienta ktorego chcesz usunac z bazy");
                    Console.WriteLine("Lub wpisz '0' zeby wrocic do menu");
                    Console.Write(": ");
                    int close;
                    int.TryParse(Console.ReadLine(),out close);
                    if (close != 0)
                    {
                        int delete = close;
                        using var cmd4 = new SQLiteCommand(con);
                        Console.WriteLine("Napewno chcesz usunac klienta? [1] Tak  [2] Nie");
                        Console.Write(": ");
                        int ans;
                        int.TryParse(Console.ReadLine(),out ans);
                        if (ans == 1)
                        {
                            cmd4.CommandText = "DELETE FROM Client WHERE Id=" + delete + "";  //usuwanie klienta DELETE FROM Client(czyli wskazuje teblice) WHERE Id=(usuwam rekord o kliencie ktory ma podany Id)
                            cmd4.Prepare();
                            cmd4.ExecuteNonQuery();
                            Console.WriteLine("Klient zostal usuniety");
                            Console.ReadLine();
                        }
                    }


                }    //ZROBIONE


                else if (answer == 5)
                {
                    Environment.Exit(0);
                }      //ZROBIONE


                else
                {
                    Console.WriteLine("Wystąpił błąd,spróbuj ponownie");
                    Console.ReadLine();
                }


            }
        }

        public static void brandChoice(int brand)
        {
            bool control=true;
            string cs = "Data Source=./sqliteDB.db";
            using var con = new SQLiteConnection(cs);
            con.Open();

            String brandTable ="";
            switch (brand)
            {
                case 1:
                brandTable="Audi_model";
                break;

                case 2:
                brandTable="BMW_model";
                break;

                case 3:
                brandTable="Mercedes_model";
                break;

                case 4:
                brandTable="Toyota_model";
                break;

                default:
                Console.WriteLine("Podano nieprawidłowe dane");
                control=false;
                break;
            }
            if(control==true)
            { 
                using var cmd1 = new SQLiteCommand("SELECT * FROM " + brandTable, con);
                using SQLiteDataReader rdr1 = cmd1.ExecuteReader();

                Console.WriteLine("Wybierz model");
                while (rdr1.Read())
                {
                    Console.WriteLine($"{rdr1.GetInt32(0)} {rdr1.GetString(1)}");
                }
                Console.Write(": ");

                int model=0;
                double multiplier=0;
                while(true)
                {
                    int.TryParse(Console.ReadLine(),out model);
                    if(model==1 || model==2 || model==3 || model==4 || model==5)
                    {
                        break;
                    }
                    else
                    {
                        Console.Write("Nie ma takiego modelu, podaj nr modelu jeszcze raz: ");
                    }
                }

                using var cmd2 = new SQLiteCommand("SELECT Multiplier FROM " + brandTable + " WHERE Id= " + model, con);
                using SQLiteDataReader read_multiplier = cmd2.ExecuteReader();
                while (read_multiplier.Read())
                {
                    multiplier = read_multiplier.GetDouble(0);
                }

                Model(multiplier);
            }
            else
            {
                int brand1;
                Console.WriteLine("Wprowadź dane ponownie:");
                int.TryParse(Console.ReadLine(),out brand1);
                brandChoice(brand1);
            }
        }

        public static void Model(double multiplier)             //tu juz chyba wszystko jest jasne
        {   
            string cs = "Data Source=./sqliteDB.db";
            using var con = new SQLiteConnection(cs);
            con.Open();
                       
            string parts = "SELECT * FROM Parts";
            string paint = "SELECT * FROM Paint";
            string[] clients = new string[100];
            int pick_part = -1;
            int pick_paint = -1;
            bool znizka = false;
            int field = 0;
            int paint_price = 0;
            double price = 0;

            Console.Clear();
            Console.WriteLine("Wybierz czesci: ");
            Console.WriteLine();
            using var cmd5 = new SQLiteCommand(parts, con);
            using SQLiteDataReader read_parts = cmd5.ExecuteReader();
            Console.WriteLine("0 Zeby potwierdzic wybor");
            Console.WriteLine();
            while (read_parts.Read())
            {

                Console.WriteLine($"{read_parts.GetInt32(0)} {read_parts.GetString(1)}");

            }
            while (pick_part != 0)
            {
                Console.Write(": ");
                int.TryParse(Console.ReadLine(),out pick_part);
                using var cmd6 = new SQLiteCommand("SELECT * FROM Parts WHERE Id=" + pick_part + "", con);
                using SQLiteDataReader read_parts1 = cmd6.ExecuteReader();
                while (read_parts1.Read())
                {
                    field += read_parts1.GetInt32(2);
                }

            }

            pick_part = -1;
            Console.Clear();
            Console.WriteLine("Wybierz kolor: ");
            using var cmd7 = new SQLiteCommand(paint, con);
            using SQLiteDataReader read_paint = cmd7.ExecuteReader();
            while (read_paint.Read())
            {
                Console.WriteLine($"{read_paint.GetInt32(0)} {read_paint.GetString(1)}");
            }
            Console.Write(": ");
            int.TryParse(Console.ReadLine(), out pick_paint);
            using var cmd8 = new SQLiteCommand("SELECT * FROM Paint WHERE Id=" + pick_paint + "", con);
            using SQLiteDataReader read_paint1 = cmd8.ExecuteReader();
            while (read_paint1.Read())
            {
                paint_price = read_paint1.GetInt32(2);
            }
            if (znizka)
            {
                price = 0;
                price = field * paint_price * multiplier * 0.95;

            }
            else
            {
                price = 0;
                price = field * paint_price * multiplier;
            }

            Console.WriteLine("Cena za malowanie tych czesci wynosi " + price + "zl");

            Console.ReadLine();
        }  //ZROBIONE
    }
}
