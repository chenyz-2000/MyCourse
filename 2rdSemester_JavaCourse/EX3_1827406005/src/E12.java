import java.util.Scanner;

public class E12 {
	static int cwin = 0,uwin = 0;
	static Scanner input = new Scanner(System.in);
	
	static void game() {//����Ҫ��ε�����Ϸ�Ĳ���������дһ����ͬ�ķ���
		int a = (int)(Math.random()*3);//���������
		System.out.print("please input 0, 1 or 2:");
		int b = input.nextInt();//�û�����
		
		if(a+1==b||a-2==b) {cwin++;System.out.println("computer wins");}
		else if(a-1==b||a+2==b) {uwin++;System.out.println("user wins");}
		else System.out.println("tie");
		//�ж�һ�غϵĽ�������
	}
	
	public static void main(String[] args) {
		System.out.print("input 1 to play 3/5 or 0 to play 2/3");
		int flag = input.nextInt();
		if(flag == 1) {
			while(true) {
				game();
				if(cwin>=3||uwin>=3)break;//�ﵽ��ʤ��������
			}
			if(cwin>=3)System.out.println("computer wins this game!");
			else System.out.println("user wins this game!");
		}
		else if(flag == 0) {
			while(true) {
				game();
				if(cwin>=2||uwin>=2)break;//�ﵽ��ʤ��������
			}
			if(cwin>=2)System.out.println("computer wins this game!");
			else System.out.println("user wins this game!");
		}
		

	}

}
