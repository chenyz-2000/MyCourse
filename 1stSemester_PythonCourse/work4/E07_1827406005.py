str=input('please input')
x=ord(str)
if x>=97 and x<=122:
    print(chr(x-32))
elif x>=65 and x<=90:
    print(chr(x+32))
else:
    print(str)