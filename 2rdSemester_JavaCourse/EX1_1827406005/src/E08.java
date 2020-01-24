package pack;

import java.util.Scanner;

public class E08 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double m = input.nextDouble()/0.45359237;//读取数据并计算，使用结果对变量赋初值
		double h = input.nextDouble()/0.0254;
		System.out.println(m/(h*h));
	}

}
