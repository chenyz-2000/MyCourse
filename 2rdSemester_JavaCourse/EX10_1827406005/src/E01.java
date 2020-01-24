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
		setTitle("地址簿");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
	}
	
	public void init() {
		/*选用BoxLayout布局*/
		Box box = Box.createVerticalBox();
		
		/*前三行，放入容纳标签和文本框的panel*/
		textList = new JTextField[5];
		String[] label = {"姓名","街道","城市","省份","区号"};
		int len[] = {32,32,20,6,6};
		JPanel panel = new JPanel();
		for(int i = 0;i<5;i++) {
			panel.add(new JLabel(label[i]));
			panel.add(textList[i]=new JTextField(len[i]));//创建文本框，并用textList记录
			if(i<=1) {
				box.add(panel);
				panel = new JPanel();
			}
		}
		box.add(panel);
		
		/*第四行，放入容纳六个按钮的panel*/
		buttonList = new JButton[6];
		panel = new JPanel();
		String button[] = {"增加","第一个","下一个","前一个","最后一个","更新"};
		for(int i = 0;i<6;i++) {
			panel.add(buttonList[i]=new JButton(button[i]));//创建按钮，并用buttonList记录
		}
		box.add(panel);
		
		/*第五行，放入标签，用来指示数据序号*/
		lab = new JLabel("无数据");
		box.add(lab);
		
		/*box放入窗口*/
		add(box);
		
		/*创建随机流 */
		File file = new File("addressField.txt");
		file.delete();//因为随机流是追加模式，所以要保证文档空白
		try {
			 inAndOut = new RandomAccessFile(file,"rw");
		}
		catch (FileNotFoundException e) {}
		
		/*为按钮注册监听器 */
		for(int i = 0;i<6;i++) {
			buttonList[i].addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			JButton source = (JButton) e.getSource();
			
			/*根据不同的事件确定随机流的指向位置pos*/
			if(source==buttonList[0])pos=inAndOut.length();
			else if(source==buttonList[1])	pos=0;
			else if(source==buttonList[2]) 	{if(pos+96<inAndOut.length())pos+=96;}
			else if(source==buttonList[3])	pos=(pos-96<0)?0:pos-96;
			else if(source==buttonList[4])	pos=inAndOut.length()-96;
			else if(source==buttonList[5]) 	{}
			inAndOut.seek(pos);
			
			int len[]= {32,32,20,6,6};
			/*点击“增加”或“更新”时，对文件进行写入（能使用同一函数的原因为，更新即从某特定位置向后覆写）*/
			if(source==buttonList[0]||source==buttonList[5]) {
				for(int i = 0;i<5;i++) {
					String s = textList[i].getText();
					while(s.length()<len[i])s+=" ";//在长度不足的字符串后补空格
					inAndOut.writeBytes(s);//向文件写入信息
				}
			}
			/*点击其他四个按钮时，进行查询操作，把信息显示在文本框中*/
			else{
				for(int i = 0;i<5;i++) {
					byte s[] = new byte [len[i]];
					inAndOut.read(s);//从文件中读取信息到数组中
					textList[i].setText(new String(s).trim());
				}
			}
			
			/*更新标签lab对数据的指示*/
			lab.setText("第"+(pos/96+1)+"个数据，共有"+inAndOut.length()/96+"个数据");
		} 
		catch (IOException e1) {}
	}
	
	public static void main(String args[]) {
		new E01();
	}
}