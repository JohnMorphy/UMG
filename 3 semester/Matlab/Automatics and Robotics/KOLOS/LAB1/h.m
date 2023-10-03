clear
clc

num = [1 6];
den = [1 6 11 6]

[r, p, k] = residue(num,den)

t = [0:0.1:10];

wynik = 1.5*exp(-3*t) - 4*exp(-2*t) + 2.5*exp(-t);

plot(t, wynik)