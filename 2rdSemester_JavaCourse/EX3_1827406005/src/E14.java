public class E14 {

	public static void main(String[] args) {
		double res = 0;
		for(int i = 1;i<=624;i++) {
			res+=1.0/(Math.sqrt(i)+Math.sqrt(i+1));
			//直接调用Math.sqrt函数求平方根
		}
		System.out.println(res);
	}

}
