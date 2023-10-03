import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        //Basic operations on Person

        Person student1 = new Person("Norwid", "Kamil", "1880-10-5");
        Person student2 = new Person("Smith", "John", "1882-5-11");

        System.out.println(student1);

        student2.setBirthDate("1990-11-24");

        new Person("Nolan", "Jack", "2000-10-5");
        new Person("White", "Amy", "1999-4-5");

        for(int i=0; i<Person.peopleList.size(); i++){
            System.out.println(Person.peopleList.get(i).getSurname() + " " + Person.peopleList.get(i).getName());
        }


        System.out.println(Person.peopleList.get(2).getSurname());

        for(int i=0; i<Person.peopleList.size(); i++){
            System.out.println(Person.peopleList.get(i));
        }


        System.out.println("Comparing students using equals\n");

        Student janek = new Student();
        Student piotr = new Student();
        new Student();
        new Student();
        new Student("Jan", "Ka", "2002-01-09", "XLO Gdańsk", "Mat-fiz", "2020-01-09", 5.0);
        new Student("Grzegorz", "Kim", "1955-01-09", "XLO Gdańsk", "Mat-fiz", "2010-01-09", 4.0);

        System.out.println(janek.equals(piotr));

        System.out.println("\nStudent with best average - his surname\n");
        System.out.println(Student.studentWithMaxAverage().getSurname());

        System.out.println("\nOldest student - his surname\n");
        System.out.println(Student.oldestStudent().getSurname());


        System.out.println("\nChecking if the student list is unique\n");

        HashSet<Student> h = new HashSet<Student>(Student.studentList);

        if(h.size() == Student.studentList.size()) {
            System.out.println("List is made of unique students");
        }
        else{
            System.out.println("List is not made out of unique students\nNames of students:");

            for (Student student : h) {
                System.out.println(student.getSurname());
            }
        }

        for(int i=0; i<Student.studentList.size(); i++) {
            System.out.println((int)Student.studentList.get(i).getAge());
        }

        System.out.println();
        System.out.println(Student.oldestWithYoungest());

        for(int i=0; i<Student.studentList.size(); i++) {
            System.out.println((int)Student.studentList.get(i).getAge());
        }

        MojaKlasa brother = new MojaKlasa("Afa", "afa");
        MojaKlasa sista = new MojaKlasa("21", "aou");

        System.out.println();
        System.out.println(brother.compareTo(sista));
        System.out.println(brother.biggerAttribute());
    }
}