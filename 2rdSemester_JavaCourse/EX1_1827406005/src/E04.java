package pack;

import java.util.Scanner;

public class E04 {
	public static void main(String[] args) {
		final int secPerYear=31536000;
		long people,sec;
		
		people = 312032486;
		for(int i = 1;i<=5;i++) {//����ӵ�1����5����˿�����
			sec = i*secPerYear;//����i��һ��������
			System.out.println(people+sec/7-sec/13+sec/45);//�����˿���
		}
		
		Scanner input = new Scanner(System.in);//����Scanner�Ķ���
		int year = input.nextInt();
		people = input.nextLong();//��ȡ����
		sec = year*secPerYear;
		System.out.println(people + sec/7 - sec/13 + sec/45);
	}
}