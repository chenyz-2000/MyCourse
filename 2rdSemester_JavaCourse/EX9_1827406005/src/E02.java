import javax.swing.*;
import java.awt.*;

public class E02 extends JFrame{
	JButton a,b,c,d;
	JPanel panel;
	E02(){
		init();
		setVisible(true);//���ÿɼ�
		setBounds(100,100,500,370);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
	}
	public void init() {
		a = new JButton("������ս��");
		b = new JButton("�Ϸ���ս��");
		c = new JButton("�����۲���");
		d = new JButton("�����۲���");
		add(a,BorderLayout.NORTH);
		add(b,BorderLayout.SOUTH);
		add(c,BorderLayout.EAST);
		add(d,BorderLayout.WEST);//����ĸ���ť��JFrame�Ķ�������
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(12,12));//ѡ�����񲼾�
		for(int i = 0;i<12;i++) {
			for(int j = 0;j<12;j++) {
				Label label = new Label();
				label.setBackground((i+j)%2==0?Color.black:Color.white);//���ñ���ɫ
				panel.add(label);//��˳���label��ӵ�panel�����
			}
		}
		add(panel);//�������ӵ��в�
	}
	
	public static void main(String args[]) {
		new E02();
	}
}
