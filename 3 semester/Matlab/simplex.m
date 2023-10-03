close all
clear all
%objectve function: input coefficients
f=[-4;-16];
%Inequality constraints. The should be in the form [A]{x}={b}
A=[2 3; 4 1; 0 1];
b=[16;24;2.5];
%Lower and upper bounds of variables
lb=zeros(2,1);
ub=[1e4;1e4];
%Add empty matrices for coefficients of equality constraints and initial
%guess
Aeq=[];
beq=[];
x0=[];
%Specify search options:
%Use the dual-simplex algorithm since simplex will be removed after this
version
%Display the results of all iterations
options=optimoptions('linprog','Algorithm','Simplex','Display','iter')
[x,fval,exitflag,output] = linprog(f,A,b,Aeq,beq,lb,ub,x0,options)