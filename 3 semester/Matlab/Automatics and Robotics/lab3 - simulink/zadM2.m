clear 
clc
close

%Warunki początkowe
y0 =0;
y1= -2;
%Y(s) - funkcja operatorowa(rozwiązanie równania różniczkowego)
%conv mnoży dwa nawiasy
num = conv([1 1],[y0 (y1+5*y0)])+[0 0 2]
den = conv([1 1], [1 5  6])
%funkcja roots liczy miejsca zerowe
roots(den)
% Poszukiwanie składowych funkcji elementarnych
[r,p,k]= residue(num,den)

%Wykres

t=[0:0.01:10];
ya = 3*exp(-3*t) - 4*exp(-2*t) + exp(-1*t)
yb = r(1)*exp(p(1)*t)+r(2)*exp(p(2)*t)+r(3)*exp(p(3)*t);
%plot(t,ya)
%hold on
%plot(t,yb)
%hold on
tmax = 8;



name_md1 = 'm4_B_Sumulink'
%open_system(name_md1)
out  = sim(name_md1,tmax);
ts = out.simout.time;
ys = out.simout.data;
plot(ts,ys)