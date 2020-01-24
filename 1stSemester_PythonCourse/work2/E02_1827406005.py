from math import sqrt
x1,y1 = eval(input('please input"x1,y1"'))
x2,y2 = eval(input('please input"x2,y2"'))
x3,y3 = eval(input('please input"x3,y3"'))
side1 = sqrt((x1-x2)**2+(y1-y2)**2)
side2 = sqrt((x2-x3)**2+(y2-y3)**2)
side3 = sqrt((x1-x3)**2+(y1-y3)**2)
s = (side1+side2+side3)/2
area = sqrt(s*(s-side1)*(s-side2)*(s-side3))
print('{:<7.2f}'.format(area))