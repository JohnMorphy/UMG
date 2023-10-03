package com.company;

import java.text.Collator;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Locale;


public class Person implements Comparable <Person>
{
    @Override
    public int compareTo(Person o) {
        Collator c = Collator.getInstance(new Locale("pl", "PL"));
        int compareAge = -1*c.compare(this.birthdate,o.birthdate);
        int compareName = c.compare(this.name, o.surname);
        if(compareAge==0) return compareName;
        return compareAge;
    }

    String surname = "Kowalski";
    String name = "Jan";
    String birthdate = "2000-10-12";

    static LocalDate presentDate = LocalDate.now();
    static int birthYear = presentDate.getYear();
    static int birthMonth = presentDate.getMonthValue();
    public static ArrayList<Person> personList = new ArrayList<Person>();
    @Override
    public String toString(){
        return surname + " " + name + " " + birthdate + " age " + String.format("%5.2f", age(birthdate));
    }

    double age(String birthDate)
    {
        String[] data = birthDate.split("-");
        LocalDate birth = LocalDate.of(Integer.parseInt(data[0]),
                Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        Period per = Period.between(birth, presentDate);
        return per.getYears()+per.getMonths()/12.0+per.getDays()/365.0;
    }

    public Person() { personList.add(this); }

    public Person(String surname, String name, String birthdate)
    {
        this.surname =surname;
        this.name = name;
        this.birthdate = birthdate;
        // personList.add(this);
    }


    public static void main (String[] args) {
        Person person = new Person();
    }
}
