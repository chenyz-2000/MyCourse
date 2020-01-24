import java.util.Scanner;
		
public class E01 {
	static Scanner input = new Scanner(System.in);
	static int n,range,sum = 0;
	
	static void process(String x) {//把出题和判断的部分提取到函数中
		int a = (int)(Math.random()*range+1), b = (int)(Math.random()*range+1);
		System.out.printf("%d%s%d=",a,x,b);
		boolean corr=false;
		int t = input.nextInt();
		//要用.contentEquals方法，==比较的是引用
		if((x.contentEquals("+")&&t==a+b)||(x.contentEquals("-")&&t==a-b)
				||(x.contentEquals("*")&&t==a*b)||(x.contentEquals("/")&&t==a/b)){
			corr=true;
		}
		if(corr) {sum++;System.out.println("correct");}
		else System.out.println("wrong");
	}
	
	public static void main(String args[]) {
		System.out.print("please input n:");
		n = input.nextInt();
		
		for(int i = 0;i<n;i++) {
			System.out.print("please input range:");
			range = input.nextInt();
			System.out.print("choose +, -, +-, *, / or mix:");
			String s = input.next();
			
			if(s.length()==1) process(s);//单个运算符的情形
			else if(s.contentEquals("+-")) {//+-两个运算符的情形
				if(Math.random()+0.5>1)process("+");
				else process("-");
				//随机产生+或-
			}
			else if(s.contentEquals("mix")) {//混合
				int t = (int)(Math.random()*4);
				switch(t) {
					case 0:process("+");break;
					case 1:process("-");break;
					case 2:process("*");break;
					case 3:process("/");break;
				}
				//随机生成四个运算符之一
			}
		}
		System.out.println("the point is"+sum);
	}
}
