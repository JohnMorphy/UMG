f= [1 0 0 0];              % tworzenie wektorów
l = [1 2 3; 4 5 6; 7 8 9];  % tworzenie macierzy
z15 = 1 + 2j;                % liczba zespolona z1
abs(z15); % moduł liczby zespolonej
angle(z15); %obliczenie argumentu (Argument liczby zespolonej jest to
% miara kąta skierowanego% między wektorem reprezentującym liczbę
% zespoloną z = a + bi na płaszczyźnie zespolonej a osią rzeczywistą.)
real(z15); % wartość rzeczywista
imag(z15); % wartość urojona

B = [1:7]; % zastępuje B = [1 2 3 4 5 6 7}
% zapis j:k generuje wektor [j j+1 j+2 ... k]
% zapis j:i:k generuje wektor [j j+1*i j+2*i ... k]

%POLECENIE 1

z1 = 5 + 3j;
z2 = 3 + 10j;
z3 = 1 +5j;

abs(z1 + z2);
real(z2 * z3);
abs(z1) + abs(z2) + abs(z3);

%POLECENIE 2

wektor1 = ones(1,10);
B = [wektor1*0; wektor1; wektor1*8];

%POLECENIE 3

m1 = [3, 1, 6, 2; 2, 1, 3, 7; 1, 1, 1, 2];

m2= [3, 1, 6; 2, 1, 3; 1, 1, 1];

m3 = [2; 7; 2];
inv(m2) * m3;

inv(m1(:,1:3)) * m2(:,4)

%POLECENIE 4

m4 = [1, 0, 1; 3, 3, 0; 0, 2, 2];
inv(m4);

%POLECENIE 5

C = [ones(1,3); ones(1,3)*10; ones(1,3)*100]
D = [1:3; 4:6; 7:9]

C .* D % mnożenie tylko odpowiednich komórek (operator tablicowy)

