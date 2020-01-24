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
		//有序表
		create(n,1);
		compare = 0;
		long time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n);//查找成功的情况
			sequentialSearch(x);
		}
		time = System.currentTimeMillis()-time;
		long t1 = time,  c1 = compare;
		System.out.println("有序表顺序查找查找成功：花费时间为"+time+"ms，平均比较次数为"+compare/(float)m);
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n)+n;//查找失败的情况
			sequentialSearch(x);
		}
		time = System.currentTimeMillis()-time;
		long t2 = time, c2 = compare;
		System.out.println("有序表顺序查找查找失败：花费时间为"+time+"ms，平均比较次数为"+compare/(float)m);
		//无序表
		create(n,0);
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n);//查找成功的情况
			sequentialSearch(x);
		}
		time = System.currentTimeMillis()-time;
		System.out.println("无序表顺序查找查找成功：花费时间为"+time+"ms，平均比较次数为"+compare/(float)m);
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n)+n;//查找失败的情况
			sequentialSearch(x);
		}
		time = System.currentTimeMillis()-time;
		System.out.println("无序表顺序查找查找失败：花费时间为"+time+"ms，平均比较次数为"+compare/(float)m);
		
		//test2
		//顺序查找
		create(n,1);
		System.out.println("\n有序表顺序查找查找成功：花费时间为"+t1+"ms，平均比较次数为"+c1/(float)m);
		System.out.println("有序表顺序查找查找失败：花费时间为"+t2+"ms，平均比较次数为"+c2/(float)m);
		//二分查找
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n);//查找成功的情况
			binarySearch_nonRecursion(x);
		}
		time = System.currentTimeMillis()-time;
		long t3 = time, c3 = compare;
		System.out.println("有序表二分查找查找成功：花费时间为"+time+"ms，平均比较次数为"+compare/(float)m);
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n)+n;//查找失败的情况
			binarySearch_nonRecursion(x);
		}
		time = System.currentTimeMillis()-time;
		long t4 = time, c4 = compare;
		System.out.println("有序表二分查找查找失败：花费时间为"+time+"ms，平均比较次数为"+compare/(float)m);
		
		//test3
		//非递归
		System.out.println("\n有序表非递归二分查找查找成功：花费时间为"+t3+"ms，平均比较次数为"+c3/(float)m);
		System.out.println("有序表非递归二分查找查找失败：花费时间为"+t4+"ms，平均比较次数为"+c4/(float)m);
		//递归
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n);//查找成功的情况
			binarySearch_nonRecursion(x);
		}
		time = System.currentTimeMillis()-time;
		System.out.println("有序表递归二分查找查找成功：花费时间为"+time+"ms，平均比较次数为"+compare/(float)m);
		compare = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<m;i++) {
			int x = (int)(Math.random()*n)+n;//查找失败的情况
			binarySearch_nonRecursion(x);
		}
		time = System.currentTimeMillis()-time;
		System.out.println("有序表递归二分查找查找失败：花费时间为"+time+"ms，平均比较次数为"+compare/(float)m);
	}
	
	public static void main(String args[]) {
		new E08();
	}
}
