
public class E09 {

	public static void main(String[] args) {
		double res = 1, a = 1;
		for(int i = 1;i<=100000;i++) {
			a/=i;//���ÿһ���ֵ
			res+=a;
			if(i%10000==0)System.out.println(res);//�ж����
		}

	}

}
