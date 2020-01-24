lst = [i for i in range(2, 501)]
for i in range(len(lst)):
    if lst[i] != 0:
        for j in range(i+1, len(lst)):
            if (lst[j]) % (lst[i]) == 0:
                lst[j] = 0
result = [i for i in lst if i != 0]
for i in range(len(result)):
    print(result[i], end=' ')
    if (i+1)%5 == 0:
        print()