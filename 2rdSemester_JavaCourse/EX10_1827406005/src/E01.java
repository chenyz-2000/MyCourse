import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class E01 extends JFrame implements ActionListener{
	JButton buttonList[];
	JTextField textList[];
	RandomAccessFile inAndOut;
	long pos;
	JLabel lab;
	
	E01(){
		init();
		setBounds(200,200,500,200);
		setVisible(true);
		setTitle("��ַ��");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
	}
	
	public void init() {
		/*ѡ��BoxLayout����*/
		Box box = Box.createVerticalBox();
		
		/*ǰ���У��������ɱ�ǩ���ı����panel*/
		textList = new JTextField[5];
		String[] label = {"����","�ֵ�","����","ʡ��","����"};
		int len[] = {32,32,20,6,6};
		JPanel panel = new JPanel();
		for(int i = 0;i<5;i++) {
			panel.add(new JLabel(label[i]));
			panel.add(textList[i]=new JTextField(len[i]));//�����ı��򣬲���textList��¼
			if(i<=1) {
				box.add(panel);
				panel = new JPanel();
			}
		}
		box.add(panel);
		
		/*�����У���������������ť��panel*/
		buttonList = new JButton[6];
		panel = new JPanel();
		String button[] = {"����","��һ��","��һ��","ǰһ��","���һ��","����"};
		for(int i = 0;i<6;i++) {
			panel.add(buttonList[i]=new JButton(button[i]));//������ť������buttonList��¼
		}
		box.add(panel);
		
		/*�����У������ǩ������ָʾ�������*/
		lab = new JLabel("������");
		box.add(lab);
		
		/*box���봰��*/
		add(box);
		
		/*��������� */
		File file = new File("addressField.txt");
		file.delete();//��Ϊ�������׷��ģʽ������Ҫ��֤�ĵ��հ�
		try {
			 inAndOut = new RandomAccessFile(file,"rw");
		}
		catch (FileNotFoundException e) {}
		
		/*Ϊ��ťע������� */
		for(int i = 0;i<6;i++) {
			buttonList[i].addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			JButton source = (JButton) e.getSource();
			
			/*���ݲ�ͬ���¼�ȷ���������ָ��λ��pos*/
			if(source==buttonList[0])pos=inAndOut.length();
			else if(source==buttonList[1])	pos=0;
			else if(source==buttonList[2]) 	{if(pos+96<inAndOut.length())pos+=96;}
			else if(source==buttonList[3])	pos=(pos-96<0)?0:pos-96;
			else if(source==buttonList[4])	pos=inAndOut.length()-96;
			else if(source==buttonList[5]) 	{}
			inAndOut.seek(pos);
			
			int len[]= {32,32,20,6,6};
			/*��������ӡ��򡰸��¡�ʱ�����ļ�����д�루��ʹ��ͬһ������ԭ��Ϊ�����¼���ĳ�ض�λ�����д��*/
			if(source==buttonList[0]||source==buttonList[5]) {
				for(int i = 0;i<5;i++) {
					String s = textList[i].getText();
					while(s.length()<len[i])s+=" ";//�ڳ��Ȳ�����ַ����󲹿ո�
					inAndOut.writeBytes(s);//���ļ�д����Ϣ
				}
			}
			/*��������ĸ���ťʱ�����в�ѯ����������Ϣ��ʾ���ı�����*/
			else{
				for(int i = 0;i<5;i++) {
					byte s[] = new byte [len[i]];
					inAndOut.read(s);//���ļ��ж�ȡ��Ϣ��������
					textList[i].setText(new String(s).trim());
				}
			}
			
			/*���±�ǩlab�����ݵ�ָʾ*/
			lab.setText("��"+(pos/96+1)+"�����ݣ�����"+inAndOut.length()/96+"������");
		} 
		catch (IOException e1) {}
	}
	
	public static void main(String args[]) {
		new E01();
	}
}