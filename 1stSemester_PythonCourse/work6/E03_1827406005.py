def isPrime(x):
    import math
    if 0 not in [x % i for i in range(2, int(math.sqrt(x))+1)]:
        return True
    else:
        return False

def palindrome(x):
    x_re = int(str(x)[::-1])
    return x_re

def isNotPalin(x):
    return True if x != palindrome(x) else False

def isInversePrime(x):
    if isPrime(x) and isPrime(palindrome(x)) and isNotPalin(x):
        return True
    else:
        return False

def printInversePrime(x):
    count, i = 0, 10
    while count <= x:
        if isInversePrime(i):
            print('{:>5d}'.format(i), end=' ')
            count += 1
            if count % 8 == 0 and count > 0:
                print()
        i += 1

def main():
    print(isInversePrime(17))
    print(isInversePrime(19))
    printInversePrime(30)

main()