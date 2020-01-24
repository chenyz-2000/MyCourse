import java.util.Scanner;
import java.math.BigInteger;

class Sqlist{
	private Object[] listElem;
	private int curlen;
	public Sqlist(int maxSize) {
		curlen = 0;
		listElem = new Object[maxSize];
	}
	public void clear() {
		curlen = 0;
	}
	public boolean isEmpty() {
		return curlen==0;
	}
	public int length() {
		return curlen;
	}
	public Object get(int i)throws Exception{
		if(i<0||i>curlen-1) {
			throw new Exception("元素不存在");
		}
		return listElem[i];
	}
	public void insert(int i,Object x)throws Exception {
		if(curlen==listElem.length)throw new Exception("顺序表已满");
		if(i<0||i>curlen)throw new Exception("插入位置不合法");
		for(int j = curlen;j>i;j--) {
			listElem[j] = listElem[j-1];
		}
		listElem[i] = x;
		curlen++;
	}
	public void remove(int i) throws Exception{
		if(i<0||i>curlen-1)throw new Exception("删除位置不合法");
		for(int j = i;j<curlen-1;j++) listElem[j] = listElem[j+1];
		curlen--;
	}
	public int indexOf(Object x) {
		int j = 0;
		while(j<curlen&&!listElem[j].equals(x))j++;
		if(j<curlen)return j;
		return -1;
	}
	public void display() {
		for(int j = 0;j<curlen;j++) {
			System.out.print(listElem[j]+" ");
		}
		System.out.println();
	}
}

class Node{
	public Object data;
	public Node next;
	public Node() {this(null,null);}
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
}
class LinkList {
	public Node head;
	public LinkList() {head = new Node();}
	public LinkList(int n)throws Exception {
		this();
		create(n);
	}
	public void create(int n)throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int j = 0;j<n;j++) {
			insert(length(),sc.next());
		}
	}
	public void clear() {
		head.data = null;
		head.next = null;
	}
	public boolean isEmpty() {
		return head.next==null;
	}
	public int length() {
	Node p = head.next;
		int length = 0;
		while(p!=null) {
			p = p.next;
			length++;
		}
		return length;
	}
	public Object get(int i) throws Exception{
		Node p = head.next;
		int j = 0;
		while(p!=null&&j<i) {
			p = p.next;
			j++;
		}
		if(j>i||p==null) {
			throw new Exception("元素不存在");
		}
		return p.data;
	}
	public void insert(int i, Object x)throws Exception{
		Node p = head;
		int j = -1;
		while(p!=null&&j<i-1) {
			p = p.next;
			j++;
		}
		if(j>i-1||p==null)throw new Exception("位置不合法");
		Node s = new Node(x,null);
		s.next = p.next;
		p.next = s;
	}
	public void remove(int i) throws Exception{
		Node p = head;
		int j = -1;
		while(p.next!=null&&j<i-1) {
			p = p.next;
			j++;
		}
		if(j>i-1||p.next==null) {
			throw new Exception("删除位置不合法");
		}
		p.next = p.next.next;
	}
	public void display() {
		Node node = head.next;
		while(node!=null) {
			System.out.print(node.data+"  ");
			node = node.next;
		}
		System.out.println();
	}
}

public class E02 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int cap = 20;
		int a[] = new int[cap];
		int b[] = new int[cap];
		int sum[] = new int [cap*2];
		String a0 = scan.next();
		String b0 = scan.next();
		int ind = 0;
		for(int i = a0.length()-1;i>=0;i--) {
			a[ind++]=a0.charAt(i)-'0';
		}
		ind = 0;
		for(int i = b0.length()-1;i>=0;i--) {
			b[ind++]=b0.charAt(i)-'0';
		}
		int len = Math.max(a0.length(), b0.length());
		//sum
		for(int i = 0;i<len;i++) {
			sum[i]+=a[i]+b[i];
			if(sum[i]>=10) {
				sum[i]-=10;
				sum[i+1]++;
			}
		}
		System.out.print("The sum is:  ");
		if(sum[len]!=0)System.out.print(sum[len]);
		for(int i = len-1;i>=0;i--)System.out.print(sum[i]);
		//difference
		int bigger[]=a,smaller[]=a;
		for(int i = len-1;i>=0;i--) {
			if(a[i]<b[i]) {
				bigger = b;
				break;
			}
			else if(a[i]>b[i]) {
				smaller = b;
				break;
			}
		}
		int diff[] = new int[cap];
		for(int i = len-1;i>=0;i--) {
			diff[i] = bigger[i]-smaller[i];
			int j = i;
			while(diff[j]<0) {
				diff[j]+=10;
				diff[++j]--;
			}
		}
		while(diff[len]==0&&len>0)len--;
		System.out.print("\nThe difference is:  ");
		for(int i = len;i>=0;i--)System.out.print(diff[i]);
		//product
		int pro[] = new int[cap*cap];
		len = a0.length()*b0.length();
		for(ind = 0;ind<len;ind++) {
			for(int i = 0;i<Math.min(ind+1, a0.length());i++) {
				if(ind-i>=b0.length())continue;
				pro[ind]+=a[i]*b[ind-i];
			}
			while(pro[ind]>=10) {
				pro[ind]-=10;
				pro[ind+1]++;
			}
		}
		while(pro[len]==0&&len>0)len--;
		System.out.print("\nThe product is:  ");
		for(int i = len;i>=0;i--)System.out.print(pro[i]);		
	}
}
