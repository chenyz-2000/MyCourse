package pack;

public class E01 {

	public static void main(String[] args) {
		int month = (int)Math.random()*12+1;//随机产生1-12的整数
		switch(month) {//运用switch语句，按month的值进行条件判断
			case 1:System.out.println("January");break;//break终止该轮条件判断，下同
			case 2:System.out.println("February");break;
			case 3:System.out.println("March");break;
			case 4:System.out.println("April");break;
			case 5:System.out.println("May");break;
			case 6:System.out.println("June");break;
			case 7:System.out.println("July");break;
			case 8:System.out.println("Auguest");break;
			case 9:System.out.println("September");break;
			case 10:System.out.println("October");break;
			case 11:System.out.println("November");break;
			case 12:System.out.println("December");break;
		}

	}

}
