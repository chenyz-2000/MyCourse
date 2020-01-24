from random import randint
def creatSet():
    n = randint(0, 9)+1
    s = {randint(0, 1000) for i in range(n)}
    while len(s) < n:
        s.add(randint(0, 1000))
    return s
def printResult(s):
    for i in s:
        print('{:>5d}'.format(i), end='')
    print()
def imputOfUser(A, B):
    for i in range(3):
        set1 = set([int(i) for i in input("A | B:").split()])
        set2 = set([int(i) for i in input("A & B:").split()])
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
if __name__ == '__main__':
    func6()