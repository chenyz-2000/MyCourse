from random import randint
def createSet():
    s = {randint(0, 500) for i in range(200)}
    while len(s) <= 200:
        s.add(randint(0, 500))
    return s
def printResult(s):
    count = 0
    for i in s:
        print('{:>5d}'.format(i), end='')
        count += 1
        if count % 10 == 0:
            print()
def func5():
    set1 = createSet()
    set2 = createSet()
    printResult(set1 ^ set2)
    print('\n')
    printResult(set1 & set2)
if __name__ == '__main__':
    func5()
