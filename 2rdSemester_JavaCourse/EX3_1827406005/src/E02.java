
public class E02 {

	public static void main(String[] args) {
		int cnt = 0,i = 2;//������2��ʼ
		do {
			boolean flag = true;
			for(int j = 2;j<=i/2;j++) {
				if(i%j==0) {
					flag = false;
					break;
				}
			}//ѭ����������i��2��i/2�������ӣ���i��������
			if(flag) {
				System.out.printf("%4d",i);
				cnt++;
				if(cnt%10==0)System.out.println();//��10����ʱ�������
			}
			i++;
		}while(cnt<50);

	}

}
