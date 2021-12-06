using System;
using System.IO;
using System.Collections.Generic;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
// dotnet add package NuGet.CommandLine --version 5.8.0
// dotnet add package Newtonsoft.Json --version 12.0.3

namespace funkcje
{
    public class Hero
    {
        public string Name;
        private int Strength;
        private int Dexterity;
        private int Intelligence;
        private int HP;
        private String Class;
        private int level;
        private int experience;
        private void Init(int strength = 5, int dexterity = 5, int intelligence = 5, string myclass="warrior")
        {
            this.Strength = strength;
            this.Dexterity = dexterity;
            this.Intelligence = intelligence;
            this.Class = myclass;
            this.HP = 50;
            this.level=1;
            this.experience=0;
        }

        public string GetName() { return Name; }
        public int GetStrength() { return Strength; }
        public int GetDexterity() { return Dexterity; }
        public int GetIntelligence() { return Intelligence; }
        public String GetClass() { return Class; }
        public int GetHP() { return HP; }
        public int GetLevel() { return level; }
        public int GetExperience() { return experience; }
        public void HPloss(int attack)
        {
            this.HP=this.HP-attack;
        }
        public void HPreset()
        {
            this.HP=50;
        }
        public void SpellCast(int attack)
        {
            this.HP=this.HP-attack;
        }
        public Hero(string name, string myclass)
        {
            Name = name;
            switch(myclass)
            {
                case "warrior": Init(8, 5, 2,  myclass); break;
                case "assassin": Init(3, 8, 4, myclass); break;
                case "sorcerer": Init(4, 2, 9, myclass); break;
                default: Init(); break;
            }
        }

        public void SaveHero(List<Hero> heroes, int i)
        {
            Console.Clear();
            String toFile="{\n\r\"Name\": "+ "\"" + heroes[i].GetName() + "\"," + "\n\r\"Strength\": " + "\"" + heroes[i].GetStrength() + "\"," + "\n\r\"Dexterity\": " + "\"" + heroes[i].GetDexterity() + "\",";
            toFile=toFile + "\n\r\"Intelligence\": " + "\"" + heroes[i].GetIntelligence() + "\"," + "\n\r\"HP\": " + "\"" + heroes[i].GetHP() + "\",";
            toFile=toFile + "\n\r\"Class\": " + "\"" + heroes[i].GetClass() + "\"," + "\n\r\"Level\": " + "\"" + heroes[i].GetLevel() + "\","  + "\n\r\"Experience\": " + "\"" + heroes[i].GetExperience() + "\"" + "\n\r}";
            File.WriteAllText("./" + heroes[i].GetName() + ".json", toFile); // Load    
            Console.Clear();
        }

        public int load(string name)
        {
            try
            {
                string data ="";
                data = File.ReadAllText("./" + name + ".json");
                JObject Hero = JObject.Parse(data);
                Name = name;
                Init((int)Hero["Strength"], (int)Hero["Dexterity"], (int)Hero["Intelligence"], (String)Hero["Class"]);
            }
            catch(Exception)
            {
                Console.WriteLine("Nie udało się wczytać pliku!");
                return 1;
            }
            Console.WriteLine("Udało się wczytać bohatera!");
            return 0;
        }

    }
    
