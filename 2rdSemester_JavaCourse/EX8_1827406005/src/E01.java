import java.util.Scanner;

public class E01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();//��ȡÿ�������ַ���
		String str = s.replaceAll("[^\\p{Alnum}]", "");//����ֻ����ĸ�����ֵ��ַ���
		StringBuilder sb = new StringBuilder(str);
		String str_reverse = sb.reverse().toString();//ͨ��StringBuilder���ַ�������
		System.out.println(str.equals(str_reverse));//�ж��Ƿ����
	}
}