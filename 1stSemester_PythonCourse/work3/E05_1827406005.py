x={'张飞':78+75,'李大刀':92+67,'李默白':84+88,'王老虎':50+50,'雷小米':99+98}
x=sorted(x.items(),key=lambda e:e[1],reverse=True)
print(x)