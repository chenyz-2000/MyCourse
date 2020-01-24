import java.util.Scanner;

public class E10 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double money, rate;
		int month;
		System.out.print("please input money:");
		money = input.nextDouble();
		System.out.print("please input rate:");
		rate = input.nextDouble();
		System.out.print("please input month:");
		month = input.nextInt();
		
		double r = 1+rate/1200, res = 0;
		for(int i = 0;i<month;i++) {
			res=(money+res)*r;
			//每个月的钱数等于上个月总和与新存入金额求和，再乘以系数
		}
		System.out.println(res);
	}

}
