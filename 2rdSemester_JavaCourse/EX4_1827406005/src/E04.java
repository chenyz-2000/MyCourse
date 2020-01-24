public class E04 {
	public static int point() {//随机返回两个骰子和的结果
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
			while(b!=a&&b!=7) b = point();//当决出胜负时停止循环，接下来进行判断
			if(b==a) System.out.println("win");
			else System.out.println("lose");
		}
	}

}
