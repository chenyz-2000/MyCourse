class Fan{
	final static int SLOW = 1,MEDIM = 2,FAST = 3;//��Ϊ��̬����
	private int speed = SLOW;//�������ݶ�ʹ��˽��Ȩ��
	private boolean on = false;
	private double radius = 5;
	private String color = "blue";
	
	Fan(){}
	
	int getSpeed() {return speed;}
	void setSpeed(int speed) {this.speed = speed;}
	boolean getOn() {return on;};
	void setOn(boolean on) {this.on = on;}
	double getRadius() {return radius;}
	void setRadius(double radius) {this.radius = radius;}
	String getColor() {return color;}
	void setColor(String color) {this.color = color;}
	
	public String toString() {//��дtoString����������Ȩ�޲��ܽ���
		String fo = on?("�ٶ�Ϊ"+speed):("fan is off");//ʹ�����������
		return fo+"\t��ɫΪ"+color+"\t�뾶Ϊ"+radius;
	}
}

public class E05 {
	public static void main(String[] args) {
		Fan a = new Fan();
		a.setSpeed(Fan.FAST);//ͨ�����������
		a.setRadius(10);
		a.setColor("yellow");
		a.setOn(true);
		System.out.println(a.toString());
		
		Fan b = new Fan();
		b.setSpeed(Fan.MEDIM);
		b.setRadius(5);
		b.setColor("blue");
		b.setOn(false);
		System.out.println(b.toString());
	}
}