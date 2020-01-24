public class E02 {
	public static double m1(int x) {
		double res = 0;
		for(int i = 1;i<=x;i++) {
			res+=(double)i/(i+1);
		}
		return res;
	}
	
	public static double m2(int x) {
		double res = 0;
		for(int i = 1;i<=x;i++) {
			res+=Math.pow(-1, i+1)/(2*i-1);//Math.pow返回double，不需要强制转换
		}
		return res*4;
	}
	
	public static void main(String[] args) {
		System.out.println("i		m(i)");
		for(int i= 1;i<=20;i++) {
			System.out.printf("%d\t\t%.4f\n", i,m1(i));
		}
		System.out.println("\ni		m(i)");
		for(int i = 1;i<=901;i+=100) {//从1到901，以100为步长循环
			System.out.printf("%d\t\t%.4f\n",i,m2(i));
		}
	}

}
