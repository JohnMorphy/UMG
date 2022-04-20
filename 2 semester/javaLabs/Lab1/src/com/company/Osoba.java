package com.company;

import java.text.Collator;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Locale;


public class Osoba implements Comparable <Osoba>
{
    @Override
    public int compareTo(Osoba o) {
        Collator c = Collator.getInstance(new Locale("pl", "PL"));
        int compareAge = -1*c.compare(this.birthdate,o.birthdate);
        int compareName = c.compare(this.name, o.surename);
        if(compareAge==0) return compareName;
        return compareAge;
    }

    String surename="Kowalski";
    String name ="Jan";
    String birthdate ="2000-10-12";

    static LocalDate presentDate = LocalDate.now();
    static int birthYear = presentDate.getYear();
    static int birthMonth = presentDate.getMonthValue();
    public static ArrayList<Osoba> listaOsób = new ArrayList<Osoba>();
    @Override
    public String toString(){
        return surename + " " + name + " " + birthdate + " wiek " + String.format("%5.2f", wiek(birthdate));
    }

    double wiek(String dataur)
    {
        String[] data = dataur.split("-");
        LocalDate urodzenie = LocalDate.of(Integer.parseInt(data[0]),
            Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        Period per = Period.between(urodzenie, presentDate);
        return per.getYears()+per.getMonths()/12.0+per.getDays()/365.0;
    }

    public Osoba() { listaOsób.add(this); }

    public Osoba(String nazwisko, String name, String birthdate)
    {
        this.surename =nazwisko;
        this.name = name;
        this.birthdate = birthdate;
        //listaOsób.add(this);
    }


    public static void main (String[] args) {
        Osoba osoba = new Osoba();
    }
}
