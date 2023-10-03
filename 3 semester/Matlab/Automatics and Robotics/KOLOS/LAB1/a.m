clear
clc

num = [1 4 2];
den = [1 5 4 0];

[r, p, k] = residue(num, den)

t = [0:0.1:10]

wynik = 0.1667*exp(-4*t) + 0.3333*exp(-t) + 0.5;

plot(t, wynik)