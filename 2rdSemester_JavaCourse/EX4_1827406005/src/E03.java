import java.util.Scanner;

public class E03 {
	public static boolean isPrime(long x) {//�ж��������ķ���
		for(int i = 2;i<=(int)Math.sqrt(x);i++) {
			if(x%i==0)return false;
		}
		return true;
	}
	
	public static long reverse(long number) {//����������
		long res = 0;
		while(number>0) {
			res=res*10+number%10;
			number/=10;
		}
		return res;
	}
	//���������������������������Ļ���
	
	public static boolean isPalinPrime(long x) {//�ж��ǻ�������
		if(isPrime(x)&&x==reverse(x))return true;//����������һ����򷵻�true
		return false;
	}
	
	public static boolean isReversePrime(long x) {//�ж��Ƿ�����
		if(!isPrime(x)||x==reverse(x))return false;//ֻ�����������Ҳ�Ϊ������������²ż����ж�
		if(isPrime(reverse(x)))return true;
		return false;
	}
	
	public static boolean isMesPrime(long x) {//�ж���÷ɭ����
		if(!isPrime(x))return false;
		int a = 0;
		while(Math.pow(2, a)-1<x) a++;//ѭ��ֹͣ��2^a>=x+1����������������������ж�
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
