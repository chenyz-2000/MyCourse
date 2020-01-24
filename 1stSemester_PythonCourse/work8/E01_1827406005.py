def func1(tpl):
    aver = sum(tpl)/len(tpl)
    v_sum = sum([(i-aver)**2 for i in tpl])
    v = v_sum/len(tpl)
    return v
if __name__ == '__main__':
    print(func1((65.5, 70.2, 100.5, 45.5, 88.8, 55.5, 73.5, 67.8)))