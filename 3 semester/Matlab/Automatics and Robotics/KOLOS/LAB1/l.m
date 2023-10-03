
clear
clc

num = [0 0 1 3] + conv([1 5], [1 6 13])
den = conv([1 3 6], [1 6 13])
printsys(num, den)

[r, p, k] = residue(num, den)