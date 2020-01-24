import java.awt.*;
import javax.swing.*;
import java.awt.geom.Arc2D;

class MyPanel extends JPanel{
	public void paint(Graphics g) {
		super.paint(g);	
		Graphics2D g2d = (Graphics2D)g;
		g2d.draw(new Arc2D.Double(100,100,200,200,0,260,Arc2D.OPEN));//弧形
		g2d.draw(new Arc2D.Double(100,100,200,200,270,80,Arc2D.OPEN));
		g2d.drawOval(140, 150, 55, 35);//空心圆
		g2d.drawOval(210, 150, 55, 35);
		g2d.fillOval(165, 165, 20, 20);//实心圆
		g2d.fillOval(235, 165, 20, 20);
		int []x = {180,205,230};
		int []y = {220,180,220};
		g2d.drawPolygon(x, y, 3);//三角形
		g2d.draw(new Arc2D.Double(170,205,70,50,180,180,Arc2D.OPEN));
	}
}

public class E04 extends JFrame{
	MyPanel panel;
	
	E04(){
		panel = new MyPanel();
		add(panel);
		setBounds(100,100,400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
	}
	
	public static void main(String[] args) {
		new E04();
	}
}