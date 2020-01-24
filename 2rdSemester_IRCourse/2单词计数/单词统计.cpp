#include<iostream>
#include<fstream>
#include<string>
#include<map>
#include<algorithm>
using namespace std;

string s;

int main(){
	ifstream Read("sample-en.txt",ios::in);
	map<string,int>M;
	while(Read>>s){
		transform(s.begin(),s.end(),s.begin(),::tolower);
		if(M.count(s))M[s]++;
		else M.insert(make_pair(s,1));
	}
	ofstream Print("dict.index",ios::out);
	for(map<string,int>::iterator it = M.begin();it!=M.end();it++){
		pair<string,int>tmp = *it;
		Print<<tmp.first<<'\t'<<tmp.second<<endl;
	}

	string test;
	while(cin>>test&&test!="###"){
		cout<<M[test]<<endl;
	}
}