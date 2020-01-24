def func4():
    with open('word.txt', 'r') as a:
        con = [i for i in a.readlines() if i[0] in ['a', 'e', 'i', 'o', 'u']]
    with open('new_word.txt', 'w') as b:
        b.writelines(con)
if __name__ == '__main__':
    func4()