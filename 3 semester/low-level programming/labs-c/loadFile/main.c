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

int main(void)
{
    char *file_buffer;
    uint16_t file_size = file_load("./start.ini", &file_buffer);
    printf(file_buffer);
    
    file_buffer[0] = 'x';
    file_save("./start2.ini", &file_buffer, file_size);
}