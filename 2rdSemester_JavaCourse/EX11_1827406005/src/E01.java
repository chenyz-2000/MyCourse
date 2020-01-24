import java.io.*;
import java.util.*;

public class E01 {
	public static void main(String [] args) {
		LinkedHashSet<String> A = new LinkedHashSet<String>();//�ӵ�һ���ļ���ȡ�ĵ���
		LinkedHashSet<String> B = new LinkedHashSet<String>();//�ӵڶ����ļ���ȡ�ĵ���
		LinkedHashSet<String>union = new LinkedHashSet<String>();//����
		LinkedHashSet<String>differ = new LinkedHashSet<String>();//�
		LinkedHashSet<String>inter = new LinkedHashSet<String>();//����
		Scanner scan;
		String s;
		
		/*ʹ��Scanner���ļ��ж�ȡ�ַ���*/
		try {
			scan = new Scanner(new File("A.txt"));
			while(scan.hasNext()) {
				s = scan.next();
				A.add(s);
				union.add(s);
				differ.add(s);
			}
			scan = new Scanner(new File("B.txt"));
			while(scan.hasNext()) {
				s = scan.next();
				B.add(s);
				union.add(s);
				differ.add(s);//�������ַ������벢���Ͳ
				if(A.contains(s)) {//�����ļ��ظ����ַ��������뽻�������Ӳ��ɾȥ
					differ.remove(s);
					inter.add(s);
				}		
			}
		}
		catch (Exception e) {}
		
		/*ʹ�õ��������*/
		Iterator iter;
		iter = union.iterator();
		System.out.println("A��B�Ĳ���Ϊ��");
		while(iter.hasNext())System.out.print(iter.next()+"\t");
		iter = differ.iterator();
		System.out.println("\nA��B�ĲΪ��");
		while(iter.hasNext())System.out.print(iter.next()+"\t");
		iter = inter.iterator();
		System.out.println("\nA��B�Ľ���Ϊ��");
		while(iter.hasNext())System.out.print(iter.next()+"\t");
	}
}
