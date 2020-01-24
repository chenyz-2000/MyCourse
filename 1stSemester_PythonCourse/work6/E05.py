def isNum(x):
    o = ord(x)
    if o>=48 and o<=57:
        return True
    else:
        return False

def code(string, n=5):
    lst = []
    # string1 = ''
    for i in range(len(string)):
        o = ord(string[i])
        if (o>=65 and o<=90-n) or (o>=97 and o<=122-n):
            lst.append(chr(o+5))
        elif (o>90-n and o<=90) or (o>122-n and o<=122):
            lst.append(chr(o-21))
        elif isNum(string[i]) and not(isNum(string[i-1])):
            j = i
            num = string[j]
            i += 1
            while isNum(string[i]):
                # num += string[i]
                i += 1
            num = string[j:i]
            print(num)

            # num_mul = (eval(num))*5
            # print(num_mul)
        #     string1 += string[i]
        #     if string

    print(lst)

code('a123BCd45EZ135xy')