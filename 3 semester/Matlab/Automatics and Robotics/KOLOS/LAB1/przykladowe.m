clear
clc 

num = [1 1 6]
den = [1 2 4 0]

[r, p, k] = residue(num, den)

r1abs = abs(r(1))
r1angle = angle(r(1)) * 180/pi

r2abs = abs(r(2))
r2angle = angle(r(2)) * 180/pi

t = [0:0.1:10];

wynik = 1.5 - exp(-t).*cos(1.7321*t + r1angle*pi/180);

plot(t, wynik);