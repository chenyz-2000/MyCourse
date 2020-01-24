from random import randint
m=[[randint(0,100) for i in range(4)]for j in range(4)]
m1=[[row[i]for row in m]for i in range(4)]
print(m1)