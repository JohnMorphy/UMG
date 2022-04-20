package com.company;

public class ListsObject {
    public static class ObjectOfList {
        Osoba element;
        ObjectOfList next = null;
    }

    public static boolean changeSurename(ObjectOfList first, int i, String newSurename) {
        int j = 0;
        ObjectOfList object = first;
        while (j <= i) {
            if (j == i) {
                Osoba buffer = new Osoba(newSurename, object.element.name, object.element.birthdate);
                object.element = new Osoba (buffer.surename, buffer.name, buffer.birthdate);
                return true;
            } else if (object.next == null)
                return false;
            j++;
            object = object.next;
        }
        return false;
    }

    public static void print(ObjectOfList object){
        while(true){
            System.out.println(object.element);
            if(object.next !=null) {
                object = object.next;
            }
            else
                break;
        }
    }

    public static void main(String[] args) {
        String[][] dane = {{"Wiśniak", "Janusz", "1965-12-09"},
                {"Żabiński", "Zbigniew","1987-04-09"},{"Nowak", "Jan", "1990-03-07"}};
        ObjectOfList pierwszy = new ObjectOfList();
        pierwszy.element = new Osoba("Wiśniewski", "Kazimierz", "1982-12-03");
        ObjectOfList kolejny = pierwszy;
        for(int i=0; i<3; i++) {
            kolejny.next = new ObjectOfList();
            kolejny = kolejny.next;
            kolejny.element = new Osoba(dane[i][0], dane[i][1], dane[i][2]);
        }
        print(pierwszy);
        System.out.println();
        kolejny=pierwszy;
        changeSurename(pierwszy, 1, "KoniecPolski");
        print(pierwszy);
    }
}