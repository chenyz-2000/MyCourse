import java.util.Scanner;

public class E03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(),positive = 0,negative = 0,sum = 0,cnt = 0;
		if(n==0)cnt = 1;//防止分母为0产生错误
		while(n!=0) {//每读取一个数字，进行判断正负、求和、计数的操作
			if(n>0)positive++;
			else if(n<0)negative++;
			sum+=n;
			cnt++;
			n = input.nextInt();
		}
		System.out.println(positive);
		System.out.println(negative);
		System.out.println(sum);
		System.out.println((double)sum/cnt);
	}

}
