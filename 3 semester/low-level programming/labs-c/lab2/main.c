#include <stdio.h> // Dołączenie biblioteki
#include <stdint.h>
#include <stdlib.h>

char* toUpper(char* ary1, int n) {
    char* newCharArr1 = malloc(n);

    for(int i=0; i<n; i++) {
        if(ary1[i]>96)
            newCharArr1[i] = ary1[i] - 32;
        else
            newCharArr1[i] = ary1[i];
    }

    return newCharArr1;
}

char* toLower(char* ary1, int n) {
    char* newCharArr2 = malloc(n);

    for(int i=0; i<n; i++) {
        if(ary1[i]<96)
            newCharArr2[i] = ary1[i] + 32;
        else
            newCharArr2[i] = ary1[i];
    }

    return newCharArr2;
}

int main (void) // Funkcja główna
{
    char ary1[] = "aAFGwwg";

    int n = sizeof(ary1)*sizeof(char);
    char* newString = toUpper(ary1, n);

    newString = toLower(ary1,n);

    for(int i = 0; i<n; i++){
        printf("%c", newString[i]);
    }

    return 0;
}