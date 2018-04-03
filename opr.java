
public class opr {
	public int x;
	public int y;
	public char op;
	public double r;
	opr(int a,char s,int b){
		x = a;
		y = b;
		op = s;
	}
	public void calR(){
		
		if(op=='+')
			r = x+y;
		else if(op=='-')
			r =  x-y;
		else if(op=='*')
			r = x*y;
		else if(op=='/')
			r = (double)x/y;
	}
	public void display(){
		System.out.println(r);
	}
		

}
