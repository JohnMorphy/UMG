#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

// konstruktor
struct Point {
  int32_t x;
  int32_t y;
};

// deklaracja zmiennej
struct Point point; // brak inicjalizacji
struct Point point = { 5, 2 };
struct Point point = { .x = 5, .y = 2 };
struct Point point = { .y = 2, .y = 5 };
// konstruktor
typedef struct {
  int32_t x;
  int32_t y;
} point_t;

int RandRange(int min,  int max) {
  return min + rand() % (max - min + 1);
}

int main(int argc, char const *argv[])
{
    / deklaracja
point_t point;                  // brak inicjalizacji
point_t point = { 5, 2 };
point_t point = { .x = 5, .y = 2 };
point_t point = { .y = 2, .y = 5 };



struct point point;
point.x = 3;                // ustawienie współrzędnej `x` gdy mamy strukturę

struct point *p = &point;   // wskaźnik na strukturę
(*p).x = 3;                 // ustawienie współrzędnej `x` gdy mamy wskaźnik na strukturę
p->x = 3;                   // ale lepiej tak


/**
 * Losowanie liczby typu `int` z przedziału od `min` do `max`.
 * @param min dolny zakres losowania.
 * @param max górny zakres losowania.
 * @return wynik losowania.
 */

    return 0;
}