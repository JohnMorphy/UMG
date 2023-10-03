clear
clc
close

% Warunki początkowe
y0=0;
y1=-2;

% Y(s) - Funkcja operatorowa (rozwiązanie równania różniczkowego)
num = conv([1 1], [y0, y1+5*y0]) + [0 0 2]
den = conv([1 1], [1 5 6])

% miejsca zerowe mianownika
roots(den)

% poszukiwanie składowej funkcji elementarnych
[r,p,k] = residue(num, den)

% tworzenie wykresu
t=0:0.01:10;

ya = 3*exp(-3.*t) - 4*exp(-2.*t) + exp(-1.*t);

% drugi sposób zapisu
yb = r(1)*exp(p(1).*t) - r(2)*exp(p(2).*t) + r(3)*exp(p(3).*t);


plot(t, ya, 'b', 'LineWidth', 1);
grid on
