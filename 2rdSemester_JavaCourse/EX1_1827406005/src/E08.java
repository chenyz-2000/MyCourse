package pack;

import java.util.Scanner;

public class E08 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double m = input.nextDouble()/0.45359237;//��ȡ���ݲ����㣬ʹ�ý���Ա�������ֵ
		double h = input.nextDouble()/0.0254;
		System.out.println(m/(h*h));
	}

}
