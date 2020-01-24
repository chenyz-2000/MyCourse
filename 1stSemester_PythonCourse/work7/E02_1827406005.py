def func2(s, n):
    if type(n) == int and n>=1 and n<=len(s):
        return s[:n-1]+s[n:]
    else:
        return 'n不合法，请重新运行'
if __name__=="__main__":
    print(func2('ABCDEFG', 5))
    print(func2('ABCDEFG', 10))