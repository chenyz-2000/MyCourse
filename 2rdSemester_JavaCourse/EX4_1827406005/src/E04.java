public class E04 {
	public static int point() {//��������������Ӻ͵Ľ��
		int res = (int)(Math.random()*6)+(int)(Math.random()*6)+2;
		System.out.println(res);
		return res;
	}
	
	public static void main(String[] args) {
		int a = point();
		if(a==2||a==3||a==12)System.out.println("lose");
		else if(a==7||a==11)System.out.println("win");
		else {
			int b = point();
			while(b!=a&&b!=7) b = point();//������ʤ��ʱֹͣѭ���������������ж�
			if(b==a) System.out.println("win");
			else System.out.println("lose");
		}
	}

}
