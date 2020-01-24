class Rectangle{
	private double width = 1,height = 1;//使用私有权限
	
	Rectangle(){}//无参构造函数
	Rectangle(double width,double height){
		this.width = width;
		this.height = height;
	}//指定值的构造函数
	
	double getWidth() {return width;}
	double getHeight() {return height;}
	
	double getArea() {
		return width*height;
	} 
	double getPerimeter() {
		return 2*(width+height);
	}
}


public class E01 {
	public static void main(String[] args) {
		Rectangle a = new Rectangle(4,40);//调用构造函数
		Rectangle b = new Rectangle(3.5,35.9);
		System.out.println(a.getWidth()+"\t"+a.getHeight()+"\t"+a.getArea()+"\t"+a.getPerimeter());
		System.out.println(b.getWidth()+"\t"+b.getHeight()+"\t"+b.getArea()+"\t"+b.getPerimeter());
	}
}