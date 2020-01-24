package pack;

import java.util.Scanner;

public class E03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("please input a three-digit integer:");
		int num = input.nextInt();
		if(num%10==num/100)System.out.println("YES");//num%10代表个位数，num/100代表百位数
		else System.out.println("NO");
	}

}
