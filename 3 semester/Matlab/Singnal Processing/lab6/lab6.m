%POLECENIE 1

fs1 = 5;
A = 10;
fp = 1000;

t = (0:1/fp:1-1/fp);
y1 = A*sin(2*pi*fs1*t);

% plot(t,y1);
% 
% xlabel("t [s]");
% ylabel("Amplituda sygnału");
% title("wykres sygnału x1");

%POLECENIE 2

fs1 = 10;
A1 = 10;
y2=A1*sin(2*pi*fs1*t);

fs2 = 100;
A2 = 1;
y3=A2*sin(2*pi*fs2*t);

y12 = y2 + y3;


% plot(t,y12);
% 
% xlabel("t [s]");
% ylabel("Amplituda sygnału");
% title("wykres sygnału y12");

%POLECENIE 3

yn = y1 + rand(size(t));

% plot(t, yn);
%  
% xlabel("t [s]");
% ylabel("Amplituda sygnału");
% title("wykres sygnału y1 po dodaniu szumu");

%POLECENIE 4

imp = [ones(1, 1) zeros(1,19)];
okno = ones(1,20);
okres=y1(1:200);

% subplot(3,1,1); stem(imp); title('sygnał imp');
% subplot(3,1,2); stem(okno); title('sygnał okno');
% subplot(3,1,3); stem(okres); title('sygnał okres'); 

%POLECENIE 5

y1_imp = conv(y1, imp);
y1_okno = conv(y1, okno);
y1_okres = conv(y1, okres);

% subplot(3,1,1); plot(y1_imp); title('splot sygnałów y1 i imp');
% subplot(3,1,2); plot(y1_okno); title('splot sygnałów y1 i okno');
% subplot(3,1,3); plot(y1_okres); title('splot sygnałów y1 i okres'); 
 
%POLECENIE 6

y12_okno = conv(y12, okno);
y12_okres = conv(y12, okres);

yn_okno = conv(yn, okno);
yn_okres = conv(yn, okres);

%  subplot(4,1,1); plot(y12_okno); title('splot sygnałów y12 i okno');
%  subplot(4,1,2); plot(y12_okres); title('splot sygnałów y12 i okres');
%  subplot(4,1,3); plot(yn_okno); title('splot sygnałów yn i okno');
%  subplot(4,1,4); plot(yn_okres); title('splot sygnałów yn i okres');

%POLECENIE 7

x=y1;
h=okno;
y1_okno=ifft(fft([x zeros(1, length(h)-1)]).*fft([h zeros(1,length(x)-1)]));

x=y1;
h=okres;
y1_okres=ifft(fft([x zeros(1, length(h)-1)]).*fft([h zeros(1,length(x)-1)]));

x=y12;
h=okno;
y12_okno=ifft(fft([x zeros(1, length(h)-1)]).*fft([h zeros(1,length(x)-1)]));

x=y12;
h=okres;
y12_okres=ifft(fft([x zeros(1, length(h)-1)]).*fft([h zeros(1,length(x)-1)]));

x=yn;
h=okno;
yn_okno=ifft(fft([x zeros(1, length(h)-1)]).*fft([h zeros(1,length(x)-1)]));

x=yn;
h=okres;
yn_okres=ifft(fft([x zeros(1, length(h)-1)]).*fft([h zeros(1,length(x)-1)]));

% subplot(6,1,1); plot(y1_okno); title('splot sygnałów y1 i okno');
% subplot(6,1,2); plot(y1_okres); title('splot sygnałów y1 i okres');
% subplot(6,1,3); plot(y12_okno); title('splot sygnałów y12 i okno');
% subplot(6,1,4); plot(y12_okres); title('splot sygnałów y12 i okres');
% subplot(6,1,5); plot(yn_okno); title('splot sygnałów yn i okno');
% subplot(6,1,6); plot(yn_okres); title('splot sygnałów yn i okres');

%POLECENIE 8

% fvtool(okres)
% fvtool(okno);