public class E11 {
	static boolean solve(int x) {//��д�����ж�ĳ���Ƿ�Ϊ��ȫ��
		int sum = 0;
		for(int i = 1;i<x;i++) {
			if(x%i==0) {
				sum+=i;
				if(sum>x)return false;
			}
		}
		if(sum==x)return true;
		return false;
	}
	
	public static void main(String[] args) {
		for(int i = 1;i<=10000;i++) {//���ζ�����������solve��������
			if(solve(i)) System.out.println(i);//�жϽ��Ϊtrue�����ֽ������
		}

	}

}
