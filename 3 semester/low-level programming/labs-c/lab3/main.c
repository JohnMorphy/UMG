#include <stdio.h> // Dołączenie biblioteki
#include <stdint.h>
#include <stdlib.h>
#include <stdbool.h>

typedef enum{
    FEMALE = 0,
    MALE = 1
} Sex;


typedef struct{
    char imie[10];
    char nazwisko[15];
    int32_t indexl;
    bool student;
    Sex sexOfStudent;
} Person;

void displayPerson(Person person){
    printf("%s\n", person.imie);
    printf("%s\n", person.nazwisko);
    printf("%d\n", person.indexl);
    printf("%d\n", person.sexOfStudent);
    printf("%d\n", person.student);
}

void goStudy(Person person, int32_t index){
    person.student = true;
    person.indexl = index;
}

void kickedFromUni(Person* person){
    person->student = false;
    person->indexl = 0;
}

int main (void) // Funkcja główna
{
    Person studentUMG = { "Jan", "Kaiser", 11111, true, MALE};
    const Person myBestFriend = {"Antek", "KurdeBiłanicz", 12137, true, MALE};

    displayPerson(studentUMG);
    kickedFromUni(&studentUMG);
    displayPerson(studentUMG);

    uint8_t dd = (166+99) ^ 0x5C;

    uint8_t ff = 341 >> 1;

    printf("%d", dd);


    return 0;
}