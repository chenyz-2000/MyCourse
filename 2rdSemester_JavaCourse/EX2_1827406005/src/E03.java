package pack;

import java.util.Scanner;

public class E03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("please input a three-digit integer:");
		int num = input.nextInt();
		if(num%10==num/100)System.out.println("YES");//num%10�����λ����num/100�����λ��
		else System.out.println("NO");
	}

}
