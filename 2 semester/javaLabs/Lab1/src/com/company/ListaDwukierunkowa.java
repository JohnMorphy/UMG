package com.company;

//import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ListaDwukierunkowa {

    public static int rozmiar = 0;
    public static ObiektListy ostatni;
    public static ObiektListy pierwszy;

    public static class ObiektListy {
        Osoba element;
        ObiektListy nastepny = null;
        ObiektListy poprzedni = null;

        public void dodajDoListy(Osoba nowa) {
            ObiektListy staryOstatni = ostatni;
            ostatni = new ObiektListy();
            ostatni.element = nowa;
            ostatni.nastepny = null;
            if (jestPusta()) pierwszy = ostatni;
            else {
                staryOstatni.nastepny = ostatni;
                ostatni.poprzedni = staryOstatni;
            }
            rozmiar++;
        }

        public void drukuj() {
            ObiektListy kolejny = pierwszy;
            while (true) {
                System.out.println(kolejny.element);
                if (kolejny.nastepny != null) {
                    kolejny = kolejny.nastepny;
                } else
                    break;
            }
        }

        public void drukujInaczej() {
            ObiektListy kolejny = ostatni;
            while (true) {
                System.out.println(kolejny.element);
                if (kolejny.poprzedni != null) {
                    kolejny = kolejny.poprzedni;
                } else
                    break;
            }
        }

        public Osoba pobierzZItego(int i) {
            int j = 1;
            ObiektListy kolejny = pierwszy;
            if (i < 1) return null;
            while (true) {
                if (j == i)
                    return kolejny.element;
                j++;
                if (kolejny.nastepny != null) {
                    kolejny = kolejny.nastepny;
                } else
                    return null;
            }
        }

        public boolean zamienElementIzK(int i, int k) {
            ObiektListy kolejny = pierwszy;
            if (jestPusta() || i > rozmiar || k > rozmiar)
                return false;
            Osoba elementi = pobierzZItego(i);
            Osoba elementk = pobierzZItego(k);
            for (int j = 1; j <= rozmiar; j++) {
                if (j == i) {
                    kolejny.element = elementk;

                }
                if (j == k) {
                    kolejny.element = elementi;
                }
                kolejny = kolejny.nastepny;
            }
            return true;
        }

        public ObiektListy ustawNaIty(int i) {
            ObiektListy kolejny = pierwszy;
            if (i > rozmiar || i < 1) return null;
            for (int j = 1; j <= rozmiar; j++) {
                if (j == i)
                    return kolejny;
                kolejny = kolejny.nastepny;
            }
            return null;
        }

        public boolean wstawIty(Osoba x, int i) {
            if (i > rozmiar + 1 || i < 1) return false;
            if (i == rozmiar + 1) {
                dodajDoListy(x);
                return true;
            }
            ObiektListy staryI = ustawNaIty(i);
            ObiektListy nowyI = new ObiektListy();
            nowyI.element = x;
            if (staryI == pierwszy) {
                pierwszy = nowyI;
                nowyI.nastepny = staryI;
                staryI.poprzedni = nowyI;
                rozmiar++;
                return true;
            }
            ObiektListy przedI = ustawNaIty(i - 1);
            nowyI.nastepny = staryI;
            nowyI.poprzedni = przedI;
            przedI.nastepny = nowyI;
            staryI.poprzedni = nowyI;
            rozmiar++;

            return true;
        }

        public boolean usunZItego(int i){
            if(i<1 || i>rozmiar || jestPusta()) return false;
            if(rozmiar == 1)
            {
                this.element=null;
                pierwszy=null;
                ostatni=null;
                rozmiar--;
                return true;
            }
            if(i==1)
            {
                pierwszy=pierwszy.nastepny;
                pierwszy.poprzedni=null;
                rozmiar--;
                return true;
            }
            if(i==rozmiar)
            {
                ostatni=ostatni.poprzedni;
                ostatni.nastepny=null;
                rozmiar--;
                return true;
            }
            ustawNaIty(i+1).poprzedni=ustawNaIty(i-1);
            ustawNaIty(i-1).nastepny=ustawNaIty(i+1);
            rozmiar--;
            return true;
        }

        public boolean jestPusta() {
            if (rozmiar == 0) return true;
            return false;
        }

        public boolean czyJestKopcem() {
            boolean jestKopcem = true;
            for (int k = 1; k <= rozmiar; k++) {
                if (2 * k > rozmiar) return true;
                jestKopcem = pobierzZItego(k).compareTo(pobierzZItego(k * 2)) >= 0;
                if (2 * k + 1 > rozmiar) return jestKopcem;
                jestKopcem = jestKopcem && pobierzZItego(k).compareTo(pobierzZItego(2 * k + 1)) >= 0;
                if (!jestKopcem) return false;
            }
            return true;
        }

        public void wynurzanie() {
            int k = rozmiar;
            while (k > 1 && pobierzZItego(k / 2).compareTo(pobierzZItego(k)) < 0) {
                zamienElementIzK(k / 2, k);
                k = k / 2;
            }
        }

        /*
        public Osoba pobierzPierwszego(){
            if(pierwszy.jestPusta()) return null;
            Osoba el=pierwszy.element;
            pierwszy=pierwszy.nastepny;
            rozmiar--;
            if(pierwszy.jestPusta()) ostatni=null;
            return el;
        }
         */
    }

    public static void main(String[] args) {
        String[][] dane = {{"Nowak", "Jan", "1990-03-07"},
                {"Żabiński", "Zbigniew","1987-04-09"},{"Wichary", "Kamil", "1990-03-07"},
                {"Wiśniewski", "Kazimierz", "1982-12-03"}, {"Grabiński", "Ludwik", "1940-04-11"},
                {"Wroński", "Jakub", "1999-01-01"}};
        ObiektListy pierwszy = new ObiektListy();
        pierwszy.dodajDoListy(new Osoba(dane[0][0], dane[0][1], dane[0][2]));
        for(int i=1; i<6; i++) {
            ObiektListy kolejny = new ObiektListy();
            kolejny.dodajDoListy(new Osoba(dane[i][0], dane[i][1], dane[i][2]));
            kolejny.wynurzanie();
        }

        pierwszy.drukuj();
        System.out.println(pierwszy.czyJestKopcem());
        System.out.println();
        pierwszy.wstawIty(new Osoba("Gołota", "Andrzej", "1947-02-11"), 6);
        pierwszy.drukuj();
        pierwszy.usunZItego(6);
        pierwszy.usunZItego(6);
        System.out.println();
        pierwszy.drukuj();
        System.out.println();
        pierwszy.dodajDoListy(new Osoba("Głomacz", "Witold", "2000-01-11"));
        System.out.println();
        pierwszy.drukuj();
    }
}
