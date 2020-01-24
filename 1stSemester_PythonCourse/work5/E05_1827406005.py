from math import sqrt
n = eval(input('please input n'))
for i in range(2, n):
    if 0 not in [i % d for d in range(2, int(sqrt(i)+1))]:
        print(i,end = ' ')