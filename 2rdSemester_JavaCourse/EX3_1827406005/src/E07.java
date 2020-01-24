import java.util.Scanner;

public class E07 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("请输入贷款总金额:");
		int money = input.nextInt();
		System.out.print("请输入贷款期限:");
		int year = input.nextInt();
		System.out.println("利率		月供		总支付金额");
		
		double rate = 0.05, pay;
		while(rate<=0.08+1e-5) {//避免浮点数误差
			pay = money*rate/12/(1-Math.pow(1+rate/12,-1*year*12));//计算月支付额
			System.out.printf("%.3f	%.2f	%.2f\n",rate*100,pay,pay*12*year);
			rate+=0.00125;//控制循环
		}
	}

}
