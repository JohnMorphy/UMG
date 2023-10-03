% POLECENIE 1

tx = 0.1;
fp = 1000;
fcos = 100;
fsin = 100;

t = (0:1/fp:0.1-1/fp);
h = 3*cos(2*pi*fcos*t)+sin(2*pi*fsin*t);
h = h+ones(1,100);

% plot(h);
% xlabel("nr próbki");
% ylabel("amplituda");
% title("wykres sygnału h");

H=fft(h);

% hold on
% plot(real(H));
% plot(imag(H)); 
% hold off
%  
% xlabel("Częstotliwość");
% ylabel("Widmo amplitudy");
% title("wykres części rzeczywistej i urojonej");


% Wykresy po przesunięciu kołowym H
% hold on
% plot(-50:49, real([H(51:100) H(1:50)]));
% plot(-50:49, imag([H(51:100) H(1:50)]));
% hold off
% 
% xlabel("Częstotliwość");
% ylabel("Widmo amplitudy");
% title("wykres części rzeczywistej i urojonej (po przesunięciu kołowym");
% 

y = ifft(H);

% hold on
% plot(real(y));
% plot(imag(y));
% hold off
% xlabel("nr próbki");
% ylabel("wartość na osi");
% title("wykres sygnału h po odwróceniu transformaty"); 

% POLECENIE 2

% Kształtowanie idealnej charakterystyki częstotliwościowej
Hre = [1 ones(1, 10) zeros(1,20) ones(1,10)];
Him = zeros(1,41);
H=Hre+j*Him;

% stem(H)
% xlabel("nr próbki");
% ylabel("wartość amplitudy");
% title("wykres sygnału H (zerowa wartość imaginalis)"); 


% Obliczenie odwrotnej transformaty DFT i analiza wyniku

hz = ifft(H);
% hold on
% stem(real(hz));
% stem(imag(hz));
% hold off

hre = real(hz);
% fvtool(hre,1);

% Przesunięcie kołowe odpowiedzi impulsowej
h = [hz(21:41) hz(1:20)];
% fvtool(h,1);

% xlabel("nr próbki");
% ylabel("wartość amplitudy");
% title("wykres sygnału Hre"); 
% stem(h)

% fvtool(h,1,hre,1) %dwie charakterystyki na 1 wykresie

% Zastosowanie funkcji okna

window_1 = hamming(41);
% fvtool(h.*window_1',1)

% POLECENIE 3

Hre=[0 zeros(1,15) ones(1,15) zeros(1,60) ones(1,15) zeros(1,15)];
Him=zeros(1,121);
H=Hre+j*Him;

% stem(H);
% xlabel("nr próbki");
% ylabel("wartość amplitudy");
% title("wykres sygnału H (zerowa wartość imaginalis)"); 

hz = ifft(H);
hre = real(hz);
h=[hz(61:121) hz(1:60)];
% fvtool(h,1,hre,1);

window_2 = hamming(121);
% fvtool(h.*window_2',1)

% POLECENIE 4

Hre=[ones(1,25) zeros(1,50) ones(1,50) zeros(1,50) ones(1,25)];
Him=zeros(1,200);
H=Hre+j*Him;

stem(H);
xlabel("nr próbki");
ylabel("wartość amplitudy");
title("wykres sygnału H (zerowa wartość imaginalis)"); 

hz = ifft(H);
hre = real(hz);
h=[hz(101:200) hz(1:100)];
fvtool(h,1);

window_3 = hamming(200);
fvtool(h.*window_3',1)