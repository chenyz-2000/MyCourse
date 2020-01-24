import java.util.Scanner;

public class E01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();//读取每行输入字符串
		String str = s.replaceAll("[^\\p{Alnum}]", "");//返回只含字母和数字的字符串
		StringBuilder sb = new StringBuilder(str);
		String str_reverse = sb.reverse().toString();//通过StringBuilder将字符串倒序
		System.out.println(str.equals(str_reverse));//判断是否回文
	}
}