close
clear
clc

a1 = [0 1]
a2 = [0 4]
a3 = [0 8]
a4 = [1 15]
a5 = [2 0]
a6 = [0 0]

b1 = -1*(conv(a1, a4) - conv(a2, a3))
b2 = -1*(-conv(a5, a2))
c1 = -1*(conv(a2,b2) - conv(a4,b1))

b1root = roots(b1)
c1root = roots(c1)

Kkr = 6.9089

rpm = [(-1*Kkr + 17)/4 0 (8*Kkr)/4];

rps = roots(rpm)
omega = imag(rps(1))
Tosc = 2*pi/omega

Kp = 0.6*Kkr
Td = Tosc/8
Kd = Kp*Td
