#include <iostream>
#include<sstream>
#include<fstream>
#include<string>
#include<vector>
#include<algorithm>
#include<ctime>
using namespace std;

vector<wstring>vecDict;
vector<wstring>vecOut;
vector<wstring>vecAns;
int distinguish, exist, correct;
wstring strSenLong;
wofstream Out("corpus.out.txt",ios::out);

bool binarySearch(wstring t) {
	int low = 0, high = vecDict.size() - 1, mid;
	while (high > low + 1) {//和后面high、low的赋值相关
		mid = (low + high) / 2;
		if (vecDict[mid] == t)return true;
		else if (vecDict[mid] > t)high = mid;
		else low = mid;
	}
	return false;
}

void process() {//sentence的处理
	int index = 0;
	wstring strSenShort;

	while (index < strSenLong.size()) {//!
		for (int i = 10; i >= 1; i--) {
			if (index + i <= strSenLong.size()) {
				strSenShort = strSenLong.substr(index, i);//第二个参数是长度
				if (binarySearch(strSenShort) || i == 1) {
					vecOut.push_back(strSenShort);
					Out << strSenShort << L" ";
					index += i;
					break;
				}
			}
		}
	}
	Out << endl;
}

void compare() {
	int sizeOut = vecOut.size(), sizeAns = vecAns.size();
	distinguish += sizeOut;  exist += sizeAns;
	int  i = 0, j = 0;
	int lenOut = vecOut[0].size(), lenAns = vecAns[0].size();
	vecOut.push_back(L""); vecAns.push_back(L"");

	do {
		if (lenOut < lenAns) { lenOut += vecOut[++i].size(); }
		else if (lenOut > lenAns) { lenAns += vecAns[++j].size(); }
		else {//只有长度相等才能进行比较
			if (vecOut[i] == vecAns[j]) {
				correct++;
			}
			lenOut += vecOut[++i].size();
			lenAns += vecAns[++j].size();
		}
	} while (i < sizeOut&&j < sizeAns);
	//或者可以创立两个空字符串，按照类似的想法把小字符串拼到其后
	//或者得到两个集合，集合内是每个分词的位置左右区间的数组，找两个集合的交集
	vecOut.clear(); vecAns.clear();
}

int main() {
	//setlocale(LC_ALL, "chs");
	//locale::global(locale("chs"));
	Out.imbue(locale("chs"));//locale是关键
	wifstream Dict("corpus.dict.txt", ios::in);		Dict.imbue(locale("chs"));
	wifstream Sentence("corpus.sentence.txt", ios::in);		Sentence.imbue(locale("chs"));
	wifstream Answer("corpus.answer.txt", ios::in);		Answer.imbue(locale("chs"));

	wstring strDict;
	while (getline(Dict, strDict)) { vecDict.push_back(strDict);}
	sort(vecDict.begin(), vecDict.end());
	//将字典内容写入vecDict数组

	while (getline(Sentence, strSenLong)) {
		//处理sentence内容，放入out
		process();
		/*char z[2] = { '\n' };
		Out.write(z, 1);	*/

		//比较成立数
		wstring strAnsLong,strAnsShort;
		getline(Answer, strAnsLong);//读取每行
		wstringstream S(strAnsLong);		S.imbue(locale("chs"));
		while (S >> strAnsShort) { vecAns.push_back(strAnsShort);}//从每行中读取单词
		compare();
	}

	double p = (double)correct / distinguish, r = (double)correct / exist;
	printf("%4.2lf%%\n%4.2lf%%\n%4.2lf%%\n", p* 100, r * 100, p*r*2/(p+r)*100);
	cout << (double)clock() / 1000;
	system("pause");
}