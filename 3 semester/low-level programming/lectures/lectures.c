#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

#define RANGE 'Z' - 'A'

void CaesarCode_Print(char *str, int8_t offset)
{
  offset %= RANGE;
  while(*str) {
    char sign = *str;
    if(sign >= 'A' && sign <= 'Z') {
      sign += offset;
      if(sign > 'Z') { sign -= RANGE; }
      else if(sign < 'A') { sign += RANGE; }
    }
    printf("%c", sign);
    str++;
  }
}


int ArraySum(int ary[], uint16_t length)
{
  int sum = 0;
  for(int i = 0; i < length; i++) {
    sum += ary[i];
  }
  return sum;
}

int main (void) // Funkcja główna
{
  int main_ary[6] = { 1, 2, 3, 4, 5, 6};
  int sum = ArraySum(main_ary, 6);
  printf("Suma: %i", sum);  return 0;

  char *main_str = "#HeLLo-7WoRLd";
  //CaesarCode_Print(main_str, 3);


}

