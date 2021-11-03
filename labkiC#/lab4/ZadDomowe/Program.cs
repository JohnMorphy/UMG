using System;

namespace ZadDomowe
{
    class Program
    {
        static void Main(string[] args)
        {
            // format danych wejściowych
            // 2021-12-01 12:00:00 1m 1mo -4h -10s 14y 5h -11s +10mo
            // lub
            // 2021.12.01 12:00:00 1m 1mo -4h -10s 14y 5h -11s +10mo
            
            
            if(args.Length<2)
            {
                return;
            }

            int value=0;
            string unit="";

            string day = args[0]+ '-' + args[1];
            string[] subs = day.Split('-', '.', ':');
            int[] subsDate = new int[6];

            for(int i=0; i<subs.Length; i++)
            {
                subsDate[i]=int.Parse(subs[i]);
            }

            DateTime date = new DateTime(subsDate[0], subsDate[1], subsDate[2], subsDate[3], subsDate[4], subsDate[5]);


            for(int i=2; i<args.Length; i++)
            {
                for(int j=0; j<args[i].Length; j++)
                {
                    if(Char.IsLetter((args[i])[j]))
                    {
                        string valueString = args[i].Substring(0, j);
                        value=int.Parse(valueString);
                        unit  = args[i].Substring(j, args[i].Length - j);
                        break;
                    }
                    
                }

                switch(unit)
                {
                    case "s":
                        date = date.AddSeconds(value);
                        break;
                        
                    case "m":
                        date = date.AddMinutes(value);
                        break;

                    case "h":
                        date = date.AddHours(value);
                        break;

                    case "d":
                        date = date.AddDays(value);
                        break;

                    case "mo":
                        date = date.AddMonths(value);
                        break;

                    case "y":
                        date = date.AddYears(value);
                        break;

                    default:
                        break;
                 }

                    
            }

            Console.WriteLine(date.ToString("yyyy-MM-dd HH:mm:ss"));
            
            //pierwszy sposób
            /* 
            string day = args[0]+ '-' + args[1];
            string[] subs = day.Split('-', ':');
            int[] subsDate = new int[6];

            for(int i=0; i<subs.Length; i++)
            {
                subsDate[i]=int.Parse(subs[i]);
            }

            DateTime date = new DateTime(subsDate[0], subsDate[1], subsDate[2], subsDate[3], subsDate[4], subsDate[5]);
            */


            //drugi sposób
            /*
            string day = args[0] + args[1];
            DateTime date = DateTime.ParseExact(day, "yyyy-MM-ddHH:mm:ss", System.Globalization.CultureInfo.InvariantCulture);
            */
            

            //trzeci sposób
            /*
            string day = args[0] + args[1];
            DateTime date;
            if(DateTime.TryParseExact(day.ToString(), "yyyy-MM-ddHH:mm:ss", System.Globalization.CultureInfo.InvariantCulture, System.Globalization.DateTimeStyles.None, out date))
            {
                Console.WriteLine(date);
            }
            */
        }
    }
}