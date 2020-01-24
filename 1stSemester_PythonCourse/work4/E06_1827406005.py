x=eval(input('please input'))
if x<10:
    print(x*1.015)
elif x>=10 and x<50:
    print(x*1.02)
elif x>=50 and x<100:
    print(x*1.03)
else:
    print(x*1.035)