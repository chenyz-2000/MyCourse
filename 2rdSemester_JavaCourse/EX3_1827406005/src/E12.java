import java.util.Scanner;

public class E12 {
	static int cwin = 0,uwin = 0;
	static Scanner input = new Scanner(System.in);
	
	static void game() {//由于要多次调用游戏的操作，所以写一个共同的方法
		int a = (int)(Math.random()*3);//创建随机数
		System.out.print("please input 0, 1 or 2:");
		int b = input.nextInt();//用户输入
		
		if(a+1==b||a-2==b) {cwin++;System.out.println("computer wins");}
		else if(a-1==b||a+2==b) {uwin++;System.out.println("user wins");}
		else System.out.println("tie");
		//判断一回合的结果并输出
	}
	
	public static void main(String[] args) {
		System.out.print("input 1 to play 3/5 or 0 to play 2/3");
		int flag = input.nextInt();
		if(flag == 1) {
			while(true) {
				game();
				if(cwin>=3||uwin>=3)break;//达到三胜结束比赛
			}
			if(cwin>=3)System.out.println("computer wins this game!");
			else System.out.println("user wins this game!");
		}
		else if(flag == 0) {
			while(true) {
				game();
				if(cwin>=2||uwin>=2)break;//达到两胜结束比赛
			}
			if(cwin>=2)System.out.println("computer wins this game!");
			else System.out.println("user wins this game!");
		}
		

	}

}
