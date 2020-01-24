n = eval(input('please input n'))
for i in range(n, 2*n):
    for j in range(1, 2*n):
        if j in range(2*n-i, n+i):
            print('* ', end='')
        else:
            print(' ', end='')
    print()
for i in range(2*n-2, n-1, -1):
    for j in range(1, 2*n):
        if j in range(2*n-i, n+i):
            print('* ', end='')
        else:
            print(' ', end='')
    print()