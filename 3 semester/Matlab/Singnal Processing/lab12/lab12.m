close

% POLECENIE 1

fp = 8000;
tb = 0.01;
ti = (0:1/fp:tb-1/fp);
flo = sin(2*pi*1415*ti);
fhi = sin(2*pi*1585*ti);
FSK_NCF = [flo fhi flo fhi flo fhi flo fhi flo fhi];

% plot(FSK_NCF);
% xlabel("number próbki");
% ylabel("amplituda");
% title("sygnał FSK NCF");


% POLECENIE 2

fp = 8000;
fn = 1500;
dewiacja = 85;
bit = ones(1,80);
sm = [-bit bit -bit bit -bit bit -bit bit -bit bit];
calka = cumsum(sm);
t = (0:1/fp:0.1-1/fp);
FSK_CF = sin(2*pi*fn*t+2*pi*(dewiacja/fp)*calka);

% plot(FSK_CF);
% xlabel("number próbki");
% ylabel("amplituda");
% title("sygnał FSK CF");

% POLECENIE 3

f = fp/800*(0:800-1);
NCF_fft = abs(fft(FSK_NCF));
CF_fft = abs(fft(FSK_CF));

% stem(f(101:200), NCF_fft(101:200));
% xlabel("częstotliwość");
% ylabel("widmo amplitudowe");
% title("Widmo amplitudowe FSK NCF");

% stem(f(101:200), CF_fft(101:200));
% xlabel("częstotliwość");
% ylabel("widmo amplitudowe");
% title("Widmo amplitudowe FSK CF");

% POLECENIE 4

A = [bit bit bit -bit -bit -bit bit];
B = [-bit bit -bit -bit bit bit bit];
C = [bit -bit bit bit bit -bit -bit];
sm = [A B C];
calka = cumsum(sm);
czas_znaku = 0.07;
t = (0:1/fp:3*czas_znaku-1/fp);
FSK_ABC = sin(2*pi*fn*t+2*pi*(dewiacja/fp)*calka);
% fvtool(FSK_ABC);

% POLECENIE 5

% filterDesigner;
% DYSRYMINATOR - filtr dolnoprzepustowy; 
% fs = 8000hz, fpass = 1415; fstop = 1585
% LOWPASS - do demodulacji asynchronicznej:
% szerokość pasma (troszkę więcej) - fpass = 180, ftop = np 200

h1 = filter(DYSKRYMINATOR, FSK_NCF);
h2 = filter(DYSKRYMINATOR, FSK_CF);
h3 = filter(DYSKRYMINATOR, FSK_ABC);

% plot(h1)
% xlabel("numer próbki");
% ylabel("amplituda");
% title("FSK NCF po filtracji przez dyskryminator częstotliwościowy");

% plot(h2)
% xlabel("numer próbki");
% ylabel("amplituda");
% title("FSK CF po filtracji przez dyskryminator częstotliwościowy");

% plot(h3)
% xlabel("numer próbki");
% ylabel("amplituda");
% title("FSK ABC po filtracji przez dyskryminator częstotliwościowy");



Fs=fp;
Fc=fn;
Dem_NCF = amdemod(h1,Fc,Fs);
Dem_CF = amdemod(h2,Fc,Fs);
Dem_ABC = amdemod(h3,Fc,Fs);

% plot(Dem_NCF);
% xlabel("numer próbki");
% ylabel("amplituda");
% title("FSK NCF po demodulacji asynchronicznej");

% plot(Dem_CF);
%  xlabel("numer próbki");
%  ylabel("amplituda");
%  title("FSK CF po demodulacji asynchronicznej");

% plot(Dem_ABC);
% xlabel("numer próbki");
% ylabel("amplituda");
% title("FSK ABC po demodulacji asynchronicznej");


bin_NCF=sign(Dem_NCF);
uni_NCF = 0.5*(bin_NCF+1);
bin_CF=sign(Dem_CF);
uni_CF = 0.5*(bin_CF+1);
bin_ABC=sign(Dem_ABC);
uni_ABC = 0.5*(bin_ABC+1);

%  stem(uni_NCF);
%  xlabel("numer próbki");
%  ylabel("amplituda");
%  title("FSK NCF unipolarny");

% stem(uni_CF);
% xlabel("numer próbki");
% ylabel("amplituda");
% title("FSK CF unipolarny");

% stem(uni_ABC);
% xlabel("numer próbki");
% ylabel("amplituda");
% title("FSK ABC unipolarny");

