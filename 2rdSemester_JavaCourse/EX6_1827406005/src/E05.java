class Fan{
	final static int SLOW = 1,MEDIM = 2,FAST = 3;//设为静态常量
	private int speed = SLOW;//其余数据都使用私有权限
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
	
	public String toString() {//重写toString函数，访问权限不能降低
		String fo = on?("速度为"+speed):("fan is off");//使用条件运算符
		return fo+"\t颜色为"+color+"\t半径为"+radius;
	}
}

public class E05 {
	public static void main(String[] args) {
		Fan a = new Fan();
		a.setSpeed(Fan.FAST);//通过类调用数据
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