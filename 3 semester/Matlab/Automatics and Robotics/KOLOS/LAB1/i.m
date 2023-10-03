clear
clc
close

num = [0 0 0 6] + conv([2 1], [1 0 4])
den = conv([1 0 4], [1 2 2])
printsys(num, den)

[r, p, k] = residue(num, den)

r1abs = abs(r(1))
r1angle = angle(r(1)) * 180/pi %radiany

r2abs = abs(r(2))
r2angle = angle(r(2)) * 180/pi

r3abs = abs(r(3))
r3angle = angle(r(3)) * 180/pi

r4abs = abs(r(4))
r4angle = angle(r(4)) * 180/pi

t = [0:0.1:10];

wynik = 0.6708*cos(r1angle * pi/180) + 1.6076*exp(-t).*cos(t - r3angle *pi/180)

plot(t, wynik)
