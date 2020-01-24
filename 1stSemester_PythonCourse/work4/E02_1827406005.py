from math import sqrt
x1,y1=eval(input('x1,y1'))
x2,y2=eval(input('x2,y2'))
x3,y3=eval(input('x3,y3'))
s1=sqrt((x1-x2)**2+(y1-y2)**2)
s2=sqrt((x1-x3)**2+(y1-y3)**2)
s3=sqrt((x2-x3)**2+(y2-y3)**2)
if s1+s2>s3 and s1+s3>s2 and s2+s3>s1:
    c=s1+s2+s3
    s=c/2
    area=sqrt(s*(s-s1)*(s-s2)*(s-s3))
    print('周长=',c,'\n面积=',area)
else:
    print('不能构成三角形')