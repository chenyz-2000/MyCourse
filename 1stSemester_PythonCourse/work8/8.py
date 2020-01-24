# 1
# def func1(tpl):
#     aver = sum(tpl)/len(tpl)
#     v_sum = sum([(i-aver)**2 for i in tpl])
#     v = v_sum/len(tpl)
#     return v
# if __name__ == '__main__':
#     print(func1((65.5, 70.2, 100.5, 45.5, 88.8, 55.5, 73.5, 67.8)))

# 2
# def func2(dct1, dct2):
#     lst = [i for i in dct1.keys() if i in dct2.keys()]
#     return lst
# if __name__ == '__main__':
#     print(func2({1: 0, 'a': 2, (3,): 4}, {1: 'b', 'c': 5, (3,): 6}))

# 3
# def func3(dct1,dct2):
#     lst = [i for i in dct1.items()]+[j for j in dct2.items()]
#     sign = [i[1] for i in lst]
#     sign = list({i for i in sign if sign.count(i) > 1})
#     res = []
#     for i in range(len(sign)):
#         res.append([])
#         for j in lst:
#             if j[1] == sign[i]:
#                 res[i].append(j[0])
#     return res
# if __name__ == '__main__':
#     print(func3({1: 0, 'a': 0, (2,): 0, 2: 1, 3: 1,4:2}, {3: 0, 'b': 0}))

# 4 没有用字典，用了列表
# def func4():
#     lst = []
#     s = input()
#     while s != '':
#         lst.append((s.split()))
#         s = input()
#     res1 = sorted(lst, key=lambda x: x[0])
#     res2 = sorted(lst, key=lambda x: x[1])
#     res2 = [(j, i) for i, j in res2]
#     return res1, res2
# if __name__ == '__main__':
#     f = func4()
#     print(f[0], '\n', f[1])

# # 5
# from random import randint
# def createSet():
#     s = {randint(0, 500) for i in range(200)}
#     while len(s) <= 200:
#         s.add(randint(0, 500))
#     return s
# def printResult(set):
#     count = 0
#     for i in set:
#         print('{:>5d}'.format(i), end='')
#         count += 1
#         if count % 10 == 0:
#             print()
# def func5():
#     set1 = createSet()
#     set2 = createSet()
#     printResult(set1 ^ set2)
#     print('\n')
#     printResult(set1 & set2)
# func5()

# 6
from random import randint
def creatSet():
    n = randint(0, 9)+1
    return {randint(0,1000) for i in range(n)}
def printResult(set):
    for i in set:
        print('{:>5d}'.format(i), end='')
    print()
def imputOfUser(A, B):
    for i in range(3):
        set1 = set(input("A | B:").split())
        set2 = set(input("A & B:").split())
        flag = 0
        if set1 == A | B:
            print("A | B is right")
            flag += 1
        if set2 == A & B:
            print("A & B is right")
            flag += 1
        if flag == 2:
            break
    else:
        print(A | B, A & B, sep='\n')
def func6():
    A = creatSet()
    B = creatSet()
    printResult(A)
    printResult(B)
    imputOfUser(A, B)
func6()