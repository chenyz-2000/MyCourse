package pack;

public class E07 {

	public static void main(String[] args) {
		double money = 0;
		for(int i = 0;i<6;i++) {//ѭ��ʵ��6�β���
			money = (money+100)*1.00417;
		}
		System.out.printf("%.3f\n",money);
	}

}
