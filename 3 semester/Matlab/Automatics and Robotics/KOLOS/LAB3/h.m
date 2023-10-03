close
clc
clear

a1 = [0 1];
a2 = [0 3];
a3 = [1 6];
a4 = [-3 10];
a5 = [2 1];

b1 = -1*(conv(a1, a4) - conv(a3, a2))
b2 = -1*(-conv(a2, a5))
c1 = -1*(conv(a2,b2) - conv(a4,b1))

rb = roots(b1)
rc = roots(c1)
cd = roots([2 1])

Kkr = 2.548

pm = [(6*Kkr+8)/3 0 (6*Kkr+3)/3]
rpm = roots(pm)
omega = imag(rpm(1))

Tosc = 2*pi/omega
Kp = 0.45*Kkr
Ti = Tosc/1.2
Ki = Kp/Ti
