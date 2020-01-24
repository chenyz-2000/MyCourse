def inverseWord(s):
    string, result = '', ''
    s += ' '
    for i in s:
        string += i
        if i == ' ':
            result = string + result
            string = ''
    return result[:len(result)-1]

def main():
    print(inverseWord('What a wonderful day!'))

main()