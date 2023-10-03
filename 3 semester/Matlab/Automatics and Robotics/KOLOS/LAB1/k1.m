clear
clc
close

num = [1 2 0 0 2];
den = [1 0 4 0 0 0];

[r, p, k] = residue(num, den)


t = [0:0.1:10];

% Pierwiastki zespolone 
% zamieniamy na postać wykładniczą

M1 = abs(r(1));
A1 = 2*abs(r(1));
A2 = 2*abs(r(1));
fi1 = angle(r(1))*180/pi;
fi1 = angle(r(2))*180/pi;

y = A1 * cos(2*t+fi1*pi/180) - 0.125 + 0.25*t.^2;

plot(t, y);