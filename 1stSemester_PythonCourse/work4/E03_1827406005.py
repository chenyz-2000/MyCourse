from math import sqrt
x1,y1=eval(input('please input x1,y1'))
r=eval(input('please input r'))
x2,y2=eval(input('please input x2,y2'))
d=sqrt((x1-x2)**2+(y1-y2)**2)
if d<=r:
    print('点在圆内')
else:
    print('点在圆外')

