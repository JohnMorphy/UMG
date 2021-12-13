using System;
using System.Threading;
using System.IO;
using System.Collections.Generic;

namespace funkcje
{
    public class menu
    {
        static void display(List<Hero> heroes, int n=-1)
        {
            for(int i=0; i<heroes.Count; i++)
            {
                if(i == n)
                Console.WriteLine($"[{i+1}] ten bohater jest już zajęty przez gracza pierwszego");
                else
                Console.WriteLine("[{0}] " + heroes[i].Name + " Str:{1} Dex:{2} Int:{3}", i+1, heroes[i].GetStrength(), heroes[i].GetDexterity(), heroes[i].GetIntelligence());
            }
        }
        public static void Startmenu()
        {
            List<Hero> heroes = new List<Hero>();

            // Hero hero1 = new Hero("Edward Białykij", "assassin");
            // heroes.Add(hero1);

            Hero.load(heroes, "heroes");

            String choice="0";
            while(true)
            {
                Console.WriteLine("Co chcesz zrobić? \r\n[1] walka 2 bohaterów na arenie - multiplayer\r\n[2] chcę utworzyć nowego bohatera \r\n[3] chcę wbić poziom na jednym z bohaterów\r\n[4] chcę wyruszyć na przygodę\r\n[0] zakończ");
                choice = Console.ReadLine();
                switch(choice)
                {
                    case "1":
                        int x, y;
                        Console.Clear();
                        while(true)
                        {
                            Console.WriteLine("Gracz 1 - wybierz swojego bohatera ");
                            display(heroes);
                            Console.WriteLine();
                            bool success = int.TryParse(Console.ReadLine(), out x);
                            if(success == true && x<=heroes.Count && x>=0)
                                break;
                            else
                                Console.WriteLine("Podano nieprawidłowe dane, wprowadź je ponownie");

                        }
                        while(true)
                        {
                            Console.Clear();
                            Console.WriteLine("Gracz 2 - wybierz swojego bohatera ");
                            display(heroes, x-1);
                            Console.WriteLine();
                            bool success = int.TryParse(Console.ReadLine(), out y);
                            if(success == true && y<=heroes.Count && y>=0 && y!=x)
                                break;
                            else
                            {
                                Console.WriteLine("Podano nieprawidłowe dane, wprowadź je ponownie");
                                Thread.Sleep(1000);
                            }
                        }
                        arena.arenaFight(heroes, x-1, y-1);
                        break;
                    case "2":
                        Console.Clear();
                        Console.WriteLine("Podaj nazwę nowego bohatera ");
                        string heroName = Console.ReadLine();
                        Console.WriteLine("Wybierz klasę:\r\n[1] warrior - ukończyłeś szkołę rycerską i jesteś wyszkolony w drodze miecza. Twoje atuty to siła i duże zdrowie\r\n[2] assassin - jesteś zręcznym kombinatorem, od dziecka uczyłeś się w szkole zabójców. Twoim atutem jest zręczność, przez co od początku potrafisz wyprowadzać cios z kontry");
                        Console.WriteLine("[3] sorcerer - od dzieciństwa zauważono u ciebie nie przeciętny intelekt i posłano cię do szkoły magów. Od początku potrafisz rzucać wiele czarów ");
                        Console.WriteLine("[dowolny przycisk] adventurer - nie zauważono u ciebie specjalnych talentów i od dzieciństwa pracowałeś na polu. Sam uczyłeś się z zapałem i zawsze marzyłeś o tym by wyruszać na przygody. Gdy wybierzesz ten start będziesz miał mniejsze statystyki, ale sam będziesz mógł decydować o swoich silnych i słabych stronach");
                        string heroClass = Console.ReadLine();
                        Hero heroNew = new Hero(heroName, heroClass);
                        heroes.Add(heroNew);
                        Hero.SaveHero(heroes, heroes.Count-1);
                        break;
                    case "3":
                        Console.Clear();
                        Console.WriteLine("Podaj nazwę nowego bohatera ");
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