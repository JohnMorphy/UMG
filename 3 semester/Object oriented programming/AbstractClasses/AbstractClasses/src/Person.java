import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String surname = "Kowalski";
    private String name = "Jan";
    private String birthDate = "1999-01-01";

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    static LocalDate today = LocalDate.now();
    static int currentYear = today.getYear();
    static int currentMonth = today.getMonthValue();
    static int currentDay = today.getDayOfMonth();

    static ArrayList<Person> peopleList = new ArrayList<>();

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Person(String surname, String name, String birthDate) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        peopleList.add(this);
    }

    public Person() {
        peopleList.add(this);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nSurnanme: " + " " + this.surname + "\nBirth Date: " + this.birthDate
                + String.format("\nAge: %5.2f",getAge());
    }

    double getAge() {
        String[] ymd = birthDate.split("[-,.]",3);
        int years = currentYear - Integer.parseInt(ymd[0]);
        int months = currentMonth - Integer.parseInt(ymd[1]);
        if(months<0) {years--; months+=12;}
        return years+months/12.0;
    }
}
