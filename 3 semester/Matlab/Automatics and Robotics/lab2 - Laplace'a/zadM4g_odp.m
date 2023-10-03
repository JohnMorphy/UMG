clear
clc
close

num = [-3 -10 1]
den = [1 4 5 0]

roots(den)

[r,p,k] = residue(num, den)

% wyznaczenie postaci residuum w postaci wykładniczej
M = abs(r(1));                      % moduł
A = 2*M                             % A z wzoru 16
phi = angle(r(1)) * 180/pi          % faza

sigma = real(p(1))
omega = imag(p(1))

t=[0:0.01:10];

yb = A*exp(sigma.*t).*cos(omega.*t+phi)+0.2;

plot(t, yb)