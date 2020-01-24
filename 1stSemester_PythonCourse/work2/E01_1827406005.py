x = int(input('please input'))
a = x%10
b = x//10%10
c = x//100
print('{:>4}'.format(a+b+c))