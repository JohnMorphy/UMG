using System;
using System.IO;
using System.Collections.Generic;
using System.Threading;


namespace funkcje
{
    class Program
    {
        public static void display(List<Hero> heroes, int n=-1)
        {
            for(int i=0; i<heroes.Count; i++)
            {
                if(i == n)
                Console.WriteLine($"[{i+1}] ten bohater jest już zajęty przez gracza pierwszego");
                else
                Console.WriteLine("[{0}] " + heroes[i].Name + " Str:{1} Dex:{2} Int:{3}", i+1, heroes[i].GetStrength(), heroes[i].GetDexterity(), heroes[i].GetIntelligence());
            }
        }
        static int levelupDisplay(List<Hero> heroes)
        {
            int x=1;
            int[] List = new int[100];
            for(int i=0; i<heroes.Count; i++)
            {
                if(heroes[i].GetExperience()>=heroes[i].GetLevel()*10)
                {
                    if(x==1)
                    {
                        Console.WriteLine("Wybierz bohatera, którego chcesz rozwinąć");
                    }
                    Console.WriteLine("[{0}] " + heroes[i].Name + " Str:{1} Dex:{2} Int:{3} Level:{4} Experience:{5}", x, heroes[i].GetStrength(), heroes[i].GetDexterity(), heroes[i].GetIntelligence(), heroes[i].GetLevel(), heroes[i].GetExperience());
                    x++;
                    List[i]=x;
                }
            }
            if(x==1)
            {
                Console.Clear();
                Console.WriteLine("Żaden bohater nie jest gotowy by rozwinąć umiejętności");
                Thread.Sleep(2000);
                return 0;
            }
            Console.WriteLine("[dowolny klawisz] zmieniłem zdanie");
            int choice;
            bool success=int.TryParse(Console.ReadLine(), out choice);
            if(success == true && choice<=x && choice>=0)
            {
                Hero.LevelUp(heroes, List[choice]);
                return 0;
            }
            else
            {
                Console.Clear();
                Console.WriteLine("Nikt nie rozwinął umiejętności");
                Thread.Sleep(2000);
                return 0;                
            }
        }

        static void Main(string[] args)
        {
            List<Hero> heroes = new List<Hero>();
            //List<Hero> mobs = new List<Hero>();

            // Hero hero1 = new Hero("Edward Białykij", "assassin");
            // heroes.Add(hero1);

            Hero.load(heroes, "heroes");
            //Hero.load(mobs, "mobs");

            String choice="0";
            while(true)
            {
                Console.Clear();
                Console.WriteLine("Co chcesz zrobić? \r\n[1] walka 2 bohaterów na arenie - multiplayer\n[2] chcę utworzyć nowego bohatera \r\n[3] chcę wbić poziom na jednym z bohaterów\r\n[4] chcę wyruszyć na przygodę [nie skończone]\r\n[5] chcę usunąć bohatera\r\n[0] zakończ");
                choice = Console.ReadLine();
                switch(choice)
                {
                    case "1":
                        int x, y;
                        Console.Clear();
                        if(heroes.Count<2)
                        {
                            Console.WriteLine("Jest za mało bohaterów");
                            Thread.Sleep(1000);
                            break;
                        }

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
                        levelupDisplay(heroes);
                        Console.Clear();
                        break;
                    case "4":
                        //adventure.adventureMenu(heroes);
                        /*
                        nie dokończone, plan działania:
                        - rozpoczynanie nowej przygody
                        - wczytywanie starej przygody z bazy danych korzystając zapisanego Stage i Adventure
                        - bazowe pomysły na wędrówkę - 4 strony świat, wejście do krainy bogów
                        */
                        break;
                    case "5":
                        int z;
                        Console.Clear();
                        Console.Clear();
                        Console.WriteLine("Wybierz bohatera którego chcesz usunąć");
                        display(heroes);
                        Console.WriteLine("[dowolny klawisz] zmieniam zdanie, nie chcę usuwać bohatera");
                        Console.WriteLine();
                        bool success2 = int.TryParse(Console.ReadLine(), out z);
                        if(success2 == true && z<=heroes.Count)
                        {
                            Hero.DeleteHero(heroes, z-1);
                            Hero.load(heroes, "heroes");
                            break;
                        }
                        else
                        {
                            Console.WriteLine("Nie usunięto bohatera");
                        }
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
