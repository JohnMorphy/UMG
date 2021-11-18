using System;

namespace funkcje
{
    public class Hero
  {
    public string Name;
    static int Strength;
    static int Dexterity;
    static int Intelligence;

    static void Init(int strength = 5, int dexterity = 5, int intelligence = 5)
    {
      Strength = strength;
      Dexterity = dexterity;
      Intelligence = intelligence;
    }

    public int GetStrength() { return Strength; }
    public int GetDexterity() { return Dexterity; }
    public int GetIntelligence() { return Intelligence; }

    public Hero(string name, string myclass)
    {
      Name = name;
      switch(myclass)
      {
        case "warior": Init(8, 5, 2); break;
        case "assassin": Init(3, 8, 4); break;
        case "sorcerer": Init(4, 2, 9); break;
        default: Init(); break;
      }
    }
    
    }

    public class action
    {
        public static void attack(Hero hero, Hero hero1)
        {
            int herohp=100;
            int hero1hp=100;
            int min = 0;
            int atak = 0;
            Random rng = new Random();
            
            while(herohp>0 && hero1hp>0)
            {
                rng = new Random();
                min = rng.Next() % (15);
                if(hero1.GetDexterity()>=min)
                {
                    Console.WriteLine("Bohater: {0} wykonał unik!", hero1.Name);
                }
                else
                {
                    min = rng.Next() % (3);
                    atak=hero.GetStrength()+min;
                    Console.WriteLine("Bohater {0} otrzymał {1} obrażeń!", hero1.Name, atak);
                    hero1hp-=atak;
                }
                rng = new Random();
                min = rng.Next() % (15);
                if(hero.GetDexterity()>=min)
                {
                    Console.WriteLine("Bohater: {0} wykonał unik!", hero.Name);
                }
                else
                {
                    min = rng.Next() % (3);
                    atak=hero1.GetStrength()+min;
                    Console.WriteLine("Bohater {0} otrzymał {1} obrażeń!", hero.Name, atak);
                    herohp-=atak;
                }
            }
            if(herohp<=0)
            {
                Console.WriteLine("{0} poległ!", hero.Name);
            }
            else if(hero1hp<=0)
            {
                Console.WriteLine("{0} poległ!", hero1.Name);
            }
            else if(herohp<=0 && hero1hp<=0)
            {
                Console.WriteLine("Obaj bohaterowie zadali sobie śmiertelne ciosy!");
            }
        }
    }



    class Program
    {
        static void Main(string[] args)
        {

            Hero hero = new Hero("Edward Białykij", "warior");
            Console.WriteLine(hero.Name + " Str:{0} Dex:{1} Int:{2}", hero.GetStrength(), hero.GetDexterity(), hero.GetIntelligence());
            Hero hero1 = new Hero("Wiesław Wszywka", "assassin");
            Console.WriteLine(hero1.Name + " Str:{0} Dex:{1} Int:{2}", hero1.GetStrength(), hero1.GetDexterity(), hero1.GetIntelligence());

            action.attack(hero, hero1);
        }
     }
}
