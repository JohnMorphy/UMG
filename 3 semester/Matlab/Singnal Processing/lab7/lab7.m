% POLECENIE 1

% fvtool([2 3 4 0], [1 3 3 1])
h = filter([2 3 4 0], [1 3 3 1], [1 zeros(1,99)]);
% stem(h);

[zz, pp, kk] = tf2zp([2 3 4 0], [1 3 3 1])

% pzmap(pp,zz);

% POLECENIE 2

a1 = 0.9;
a2 = 0.8;
a3 = 0.5;

% fvtool([1-a1 0], [1 -a1], [1-a2 0], [1 -a2], [1-a3 0], [1 -a3]);

% l1 = filter([1-a1 0], [1 -a1], [1 zeros(1,99)]);
% l2 = filter([1-a2 0], [1 -a2], [1 zeros(1,99)]);
% l3 = filter([1-a3 0], [1 -a3], [1 zeros(1,99)]);
% hold on;
% 
% plot(l1);
% plot(l2);
% plot(l3);
% 
% hold off;

% POLECENIE 3



alfa1 = 0.9;
b1 = 0.5*(1+alfa1)*[1 -1];
a1 = [1 -alfa1];

alfa2= 0.8;
b2 = 0.5*(1+alfa2)*[1 -1];
a2 = [1 -alfa2];

alfa3 = 0.5;
b3 = 0.5*(1+alfa3)*[1 -1];
a3 = [1 -alfa3];


% fvtool(b1, a1, b2, a2, b3, a3);
fg1 = acos((2*alfa1)/(1+pow2(alfa1)))
fg2 = acos((2*alfa2)/(1+pow2(alfa2)))
fg3 = acos((2*alfa3)/(1+pow2(alfa3)))

% POLECENIE 4

% 1)

alfa1 = 0.9;

beta1 = 0.3;
b1 = (1-alfa1)*[1 0 -1];
a1 = 2*[1 -beta1*(1+alfa1) alfa1];

beta2 = 0.5;
b2 = (1-alfa1)*[1 0 -1];
a2 = 2*[1 -beta2*(1+alfa1) alfa1];

beta3 = 0.8;
b3 = (1-alfa1)*[1 0 -1];
a3 = 2*[1 -beta3*(1+alfa1) alfa1];

% fvtool(b1, a1, b2, a2, b3, a3);

% 2)

beta1 = 0.3;

alfa1 = 0.9;
b1 = (1-alfa1)*[1 0 -1];
a1 = 2*[1 -beta1*(1+alfa1) alfa1];

alfa2 = 0.8;
b2 = (1-alfa2)*[1 0 -1];
a2 = 2*[1 -beta1*(1+alfa2) alfa2];

alfa3 = 0.5;
b3 = (1-alfa3)*[1 0 -1];
a3 = 2*[1 -beta1*(1+alfa3) alfa3];

% fvtool(b1, a1, b2, a2, b3, a3);

% POLECENIE 5

fvtool((1+0.9)/2*[1 zeros(1,15) -1], [1 zeros(1,15) -0.9]);
