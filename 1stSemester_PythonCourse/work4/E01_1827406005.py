from math import sqrt
a,b,c=eval(input('please input float a,b,c'))
if a==0:
    print('错误，a不能为0')
else:
    delta=b**2-4*a*c
    if delta>=0:
        x1=(-b-sqrt(delta))/(2*a)
        x2=(-b+sqrt(delta))/(2*a)
    else:
        x1=complex((-b)/(2*a),(sqrt(-delta))/2*a)
        x2=complex((-b)/(2*a),(sqrt(-delta))/2*a)
    print('{:10.5f},{:10.5f}'.format(x1,x2))