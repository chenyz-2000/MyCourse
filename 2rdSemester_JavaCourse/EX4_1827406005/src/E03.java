import java.util.Scanner;

public class E03 {
	public static boolean isPrime(long x) {//判断是素数的方法
		for(int i = 2;i<=(int)Math.sqrt(x);i++) {
			if(x%i==0)return false;
		}
		return true;
	}
	
	public static long reverse(long number) {//返回逆向数
		long res = 0;
		while(number>0) {
			res=res*10+number%10;
			number/=10;
		}
		return res;
	}
	//上面两个方法是下面三个方法的基础
	
	public static boolean isPalinPrime(long x) {//判断是回文素数
		if(isPrime(x)&&x==reverse(x))return true;//如果是素数且回文则返回true
		return false;
	}
	
	public static boolean isReversePrime(long x) {//判断是反素数
		if(!isPrime(x)||x==reverse(x))return false;//只有在是素数且不为回文数的情况下才继续判断
		if(isPrime(reverse(x)))return true;
		return false;
	}
	
	public static boolean isMesPrime(long x) {//判断是梅森素数
		if(!isPrime(x))return false;
		int a = 0;
		while(Math.pow(2, a)-1<x) a++;//循环停止后，2^a>=x+1，接下来对两种情况进行判断
		double t = Math.pow(2,a);
		if(Math.pow(2, a)-1==x)return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int cnt = 0,num = 2;
		while(cnt<n) {
			if(isPalinPrime(num)) {
				System.out.printf("%7d",num);
				cnt++;
				if(cnt%10==0)System.out.println();
			}
			num++;
		}
		
		cnt = 0;num = 2;
		System.out.println("\n");
		while(cnt<n) {
			if(isReversePrime(num)) {
				System.out.printf("%7d",num);
				cnt++;
				if(cnt%10==0)System.out.println();
			}
			num++;
		}
		
		System.out.println("\n");
		for(int i = 2;i<32;i++) {
			long t = (long)Math.pow(2, i)-1;
			if(isMesPrime(t))System.out.printf("%d\t",t);
		}		
	}

}
