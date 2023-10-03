clear

a1 = [0 1];
a2 = [1 6];
a3 = [0 11];
a4 = [1 11];
a5 = [2 8];

b1 = -1*(conv(a1,a4) - conv(a2,a3))
b2 = -1*(-conv(a5,a2))
c1 = -1*(conv(a2,b2) - conv(a4, b1))
d1 = [2 8]

b1roots = roots(b1)
c1roots = roots(c1)
d1roots = roots(d1)

Kkr = 3.2795;

pm = [(10*Kkr+55)/(Kkr+6) 0 (2*(Kkr^2)+20*Kkr+48)/(Kkr+6)];

rps = roots(pm)

omega = imag(rps(1))
Tosc = 2*pi/omega

Kp = 0.6*Kkr
Ti = Tosc/2
Td = Tosc/8
Ki
Kd