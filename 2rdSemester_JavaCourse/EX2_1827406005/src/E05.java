package pack;

import java.util.Scanner;

public class E05 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("please input x y:");
		int x = input.nextInt(),y = input.nextInt();
		//��(x,y)��(0,0)�ľ�������жϣ���10Ϊ�ֽ������
		if(Math.sqrt(x*x+y*y)<10)System.out.println("inside");
		else if(Math.sqrt(x*x+y*y)==10)System.out.println("on circle");
		else System.out.println("outside");
	}

}
