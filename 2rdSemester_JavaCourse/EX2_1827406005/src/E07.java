package pack;

import java.util.Scanner;

public class E07 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("please input x1 y1:");
		double x1 = input.nextDouble(),y1 = input.nextDouble();
		System.out.print("please input x2 y2:");
		double x2 = input.nextDouble(),y2 = input.nextDouble();
		System.out.print("please input a1 b1:");
		double a1 = input.nextDouble(),b1 = input.nextDouble();
		System.out.print("please input a2 b2:");
		double a2 = input.nextDouble(),b2 = input.nextDouble();
		
		if((x2+a2/2<=x1+a1/2)&&(x2-a2/2>=x1-a1/2)&&(y2+b2/2<=y1+b1/2)&&(y2-b2/2>=y1-b1/2))
			System.out.println("�ڶ��������ڵ�һ�����ε��ڲ�");
		else if(Math.abs(x1-x2)>(a1/2+a2/2)||Math.abs(y1-y2)>(b1/2+b2/2))
			System.out.println("�ڶ��������ڵ�һ�����ε��ⲿ");
		else 
			System.out.println("���ص�");
		//�Ա����������ⲿ���ص���ⲻ�壬���Լ���һ�������������ж�
	}

}
