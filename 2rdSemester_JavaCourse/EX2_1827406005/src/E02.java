package pack;

import java.util.Scanner;

public class E02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int nums[] = new int[9];//����������ǰ9����
		int sum = 0;
		for(int i = 0;i<9;i++) {//ѭ������ǰ9������������sum
			System.out.printf("please input the %d-th number:",i+1);
			int t = input.nextInt();
			sum+=t*(i+1);
			nums[i]=t;
		}
		int x = sum%11;//�����ʮ����
		for(int i:nums) {//ѭ�����ǰ9����
			System.out.print(i);
		}
		if(x==10)System.out.println("X");//�����һλ�����ж�
		else System.out.println(x);
	}

}