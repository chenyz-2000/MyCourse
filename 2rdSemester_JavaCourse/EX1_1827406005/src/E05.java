package pack;

import java.util.Scanner;

public class E05 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int v0 = input.nextInt(),v1 = input.nextInt();
		double t = input.nextDouble();
		System.out.println((v1-v0)/t);
	}

}
