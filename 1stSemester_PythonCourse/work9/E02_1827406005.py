def func2():
    with open('Numbers.txt', 'r') as a:
        con = [float(i.strip()) for i in a.readlines()]
    con.sort()
    aver = sum(con)/len(con)
    s2 = sum([(i-aver)**2 for i in con])/len(con)
    res = [str(i)+'\n' for i in con]
    res.extend([str(aver)+'\n',str(s2)])
    with open('Sort.txt', 'w') as b:
        b.writelines(res)
if __name__ == '__main__':
    func2()