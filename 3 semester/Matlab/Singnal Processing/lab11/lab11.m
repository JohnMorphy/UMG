% POLECENIE 1

tx = 0.01;
fp = 200000;
fm = 1000;
fn = 20000;
t = (0:1/fp:tx-1/fp);


beta = 1;
FM1 = sin(2*pi*fn*t+ beta*sin(2*pi*fm*t));

beta = 2;
FM2 = sin(2*pi*fn*t+ beta*sin(2*pi*fm*t));

beta = 3;
FM3 = sin(2*pi*fn*t+ beta*sin(2*pi*fm*t));

% plot(t,FM3);

f=1/tx*(0:length(t)-1);

FM1abs = abs(fft(FM1));
% stem(f(101:1:300),FM1abs(101:1:300));
% xlabel("częstotliwość");
% ylabel("widmo amplitudowe");
% title("wykres sygnału FM1; przedstawiono przedział od 10 do 30 khz");

FM2abs = abs(fft(FM2));
% stem(f(101:1:300),FM2abs(101:1:300));
% xlabel("częstotliwość");
% ylabel("widmo amplitudowe");
% title("wykres sygnału FM2; przedstawiono przedział od 10 do 30 khz");
 
FM3abs = abs(fft(FM3));
% stem(f(101:1:300),FM3abs(101:1:300));
% xlabel("częstotliwość");
% ylabel("widmo amplitudowe");
% title("wykres sygnału FM3; przedstawiono przedział od 10 do 30 khz");

% POLECENIE 2

% filterDesigner;
% Projektowanie filtrów - dyskryminatorów częstotliwościowych
% HFM1 i HFM2 - dyskryminatory okienkowe


h1 = filter(HFM1, FM1);
% plot(t,h1);
% xlabel("czas [s]");
% ylabel("amplituda");
% title("FM1 po filtracji przez dyskryminator okienkowy");

h2 = filter(HFM2, FM2);
% plot(t,h2);
% xlabel("czas [s]");
% ylabel("amplituda");
% title("FM2 po filtracji przez dyskryminator okienkowy");

mod = sin(2*pi*fm*t);

FM1abs = abs(h1);
FM2abs = abs(h2);

h3 = filter(DEMOD1, FM1abs);
h4 = filter(DEMOD2, FM2abs);

hold on
plot(t, mod);
plot(t,h3);
plot(t,h4);
hold off
xlabel("czas [s]");
ylabel("amplituda");
title("Demodulacja FM1 FM2");