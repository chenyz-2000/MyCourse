def func3(dct1, dct2):
    lst = [i for i in dct1.items()]+[i for i in dct2.items()]
    sign = [i[1] for i in lst]
    sign = list({i for i in sign if sign.count(i) > 1})
    res = []
    for i in range(len(sign)):
        res.append([])
        for j in lst:
            if j[1] == sign[i]:
                res[i].append(j[0])
    return res
if __name__ == '__main__':
    print(func3({1: 0, 'a': 0, (2,): 0, 3: 1, 4: 2}, {3: 1, 1 : 0, 'b': 0}))