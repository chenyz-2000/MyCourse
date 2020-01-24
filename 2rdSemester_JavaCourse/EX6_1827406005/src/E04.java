import java.util.Date;

class Account{
	private int id = 0;
	private double banlance = 0;
	private double annualInterestRate;
	private Date dataCreated;
	
	{dataCreated = new Date();}//��������
	Account(){}
	Account(int id,double banlance){
		this.id = id;
		this.banlance = banlance;
	}
	
	int getId() {return id;}
	void setId(int id) {this.id = id;}
	double getBanlance() {return banlance;}
	void setBanlance(double banlance) {this.banlance = banlance;}
	double getAnnualInterestRate() {return annualInterestRate;}
	void setAnnualInterestRate(double annualInterestRate) {this.annualInterestRate = annualInterestRate;}
	Date getDataCreated() {return dataCreated;}
	
	double getMonthlyInterestRate(){return annualInterestRate/12;}
	void withDraw(double x) {banlance-=x;}
	void deposit(double x) {banlance+=x;}
}


public class E04 {
	public static void main(String[] args) {
		Account a = new Account(1122,20000);
		a.setAnnualInterestRate(0.045);
		a.withDraw(2500);
		a.deposit(3000);
		System.out.println("���Ϊ"+a.getBanlance());
		System.out.printf("������Ϊ%f%%\n",a.getMonthlyInterestRate()*100);
		System.out.printf("��������Ϊ%1$tF", a.getDataCreated());//ʹ��%1$tF��ӡDate���������
	}
}