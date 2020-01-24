import java.io.IOException;
import java.util.Scanner;

public class E03 {
	public String input;
	public int ind = 0;
	
	public void display(String s, String[] sta) {
		System.out.println("�Ѷ�ȡ���ַ���"+s);
		System.out.print("��ǰһ���ջ��");
		for(int i = 0;i<sta.length&&sta[i]!=null;i++) System.out.print(sta[i]+"   ");
		System.out.println("\n");
	}
	
	public double calcuBracket() {
		String temp = "";
		String sta[] = new String[50];
		int p = 0;
		while(true) {
			char c = input.charAt(ind);
			ind++;
			if(c=='(') temp=String.valueOf(calcuBracket());//�ݹ飬������������ֵ
			else if(c=='.'||'0'<=c&&c<='9')temp+=c;//�������
			else if(c=='+'||c=='-'||c=='*'||c=='/'||c=='#'||c==')') {//���ֱ߽�
				if(!temp.equals(""))sta[p++]=temp;
				temp = "";
				display(input.substring(0,ind),sta);
				if(p!=1) {//����ǰ��������ȴ�����
					if((sta[p-2].equals("+")||sta[p-2].equals("-"))&&(c=='+'||c=='-')) {//��ǰһ���������
						
						double a = Double.parseDouble(sta[p-3]),b = Double.parseDouble(sta[p-1]);
						if(sta[p-2].equals("+"))	sta[p-3]=String.valueOf(a+b);
						else sta[p-3]=String.valueOf(a-b);
						p-=2;
						sta[p]=sta[p+1]=null;
					}
					else if((sta[p-2].equals("*")||sta[p-2].equals("/"))) {//ֱ����ǰһ����������
						//����������г˳�����
						double a = Double.parseDouble(sta[p-3]),b = Double.parseDouble(sta[p-1]);
						if(sta[p-2].equals("*"))	sta[p-3]=String.valueOf(a*b);
						else sta[p-3]=String.valueOf(a/b);
						p-=2;
						sta[p]=sta[p+1]=null;
					}
				}
				if(c=='#'||c==')') {//������else if
					//����Ƿ��мӼ�����Ҫ���������ж����
					//�������Ժ�return
					while(p!=1) {
						double a = Double.parseDouble(sta[p-3]),b = Double.parseDouble(sta[p-1]);
						if(sta[p-2].equals("+"))	sta[p-3]=String.valueOf(a+b);
						else sta[p-3]=String.valueOf(a-b);
						p-=2;
						sta[p]=sta[p+1]=null;
					}
					return Double.parseDouble(sta[0]);
				}
				if(c!='#'&&c!=')')sta[p++]=String.valueOf(c);
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		E03 exe = new E03();
		exe.input = scan.nextLine();
		double res = exe.calcuBracket();
		if(Math.abs(Math.round(res)-res)<1e-8)System.out.printf("%.0f\n",res);
		else System.out.println(res);
	}
}
