
abstract public class shape {
	public String name;
	public int sides;
	abstract double getArea();
	abstract double getPer();
	public String toString(){
		return "Name: "+this.name+"\n"+"No. of Side: "+this.sides;
	}

}
