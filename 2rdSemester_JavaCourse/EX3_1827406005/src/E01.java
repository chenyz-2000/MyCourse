import java.util.Scanner;
		
public class E01 {
	static Scanner input = new Scanner(System.in);
	static int n,range,sum = 0;
	
	static void process(String x) {//�ѳ�����жϵĲ�����ȡ��������
		int a = (int)(Math.random()*range+1), b = (int)(Math.random()*range+1);
		System.out.printf("%d%s%d=",a,x,b);
		boolean corr=false;
		int t = input.nextInt();
		//Ҫ��.contentEquals������==�Ƚϵ�������
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
			
			if(s.length()==1) process(s);//���������������
			else if(s.contentEquals("+-")) {//+-���������������
				if(Math.random()+0.5>1)process("+");
				else process("-");
				//�������+��-
			}
			else if(s.contentEquals("mix")) {//���
				int t = (int)(Math.random()*4);
				switch(t) {
					case 0:process("+");break;
					case 1:process("-");break;
					case 2:process("*");break;
					case 3:process("/");break;
				}
				//��������ĸ������֮һ
			}
		}
		System.out.println("the point is"+sum);
	}
}
