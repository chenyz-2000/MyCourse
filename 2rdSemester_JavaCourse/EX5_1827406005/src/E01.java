class Solve{
	private String[] key;
	private String[][] data;
	Solve(String[]key, String[][]data){//构造函数
		this.key = key;
		this.data = data;
	}
	void printScore() {
		for(int i = 0;i<data.length;i++) {//外层循环选取data的每个数组data[i]
			int score = 0;
			for(int j = 0;j<key.length;j++) {//内层循环进行key和data[i]对应数据的对比
				if(key[j]==data[i][j])score++;
			}
			System.out.printf("第%d个学生的成绩为：%d分\n",i+1,score);//输出结果
		}
	}
}

public class E01 {	
	public static void main(String[] args) {
		//测试数据
		String[] key = {"A","B","C","D"};
		String[][] data = {{"B","C","A","D"},{"B","C","D","A"},{"A","B","C","D"}};
		Solve res = new Solve(key,data) ;
		res.printScore();
	}
}