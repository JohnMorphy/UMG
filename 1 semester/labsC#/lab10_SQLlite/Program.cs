using System;
using Microsoft.Data.Sqlite;    //niezbędna biblioteka

namespace lab10_SQLlite
{
    class Program
    {
        static void Main(string[] args)
        {
            //dodanie paczki do projektu
            //dotnet add package Microsoft.Data.Sqlite
            string name = "hello.db";
            // using to coś w rodzaju try catch
            using (var conn = new SqliteConnection($"Data Source={name}")) {
            conn.Open();
            var cmd = conn.CreateCommand();
            cmd.CommandText = @"
            CREATE TABLE users (
                id INTEGER PRIMARY KEY,
                login TEXT UNIQUE NOT NULL,
                emial TEXT UNIQUE NOT NULL,
                password TEXT NOT NULL
            );";
            using var reader = cmd.ExecuteReader();
            }
        }
    }
}
