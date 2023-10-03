#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

bool file_save(const char *name, char **bytes, size_t size) {
    FILE *fp = fopen(name, "rb");
    if(fp == NULL) {
        return false;
    }
    fwrite(*bytes, sizeof(char), size, fp);
    fclose(fp);
    return true;
}

int file_load(const char* name, char **bytes) {
    
    uint16_t size = 0;

    FILE *fp = fopen(name, "rb");

    if(fp == NULL) {
        *bytes = 0;
        return -1;
    }
    fseek(fp, 0, SEEK_END); //we go to the end of the file
    size = ftell(fp);
    fseek(fp, 0, SEEK_SET);
    *bytes = malloc(size);

    if(size != fread(*bytes, sizeof(char), size, fp)) {
        free(*bytes);
        return -2;
    }
    fclose(fp);
    (*bytes)[size] = 0;
    
    return size;
}

void print_file(const char* name) {

    char *fileBuffer;

    uint16_t file_size = file_load(name, &fileBuffer);
    
    printf(fileBuffer);

}

int countWords(const char *name) {

    char *fileBuffer;

    uint16_t file_size = file_load(name, &fileBuffer);
    
    printf(fileBuffer);

    uint32_t wordCount = 0;
    bool flag = false;

    while(*fileBuffer) {
        if(*fileBuffer <= 32) {
            if(flag == true) {
                wordCount++;
                flag = false;
            }
            fileBuffer++;
        } else {
            flag = true;         
            fileBuffer++;
        }
    }

    if(flag == true) {
        wordCount++;
    }
    
    return wordCount;
}

void tableOfString(const char *name) {

    char *fileBuffer;

    uint16_t file_size = file_load(name, &fileBuffer);
    
    printf(fileBuffer);

    uint32_t wordCount = 0;
    bool flag = false;

    char arr[5][20];
    int j = 0;

    while(*fileBuffer) {
        if(*fileBuffer <= 32) {
            arr[wordCount][j] = '\0';
            j=0;
            if(flag == true) {
                wordCount++;
                flag = false;
            }
            fileBuffer++;
        } else {
            arr[wordCount][j] = *fileBuffer;
            j++;
            flag = true;         
            fileBuffer++;
        }
    }
    
    int k = 0;
    char *d = arr[k];
    char *p = arr;
        

    while(*p) {
        char *d = arr[k];
        while (*d) {
            printf("%c", *d);
            d++;
        }
        k++;
        p++;
    }
}

int main(void)
{

    //int count = countWords("./test.txt");
    //printf("\n%d", count);

    tableOfString("./test.txt");

    /*
    char *file_buffer;
    uint16_t file_size = file_load("./start.ini", &file_buffer);
    printf(file_buffer);
    
    file_buffer[0] = 'x';
    file_save("./start2.ini", &file_buffer, file_size);
    */
}