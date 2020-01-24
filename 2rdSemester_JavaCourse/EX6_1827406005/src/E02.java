class Stock{
	private String symbol,name;
	private double previousClosingPrice,currentPrice;
	
	Stock(String symbol,String name){
		this.symbol = symbol;
		this.name = name;
	}
	
	void setPreviousClosingPrice(double previousClosingPrice) {this.previousClosingPrice=previousClosingPrice;}
	void setCurrentPrice(double currentPrice) {this.currentPrice = currentPrice;}
	
	double getChangePercent() {//计算市值变化百分比
		return (currentPrice-previousClosingPrice)/previousClosingPrice;
	}
}


public class E02 {
	public static void main(String[] args) {
		Stock t = new Stock("ORCL","Oracle Corporation");
		t.setPreviousClosingPrice(34.5);
		t.setCurrentPrice(34.35);
		System.out.printf("%f%%\n",t.getChangePercent()*100);
	}
}