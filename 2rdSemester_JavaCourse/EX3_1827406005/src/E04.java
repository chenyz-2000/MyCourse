
public class E04 {

	public static void main(String[] args) {
		double n = 10000;
		for(int i = 0;i<n;i++) {
			n*=1.05;
		}
		System.out.println(n);
		double sum = n;//sum��Ϊ��ʮ����ѧ��
		for(int i = 0;i<3;i++) {//sum�����ٹ�3���ѧ��
			n*=1.05;
			sum+=n;
		}
		System.out.println(sum);
	}

}
