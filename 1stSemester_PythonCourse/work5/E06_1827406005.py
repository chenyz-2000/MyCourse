a, n = eval(input('please input a, n'))
s = 0
for i in range(1, n+1):
    x = int('{}'.format(a)*i)
    s += x
print(s)