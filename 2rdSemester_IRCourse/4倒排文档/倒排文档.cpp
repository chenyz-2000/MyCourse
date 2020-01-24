#include<iostream>
#include<fstream>
#include<sstream>
#include<vector>
#include<map>
#include<set>
#include<string>
#include<algorithm>
using namespace std;
const int maxn = 10;

vector<int> ADD(vector<int>&a, vector<int>&b) {
	int i = 0, j = 0;
	vector<int>res;
	while (i < a.size() && j < b.size()) {
		if (a[i] < b[j])i++;
		else if (a[i] > b[j])j++;
		else {res.push_back(a[i]); i++; j++;}
	}
	return res;
}

vector<int> OR(vector<int>&a, vector<int>&b) {
	set<int>temp;
	for (int i = 0; i < a.size(); i++)temp.insert(a[i]);
	for (int i = 0; i < b.size(); i++)temp.insert(b[i]);
	vector<int>res;
	for (set<int>::iterator it = temp.begin(); it != temp.end(); it++) {
		res.push_back(*it);
	}
	return res;
}


int main() {
	map<string, vector<int> >dct;
	for (int i = 1; i <= maxn; i++) {
		string title = "d" + to_string(i) + ".txt";//不方便字符串格式化
		fstream file(title);//有构造函数
		//fstream file; file.open("title",ios::in);
		string s;
		while (file >> s) {
			transform(s.begin(), s.end(), s.begin(), ::tolower);//转换小写
			if (!dct.count(s))	dct.insert({ s,{i} }) ;
			else if (dct[s][dct[s].size() - 1] != i)	dct[s].push_back(i);
		}
	}
	
	fstream output("dict.txt");
	for(map<string, vector<int> >::iterator it = dct.begin();it!=dct.end();it++){
		int size = it->second.size();
		output << it->first << '\t' << size << '\t'<<it->second[0];
		for (int i = 1; i < size; i++)output << ' ' << it->second[i];//防止最后多余空格
		output << endl;
		it++;
	}

	string line;
	getline(cin, line);
	istringstream l(line);
	string a, oper, b;
	l >> a;
	vector<int>res = dct[a];
	if (l >> oper) {
		l >> b;
		if (oper == "and") res = ADD(dct[a], dct[b]); 
		else if (oper == "or")res = OR(dct[a], dct[b]);
	}
	for (int i = 0; i < res.size(); i++) {
		cout << res[i] << ".txt\t";
	}

	system("pause");
	return 0;
}