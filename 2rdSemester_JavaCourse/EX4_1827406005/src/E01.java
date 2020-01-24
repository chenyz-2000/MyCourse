import java.util.Scanner;

public class E01 {
	public static int reverse(int number) {
		int res = 0;
		while(number>0) {//����number��������
			res=res*10+number%10;
			number/=10;
		}
		return res;
	}
	
	public static boolean isPalindrome(int number) {
		return number==reverse(number);//����true��false
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("please input one number:");
		int num = input.nextInt();
		System.out.println(isPalindrome(num));
	}

}
