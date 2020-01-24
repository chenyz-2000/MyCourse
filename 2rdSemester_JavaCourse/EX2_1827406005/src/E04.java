package pack;

import java.util.Scanner;

public class E04 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int computer = (int)Math.random()*3;//产生0，1，2中的随机数
		System.out.print("please input 0,1 or 2:");
		int user = input.nextInt();
		//接下来评判结果
		if(computer==user)System.out.println("tie");
		else if(computer==user-1||computer==user+2)System.out.println("computer wins");
		else System.out.println("user wins");
	}

}
