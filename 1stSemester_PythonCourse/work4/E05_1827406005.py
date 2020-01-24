x,y,z=eval(input('please input x,y,z'))
if x<=y:
    if x<=z:
        if y<=z:
            print(x,y,z)
        else:
            print(x,z,y)
    else:
        print(z,x,y)
else:
    if z<=y:
        print(z,y,x)
    else:
        if z<=x:
            print(y,z,x)
        else:
            print(y,x,z)