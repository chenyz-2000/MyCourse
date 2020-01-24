def statistics(s, n=0):
    s = s.lower()
    cha = s[n]
    return s.count(cha)

def main():
    print(statistics('This is a test example'))

main()