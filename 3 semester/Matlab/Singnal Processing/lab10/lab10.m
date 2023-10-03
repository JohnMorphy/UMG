% POLECENIE 1

tx = 0.01;
fp = 250000;
fm = 1000;
m = 0.5;
fn = 20000;
t=(0:1/fp:tx-1/fp);
AM=(1+m*sin(2*pi*fm*t)).*sin(2*pi*fn*t);
% plot(t,AM);
%  
% xlabel("t [s]");
% ylabel("Amplituda");
% title("wykres sygnału AM");

f=1/tx*(0:length(t)-1);
f1 = abs(fft(AM));

% stem(f(1:400),f1(1:400));
%  
% xlabel("częstotliwość [hz]");
% ylabel("Amplituda");
% title("wykres widma amplitudowego sygnału AM");

x = f(150:250);
y = abs(fft(AM))/(tx*fp/2);
y = y(150:250);

% stem(x,y);
% xlabel("częstotliwość [hz]");
% ylabel("Amplituda");
% title("fragment widma amplitudowego sygnału AM");

% POLECENIE 2

% 1)

AM_abs = abs(AM);

% plot(t, AM_abs);
  
% xlabel("czas t[s]");
% ylabel("amplituda");
% title("moduł sygnału AM");

f1 = 10*log(fft(AM_abs));
% plot(f(1:1249), f1(1:1249));
% 
% xlabel("częstotliwość [hz]");
% ylabel("amplituda w skali logarytmicznej");
% title("moduł sygnału AM");

% 2)

mod = sin(2*pi*fm*t);
% fdatool(mod) 
% create low pass filter AMfilter

h = filter(AMfilter, AM_abs);

% plot(mod);
% title("Sygnał modulujący");
% ylabel("Amplituda");
% xlabel("Częstotliwość [Hz]");
% hold on;
% plot(h)
% hold off;

% POLECENIE 3

AM_x_nosna = AM.*sin(2*pi*fn*t);

% plot(t, AM_x_nosna);
% title("Syngał AM pomnożony przez sygnał nośnej");
% ylabel("Amplituda");
% xlabel("czas [s]");

f=1/tx*(0:length(t)-1);
f2 = 10*log(fft(AM_x_nosna));

% plot(f(1:1250), f2(1:1250));
% title("Syngał AM pomnożony przez sygnał nośnej - widmo amplitudowe (skala logarytmiczna)");
% ylabel("widmo amplitudowe");
% xlabel("częstotliwość");

h2 = filter(AMfilter, AM_x_nosna);
% plot(mod);
% title("Sygnał modulujący");
% ylabel("Amplituda");
% xlabel("Numer próbki");
% hold on;
% plot(h2);
% hold off;

% title("Sygnał modulujący");
% ylabel("Amplituda");
% xlabel("Numer próbki");
% hold on;
% plot(h)
% plot(h2);
% hold off;

% title("Widma amplitudowe");
% ylabel("widmo amplitudowe");
% xlabel("częstotliwość");
% hold on;
% plot(f(1:1250), f1(1:1250));
% plot(f(1:1250), f2(1:1250));
% hold off;

% POLECENIE 4

DSB = sin(2*pi*fm*t).*sin(2*pi*fn*t);

DSB_fft=abs(fft(DSB));

%  plot(t,DSB);
%  title("Wykres  sygnału DSB");
%  ylabel("amplituda");
%  xlabel("czas [s]");

% plot(f(1:1250),DSB_fft(1:1250));
% title("Wykres widma amplitudowego sygnału DSB");
% ylabel("Amplituda");
% xlabel("częstotliwość");

h3=filter(AMfilter, DSB);

% title("Wykres modulatu sygnału DSB");
% ylabel("Amplituda");
% xlabel("numer próbki");
% 
% hold on
% plot(mod);
% plot(h3);
% hold off

% POLECENIE 5

DSB_x_nosna = DSB.*sin(2*pi*fn*t);

% plot(t, DSB_x_nosna);
% title("Syngał DSB pomnożony przez sygnał nośnej");
% ylabel("Amplituda");
% xlabel("czas [s]");

h4 = filter(AMfilter, DSB_x_nosna);

% title("Sygnał modulujący");
% ylabel("Amplituda");
% xlabel("Numer próbki");
% hold on;
% plot(h3);
% plot(h4);
% hold off;

DSB1_fft = fft(h3);
DSB2_fft = fft(h4);

% title("Widma amplitudowe demodulat DSB i DSB * nośna");
% ylabel("widmo amplitudowe");
% xlabel("częstotliwość");
% hold on;
% plot(f (1:1250), DSB1_fft(1:1250));
% plot(f (1:1250), DSB2_fft(1:1250));
% hold off;


