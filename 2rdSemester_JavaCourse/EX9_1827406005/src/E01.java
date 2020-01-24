import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.script.*;

public class E01 extends JFrame{
	JTextField textShow;
	JPanel panel;
	JButton buttonList[];
	
	E01(){
		init();
		setBounds(100,100,230,220);
		setTitle("��ӭ");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
	}
	
	public void init(){
		//�ı���
		textShow = new JTextField(100);
		textShow.setPreferredSize(new Dimension(200,30));
		add(textShow,BorderLayout.NORTH);
		
		//ʹ��GridLayout�������Ű�ť
		panel = new JPanel(new GridLayout(4,4));
		buttonList = new JButton[16];
		String[] s = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
		for(int i = 0;i<16;i++) {
			panel.add(buttonList[i]=new JButton(s[i]));
		}
		add(panel);

		//Ϊ��ť��Ӽ�����
		for(int i = 0;i<16;i++) {
			JButton button = buttonList[i];
			if(i!=14) {//���ǵȺŵĶ���ʾ���ı�����
				button.addActionListener(new ActionListener() {//������ʵ�ֽӿ�
					public void actionPerformed(ActionEvent e) {
						textShow.setText(textShow.getText()+button.getText());//�����ı��������
					}
				});
			}
			else {//�Ⱥ�
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s = textShow.getText();
						int indexApart=0;
						for(int i = 0;i<s.length();i++) {//�ҵ��ַ������������λ��
							if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/') {
								indexApart = i;
								break;
							}
						}
						//�������Ϊ�ֽ�õ�ǰ����������ֵ
						double num1 = Double.parseDouble(s.substring(0,indexApart));
						double num2 = Double.parseDouble(s.substring(indexApart+1));
						double res;
						//�����������������
						if(s.charAt(indexApart) == '+')res = num1+num2;
						else if(s.charAt(indexApart) == '-')res = num1-num2;
						else if(s.charAt(indexApart) =='*')res = num1*num2;
						else res = num1/num2;
						//���ֵΪ����������ʾ����
						if (Math.abs(res-Math.round(res))<1e-8)textShow.setText(String.valueOf(Math.round(res)));
						else textShow.setText(String.valueOf(res));
					}
				});
			}
		}
	}
	
	public static void main(String args[]) {
		new E01();
	}
}