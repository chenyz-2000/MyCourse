import java.util.Scanner;

public class E03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(),positive = 0,negative = 0,sum = 0,cnt = 0;
		if(n==0)cnt = 1;//��ֹ��ĸΪ0��������
		while(n!=0) {//ÿ��ȡһ�����֣������ж���������͡������Ĳ���
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
