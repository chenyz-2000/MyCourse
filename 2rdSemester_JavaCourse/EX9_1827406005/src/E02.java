import javax.swing.*;
import java.awt.*;

public class E02 extends JFrame{
	JButton a,b,c,d;
	JPanel panel;
	E02(){
		init();
		setVisible(true);//设置可见
		setBounds(100,100,500,370);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
	}
	public void init() {
		a = new JButton("北方参战者");
		b = new JButton("南方参战者");
		c = new JButton("东方观察团");
		d = new JButton("西方观察团");
		add(a,BorderLayout.NORTH);
		add(b,BorderLayout.SOUTH);
		add(c,BorderLayout.EAST);
		add(d,BorderLayout.WEST);//添加四个按钮到JFrame的东南西北
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(12,12));//选用网格布局
		for(int i = 0;i<12;i++) {
			for(int j = 0;j<12;j++) {
				Label label = new Label();
				label.setBackground((i+j)%2==0?Color.black:Color.white);//设置背景色
				panel.add(label);//按顺序把label添加到panel面板中
			}
		}
		add(panel);//将面板添加到中部
	}
	
	public static void main(String args[]) {
		new E02();
	}
}
