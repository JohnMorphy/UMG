#include <stdio.h> // Dołączenie biblioteki
#include <math.h>
#include <stdint.h>

int main (void) // Funkcja główna
{


  uint8_t abcd = (166+99) ^ 0x5c;
  printf("\n%d\n", abcd);


  float a = 0;
  float b = 0;
  float c = 0;

  float delta = b*b - 4*a*c;

  printf("\n\n");

  if(a==0 && b!=0){
    printf("a wynosi zero, mamy równanie liniowe o miejscu zerowym: %2.5f", -c/b);
    return 0;
  }

  if(a==0 && b==0){
    printf("a i b wynosi zero - brak niewiadomej");
    return 0;
  }

  if(delta<0)
  {
    printf("Brak miejsc zerowych");
  }
  else if(delta == 0)
  {
    printf("tylko 1 miejsce zerowe: %2.5f", (b)/2*a);
  }
  else
  {
    printf("1 miejsce zerowe: %2.5f\n", (b-sqrt(delta))/2*a);
    printf("2 miejsce zerowe: %2.5f", (b+sqrt(delta))/2*a);
  }

  return 0;
}