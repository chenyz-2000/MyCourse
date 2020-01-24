import java.util.Scanner;

public class E05 {
	public static boolean onTheSameLine(double x0,double y0,double x1,double y1,double x2,double y2) {
		if((y0-y1)*(x0-x2)==(y0-y2)*(x0-x1))return true;//����ȡ������ƽ��
		return false;
	}
	
	public static boolean leftOfTheLine(double x0,double y0,double x1,double y1,double x2,double y2) {
		if(onTheSameLine(x0,y0,x1, y1,x2,y2)||y0==y1)return false;
		if(x0==x1)return x2<x0;//ֱ����ֱ
		double k = (y0-y1)/(x0-x1);//ֱ��б��
		if(k>0)return y2>y0+k*(x2-x0);//����ʽ�Ҳ���ֱ����x=x2ʱ��������
		else return y2<y0+k*(x2-x0);
	}

	public static boolean onTheLineSegment(double x0,double y0,double x1,double y1,double x2,double y2) {
		if(onTheSameLine(x0, y0, x1, y1, x2, y2)&&(x0-x2)*(x1-x2)<=0)return true;//p2��ֱ���ϣ��Һ�������x0��x1֮��
		return false;
	}
		
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("please input x0,y0,x1,y1,x2,y2:");
		double x0 = input.nextDouble(),y0 = input.nextDouble(),x1 = input.nextDouble(),y1 = input.nextDouble(),x2 = input.nextDouble(),y2 = input.nextDouble();
		if(leftOfTheLine(x0,y0,x1,y1,x2,y2))System.out.println("p2 is on the left of the line");
		else System.out.println("p2 is not on the left of the line");
		if(onTheSameLine(x0,y0,x1,y1,x2,y2))System.out.println("p2 is on the same line");
		else System.out.println("p2 is not on the same line");
		if(onTheLineSegment(x0,y0,x1,y1,x2,y2))System.out.println("p2 is on the line segment");
		else System.out.println("p2 is not on the line segment");
	}

}
