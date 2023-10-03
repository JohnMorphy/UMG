clear
clc
close

numGs = [5 7];
denGs = [1 5 13 14 6];
Gs = tf(numGs,denGs) %transfer function

% sisotool(Gs);

% wyznaczanie współczynników tablicy Routha

b1 = [0 5*13] - [5 14]

c1 = conv([-5 51],[5 14]) - [0, 5*5*[7 6]]

% wyznaczenie pierwiastków współczynników z pierwszej kolumny tablicy

rb1 = roots(b1)
rc1 = roots(c1)

% wzmocnienie krytyczne

K = rc1(1)

%wielomian pomocniczy

ps = [(-5*K+51), 0, (7*K+6)*5]
rps = roots(ps)
omega = imag(rps(1))

% okres oscylacji
Tosc = 2*pi/omega

% nastawy regulaotra PID
Kp = 0.6*K
Ti = Tosc/2
Td = Tosc/8
Ki = Kp/Ti
Kd = Kp*Td

% fc1 = @(K) -25*K^2+10*K+564
% fplot( fc1, [-5 6])
% hold on;
% 
% plot(rc1(1), 0, 'ko')
% plot(rc1(2), 0, 'ko')
% 
% hold off;
% grid on;
