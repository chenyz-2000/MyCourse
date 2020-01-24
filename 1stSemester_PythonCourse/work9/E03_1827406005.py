def merge(f):
    with open(r'folder\{}'.format(f), 'r') as t:
        con = t.read()
    with open(r'folder\merge.txt', 'a') as t:
        t.write(con)
def func3():
    merge('file1.txt')
    merge('file2.txt')
    merge('file3.txt')
    merge('file4.txt')
if __name__ == '__main__':
    func3()