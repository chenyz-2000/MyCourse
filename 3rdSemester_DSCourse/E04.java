import java.util.*;

public class E04 {
	public static void main(String args[]) {
		int n = 5;
		int A0[]  = {2,3,5,6,1};
		int B0[] = {1,5,4,2,9};
		Queue<Integer>A  = new LinkedList<>();
		Queue<Integer>B = new LinkedList<>();
		int played[] = new int[50];
		int len = 0;
		
		for(int i = 0;i<n;i++) {
			A.add(A0[i]);
			B.add(B0[i]);
		}
		
		while(!A.isEmpty()&&!B.isEmpty()) {
			int i;
			for(i = 0;i<len;i++) {
				if (played[i]==A.peek())break;
			}
			played[len]=A.poll();
			len++;
			if(i!=len-1) {
				for(int j = i;j<len;j++) {
					A.add(played[j]);
					played[j]=0;
				}
				len = i;
			}
			if(A.isEmpty())break;
			for(i = 0;i<len;i++) {
				if (played[i]==B.peek())break;
			}
			played[len]=B.poll();
			len++;
			if(i!=len-1) {
				for(int j = i;j<len;j++) {
					B.add(played[j]);
					played[j]=0;
				}
				len = i;
			}
		}
		if(A.isEmpty())System.out.print("A is the winner.");
		else System.out.print("B is the winner.");
	}
}
