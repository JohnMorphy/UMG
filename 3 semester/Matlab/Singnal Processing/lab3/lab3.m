%\POLECENIE 1

t=0:0.01:0.99;

fs=5;
A=10;
y1=A*sin(2*pi*fs.*t);

stem(t,y1)

%POLECENIE 2

fs=95;
A=10; 
y2=A*sin(2*pi*fs.*t);

%stem(t,y2)

%POLECENIE 3

fs=105;
A=10;
y3=A*sin(2*pi*fs.*t);

%stem(t,y3)

%POLECENIE 4

%plot(t,y1,t,y2,t,y3);


% 
% t=0:1/1050:1;
% 
% fs=5;
% y1=A*sin(2*pi*fs.*t);
% 
% fs=95;
% y2=A*sin(2*pi*fs.*t);
% 
% fs=105;
% y3=A*sin(2*pi*fs.*t);
% 
% subplot(3,1,1); plot(t,y1);
% subplot(3,1,2); plot(t,y2);
% subplot(3,1,3); plot(t,y3);

%POLECENIE 5

Y1=fft(y1);
%stem(0:1:50,abs(Y1(1:51)));

Y2=fft(y2);
%stem(0:1:50,abs(Y1(1:50)));

Y3=fft(y3);
%stem(0:1:50,abs(Y1(1:50)));

%POLECENIE 6

t=0:0.01:0.99;
y123 = 10*sin(2*pi*20.*t) + 5*sin(2*pi*70.*t) + 2*sin(2*pi*90.*t);

f=0:1:99;
Y123=fft(y123);
stem(0:1:50,abs(Y123(1:51)));

%POLECENIE 7

yokres1=[-1*ones(1,14) 2 5*ones(1,14) 2];
yp1 = yokres1;
for k=1:7
    yp1=[yp1 yokres1];
end
t=0:1/240:1-1/240;

%stem(t,yp1);

%POLECENIE 8

f=0:1:120;
YP1=fft(yp1);
%stem(f,abs(YP1(1:121)));

%POLECENIE 9


yokres2=[-1*ones(1,7) 5*ones(1,7) 2];
yp2 = yokres2;
for k=1:7
    yp2=[yp2 yokres2];
end
t=0:1/120:1-1/120;
%stem(t,yp2);

% f=0:1:60;
% YP2=fft(yp2);
% stem(f,abs(YP2(1:61)));
% 
% xlabel("częstotliwość [hz]");
% ylabel("widmo sygnału");
% title("wykres widma amplitudowego fali prostokątnej");

