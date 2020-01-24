
public class E05 {

	public static void main(String[] args) {
		int cnt = 0;
		for(int i = 100;i<=200;i++) {
			if((i%6==0||i%5==0)&&i%30!=0) {
				cnt++;
				System.out.printf("%4d",i);
				if(cnt%10==0)System.out.println();//Ã¿10¸ö»»ÐÐ
			}
		}

	}

}
