package pack;

import java.util.Scanner;

public class E04 {
	public static void main(String[] args) {
		final int secPerYear=31536000;
		long people,sec;
		
		people = 312032486;
		for(int i = 1;i<=5;i++) {//输出从第1到第5年的人口数据
			sec = i*secPerYear;//计算i年一共的秒数
			System.out.println(people+sec/7-sec/13+sec/45);//计算人口数
		}
		
		Scanner input = new Scanner(System.in);//创建Scanner的对象
		int year = input.nextInt();
		people = input.nextLong();//读取数据
		sec = year*secPerYear;
		System.out.println(people + sec/7 - sec/13 + sec/45);
	}
}