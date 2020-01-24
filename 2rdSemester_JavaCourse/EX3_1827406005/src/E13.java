import java.util.Scanner;

public class E13 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		int max=0, times=1;
		while(t!=0) {//直到t为0时终止循环
			if(t>max) {//当新读入的数大于已有最大数，最大数更新，次数为1
				max = t;
				times = 1;
			}
			else if(t==max) {//当新读入的数等于已有最大数，次数加1
				times++;
			}
			t = input.nextInt();//每次循环过后更新t的值
		}
		System.out.println("最大数为"+max+"，出现次数为"+times);
	}

}
