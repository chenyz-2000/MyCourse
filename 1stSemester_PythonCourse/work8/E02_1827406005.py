def func2(dct1, dct2):
    lst = [i for i in dct1.keys() if i in dct2.keys()]
    return lst
if __name__ == '__main__':
    print(func2({1: 0, 'a': 2, (3,): 4}, {1: 'b', 'c': 5, (3,): 6}))