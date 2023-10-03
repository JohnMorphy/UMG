% POLECENIE 1

tx = 0.1;
fp = 1000;
fx1 = 100;
t=0:1/fp:tx-1/fp;
x1=3*sin(2*pi*fx1.*t);

%stem(t,x1);

%xlabel("t [s]");
%ylabel("Amplituda sygnału");
%title("wykres sygnału x1");

X1=fft(x1);
amp1=abs(X1(1:51));
f01=1/tx;
f=f01*(0:50);
%stem(f,amp1)
% 
% xlabel("f [Hz]");
% ylabel("Widmo amplitudowe");
% title("wykres widma amplitudowego sygnału x1");

% POLECENIE 2

fx2 = 105;
x2=3*sin(2*pi*fx2.*t);
% stem(t,x2);
% 
% xlabel("t [s]");
% ylabel("Amplituda sygnału");
% title("wykres sygnału x2");

X2=fft(x2);
amp2=abs(X2(1:51));
% stem(f,amp2);
%   
% xlabel("f [Hz]");
% ylabel("Widmo amplitudowe");
% title("wykres widma amplitudowego sygnału x1");

% POLECENIE 3

win1 = hamming(100);

X1_ham = fft(x1.*win1');
X2_ham = fft(x2.*win1');

%stem(f,abs(X2_ham(1:51)));

%plot(f,amp1,f,abs(X1_ham(1:51)));

%plot(f,amp2,f,abs(X2_ham(1:51)));

% POLECENIE 4

win1 = blackmanharris(100);

X1_bk = fft(x1.*win1');
X2_bk = fft(x2.*win1');

%stem(f,abs(X2_bk(1:51)));

%plot(f,amp1,f,abs(X1_bk(1:51)));

%plot(f,amp2,f,abs(X2_bk(1:51)));

% POLECENIE 5

x3 = [ones(1,8) zeros(1,49) ones(1,7)];
% stem(x3);
% xlabel("t [s]");
% ylabel("Amplituda sygnału");
% title("wykres sygnału x3");

X3 = fft(x3);
% stem(-32:31, [X3(33:64) X3(1:32)]);
% xlabel("f [Hz]");
% ylabel("Widmo amplitudowe");
% title("wykres widma amplitudowego sygnału x3");

% x4 = [ones(1,13) zeros(1,39) ones(1,12)];
%  stem(x4);
%  xlabel("t [s]");
%  ylabel("Amplituda sygnału");
%  title("wykres sygnału x4");

X4 = fft(x4);
% stem(-32:31, [X4(33:64) X4(1:32)]);
% xlabel("f [Hz]");
% ylabel("Widmo amplitudowe");
% title("wykres widma amplitudowego sygnału x4");

% POLECENIE 6

x5 = [ones(1,3) zeros(1,47)];
%  stem(x5);
% xlabel("t [s]");
% ylabel("Amplituda sygnału");
% title("wykres sygnału x5");

X5 = fft(x5);
%  stem(-25:24, fftshift(X5));
%  xlabel("f [Hz]");
%  ylabel("Widmo amplitudowe");
%  title("wykres widma amplitudowego sygnału x5");

p=unwrap(real(X5));
mf=abs(p);
  
ful=(0:length(x5)-1)'*100/length(x5);
% plot(ful,mf);
  
% plot(ful(1:50),p*180/pi); %faza
% xlabel('Częstotliwość [Hz]');
% ylabel('faza [stopnie]');
% title("widmo fazowe x5");

x6 = [zeros(1,25) ones(1,3) zeros(1,22)];
%  stem(x6);
%  xlabel("t [s]");
%  ylabel("Amplituda sygnału");
%  title("wykres sygnału x6");


X6 = fft(x6);
% stem(-25:24, fftshift(X6));
% xlabel("f [Hz]");
% ylabel("Widmo amplitudowe");
% title("wykres widma amplitudowego sygnału x6");

p=unwrap(real(X6));
mf=abs(p);
 
ful=(0:length(x6)-1)'*100/length(x6);
plot(fftshift(ful),mf);
  
%  plot(ful(1:50),p*180/pi); %faza
 xlabel('Częstotliwość [Hz]');
 ylabel('faza [stopnie]');
 title("widmo fazowe x6");

%POLECENIE KONTROLNE

x7 = [zeros(1,99) ones(1, 1) zeros(1,100)];
X7 = fft(x7);
% plot(-100:99, X7);
% 
% xlabel("f [Hz]");
% ylabel("Widmo amplitudowe");
% title("wykres widma amplitudowego sygnału jednostkowego");