    public class action
    {
        public static void attack(List<Hero> heroes, int x, int y)
        {
            heroes[x].HPreset();
            heroes[y].HPreset();
            int unik = 0;
            int magia = 0;
            int attack = 0;
            int fart = 0;
            int a = x;
            int b = y;
            int bufor=0;

            Random rng = new Random();
            
            while(heroes[a].GetHP()>=0 && heroes[b].GetHP()>=0)
            {
                unik = rng.Next() % (15);
                magia = rng.Next() % (20);
                
                if(heroes[b].GetDexterity()==unik && heroes[b].GetClass()=="assassin")
                {
                    Console.WriteLine("Bohater {0} sparował cios i dokonał kontry!", heroes[b].Name);
                    fart = rng.Next() % (3);
                    attack=heroes[b].GetStrength()+fart;
                    Console.WriteLine("Bohater {0} otrzymał {1} obrażeń!", heroes[a].Name, attack);
                    heroes[a].HPloss(attack);
                }
                else if(heroes[b].GetDexterity()>=unik)
                {
                    Console.WriteLine("Bohater {0} wykonał unik!", heroes[b].Name);
                }
                else
                {
                    fart = rng.Next() % (3);
                    attack=heroes[a].GetStrength()+fart;
                    Console.WriteLine("Bohater {0} otrzymał {1} obrażeń!", heroes[b].Name, attack);
                    heroes[b].HPloss(attack);
                }

                if(heroes[y].GetIntelligence()<=magia)
                {
                    //heroes[y].SpellCast();
                }
                bufor = a;
                a=b;
                b=bufor;
            }
            if(heroes[a].GetHP()<=0)
            {
                Console.WriteLine("{0} został pokonany!", heroes[a].Name);
                Console.WriteLine("{0} zostało {1} punktów życia", heroes[b].Name, heroes[b].GetHP());
            }
            else
            {
                Console.WriteLine("{0} został pokonany!", heroes[b].Name);
                Console.WriteLine("{0} zostało {1} punktów życia", heroes[a].Name, heroes[a].GetHP());
            }
                        
        }
    }



    class Program
    {
        static void display(List<Hero> heroes)
        {
            for(int i=0; i<heroes.Count; i++)
            {
                Console.WriteLine("[{0}] " + heroes[i].Name + " Str:{1} Dex:{2} Int:{3}", i+1, heroes[i].GetStrength(), heroes[i].GetDexterity(), heroes[i].GetIntelligence());
            }
        }
        static void Main(string[] args)
        {
            
            Hero hero1 = new Hero("Edward Białykij", "assassin");
            Hero hero2 = new Hero("Wiesław Wszywka", "warrior");
            Hero hero3 = new Hero("Maciej Sokołowski", "sorcerer");
            List<Hero> heroes = new List<Hero>();
            heroes.Add(hero1);
            heroes.Add(hero2);
            heroes.Add(hero3);



            String choice="0";
            while(true)
            {
                Console.WriteLine("Co chcesz zrobić? \r\n[1] chcę zobaczyć walkę 2 bohaterów na arenie\r\n[2] chcę wczytać bohatera\r\n[3] chcę utworzyć nowego bohatera \r\n[4] chcę wbić poziom na jednym z bohaterów\r\n[0] zakończ");
                choice = Console.ReadLine();
                switch(choice)
                {
                    case "1":
                        Console.Clear();
                        Console.WriteLine("Wybierz 2 bohaterów którzy staną do walki ");
                        display(heroes);
                        Console.WriteLine();
                        int x=int.Parse(Console.ReadLine());
                        int y=int.Parse(Console.ReadLine());
                        action.attack(heroes, x-1, y-1);
                        break;
                    case "2":
                        Console.Clear();
                        Console.WriteLine("Podaj nazwę bohatera, którego chcesz wczytać ");
                        string heroLoad = Console.ReadLine();
                        Hero hero4 = new Hero("", "");
                        if(hero4.load(heroLoad)==1)
                        {
                            break;
                        }
                        else
                        {
                            heroes.Add(hero4);
                        }
                        break;
                    case "3":
                        Console.WriteLine("Podaj nazwę nowego bohatera ");
                        string heroName = Console.ReadLine();
                        Console.WriteLine("Podaj klasę nowego bohatera (do wyboru warrior, assassin i sorcerer) ");
                        string heroClass = Console.ReadLine();
                        Hero heroNew = new Hero(heroName, heroClass);
                        heroes.Add(heroNew);
                        heroNew.SaveHero(heroes, heroes.Count-1);
                        Console.Clear();
                        break;
                    case "4":
                        Console.Clear();
                        break;
                }

                if(choice=="0")
                {
                    break;
                }
            }   

        }
    }
}
