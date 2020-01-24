import re

name = input("请输入文件名（不含拓展名）：")

with open("{}.html".format(name),"r",encoding="utf-8") as f:
    string = f.read();

title = re.findall(r"<title>(.+)</title>",string)[0]#字符串
anchor = re.findall(r"<a.*href=\"(.+)\">(.+)</a>",string)#列表

s = re.findall(r"(<body.*)</body>",string,re.S)[0]  #获取body部分
s = re.sub("<!--.*?-->\n","",s,flags = re.S)    #删除注释
s = re.sub("\t* *","",s)    #调整缩进
s = re.sub("^(</{0,1}\w+>)+$\n","",s,flags=re.M)    #删去一些格式符
s = re.sub("<.*?>","",s).strip()    #删除<>和首空白字符
s = re.sub("\n{3,}","\n\n",s)   #调整空行

with open("{}.txt".format(name),"w",encoding="utf-8") as g:
    g.write("title:\n"+title+"\n\n\n")
    g.write("body:"+s+"\n\n\n")
    g.write("link:"+"")
    for i in anchor:
        g.write(i[1]+i[0]+"\n")