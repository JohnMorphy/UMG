clear; clc;
f=[-12; -18];
ograniczenia=[0.3 0.2; 0.2 0.3; 0.05 0.15];
towarMax=[20;15;10];
x0=[]; lb=zeros(2,1); ub=[1e4;1e4];
aeq = []; beq = [];
% równania (tu nie ma takich warunków)
% ustawianie granic
options=optimoptions('linprog','Algorithm','dual-simplex','Display','iter')
values=linprog(f,ograniczenia,towarMax,aeq,beq,lb,ub,x0,options)