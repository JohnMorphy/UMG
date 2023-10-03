using System;
using System.Collections.Generic;
using System.Threading;

namespace funkcje
{
    public class fight
    {
        
        public static int chance;
        public static void chanceInit(int i)
        {
            chance = i;
        }
        public static void WaterBend(List<Hero> heroes, int x, int y)
        {
            Console.Clear();
            Console.WriteLine("Otwierasz menażkę i zręcznym ruchem formujesz bicz wodny");
            Console.WriteLine();
            int force=heroes[x].GetIntelligence()+(3*heroes[x].GetDexterity())-heroes[y].GetDexterity();
            Attack(heroes, x, y, force);
        }
        public static void EarthBend(List<Hero> heroes, int x, int y)
        {
            Console.Clear();
            Console.WriteLine("Zasypujesz przeciwnika odłamkami skał");
            Console.WriteLine();
            int force=heroes[x].GetIntelligence()+(3*heroes[x].GetStrength())-heroes[y].GetStrength();
            Attack(heroes, x, y, force);
        }
        public static void FireBend(List<Hero> heroes, int x, int y)
        {
            Console.Clear();
            Console.WriteLine("Miotasz w przeciwnika kulą ognia");
            Console.WriteLine();
            int force=3*heroes[x].GetIntelligence();
            Attack(heroes, x, y, force);
        }
        public static void SpellCast(List<Hero> heroes, int x, int y)
        {
            Console.Clear();
            // int w=heroes[x].GetIntelligence();
            int[] czary = new int[10];
            int bufor=1;
            Console.WriteLine("Wybierz czar który chcesz rzucić");

            if(heroes[x].GetStrength()>5) {Console.WriteLine($"[{bufor}] krzyk bojowy, wszyscy walczący mają mniejszą szansę na unik");  czary[bufor-1]=0; bufor++;}
            if(heroes[x].GetIntelligence()>5 && heroes[x].GetDexterity()>5) {Console.WriteLine($"[{bufor}] spróbuj zranić przeciwnika biczem wodnym");  czary[bufor-1]=1; bufor++;}
            if(heroes[x].GetIntelligence()>5 && heroes[x].GetStrength()>5) {Console.WriteLine($"[{bufor}] miotaj w przeciwnika odłamkami skał");  czary[bufor-1]=2; bufor++;}
            if(heroes[x].GetIntelligence()>7) {Console.WriteLine($"[{bufor}] rzuć kulę ognia");  czary[bufor-1]=3; bufor++;}
            //if(heroes[x].GetDexterity()>7) {Console.WriteLine($"[{bufor}] wejdź do krainy cienia");  czary[bufor-1]=4; bufor++;} //TODO więcej czarów
            Console.WriteLine("[dowolny znak] zmieniam zdanie, nie chcę rzucać czaru");
            int choice=0;
            try
            {
                int.TryParse(Console.ReadLine(), out choice);
                Console.Clear();
                if(choice>0 && choice<bufor)
                {
                    switch(czary[choice-1])
                    {
                        case 0:
                            Console.WriteLine("AAAA!!!");
                            chance+=3;
                            Thread.Sleep(1000);
                            break;
                        case 1:
                            WaterBend(heroes, x, y);
                            break;
                        case 2:
                            EarthBend(heroes, x, y);
                            break;
                        case 3:
                            FireBend(heroes, x, y);
                            break;
                        case 4:
                            //Shadow realm(heroes, x, y);
                            break;
                        default:
                            heroes[x].Rest();
                            break;

                    }
                }
                else
                {
                    heroes[x].Rest();
                }
            }
            catch
            {
                heroes[x].Rest();
            }
        }
        public static void Attack(List<Hero> heroes, int x, int y, int force)
        {
            Random rng = new Random();
            int attack = 0;
            int fart = 0;
            int unik = rng.Next() % (chance);
            if(heroes[y].GetDexterity()==unik && heroes[y].GetDexterity()>7)
            {
                Console.WriteLine("{0} uniknął i dokonał kontry!", heroes[y].Name);
                fart = rng.Next() % (3);
                attack=2*heroes[y].GetDexterity()+fart;
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
                attack=force+fart;
                Console.WriteLine("{0} otrzymał {1} obrażeń!", heroes[y].Name, attack);
                heroes[y].HPloss(attack);
            }
            Thread.Sleep(1000);
            Console.Clear();
        }
    }
}