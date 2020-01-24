import java.io.*;
import java.util.Scanner;

public class E07 {
	int compare;
	int move;
	long time;
	int n;
	
	void create(int range,int model) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File("data.txt")));
			if(model == 1) {
				for(int i = 0;i<n;i++)out.append(i+" ");
			}
			else if(model ==-1) {
				for(int i = n-1;i>=0;i--)out.append(i+" ");
			}
			else if(model == 0) {
				for(int i = 0;i<n;i++) {
					int a = (int)(Math.random()*range);
					out.append(a+" ");
				}
			}
			out.close();
		}
		catch(Exception e) {}
	}
	
	int[] scan() {
		int[] res = new int[n];
		Scanner input = null;
		try {
			input = new Scanner(new File("data.txt"));
		} 
		catch (FileNotFoundException e) {}
		for(int i = 0;i<n;i++) {
			res[i] = input.nextInt();
		}
		return res;
	}
	
	void insertionSort() {
		int num[] = scan();
		compare = 0;
		move = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<n;i++) {
			int t = num[i];
			move++;
			int j;
			for(j = i-1;j>=0;j--) {
				compare++;
				if(t>=num[j])break;
				num[j+1] = num[j];
				move++;
			}
			num[j+1]=t;
			move++;
		}
		time = System.currentTimeMillis()-time;
	}
	
	void selectionSort() {
		int num[] = scan();
		compare = 0;
		move = 0;
		time = System.currentTimeMillis();
		for(int i = 0;i<n;i++) {
			int mini = i;
			for(int j = i+1;j<n;j++) {
				if(num[j]<num[i])mini = j;
				compare++;
			}
			if(mini!=i) {
				compare++;
				int t = num[i];
				num[i] = num[mini];
				num[mini] = t;
				move+=3;
			}
		}
		time = System.currentTimeMillis()-time;
	}
	
	void shellSort() {
		int num[] = scan();
		compare = 0;
		move = 0;
		time = System.currentTimeMillis();
		for(int k = n/2;k>0;k/=2) {
			for(int i = k;i<n;i++) {
				for(int j = i-k;j>=0;j-=k) {
					compare++;
					if(num[i]>=num[j])break;
					move++;
					num[j+k]=num[j];
				}
			}
		}
		time = System.currentTimeMillis()-time;
	}
	
	void merge(int[]num, int []order, int h, int m, int t) {
		int i = h,j = m+1,k = h;
		while(i<=m&&j<=t) {
			compare++;
			move++;
			if(num[i]<=num[j]) order[k++] = num[i++];
			else order[k++] = num[j++];
		}
		while(i<=m) {
			order[k++] = num[i++];
			compare++;
			move++;
		}
		while(j<=t) {
			order[k++] = num[j++];
			compare++;
			move++;
		}
	}
	void mergepass(int[]num, int[]order, int s, int n) {
		int p = 0;
		while(p+2*s-1<=n-1) {
			merge(num, order, p, p+s-1,p+2*s-1);
			p+=2*s;
		}
		if(p+s-1<n-1) {
			merge(num,order,p,p+s-1,n-1);
		}
		else {
			for(int i = p;i<=n-1;i++) {
				move++;
				order[i] = num[i];
			}
		}
	}
	void mergingSort() {
		int num[] = scan();
		compare = 0;
		move = 0;
		time = System.currentTimeMillis();
		int s = 1;
		int n = num.length;
		int[]temp = new int[n];
		while(s<n) {
			mergepass(num,temp,s,n);
			s*=2;
			mergepass(temp,num,s,n);
			s*=2;
		}
		time = System.currentTimeMillis()-time;
	}
	
	int partition(int[]num, int i, int j) {
		int t = num[i];
		while(i<j) {
			while(i<j) {
				compare++;
				if(t>num[j])break;
				j--;
			}
			if(i<j) {
				move++;
				num[i] = num[j];
				i++;
			}
			while(i<j) {
				compare++;
				if(t<=num[i])break;
				i++;
			}
			if(i<j) {
				move++;
				num[j] = num[i];
				j--;
			}
		}
		num[i] = t;
		return i;
	}
	void qsort(int []num, int low, int high) {
		if(low<high) {
			int t = partition(num,low,high);
			qsort(num, low,t-1);
			qsort(num, t+1,high);
		}
	}
	void quickSort() {
		int num[] = scan();
		compare = 0;
		move = 0;
		time = System.currentTimeMillis();
		qsort(num, 0, n-1);
		time = System.currentTimeMillis()-time;
	}
	
	void sift(int[]num, int low, int high) {
		int i = low;
		int j = 2*i+1;
		int t = num[i];
		while(j<high) {
			if(j<high-1) {
				compare++;
				if(num[j]<=num[j+1])break;
				j++;
			}
			if(t>num[j]) {
				compare++;
				move++;
				num[i] = num[j];
				i = j;
				j = 2*i+1;
			}
			else {
				j = high+1;
			}
		}
		move++;
		num[i] = t;
	}
	void heapSort() {
		int num[] = scan();
		compare = 0;
		move = 0;
		time = System.currentTimeMillis();
		int n = num.length;
		int t;
		for(int i = n/2-1;i>=0;i--) {
			sift(num,i,n);
		}
		for(int i = n-1;i>0;i--) {
			t = num[0];
			num[0] = num[i];
			num[i] = t;
			sift(num,0,i);
		}
		time = System.currentTimeMillis()-time;
	}
	
	void repeat(){
		insertionSort();
		System.out.println("插入排序时间为"+time+"ms，比较次数为"+compare+"，移动次数为"+move);
		selectionSort();
		System.out.println("选择排序时间为"+time+"ms，比较次数为"+compare+"，移动次数为"+move);
		shellSort();
		System.out.println("希尔排序时间为"+time+"ms，比较次数为"+compare+"，移动次数为"+move);
		mergingSort();
		System.out.println("归并排序时间为"+time+"ms，比较次数为"+compare+"，移动次数为"+move);
		quickSort();
		System.out.println("快速排序时间为"+time+"ms，比较次数为"+compare+"，移动次数为"+move);
		heapSort();
		System.out.println("堆排序时间为"+time+"ms，比较次数为"+compare+"，移动次数为"+move);
	}
	
	E07(){
		n = 10000;
		System.out.println("顺序：");
		create(n,1);//顺序
		repeat();
		System.out.println("\n逆序：");
		create(n,-1);//逆序
		repeat();
		System.out.println("\n随机：");
		create(n,0);//随机
		repeat();
	}
	
	public static void main(String args[]) {
		new E07();
	}
}
