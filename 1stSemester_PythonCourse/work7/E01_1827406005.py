def func1(s):
    if len(s) < 2:
        return ''
    else:
        return s[:2] + s[-2:]
if __name__=="__main__":
    print(func1("python"))
    print(func1("py"))
    print(func1("p"))