package pack;

import java.util.Scanner;

public class E05 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("please input x y:");
		int x = input.nextInt(),y = input.nextInt();
		//对(x,y)到(0,0)的距离进行判断，以10为分界输出答案
		if(Math.sqrt(x*x+y*y)<10)System.out.println("inside");
		else if(Math.sqrt(x*x+y*y)==10)System.out.println("on circle");
		else System.out.println("outside");
	}

}
