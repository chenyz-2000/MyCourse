
public class E08 {

	public static void main(String[] args) {
		double res = 0;
		for(int i = 1;i<=97;i+=2) {//以步长为2进行循环
			res+=(double)i/i+2;
		}
		System.out.println(res);
	}

}
