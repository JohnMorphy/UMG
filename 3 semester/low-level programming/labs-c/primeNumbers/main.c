#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int main() {

    uint32_t end = 100000;
    bool flag;
    uint32_t arr[100000];
    uint32_t n = 0;

    for(uint32_t i = 2; i <= end; i++) {
        
        flag = true;
        
        // for(uint32_t j = 2; j*j <= i; j++) {
        //     if(i % j == 0) {
        //         flag = false;
        //         break;
        //     }
        // }
        // if(flag == true) arr[n++] = i;

        for(uint32_t j = 0; j < n; j++) {
            if(i % arr[j] == 0) {
                flag = false;
                break;
            }
            if(i * i < arr[j]) break;   
        }
        if(flag) arr[n++] = i;
    }

    for(uint32_t i = 0; i<n; i++) {
        printf("%d ", arr[i]);
    }

}