package pack;

public class E07 {

	public static void main(String[] args) {
		double money = 0;
		for(int i = 0;i<6;i++) {//循环实现6次操作
			money = (money+100)*1.00417;
		}
		System.out.printf("%.3f\n",money);
	}

}
