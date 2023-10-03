num = 5*[1 1];
den = conv( conv([1 2], [1 2]), conv([1 2], [1 3]));

roots(den);

[r,p,k] = residue(num, den);

t=[0:0.01:10];

yb = r(1)*exp(p(1).*t) - r(2)*exp(p(2).*t) + r(3).*t.*exp(p(3).*t) + (r(4)/2).*t.^2.*exp(p(4)*t);

plot(t, yb)