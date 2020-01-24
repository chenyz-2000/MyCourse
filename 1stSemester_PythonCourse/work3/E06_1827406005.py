n=eval(input('please input positive odd number'))
mgc=[]
row,col=0,n//2
for i in range(n):
    mgc.append([0]*n)
mgc[row][col]=1
for i in range(2,n**2+1):
    r,l=(row-1+n)%n,(col+1)%n
    if mgc[r][l]==0:
        row , col=r,l
    else:row =(row+1)%n
    mgc[row][col]=i
import numpy as np
x=np.array(mgc)
print(x)