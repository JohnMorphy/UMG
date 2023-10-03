%x=0:pi/100:4*pi;
%plot(x, sin(x));

x=-10:10/50:10;
y=x.^2+3.*x+10;

x1=0:3*pi/100:3*pi;
y1=sin(2.*x1).*cos(100.*x1);

x2=0:3*pi/100:3*pi;
y2=sin(5.*x1).*cos(10.*x1);

%subplot(3,1,1); plot(x,y);
%subplot(3,1,2); plot(x1,y1)
%subplot(3,1,3); plot(x2,y2);


x=-10:10/50:10;
y=sin(x);

plot(x,y);
title('zoomed out sin function')
xlabel('x')
ylabel('y')
axis([0 3*pi -2 2])
