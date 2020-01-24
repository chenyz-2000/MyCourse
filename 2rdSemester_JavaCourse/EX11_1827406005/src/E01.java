import java.io.*;
import java.util.*;

public class E01 {
	public static void main(String [] args) {
		LinkedHashSet<String> A = new LinkedHashSet<String>();//从第一个文件读取的单词
		LinkedHashSet<String> B = new LinkedHashSet<String>();//从第二个文件读取的单词
		LinkedHashSet<String>union = new LinkedHashSet<String>();//并集
		LinkedHashSet<String>differ = new LinkedHashSet<String>();//差集
		LinkedHashSet<String>inter = new LinkedHashSet<String>();//交集
		Scanner scan;
		String s;
		
		/*使用Scanner从文件中读取字符串*/
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
				differ.add(s);//把所有字符串加入并集和差集
				if(A.contains(s)) {//两个文件重复的字符串，加入交集，并从差集中删去
					differ.remove(s);
					inter.add(s);
				}		
			}
		}
		catch (Exception e) {}
		
		/*使用迭代器输出*/
		Iterator iter;
		iter = union.iterator();
		System.out.println("A与B的并集为：");
		while(iter.hasNext())System.out.print(iter.next()+"\t");
		iter = differ.iterator();
		System.out.println("\nA与B的差集为：");
		while(iter.hasNext())System.out.print(iter.next()+"\t");
		iter = inter.iterator();
		System.out.println("\nA与B的交集为：");
		while(iter.hasNext())System.out.print(iter.next()+"\t");
	}
}
