import java.util.Scanner;

public class E15 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = 0, sum = 0;
		int nums[] = new int[1001];//����������Ϊ1000
		int t = input.nextInt();
		while(t!=0) {
			nums[++n]=t;//�����±��1��ʼ��n����ֵΪ������������
			sum+=t;
			t = input.nextInt();
		}
		double aver=sum/(double)n,ssum = 0;
		for(int i = 1;i<=n;i++) {
			ssum+=Math.pow(Math.abs(nums[i]-aver), 2);//��Ŀ�й�ʽ����
		}
		System.out.println(aver);
		System.out.println(ssum/n);
	}

}
