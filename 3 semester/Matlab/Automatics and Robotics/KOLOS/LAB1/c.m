clear
clc

num = [2 6 8];
den = [1 2 4 8];

[r, p, k] = residue(num, den);

r2abs = abs(r(2))
r2angle = angle(r(2)) * 180/pi

r3abs = abs(r(3))
r3angle = angle(r(3)) * 180/pi

t = [0:0.1:10];
wynik = 0.5 * exp(-2*t) + 2.1214 * cos(2*t - 45);
plot(t, wynik)