import math

def isPrime(x):
    if 0 not in [x%i for i in range(2, int(math.sqrt(x))+1)]:
        return True
    else:
        return False

def isMersenne(x):
    p = math.log2(x+1)
    if abs(p-round(p)) <=1e-10:
        return round(p)
    else:
        return -1

def printMersenne(x):
    p = 2
    a = 2**p-1
    while a < x:
        if isPrime(a):
            print('{:>3d}{:>4d}'.format(p, a))
        p += 1
        a = 2**p-1

def main():
    print(isMersenne(31))
    print(isMersenne(29))
    printMersenne(1000)

main()