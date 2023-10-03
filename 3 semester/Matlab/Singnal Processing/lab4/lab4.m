%\POLECENIE 1

fx1 = 100;
fp = 1000;
tx = 0.1;

t = (0:1/fp:tx-1/fp);
x1=3*sin(2*pi*fx1.*t);

%stem(t,x1);

% xlabel("t [s]");
% ylabel("Amplituda sygnału");
% title("wykres sygnału x1");

% fvtool(x1);

%POLECENIE 2

fx2 = 105;

x2=3*sin(2*pi*fx2.*t);

%stem(t,x2);

% xlabel("t [s]");
% ylabel("Amplituda sygnału");
% title("wykres sygnału x2");

%fvtool(x2);

%POLECENIE 3

% wintool;  % - szerokość 100 i wyeksporotwane
%Win1 = hamming(100);

%POLECENIE 4

%stem(t, x1.*Win1');

% xlabel("t [s]");
% ylabel("Amplituda sygnału");
% title("wykres sygnału x1 po pomnożeniu przez sygnał wygładzający");

%fvtool(x1.*Win1');
%fvtool(x2.*Win1');

%POLECENIE 5

Win2 = kaiser(100);

% stem(t, x1.*Win2');
% 
% xlabel("t [s]");
% ylabel("Amplituda sygnału");
% title("wykres sygnału x1 po pomnożeniu przez sygnał kaiser");

%fvtool(x1.*Win2');
fvtool(x2.*Win2');

%POLECENIE 6

t = 0:1/fp:1-1/fp;
x1_k1 = 3*sin(2*pi*fx1*t);

% fvtool(x1_k1);

%POLECENIE 7

Win3 = hamming(1000);

%fvtool(x1_k1.*Win3');