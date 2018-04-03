
public class items {
	int itemCode;
	String itemName;
	double unitPrice;
	int stockRemaining;
	int itemLimit;
	public items(int itemCode,String itemName, double unitPrice,int stockRemaining,int itemLimit)
	{
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.stockRemaining = stockRemaining;
		this.itemLimit=itemLimit;
	}
	public String toString(){
		return itemCode+" "+itemName+" "+unitPrice+" "+stockRemaining+
				" "+itemLimit;
	}

}
