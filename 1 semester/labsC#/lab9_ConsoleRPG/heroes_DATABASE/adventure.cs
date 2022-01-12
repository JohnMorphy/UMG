using System;
using System.Threading;
using System.Collections.Generic;
using System.Data.SQLite;


namespace funkcje
{
    public class adventure
    {
        public static void chooseAdventure(List<Hero> heroes, int x)
        {
            //TODO
            //wybór przygody
            //dodaje bohatera do listy adventure, dodając do niego Stage 0 i wybraną przygodę. Dodaje go do bazy danych
            //usuwam bohatera z bazy danych i z listy heroes
            //wczytuję przygodę (stage zerowy - rozpoczęcie wędrówki) - loadAdventure(adventurer)
        }
        public static void loadAdventure(Hero adventure)
        {
            //TODO
            //korzystając z bazy wczytuje Stage i rodzaj przygody
            //otwieram odpowiednią przygodę
        }
        public static void adventureMenu(List<Hero> heroes)
        {
            List<Hero> adventure = new List<Hero>();
            Hero.load(adventure, "adventureSave");
            Console.Clear();
            Console.WriteLine("Co chcesz zrobić? \r\n[1] wyrusz na nową przygodę\n[2] wczytaj przygodę \r\n[dowolny klawisz] rezygnuje z przygody");
            string choice = Console.ReadLine();
            int x;
            switch(choice)
            {
                case "1":
                    Console.Clear();
                    if(heroes.Count<1)
                        {
                            Console.WriteLine("Nie ma bohatera, które może wyruszyć na przygodę");
                            Thread.Sleep(1000);
                            break;
                        }
                    Console.WriteLine("Wybierz bohatera, który ma wyruszyć na przygodę");
                    Program.display(heroes);
                    Console.WriteLine("[dowolny klawisz] rezygnuję z przygody");
                    bool success = int.TryParse(Console.ReadLine(), out x);
                    if(success == true && x<=heroes.Count && x>=0)
                        chooseAdventure(heroes, x);                
                    break;
                case "2":
                    Console.Clear();
                    if(adventure.Count<1)
                    {
                        Console.WriteLine("Nie ma bohatera, który jest w trakcie przygody");
                        Thread.Sleep(1000);
                        break;
                    }
                    Console.WriteLine("Wczytaj przygodę");
                    Program.display(adventure);
                    Console.WriteLine();
                    bool success1 = int.TryParse(Console.ReadLine(), out x);
                    if(success1 == true && x<=adventure.Count && x>=0)
                        loadAdventure(adventure[x]);
                    break;
                default:
                    break;
            }
        }
    }
}