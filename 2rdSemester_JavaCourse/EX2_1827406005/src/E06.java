package pack;

import java.util.Scanner;

public class E06 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("please input the weight:");
		double w = input.nextDouble();
		//根据w值条件判断
		if(0<w&&w<=1)System.out.println(3.5);
		else if(1<w&&w<=3)System.out.println(5.5);
		else if(3<w&&w<=10)System.out.println(8.5);
		else if(10<w&&w<=20)System.out.println(10.5);
		else System.out.println("the package cannot be shipped");
	}

}