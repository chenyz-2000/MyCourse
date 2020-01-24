import java.util.Scanner;

public class E08 {
	int num[] = new int[100000];
	int maxn;
	long compare;
	
	void create(int n, int mode) {
		maxn = n;
		if(mode==0||mode==1) {
			for(int i = 0;i<n;i++)num[i]=i;
			if(mode==0) {
				for(int i = 0;i<n;i++) {
					int a = num[i];
					int r = (int)(Math.random()*n);
					num[i]=num[r];
					num	[r] = a;			
				}
			}
		}
	}
	
	int sequentialSearch(int x) {
		for(int i = 0;i<maxn;i++) {
			compare++;
			if(num[i]==x)return i;
		}
		return -1;
	}
	
	int binarySearch_nonRecursion(int x) {
		int low = 0,high = maxn,mid = (low+high)/2;
		while(low<high) {
			compare++;
			if(x==num[mid])return mid;
			else if(x<num[mid]) {
				high = mid;
				mid = (low+high)/2;
			}
			else if(x>num[mid]) {
				low = mid+1;
				mid = (low+high)/2;
			}
		}
		return -1;
	}
	
	int binarySearch_recursion(int x, int low, int high) {
		int mid = (low+high)/2;
		if(low>=high)return -1;
		if(num[mid]==x)return mid;
		else if(num[mid]<x)return this.binarySearch_recursion(x, low, (low+high)/2);
		else return this.binarySearch_recursion(x, mid+1, high);
	}
	
	E08(){
		Scanner scan = new Scanner(System.in);
		System.out.print("input n:");
		int n = scan.nextInt();
		System.out.print("input m:");
		int m = scan.nextInt();
		//test1
		//�����
		create(n,1);
		compare = 0;
		long time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n);//���ҳɹ������
			sequentialSearch(x);
		}
		time = System.currentTimeMillis()-time;
		long t1 = time,  c1 = compare;
		System.out.println("�����˳����Ҳ��ҳɹ�������ʱ��Ϊ"+time+"ms��ƽ���Ƚϴ���Ϊ"+compare/(float)m);
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n)+n;//����ʧ�ܵ����
			sequentialSearch(x);
		}
		time = System.currentTimeMillis()-time;
		long t2 = time, c2 = compare;
		System.out.println("�����˳����Ҳ���ʧ�ܣ�����ʱ��Ϊ"+time+"ms��ƽ���Ƚϴ���Ϊ"+compare/(float)m);
		//�����
		create(n,0);
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n);//���ҳɹ������
			sequentialSearch(x);
		}
		time = System.currentTimeMillis()-time;
		System.out.println("�����˳����Ҳ��ҳɹ�������ʱ��Ϊ"+time+"ms��ƽ���Ƚϴ���Ϊ"+compare/(float)m);
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n)+n;//����ʧ�ܵ����
			sequentialSearch(x);
		}
		time = System.currentTimeMillis()-time;
		System.out.println("�����˳����Ҳ���ʧ�ܣ�����ʱ��Ϊ"+time+"ms��ƽ���Ƚϴ���Ϊ"+compare/(float)m);
		
		//test2
		//˳�����
		create(n,1);
		System.out.println("\n�����˳����Ҳ��ҳɹ�������ʱ��Ϊ"+t1+"ms��ƽ���Ƚϴ���Ϊ"+c1/(float)m);
		System.out.println("�����˳����Ҳ���ʧ�ܣ�����ʱ��Ϊ"+t2+"ms��ƽ���Ƚϴ���Ϊ"+c2/(float)m);
		//���ֲ���
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n);//���ҳɹ������
			binarySearch_nonRecursion(x);
		}
		time = System.currentTimeMillis()-time;
		long t3 = time, c3 = compare;
		System.out.println("�������ֲ��Ҳ��ҳɹ�������ʱ��Ϊ"+time+"ms��ƽ���Ƚϴ���Ϊ"+compare/(float)m);
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n)+n;//����ʧ�ܵ����
			binarySearch_nonRecursion(x);
		}
		time = System.currentTimeMillis()-time;
		long t4 = time, c4 = compare;
		System.out.println("�������ֲ��Ҳ���ʧ�ܣ�����ʱ��Ϊ"+time+"ms��ƽ���Ƚϴ���Ϊ"+compare/(float)m);
		
		//test3
		//�ǵݹ�
		System.out.println("\n�����ǵݹ���ֲ��Ҳ��ҳɹ�������ʱ��Ϊ"+t3+"ms��ƽ���Ƚϴ���Ϊ"+c3/(float)m);
		System.out.println("�����ǵݹ���ֲ��Ҳ���ʧ�ܣ�����ʱ��Ϊ"+t4+"ms��ƽ���Ƚϴ���Ϊ"+c4/(float)m);
		//�ݹ�
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n);//���ҳɹ������
			binarySearch_nonRecursion(x);
		}
		time = System.currentTimeMillis()-time;
		System.out.println("�����ݹ���ֲ��Ҳ��ҳɹ�������ʱ��Ϊ"+time+"ms��ƽ���Ƚϴ���Ϊ"+compare/(float)m);
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n)+n;//����ʧ�ܵ����
			binarySearch_nonRecursion(x);
		}
		time = System.currentTimeMillis()-time;
		System.out.println("�����ݹ���ֲ��Ҳ���ʧ�ܣ�����ʱ��Ϊ"+time+"ms��ƽ���Ƚϴ���Ϊ"+compare/(float)m);
	}
	
	public static void main(String args[]) {
		new E08();
	}
}
