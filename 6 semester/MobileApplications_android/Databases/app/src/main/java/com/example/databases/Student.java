package com.example.databases;

import java.text.Collator;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

//@RequiresApi(api = Build.VERSION_CODES.O)
public class Student implements Comparable<Student>{
    int image;
    int id;
    String surname;
    String name;
    String department;
    String birthDate ="1999-09-14";
    double average;
    public Student( int id, String name,
                   String surname,
                   String department,
                   String Ur,
                   double average,
                   int image
    )
    {
        this.id = id;
        this.image = image;
        this.surname = surname;
        this.name = name;
        this.department = department;
        this.birthDate = Ur;
        this.average = average;
        students.add(this);
    }

    public Student(){}

    public static ArrayList<Student> students =new ArrayList<Student>();

    @Override
    public String toString() {
        return this.surname + " "+this.name + "\nWydział: "+this.department;
    }

    static LocalDate today=LocalDate.now();
    public double getAge(){
        LocalDate birthday = LocalDate.parse(birthDate);
        Period per=Period.between(birthday,today);
        return Math.round((per.getYears()+per.getMonths()/12.0+per.getDays()/365.0)*100.0)/100.0;
    }
    public boolean equals(Student inny) {
        return this.surname.equals(inny.surname)
                && this.name.equals(inny.name)
                && this.birthDate.equals(inny.birthDate);
    }
    @Override
    public int compareTo( Student student) {
        Collator c = Collator.getInstance(new Locale("pl", "PL"));
        int compareSurname=c.compare(this.surname,student.surname);
        int compareName=c.compare(this.name,student.name);
        if(compareSurname==0) return compareName;
        return compareSurname;
    }


    public static Comparator<Student> compareByAverage = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return Double.compare(o2.average, o1.average);

        }
    };

    public static Comparator<Student> compareByName = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            Collator c = Collator.getInstance(new Locale("pl", "PL"));
            int compareSurnames =c.compare(o1.surname, o2.surname);
            int compareNames =c.compare(o1.name, o2.name);
            if(compareSurnames==0) return compareNames;
            return compareSurnames;
        }
    };

}

