
public class saving implements bank {
	public double total;
	public double interestRate=3.5;
	saving(double t){
		this.total = t;
	}
	public double calTotal(){
		total = total + (interestRate*total);
		return total;
	}
	public double getROI(){
		return interestRate;
	}
	public double depositMoney(int m){
		total = total + m;
		return total;
	}
	public double getTotal(){
		return total;
	}
}
