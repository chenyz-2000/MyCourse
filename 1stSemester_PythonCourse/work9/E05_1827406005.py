def func5(s):
    with open('names.txt', 'r') as a:
        lst = a.readlines()
    con = [i+'\n' if i == lst[-1] else i for i in lst]
    if s+'\n' not in con:
        con.append(s+'\n')
        con.sort()
    res = [i[:-1] if i == con[-1] else i for i in con]
    with open('new_Names.txt', 'w') as b:
        b.writelines(res)
if __name__ == '__main__':
    func5('Abc')