def func4():
    lst = []
    s = input()
    while s != '':
        lst.append((s.split()))
        s = input()
    res1 = sorted(lst, key=lambda x: x[0])
    res2 = sorted(lst, key=lambda x: x[1])
    res2 = [(j, i) for i, j in res2]
    return res1, res2
if __name__ == '__main__':
    f = func4()
    print(f[0], '\n', f[1], sep='')
