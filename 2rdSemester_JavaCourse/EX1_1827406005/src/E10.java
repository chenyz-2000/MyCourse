package pack;

import java.util.Scanner;

public class E10 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double ta = input.nextDouble(),v = input.nextDouble();
		System.out.println(35.74+0.62145*ta-35.75*Math.pow(v, 0.16)+0.4275*ta*Math.pow(v, 0.16));
		//将泽勒一致性转化为代码语言
	}

}
