#include <stdio.h> // Dołączenie biblioteki
#include <stdint.h>
#include <stdlib.h>

uint8_t* sumArrays(uint8_t* ary1, uint8_t* ary2, uint8_t n){
  
  uint8_t* sum = malloc(n * sizeof(uint8_t));

  for(int i=0; i<n; i++){
    sum[i] = ary1[i] + ary2[i];
  }

  return sum;
}

int main (void) // Funkcja główna
{
  uint8_t ary1[] = {1, 2, 4, 8}; 
  uint8_t ary2[] = {2, 1, 3, 7}; 

  //uint8_t n = sizeof(ary1);

  uint8_t* sum = sumArrays(ary1, ary2, sizeof(ary1));

  for(int i=0; i<sizeof(ary1)*sizeof(uint8_t); i++){
    printf("%d ", sum[i]);
  }

  return 0;
}