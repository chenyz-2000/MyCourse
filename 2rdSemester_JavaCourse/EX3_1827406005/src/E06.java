import java.util.Scanner;

public class E06 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("please input n:");
		int n = input.nextInt();
		for(int i = 1;i<=n;i++) {//��������
			for(int j = 1;j<2*n;j++) {//��������
				if(Math.abs(j-n)<i) {//�ں��ʵ�λ���������
					System.out.printf("%4d",Math.abs(j-n)+1);
				}
				else System.out.print("    ");
			}
			System.out.println();
		}
	}

}
