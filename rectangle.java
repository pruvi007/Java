
public class rectangle extends shape{
	public int l;
	public int b;
	rectangle(int a,int br){
		this.l=a;
		this.b=br;
	}
	public double getArea(){
		return l*b;
	}
	public double getPer(){
		return 2*(l+b);
	}
	

}
