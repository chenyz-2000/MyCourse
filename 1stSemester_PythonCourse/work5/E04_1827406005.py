n = eval(input('please input int n'))
sum = n
while True:
    if n > 0 and type(n) != int:
        print('error, please input int')
        n = eval(input('please input int n'))
    elif n > 0 and type(n) == int:
        n = eval(input('please input int n'))
        sum += n
    else:
        break
print(sum)