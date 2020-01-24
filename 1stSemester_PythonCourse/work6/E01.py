def sumFactor(x):
    s = sum([i for i in range(1, x) if x % i == 0])
    return s

def main():
    print(sumFactor(8))

main()