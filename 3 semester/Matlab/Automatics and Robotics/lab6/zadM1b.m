clear 
clc
close

tmax = 6;

% Rozwiązania równania różniczkowego metodą numeryczną
% inne warunki początkowe y1(0) = 2, a nie -2

name_md1 = 'm1_B_Sumulink';
%open_system(name_md1)

out = sim(name_md1, tmax);
tS = out.simout.time;
yS = out.simout.data;

% Wykresy rozwiązań
id = figure;
plot(tS, yS, "k-", "LineWidth", 1);
xlabel('t [s]');
ylabel('y(t) [-]');
idt = title('Rozwiązania równania róźniczkowego');
set(idt, 'FontWeight', 'normal');
grid on;
set(id, 'Color', [1 1 1])

% Dyskretyzacja równania różniczkowego metodą Eulera w przód

T = 0.1;        % Okres próbkowania

% Współczynniki równania róźnicowego
a1 = -2 + 5*T
a0 = 1 - 5*T + 6*T^2
b0 = 2*T^2
r = exp(-T)

% Wyznaczamy warunki początkowe
y0 = 0
y1 = 2*T + y0

% Wykres rozwiązania
tk(1) = 0*T;    yk(1) = y0;
tk(2) = 1*T;    yk(2) = y1;

Nmax = tmax/T;

for k = 1:Nmax
    tk(k+2) = (k+1)*T;
    yk(k+2) = -a1*yk(k+1) - a0*yk(k) + b0*r^(k-1);
end

figure;
stem(tk, yk);
grid on
title('Forward')

figure(id)
hold on
plot(tk, yk, 'bo');
hold off

% Dyskretyzacja równania różniczkowego metodą Eulera wstecz backward

T = 0.1;        % Okres próbkowania

name_md1 = 'm1_B_Sumulink';

% Współczynniki równania róźnicowego
M = 1 + 5*T + 6*T^2;
a1b = (-2 - 5*T)/M
a2b = 1/M
b0b = 2*T^2/M
rb = exp(-T)

% Wykres rozwiązania
tkb(1) = 0*T;    ykb(1) = y0;
tkb(2) = 1*T;    ykb(2) = y1;

Nmax = tmax/T;

for k = 3:Nmax-1
    tkb(k) = (k+1)*T;
    ykb(k) = -a1b*ykb(k-1) - a2b*ykb(k-2) + b0b*rb^(k-3);
end

figure(id);
hold on
stem(tkb, ykb, 'LineWidth', 1)
title('Backward')
hold off