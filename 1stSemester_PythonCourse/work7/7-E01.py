# 1
s = input('please input s')
if len(s) < 2:
    print('')
else:
    print(s[:2]+s[-2:])

# 2
s = input('please input s')
n = eval(input('please input n'))
if type(n) == int and n>=1 and n<=len(s):
    print(s[:n-1]+s[n:])
else:
    print('n不合法，请重新输入')
    s = input('please input s')
    n = input('please input n')

# 3
# 之前做过

# 4
s = input('please input s')
result = {}
for i in s:
    result.update({'{}'.format(i):s.count(i)})
print(result)

# 5
volca = input('please input a verb')
if volca[-1] == 'y':
    result = volca[:-1]+'ies'
elif volca[-1] == 'o' or volca[-1] == 's' or volca[-1] == 'x' or volca[-1] == 'z' or volca[-2:] == 'ch' or volca[-2:] == 'sh':
    result = volca + 'es'
else:
    result = volca + 's'
print(result)

# 6
import re, string
s = input('please input s')
s = re.sub(' +', ' ', s.strip())
s = re.sub('([{}])(\w)'.format(string.punctuation), r'\1 \2', s)
print(s)

# 7
import re
s = '<composer>Wolfgang Amadeus Mozart</composer>\n<author>Samuel Beckett</author>\n<city>London</city>'
s = re.sub('(<)(\w*)(>)(.*)(</\w*>)', r'\2: \4', s)
print(s)