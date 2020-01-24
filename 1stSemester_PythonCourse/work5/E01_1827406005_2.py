n = eval(input('please input n'))
for i in range(1, n+1):
    for j in range(1, 2*n):
        if j in range(n+1-i, n+i, 2):
            print('*', end=' ')
        else:
            print('  ', end='')
    print()
