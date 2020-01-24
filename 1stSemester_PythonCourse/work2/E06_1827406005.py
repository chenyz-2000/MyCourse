import random,math
a = random.uniform(10,50)
b = random.uniform(10,50)
c = complex(a,b)
c1 = abs(c)
arg = math.acos(a/c1)*180/math.pi
print('{:>7.4f},{:>7.4f},{:>7.4f}'.format(c,c1,arg))