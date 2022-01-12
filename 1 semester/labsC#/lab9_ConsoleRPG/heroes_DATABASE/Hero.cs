using System;
using System.Threading;
using System.Collections.Generic;
using System.Data.SQLite;


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
        private int Level;
        private int Experience;
        private int Stage;
        private int Adventure;
        public void UpLevel()   { this.Experience=this.Experience-10 * this.Level; this.Level +=1;}
        public void UpStrength() { this.Strength += 1; this.HP += 3; }
        public void UpDexterity() { this.Dexterity += 1; }
        public void UpIntelligence() { this.Intelligence += 1; }
        public void ExperienceGain(Hero hero, int exp) 
        {
            this.Experience+=exp;
            Console.WriteLine(Name + " +"+exp+"exp");
            hero.Save();
        }
        private void InitAdventurer(String name="")
        {
            Init(name);
            for(int i=0; i<11;i++)
            {
                Console.Clear();
                Console.WriteLine("Pozostało {0} punktów do rozdania\r\n" + this.Name + " HP:{1} Str:{2} Dex:{3} Int:{4}", 11-i, this.HP, this.Strength, this.Dexterity, this.Intelligence);
                Console.WriteLine("[1] strength\r\n[2] dexterity \r\n[3] intelligence\r\n [dowolny klawisz] losowo przydziel resztę punktów");
                String level=Console.ReadLine();
                switch(level)
                {
                    case "1":
                        UpStrength();
                        break;
                    case "2":
                        UpDexterity();
                        break;
                    case "3":
                        UpIntelligence();
                        break;
                    default:
                        for(;i<11;i++)
                        {
                            Random rng = new Random();
                            int nbr = rng.Next(0, 2);;
                            switch(nbr)
                            {
                                case 0:
                                    UpStrength();
                                    Console.WriteLine("Dodano siłę");
                                    break;
                                case 1:
                                    UpDexterity();
                                    Console.WriteLine("Dodano zręczność");
                                    break;
                                case 2:
                                    UpIntelligence();
                                    Console.WriteLine("Dodano inteligencję");
                                    break;
                            }
                        }
                        break;
                }
            }
            Console.Clear();
            Console.WriteLine("Statystyki stworzonego bohatera\r\n" + this.Name + " HP:{0} Str:{1} Dex:{2} Int:{3}", this.HP, this.Strength, this.Dexterity, this.Intelligence);
            Thread.Sleep(1500);
            Console.Clear();
        }
        private void Init(String name = "", string myclass="adventurer", int strength = 1, int dexterity = 1, int intelligence = 1,  int HP = 53, int level = 1, int experience = 0)
        {
            this.Name = name;
            this.Strength = strength;
            this.Dexterity = dexterity;
            this.Intelligence = intelligence;
            this.Class = myclass;
            this.HP = 50 + strength*3;
            this.Level=level;
            this.Experience=experience;
        }
        public string GetName() { return Name; }
        public int GetStrength() { return Strength; }
        public int GetDexterity() { return Dexterity; }
        public int GetIntelligence() { return Intelligence; }
        public string GetClass() { return Class; }
        public int GetHP() { return HP; }
        public int GetLevel() { return Level; }
        public int GetExperience() { return Experience; }
        public void Rest() 
        {
            int r=this.Strength/4+1;
            this.HP=this.HP + r;
            Console.WriteLine(this.Name + " odzyskał " + r + " punktów zdrowia");
        }
        public void HPloss(int attack)
        {
            this.HP=this.HP-attack;
        }
        public void HPreset()
        {
            this.HP=50+this.Strength*5;
        }
        public Hero(string name, string myclass)
        {
            switch(myclass)
            {
                case "1" or "warrior": Init(name, "warrior", 8, 5, 2); break;
                case "2" or "assassin": Init(name, "assassin", 3, 8, 4); break;
                case "3" or "sorcerer": Init(name, "sorcerer", 4, 3, 8); break;
                case "adventurer": Init(name, "adventurer"); break;
                default: InitAdventurer(name); break;

            }
        }
        public static void load(List<Hero> avatar, String name)
        {
            avatar.Clear();
            string cs = "Data Source=./"+ name +".db"; //connection string  (wskazuje sciezke do bazy danych)
            using var con = new SQLiteConnection(cs);
            con.Open();
            string client = "SELECT * FROM " + name;
            using var cmd = new SQLiteCommand(client, con);
            using SQLiteDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                Hero hero1 = new Hero(reader.GetString(0), reader.GetString(1));
                hero1.Init(reader.GetString(0), reader.GetString(1), reader.GetInt32(2), reader.GetInt32(3), reader.GetInt32(4), reader.GetInt32(5), reader.GetInt32(6), reader.GetInt32(7));
                avatar.Add(hero1);
            }
        }
        public static void StrengthGain(Hero hero)
        {
            switch(hero.GetStrength())
            {
                case <8:
                    Console.WriteLine("Ćwiczenia opłaciły się!\r\nStajesz się silniejszy");
                    break;
                case 8:
                    Console.WriteLine("Siłą własnych rąk potrafisz zginać żelazne sztaby!\r\nMógłbyś pracować w cyrku");
                    break;
                case 9:
                    Console.WriteLine("Jesteś tak silny, że potrafisz siłą jedynie swoich mięśni otworzyć 2 tonowe wrota areny!\r\nTo wygląda na niezłe wejście");
                    break;
                case 10:
                    Console.WriteLine("Jesteś wystarczająco silny by przenieść skałę herkulesa!\r\nJesteś gotowy by przedrzeć się do krainy Bogów!");
                    break;
                case 11:
                    Console.WriteLine("Jednym ciosem topora scinasz drzewo, a jednym ciosem pięści posyłasz przeciętnego śmiertelnika do kostnicy\r\nPrzeciętni ludzie widzą cię jako pół Boga i boją się na ciebie spojrzeć");
                    break;
                default:
                    Console.WriteLine("UNLIMITED POWER!");
                    break;
            }
            hero.UpStrength();
        }
        public static void DexterityGain(Hero hero)
        {
            switch(hero.GetDexterity())
            {
                case <8:
                    Console.WriteLine("Ćwiczenia opłaciły się!\r\nJesteś coraz bardziej zręczny");
                    break;
                case 8:
                    Console.WriteLine("Potrafisz wykonywać cios z kontry\r\nJesteś zręczny jak wyćwiczony assassin");
                    break;
                case 9:
                    Console.WriteLine("Potrafisz przejść po linie rozwieszonej między budynkami!\r\nTwój zmysł równowagi jest niesamowity");
                    break;
                case 10:
                    Console.WriteLine("Jesteś wystarczająco zręczny by niezauważenie przekraść się obok wiecznie czuwającego!\r\nJesteś gotowy by przekraść się do krainy Bogów!");
                    break;
                case 11:
                    Console.WriteLine("Potrafisz złapać strzałę w locie!\r\nJesteś nie mal nie do trafienia");
                    break;
                default:
                    Console.WriteLine("UNLIMITED POWER!");
                    break;
            }
            hero.UpDexterity();            
        }
        public static void IntelligenceGain(Hero hero)
        {
            switch(hero.GetIntelligence())
            {
                case <8:
                    Console.WriteLine("");
                    break;
                case 8:
                    Console.WriteLine("Potrafisz manipulować ogniem\r\nMógłbyś pracować w cyrku");
                    break;
                case 9:
                    Console.WriteLine("Twoja reputacja mędrca wyszła poza granice miasta\r\n");
                    break;
                case 10:
                    Console.WriteLine("Swoją siłą umysłu jesteś w stanie stworzyć portal do krainy Bogów\r\nJesteś gotowy wejść do krainy Bogów!");
                    break;
                case 11:
                    Console.WriteLine("Potrafisz nagiąć wolę większości istot\r\nPrzeciętni ludzie kłaniają się tobie na ulicach");
                    break;
                default:
                    Console.WriteLine("UNLIMITED POWER!");
                    break;
            }
            hero.UpIntelligence();    
        }
        public static void RandomLevel(Hero hero)
        {
            Random rng = new Random();
            int nbr = rng.Next(0, 2);;
            switch(nbr)
            {
                case 0:
                    hero.UpStrength();
                    Console.WriteLine("Dodano siłę");
                    break;
                case 1:
                    hero.UpDexterity();
                    Console.WriteLine("Dodano zręczność");
                    break;
                case 2:
                    hero.UpIntelligence();
                    Console.WriteLine("Dodano inteligencję");
                    break;

            }
        }
        public static void LevelUp(List<Hero> heroes, int index)
        {
            Console.Clear();
            //heroes[index].GetExperience()>=heroes[index].GetLevel()*10)
            Console.WriteLine("W czym chcesz rozwinąć swojego bohatera?");
            Console.WriteLine("\r\n[1] chcę rozwinąc jego siłę\r\n[2] chcę wyćwiczyć jego zręczność \r\n[3] chcę rozwijać jego wiedzę i mądrość\r\n[dowolny klawisz] losowo");
            String choice = Console.ReadLine();
            switch(choice)
            {
                case "1":
                    Console.Clear();
                    StrengthGain(heroes[index]);
                    break;
                case "2":
                    Console.Clear();
                    DexterityGain(heroes[index]);
                    break;
                case "3":
                    Console.Clear();
                    IntelligenceGain(heroes[index]);
                    break;    
                default:
                    Console.Clear();
                    RandomLevel(heroes[index]);
                    break;
            }
            heroes[index].Save();
        }
        public void Save()
        {
            try
            {
                string cs = "Data Source=./heroes.db";
                using var con = new SQLiteConnection(cs);
                con.Open();
                using var cmd = new SQLiteCommand(con);
                cmd.CommandText = $"UPDATE Heroes SET Strength={Strength}, Dexterity={Dexterity}, Intelligence={Intelligence}, Level={Level}, Experience={Experience} WHERE Name=\"{Name}\"";
                cmd.Prepare();
                cmd.ExecuteNonQuery();
            }
            catch(Exception x)
            {
                Console.WriteLine(x);
                Console.WriteLine("Nie udało się zapisać bohatera!");
            }
        }
        public static void SaveHero(List<Hero> heroes, int index)
        {
            try
            {
                string cs = "Data Source=./heroes.db"; //connection string  (wskazuje sciezke do bazy danych)
                using var con = new SQLiteConnection(cs);
                con.Open();
                using var cmd = new SQLiteCommand(con);
                cmd.CommandText = "INSERT INTO Heroes ('Name', 'Class', 'Strength', 'Dexterity', 'Intelligence', 'HP', 'Level', 'Experience') VALUES (@Name, @Class, @Strength, @Dexterity, @Intelligence, @HP, @Level, @Experience)";
                cmd.Parameters.AddWithValue("@Name", heroes[index].GetName());
                cmd.Parameters.AddWithValue("@Class", heroes[index].GetClass());
                cmd.Parameters.AddWithValue("@Strength", heroes[index].GetStrength());
                cmd.Parameters.AddWithValue("@Dexterity", heroes[index].GetDexterity());
                cmd.Parameters.AddWithValue("@Intelligence", heroes[index].GetIntelligence());
                cmd.Parameters.AddWithValue("@HP", heroes[index].GetHP());
                cmd.Parameters.AddWithValue("@Level", heroes[index].GetLevel());
                cmd.Parameters.AddWithValue("@Experience", heroes[index].GetExperience());
                cmd.Prepare();
                cmd.ExecuteNonQuery();
                //cmd.CommandText = "INSERT INTO Heroes VALUES("  + heroes[index].GetName() +","+ heroes[index].GetClass() +","+ heroes[index].GetStrength() + "," + heroes[index].GetDexterity() +","+ heroes[index].GetIntelligence() +","+ heroes[index].GetHP() +","+ heroes[index].GetLevel() +","+ heroes[index].GetExperience() + ")";
            }
            catch(Exception x)
            {
                Console.WriteLine(x);
                Console.WriteLine("Nie udało się zapisać bohatera!");
            }
        }
        public static void DeleteHero(List<Hero> heroes, int index)
        {
            try
            {
                string cs = "Data Source=./heroes.db"; //connection string  (wskazuje sciezke do bazy danych)
                using var con = new SQLiteConnection(cs);
                con.Open();
                using var cmd = new SQLiteCommand(con);
                cmd.CommandText = "DELETE FROM Heroes WHERE Name=@Name";
                cmd.Parameters.AddWithValue("@Name", heroes[index].GetName());
                cmd.Prepare();
                cmd.ExecuteNonQuery();
            }
            catch(Exception x)
            {
                Console.WriteLine(x);
                Console.WriteLine("Nie udało się usunąć bohatera!");
            }
            Console.WriteLine("Pomyślnie usunięto bohatera");
            Thread.Sleep(500);
        }
    }
}