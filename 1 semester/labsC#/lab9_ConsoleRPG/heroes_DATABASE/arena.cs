using System;
using System.Collections.Generic;
using System.Threading;

namespace funkcje
{
    public class arena
    {
        public static void SpellCast(List<Hero> heroes, int x, int y)
        {
            Console.Clear();
            int w=heroes[x].GetIntelligence();
            string[] czary = new string[10];
            int bufor=1;
            Console.WriteLine("Wybierz czar który chcesz rzucić");
            if(heroes[x].GetIntelligence()>5 && heroes[x].GetDexterity()>5) {Console.WriteLine($"[{bufor}] spróbuj zranić przeciwnika biczem wodnym");  czary[bufor-1]="Waterbend"; bufor++;}
            if(heroes[x].GetIntelligence()>5 && heroes[x].GetStrength()>5) {Console.WriteLine($"[{bufor}] miotaj w przeciwnika odłamkami skał");  czary[bufor-1]="Earthbend"; bufor++;}
            if(heroes[x].GetIntelligence()>7) {Console.WriteLine($"[{bufor}] rzuć kulę ognia");  czary[bufor-1]="Firebend"; bufor++;}

            Console.WriteLine("[dowolny znak] zmieniam zdanie, nie chcę rzucać czaru");

        }
        public static void Attack(List<Hero> heroes, int x, int y)
        {
            Console.Clear();
            Random rng = new Random();
            int attack = 0;
            int fart = 0;
            int unik = rng.Next() % (15);
            if(heroes[y].GetDexterity()==unik && heroes[y].GetDexterity()>7)
            {
                Console.WriteLine("{0} sparował cios i dokonał kontry!", heroes[y].Name);
                fart = rng.Next() % (3);
                attack=heroes[y].GetStrength()+fart;
                Console.WriteLine("{0} otrzymał {1} obrażeń!", heroes[x].Name, attack);
                heroes[x].HPloss(attack);
            }
            else if(heroes[y].GetDexterity()>=unik)
            {
                Console.WriteLine("{0} wykonał unik!", heroes[y].Name);
            }
            else
            {
                fart = rng.Next() % (3);
                attack=heroes[x].GetStrength()+fart;
                Console.WriteLine("{0} otrzymał {1} obrażeń!", heroes[y].Name, attack);
                heroes[y].HPloss(attack);
            }
            Thread.Sleep(1000);
            Console.Clear();
        }
        public static void arenaFight(List<Hero> heroes, int x, int y)
        {
            heroes[x].HPreset();
            heroes[y].HPreset();
            int bufor=0;            
            while(heroes[x].GetHP()>=0 && heroes[y].GetHP()>=0)
            {   
                Console.Clear();
                Console.WriteLine(heroes[x].Name + " HP:{0} Str:{1} Dex:{2} Int:{3}", heroes[x].GetHP(), heroes[x].GetStrength(), heroes[x].GetDexterity(), heroes[x].GetIntelligence());
                Console.WriteLine("Co chcesz zrobić? \r\n[1] uderz z całą siłą\r\n[2] próbuj rzucić czar\r\n[dowolny klawisz] czekaj");
                String choice = Console.ReadLine();
                Console.Clear();
                switch(choice)
                {
                    case "1":
                        Attack(heroes, x, y);
                        break;
                    case "2":
                        SpellCast(heroes, x, y);
                        break;
                    default:
                        Console.WriteLine("Odetchnąłeś chwilę");
                        heroes[x].Rest();
                        break;
                }
                bufor = x;
                x=y;
                y=bufor;
            }
            if(heroes[x].GetHP()<=0)
            {
                Console.WriteLine("{0} został pokonany!", heroes[x].Name);
                Console.WriteLine("{0} zostało {1} punktów życia", heroes[y].Name, heroes[y].GetHP());
            }
            else
            {
                Console.WriteLine("{0} został pokonany!", heroes[y].Name);
                Console.WriteLine("{0} zostało {1} punktów życia", heroes[x].Name, heroes[x].GetHP());
            }
        }
    }
}