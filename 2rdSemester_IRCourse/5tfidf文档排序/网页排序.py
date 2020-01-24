import jieba
import collections
import math

# tf：词在某文档中的出现次数
# df：词在所有文档中的出现文档数
# w = (1+log10(tf)) * log10(10000/df)

query = input().split()     # 输入查询
queryDict = collections.OrderedDict()     # 单词在查询中的出现次数，保持顺序
for i in query:
    if i in queryDict:
        queryDict[i] += 1
    else:
        queryDict[i] = 1
queryDf = {i: 0 for i in queryDict}     # 用来之后记录查询词的df值，默认不存在为0

fenciDict = []      # 各个文档分词结果的单词计数
for i in range(0, 10000):
    with open("{}".format(i+1), "rb") as f:
        s = f.read()
        fenci = jieba.lcut_for_search(s)
        fenciSet = set(fenci)
        fenciDict.append({i: fenci.count(i) for i in fenciSet})
        # 与上面对query的处理类似
        for word in queryDf:
            if word in fenciDict[i]:
                queryDf[word] += 1
        # 若关键词在文档中出现，则df加1

for i in queryDf:
    print(i, ':', queryDf[i], '\t')     # 输出查询词的df值
print('\n')

similarList = []
for i in range(0, 10000):
    sum_qd = 0.0        # 作分子
    sum_q2 = 0.0
    sum_d2 = 0.0        # sum_q2*sum_d2的平方根作分母
    for word in queryDict:
        w_query = 1.0+math.log10(queryDict[word])     # word在query中的tf-idf权重
        w_doc = 0     # word在第i个文档中的tf-idf权重
        if word in fenciDict[i]:
            w_doc = (1.0+math.log10(fenciDict[i][word]))*math.log10(10000.0/queryDf[word])
        sum_qd += w_query*w_doc
        sum_q2 += w_query**2
        sum_d2 += w_doc**2
    similar = 0.0       # 余弦相似度
    len_q2d2 = math.sqrt(sum_q2*sum_d2)
    if math.fabs(len_q2d2) > 1e-5:
        similar = sum_qd/len_q2d2
    similarList.append((i+1, similar))      # 文档编号和余弦相似度的元祖

similarList.sort(key=lambda x: x[1], reverse=True)

for i in range(10):
    d = similarList[i][0]
    with open("{}".format(d), "rb") as f:
        s = str(f.read(), encoding="utf-8", errors="ignore")
    print("D{}:".format(d), similarList[i][1])
    print(s)