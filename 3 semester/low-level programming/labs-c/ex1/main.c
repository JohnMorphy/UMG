#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

void printArray(char *ary) {
    char *p = ary;
    while(*p) { 
        printf("%c", *p); 
        p++; 
    }
    printf("\n");
}

void toUpperThis(char* ary) {

    char *p = ary;
    
    while(*p) {
        if(*p>96 && *p<123)
            *p -= 32;
        p++;
    }
}

void toLowerThis(char* ary) {

    char *p = ary;
    
    while(*p) {
        if(*p>64 && *p<91)
            *p += 32;
        p++;
    }
}

void removeRedundantThis(char* ary, char seperation){
            
    char *p = ary;
    
    int32_t length = 0;

    while (*p) {
        if (isalnum(*p)) {
            ary[length] = *p;
            length++;
            p++;
        }
        else if (length > 0) {
            while (*p) {
                if (isalnum(*p)) {
                    ary[length] = seperation;
                    length++;
                    break;
                }
                ++p;
            }
        }
        else ++p;
    }
    ary[length*sizeof(char)] = '\0';
}

    
 

void removePolishCharThis(char* ary) {
    
    int32_t size = strlen(ary);
        
    char *p = ary;
    int32_t length = 0;

    while(*p) {

        if(*p==-61) 
        {
            p++;
            switch(*p)
            {
                case -77: ary[length]=111; break;
                case -109: ary[length]=79; break;
            }
            length++;
            p++;
            continue;
        }

        if(*p==-60) 
        {
            p++;
            switch(*p)
            {
                case -123: ary[length]=97; break;
                case -124: ary[length]=65; break;
                case -121: ary[length]=99; break;
                case -122: ary[length]=67; break;
                case -103: ary[length]=101; break;
                case -104: ary[length]=69; break;
            }
            length++;
            p++;
            continue;
        }

        if(*p==-59)
        {
            p++;
            switch(*p)
            {
                case -126: ary[length]=108; break;
                case -127: ary[length]=76; break;
                case -124: ary[length]=110; break;
                case -125: ary[length]=78; break;
                case -101: ary[length]=115; break;
                case -102: ary[length]=83; break;

                case -68: ary[length]=122; break;
                case -69: ary[length]=90; break;
                case -70: ary[length]=122; break;
                case -71: ary[length]=90; break;
            }
            length++;
            p++;
            continue;
        }

        ary[length] = *p;
        length++;
        p++;
    }

    ary[length*sizeof(char)] = '\0';

}


typedef enum {
    CONVERT_Void = 0,
    CONVERT_Lower = 1,
    CONVERT_Upper = 2
}CONVERT_t;


// replaces polish chars with char friendly alternatives;
// strings of not letter/digits are turned into a separator;
// turns to lower case if parameter lowORUP equals 0,  
// turns to upper case if parameter lowORUP equals 1 - otherwise doesn't affect it;

/**/

char* digitsAndLetters(char* ary, char seperation, CONVERT_t conv) {

    int32_t size = strlen(ary);
    char* newCharArr = malloc(size);

    strcpy(newCharArr, ary);
    
    removePolishCharThis(newCharArr);
    removeRedundantThis(newCharArr, seperation);
    
    if(conv == CONVERT_Lower)       { toLowerThis(newCharArr); }
    else if (conv == CONVERT_Upper) { toUpperThis(newCharArr); }
    return newCharArr;
}

int main (void) // main function
{

    char ary1[] = "@@@a$a!@$-f_(-^^7541__aaaa_a__)AF*$X&";
    char ary2[] = "^^^1#@#@24142AA7777777AfaaaaX";
    char ary3[] = "as***ffafafafaX";
    char ary4[] = "asff()()aX";
    char ary5[] = "ąĄ$$$$$$$$$$$aAćĆcCęĘeEłŁlLńŃnNśŚsSżŻzZźŹzZX__haha__";
    
    char* testString = digitsAndLetters(ary1, '-', CONVERT_Lower); 
    printArray(testString);
    
    char* newString2 = digitsAndLetters(ary2, '-', CONVERT_Void);
    printArray(newString2);
    
    char* newString3 = digitsAndLetters(ary3, '_', CONVERT_Upper);
    printArray(newString3);

    char* newString4 = digitsAndLetters(ary4, '+', CONVERT_Upper);
    printArray(newString4);

    char* newString5 = digitsAndLetters(ary5, '+', CONVERT_Upper);
    printArray(newString5);

    
    return 0;
}