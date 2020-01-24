import java.util.StringTokenizer;

class MyStringl{
	char[] str;
	public MyStringl(char[]chars) {
		str = new char[chars.length];
		for(int i = 0;i<chars.length;i++) {
			str[i] = chars[i];
		}
	}
	public char charAt(int index) {
		return str[index];
	}
	public int length() {
		return str.length;
	}
	public MyStringl substring(int begin, int end) {
		char[] sub = new char[end-begin];//创建新数组，将范围内元素放入新数组
		for(int i = 0;i<end-begin;i++) {
			sub[i]=str[begin+i];
		}
		return new MyStringl(sub);
	}
	public MyStringl toLowerCase() {
		char[] lower = new char[str.length];
		for(int i = 0;i<lower.length;i++) {
			lower[i]=str[i];
			if(str[i]>='A'&&str[i]<='Z')
				lower[i]+=32;
		}
		return new MyStringl(lower);
	}
	public MyStringl toUpperCase() {
		char[] upper = new char[str.length];
		for(int i = 0;i<upper.length;i++) {
			upper[i]=str[i];
			if(str[i]>='a'&&str[i]<='z')
				upper[i]-=32;
		}
		return new MyStringl(upper);
	}
	public boolean equals(MyStringl s) {
		if(str.length!=s.length())return false;
		for(int i = 0;i<str.length;i++) {
			if(str[i]!=s.str[i])return false;
		}
		return true;
	}
	public static MyStringl valueOf(int i) {
		int len = 1,copyi = i;
		while(copyi/10!=0) {
			len++;
			copyi/=10;
		}
		char[] nums = new char[len];
		for(int j = len-1;j>=0;j--) {
			nums[j]=(char)(i%10);
			nums[j]+='0';
			i/=10;
		}
		return new MyStringl(nums);
	}
	public int compare(String s) {
		int len_str = str.length,len_s = s.length();
		for(int i = 0;i<Math.min(len_str, len_s);i++){
			if(str[i]<s.charAt(i))return -1;
			else if(str[i]>s.charAt(i))return 1;
		}
		if(len_str ==len_s)return 0;
		else if(len_str<len_s)return -1;
		else return 1;
	}
	public char[] toChars() {
		char[] res = new char[str.length];
		for(int i = 0;i<str.length;i++) {
			res[i]=str[i];
		}
		return res;
	}
}

public class E01 {
	public static String[] split(String s,String regex) {
		StringTokenizer st = new StringTokenizer(s,regex,true);
		int len = st.countTokens();
		String[] res = new String[len];
		for(int i = 0;i<len;i++)res[i] = st.nextToken();
		return res;
	}
	
	public static void main(String[] args) {
		char[] c = {'a','b','c','D'};
		MyStringl ms = new MyStringl(c);
		System.out.println(ms.str);
		System.out.println(ms.charAt(1));
		System.out.println(ms.length());
		System.out.println(ms.substring(1, 3).str);
		System.out.println(ms.toLowerCase().str);
		System.out.println(ms.toUpperCase().str);
		char[] c1 = {'a','b','c','d'};
		System.out.println(ms.equals(new MyStringl(c1)));
		System.out.println(MyStringl.valueOf(1234).str);
		String s = "abcd";
		System.out.println(ms.compare(s));
		System.out.println(ms.toChars());
		
		String[] x = split("a?b?gf#e", "[?#]");
		System.out.println();
		for(String e:x)System.out.print(e+"\t");
	}
}