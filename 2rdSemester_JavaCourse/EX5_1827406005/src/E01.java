class Solve{
	private String[] key;
	private String[][] data;
	Solve(String[]key, String[][]data){//���캯��
		this.key = key;
		this.data = data;
	}
	void printScore() {
		for(int i = 0;i<data.length;i++) {//���ѭ��ѡȡdata��ÿ������data[i]
			int score = 0;
			for(int j = 0;j<key.length;j++) {//�ڲ�ѭ������key��data[i]��Ӧ���ݵĶԱ�
				if(key[j]==data[i][j])score++;
			}
			System.out.printf("��%d��ѧ���ĳɼ�Ϊ��%d��\n",i+1,score);//������
		}
	}
}

public class E01 {	
	public static void main(String[] args) {
		//��������
		String[] key = {"A","B","C","D"};
		String[][] data = {{"B","C","A","D"},{"B","C","D","A"},{"A","B","C","D"}};
		Solve res = new Solve(key,data) ;
		res.printScore();
	}
}