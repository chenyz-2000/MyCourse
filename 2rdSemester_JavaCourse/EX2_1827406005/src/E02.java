package pack;

import java.util.Scanner;

public class E02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int nums[] = new int[9];//创建数组存放前9个数
		int sum = 0;
		for(int i = 0;i<9;i++) {//循环输入前9个数，并计算sum
			System.out.printf("please input the %d-th number:",i+1);
			int t = input.nextInt();
			sum+=t*(i+1);
			nums[i]=t;
		}
		int x = sum%11;//计算第十个数
		for(int i:nums) {//循环输出前9个数
			System.out.print(i);
		}
		if(x==10)System.out.println("X");//对最后一位进行判断
		else System.out.println(x);
	}

}