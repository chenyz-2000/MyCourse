import java.util.Scanner;

public class E13 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		int max=0, times=1;
		while(t!=0) {//ֱ��tΪ0ʱ��ֹѭ��
			if(t>max) {//���¶�����������������������������£�����Ϊ1
				max = t;
				times = 1;
			}
			else if(t==max) {//���¶���������������������������1
				times++;
			}
			t = input.nextInt();//ÿ��ѭ���������t��ֵ
		}
		System.out.println("�����Ϊ"+max+"�����ִ���Ϊ"+times);
	}

}
