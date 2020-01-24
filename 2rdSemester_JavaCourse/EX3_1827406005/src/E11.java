public class E11 {
	static boolean solve(int x) {//编写方法判断某数是否为完全数
		int sum = 0;
		for(int i = 1;i<x;i++) {
			if(x%i==0) {
				sum+=i;
				if(sum>x)return false;
			}
		}
		if(sum==x)return true;
		return false;
	}
	
	public static void main(String[] args) {
		for(int i = 1;i<=10000;i++) {//依次对所有数进行solve函数操作
			if(solve(i)) System.out.println(i);//判断结果为true的数字进行输出
		}

	}

}
