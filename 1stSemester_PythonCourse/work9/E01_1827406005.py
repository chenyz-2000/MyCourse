def func1():
    with open('copy.txt', 'r') as a:
        con = a.read()
    with open('new.txt', 'w') as b:
        b.write(con)
if __name__ == '__main__':
    func1()