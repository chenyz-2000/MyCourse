from random import randint
i=randint(100,999)
print(i)
v_1=i%10
v_10=i//10%10
v_100=i//100
print(v_1*100+v_10*10+v_100)
# v_100=i//100
# v_10=(i-v_100*100)//10
# v_1=i-v_100*100-v_10*10