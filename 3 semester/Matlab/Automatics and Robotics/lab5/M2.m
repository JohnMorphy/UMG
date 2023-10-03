clear
clc

% Zadane wskaźniki jakości

tp = 1;
wr = 2;

% Wyznaczenie parametrów wzorcowego układu 2 rzędu

a = (wr*tp/pi)^2
zeta = sqrt((a-1)/(a-2))
wn = pi/(tp*sqrt(1-zeta^2))

% Sprawdzenie poprawności wyznaczenia parametrów (zeta, wn)

tps = pi/(wn * sqrt(1-zeta^2))
wrs = wn*sqrt(1-2*zeta^2)

% Poszukiwanie wartości wzmocnień (K1, K2) układu

K1 = wn^2
K2 = 2*K1 - 2*zeta*wn

%  Pozostałe wskaźniki jakości - (nie w treści zadania, na kolosie nope)

Mp = exp(-pi*zeta/sqrt(1-zeta^2)) * 100
tp = pi/(wn*sqrt(1-zeta^2))
to = (1+0.7*zeta)/wn
tn = 1.8/wn
tr