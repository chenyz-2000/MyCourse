
public class E02 {

	public static void main(String[] args) {
		int cnt = 0,i = 2;//素数从2开始
		do {
			boolean flag = true;
			for(int j = 2;j<=i/2;j++) {
				if(i%j==0) {
					flag = false;
					break;
				}
			}//循环遍历，若i在2到i/2间有因子，则i不是素数
			if(flag) {
				System.out.printf("%4d",i);
				cnt++;
				if(cnt%10==0)System.out.println();//满10个数时输出换行
			}
			i++;
		}while(cnt<50);

	}

}
