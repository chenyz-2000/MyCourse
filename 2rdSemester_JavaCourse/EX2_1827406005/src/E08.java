package pack;

import java.util.Scanner;

public class E08 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("please input year:");
		int year = input.nextInt();
		System.out.print("please input month:");
		int month = input.nextInt();
		System.out.print("please input day:");
		int day = input.nextInt();
		int h = (day+26*(month+1)/10+year%100+year%100/4+Math.abs(year)/100/4+5*Math.abs(year)/100)%7;
		//��������һ���Լ���h
		int res = (h+5)%7+1;//�����������
		System.out.printf("����%d\n",res);
	}

}
