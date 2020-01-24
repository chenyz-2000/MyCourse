x=input('please input x')
if len(x)<=5:
    print('x是{}位数'.format(len(x)))
    lst=list(x)
    for i in lst:
        print(i,end='  ')
    print()
    for i in lst[::-1]:
        print(i,end='  ')
else:
    print('输入的x位数多余5')