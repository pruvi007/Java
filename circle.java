
public class circle extends shape {
	public int rad;
	circle(int r){
		this.rad=r;
	}
	public double getArea(){
		return (3.14*rad*rad);
	}
	public double getPer(){
		return 2*3.14*rad;
	}
	

}
