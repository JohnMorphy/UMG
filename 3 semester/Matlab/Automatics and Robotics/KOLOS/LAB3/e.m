
a0 = [0 1]
a1 = [0 4]
a2 = [0 3]
a3 = [1 2]
a4 = [2 0]

b1 = -1*(conv(a0, a3) - (conv(a1, a2)))
b2 = -1*(conv(a0, [0 0]) - conv(a1, a4))
c1 = -1*(conv(a1,b2) - conv(a3,b1))
d1 = [2 0]

rb1 = roots(b1)
rc1 = roots(c1)
rd1 = roots(d1)

Kkr = 0.8062;

ps = [(-Kkr+10)/4, 0, 8*Kkr/4];

rps = roots(ps)

omega = imag(rps(1))

Tosc = 2*pi/omega
Kp = 0.6*Kkr
Td = Tosc/8
Kd = Kp*Td
