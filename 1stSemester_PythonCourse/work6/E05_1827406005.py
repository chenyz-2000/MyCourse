def isNum(x):
    return True if ord(x)>=48 and ord(x)<=57 else False

def exc(string, i):
    if i-1 == len(string)-1:
        return False
    else:
        return isNum(string[i-1])

def code(string, n=5):
    lst = []
    for i in range(len(string)):
        o = ord(string[i])
        if (o>=65 and o<=90-n) or (o>=97 and o<=122-n):
            lst.append(chr(o+n))
        elif (o>90-n and o<=90) or (o>122-n and o<=122):
            lst.append(chr(o-26+n))
        elif isNum(string[i]) and not exc(string, i):
            lst.append([string[i]])
        elif isNum(string[i]) and exc(string, i):
            lst[-1].append(string[i])
    for i in range(len(lst)):
        if type(lst[i]) == list:
            num = eval(''.join(lst[i]))
            lst[i] = str(num*n)
    return ''.join(lst)

def decode(string, n=5):
    lst = []
    for i in range(len(string)):
        o = ord(string[i])
        if (o>=65+n and o<=90) or (o>=97+n and o<=122):
            lst.append(chr(o-n))
        elif (o>=65 and o<65+n) or (o>=97 and o<97+n):
            lst.append(chr(o+26-n))
        elif isNum(string[i]) and not exc(string, i):
            lst.append([string[i]])
        elif isNum(string[i]) and exc(string, i):
            lst[-1].append(string[i])
    for i in range(len(lst)):
        if type(lst[i]) == list:
            num = eval(''.join(lst[i]))
            lst[i] = str(int(num/n))
    return ''.join(lst)

def main():
    print(code('avbV125av1'))
    print(decode('fagA625fa5'))

main()