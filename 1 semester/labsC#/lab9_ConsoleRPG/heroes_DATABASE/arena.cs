using System;
using System.Collections.Generic;
using System.Threading;

namespace funkcje
{
    public class arena
    {
        public static void reset(List<Hero> heroes, int x, int y, int exp=5)
        {
            heroes[x].HPreset();
            heroes[y].HPreset();
            heroes[x].ExperienceGain(heroes[x], exp); //dla testowania levelowania
        }
        
        public static void arenaFight(List<Hero> heroes, int x, int y)
        {
            int bufor=0;
            fight.chanceInit(heroes[x].GetDexterity()+heroes[y].GetDexterity()+3);            
            while(heroes[x].GetHP()>=0 && heroes[y].GetHP()>=0)
            {   
                Console.Clear();
                Console.WriteLine(heroes[x].Name + " HP:{0} Str:{1} Dex:{2} Int:{3}", heroes[x].GetHP(), heroes[x].GetStrength(), heroes[x].GetDexterity(), heroes[x].GetIntelligence());
                Console.WriteLine("Co chcesz zrobić? \r\n[1] atakuj brutalnie z całą siłą\r\n[2] próbuj rzucić czar lub użyj specjalnej techniki\r\n[dowolny klawisz] czekaj");
                String choice = Console.ReadLine();
                Console.Clear();
                switch(choice)
                {
                    case "1":
                        fight.Attack(heroes, x, y, 2*heroes[x].GetStrength());
                        break;
                    case "2":
                        fight.SpellCast(heroes, x, y);
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
            if(heroes[x].GetHP()<1)
            {
                Console.WriteLine("{0} został pokonany!", heroes[x].Name);
                Console.WriteLine("{0} zostało {1} punktów życia", heroes[y].Name, heroes[y].GetHP());
                reset(heroes, y, x);
                
            }
            else
            {
                Console.WriteLine("{0} został pokonany!", heroes[y].Name);
                Console.WriteLine("{0} zostało {1} punktów życia", heroes[x].Name, heroes[x].GetHP());
                reset(heroes, x, y);
            }
        }
    }
}