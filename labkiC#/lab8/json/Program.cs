using System;
using System.IO;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
// using Models;

// dotnet add package NuGet.CommandLine --version 5.8.0
// dotnet add package Newtonsoft.Json --version 12.0.3

namespace JsonSample
{
  class Testc
  {
    static void Main(string[] args)
    {
        string data = File.ReadAllText("./hero.json");
        JObject Hero = JObject.Parse(data);
        Console.WriteLine("Name: "+ Hero["Name"]);
        Console.WriteLine("Strength: " + Hero["Strength"]);
        Console.WriteLine("Dexterity: " + Hero["Dexterity"]);
        Console.WriteLine("Intelligence: " + Hero["Intelligence"]);
        Console.WriteLine("HP: " + Hero["HP"]);
        Console.WriteLine("MP: " + Hero["MP"]);
        Console.Write("array: ");
        foreach(string tmp in Hero["array"])
        {
            Console.Write(tmp + ", ");
        }
        Console.WriteLine(Hero.ToString());

        Hero["Strength"]=(int)Hero["Strength"] + 10;
        Hero["Dexterity"]=(int)Hero["Dexterity"] - 2;

        File.WriteAllText("./hero2.json", Hero.ToString()); // Load    
    }
  }
}