import java.awt.*;
import javax.swing.*;
import java.awt.geom.Arc2D;

class MyPanel_pie extends JPanel{
	public void paint(Graphics g) {
		super.paint(g);	
		Graphics2D g2d = (Graphics2D)g;
		Arc2D arc1 = new Arc2D.Double(120,80,180,180,0,70,Arc2D.PIE);//画出饼状图形
		g2d.setColor(Color.red);//设置颜色
		g2d.fill(arc1);//填充
		//下同
		Arc2D arc2 = new Arc2D.Double(120,80,180,180,70,40,Arc2D.PIE);
		g2d.setColor(Color.green);
		g2d.fill(arc2);
		Arc2D arc3 = new Arc2D.Double(120,80,180,180,110,100,Arc2D.PIE);
		g2d.setColor(Color.blue);
		g2d.fill(arc3);
		Arc2D arc4 = new Arc2D.Double(120,80,180,180,210,150,Arc2D.PIE);
		g2d.setColor(Color.ORANGE);
		g2d.fill(arc4);
	}
}

public class E03 extends JFrame{
	MyPanel_pie panel;
	
	E03(){
		panel = new MyPanel_pie();
		add(panel);
		setTitle("圆饼图");
		setBounds(100,100,400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
	}
	
	public static void main(String args[]) {
		new E03();
	}
}
